package diellza.touristguide.Helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;

/**
 * Created by SINKOPA on 5/25/2018.
 */

public class BootReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if(info != null && info.isConnected()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                context.startForegroundService(new Intent(context, UpdaterService.class));
            else context.startService(new Intent(context, UpdaterService.class));
        }

    }

}
