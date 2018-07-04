package br.com.ifpb.atividade2;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class CleanServiceRepo extends IntentService{

    public final static String action = "CLEAN_SERVICE_REPO";

    public CleanServiceRepo() {
        super("CleanServiceRepo");
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        Thread thread = new Thread() {
            @Override
            public void run() {

                stopSelf();
            }
        };
        thread.start();

    }
}
