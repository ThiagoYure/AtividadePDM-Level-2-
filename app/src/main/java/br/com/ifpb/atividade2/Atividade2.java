package br.com.ifpb.atividade2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Atividade2 extends AppCompatActivity {

    private BroadcastReceiver receiver;
    private EditText user;
    private ListView resultado;
    private BaseAdapter adapter;
    private List<Repositorio> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);
        resultado = findViewById(R.id.resultado);

    }

    @Override
    public void onStart() {
        receiver = new ReceiverBeauty();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ServiceRepo.action);
        registerReceiver(receiver, intentFilter);
        repos = new ArrayList<>();
        super.onStart();
    }

    public void pesquisarRepo(View view){
        Intent intent = new Intent(this, ServiceRepo.class);
        user = findViewById(R.id.user);
        intent.putExtra("user",user.getText());
        startService(intent);
    }

    public void cleanRepo(View view){
        repos.clear();
        adapter = new RepositorioAdapter(repos, (Atividade2) view.getContext());
        resultado.setAdapter(adapter);
    }

    public class ReceiverBeauty extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String jsonString = intent.getExtras().getString("json");
            String url_foto = "";
            JSONArray array = new JSONArray();
            try {
                array = new JSONArray(jsonString);
                for (int i = 0; i < array.length(); i++) {
                    Repositorio repo = new Repositorio();
                    try {
                        JSONObject object = (JSONObject) array.get(i);
                        if(url_foto.isEmpty())
                            url_foto = object.getJSONObject("owner").getString("avatar_url");
                        repo.setAutor(object.getString("full_name").split("/")[0]);
                        repo.setNome(object.getString("full_name").split("/")[1]);
                        repo.setDescricao(object.getString("description"));
                        repo.setUrl_foto(url_foto);
                    } catch (JSONException e) {
                        e.getMessage();
                    }
                    repos.add(repo);
                }
                adapter = new RepositorioAdapter(repos, (Atividade2) context);
                resultado.setAdapter(adapter);
            } catch (JSONException e) {
                new Exception(e.getMessage());
            }

        }
    }
}
