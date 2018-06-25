package br.com.ifpb.atividade2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAdapter extends BaseAdapter{
    private Activity activity;
    private List<Repositorio> repositorios = new ArrayList<>();

    public RepositorioAdapter(List<Repositorio> repositorios, Activity activity) {
        this.activity = activity;
        this.repositorios = repositorios;
    }

    @Override
    public int getCount() {
        return repositorios.size();
    }

    @Override
    public Object getItem(int position) {
        return repositorios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.activity_repositorios, parent, false);
        Repositorio repo = repositorios.get(position);
        TextView autor = (TextView) view.findViewById(R.id.autor);
        autor.setText(repo.getAutor());
        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        descricao.setText(repo.getDescricao());
        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        titulo.setText(repo.getNome());
        ImageView url_foto = (ImageView) view.findViewById(R.id.url_foto);
        Picasso.get().load(repo.getUrl_foto()).into(url_foto);
        return view;
    }
}
