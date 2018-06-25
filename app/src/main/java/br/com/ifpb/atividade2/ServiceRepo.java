package br.com.ifpb.atividade2;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class ServiceRepo extends IntentService{

    public final static String action = "SERVICE_REPO";
    private HandlerJson handlerJson;

    public ServiceRepo() {
        super("ServiceRepo");
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        handlerJson = new HandlerJson();
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = "https://api.github.com/users/"+intent.getCharSequenceExtra("user")+"/repos";
                String stringJson = handlerJson.getStringJson(url);
                Intent intentEnvio = new Intent();
                intentEnvio.putExtra("json", stringJson);
                intentEnvio.setAction(action);
                sendBroadcast(intentEnvio);
                stopSelf();
            }
        };
        thread.start();

    }
}
