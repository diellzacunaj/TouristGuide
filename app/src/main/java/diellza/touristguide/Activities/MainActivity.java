package diellza.touristguide.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import diellza.touristguide.Fragments.CategoryFragment;
import diellza.touristguide.Fragments.ScanFragment;
import diellza.touristguide.Helpers.DisableShiftingBNV;
import diellza.touristguide.R;

public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_scan:
                    fragment=new ScanFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flContent, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

                    return true;
                case R.id.navigation_monuments:
                    fragment=new CategoryFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flContent, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_favorites:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.mainBN);
        DisableShiftingBNV.disableShiftingMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setTitle(String s)
    {
        getSupportActionBar().setTitle(s);

    }
}
