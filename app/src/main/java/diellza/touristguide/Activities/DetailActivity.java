package diellza.touristguide.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;



import diellza.touristguide.Fragments.DetailFragment;
import diellza.touristguide.Fragments.MonumentsFragment;
import diellza.touristguide.R;
import diellza.touristguide.Models.Monument;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {

            String s = "";
            Monument monument;
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    Object value = bundle.get(key);
                    Log.e("EXTRA", String.format("%s %s (%s)", key,
                            value.toString(), value.getClass().getName()));
                    s = key;

                }
            }


            if (s.equals(DetailFragment.TAG)) {
                monument = (Monument) getIntent().getSerializableExtra(s);
            } else {
                String m=getIntent().getStringExtra(s);
                monument = MonumentsFragment.getMonumentById(m);
            }
            DetailFragment fragmentItemDetail = DetailFragment.newInstance(monument);
            getSupportFragmentManager().beginTransaction().replace(R.id.itemDetailContainer, fragmentItemDetail).commit();
        }


        setContentView(R.layout.item_detail);


    }

}