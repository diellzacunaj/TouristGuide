package diellza.touristguide.Helpers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Models.Monument;

/**
 * Created by SINKOPA on 5/21/2018.
 */

public class UpdaterService extends Service {
    public  static final String TAG="tg.UpdaterService";
boolean running=true;
MainActivity t;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"on Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        running = true;
        new Thread() {
            @Override
            public void run() {
                while (running) {
                    try {

                      MainActivity.getJson();
Log.d(TAG, "onStartCommand()");
                        Thread.sleep(1800000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }//end of run()
        }.start();//end of Thread
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running=false;
    }


    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
