package diellza.touristguide.Helpers;

import android.app.IntentService;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Database.DBAdapter;
import diellza.touristguide.Database.DBHelper;
import diellza.touristguide.Fragments.MonumentsFragment;
import diellza.touristguide.Models.Monument;

/**
 * Created by SINKOPA on 5/21/2018.
 */

public class RefreshService extends IntentService {
    public  static final String TAG="tg.RefreshService";
    public RefreshService() {
        super("Refresh Service");
    }

    long lastStatusCreatedtime=-1;
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int count=0;
        Log.d(TAG,"Refresh Service");

        int i=0;
            DBAdapter adapter =MonumentsFragment.getDb();
            ArrayList<Monument> monuments = MonumentArrayList.getArray();
            for (Monument m : monuments) {
                adapter.openDB();
                 adapter.add((int)m.getID(),m.getTitle(),m.getOverview(),m.getHistory(),m.getClassName(),m.getType(),
                         m.getPeriod(),m.getCentury(),m.getAddress(),m.getLongitude(),m.getLatitude(),m.getCategory(),m.getOverviewImg());
            adapter.closeDB();
                if (m.getCreatedAt() > lastStatusCreatedtime) {
                    lastStatusCreatedtime =  m.getCreatedAt();
                    count++;
                }
            }

            if (count > 0)
          sendBroadcast(new Intent(MonumentsFragment.ACTION_STATUS).putExtra("COUNT",count));
        }
        }



