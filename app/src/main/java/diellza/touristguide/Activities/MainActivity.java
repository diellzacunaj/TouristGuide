package diellza.touristguide.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import diellza.touristguide.Fragments.CategoryFragment;
import diellza.touristguide.Fragments.ScanFragment;
import diellza.touristguide.Helpers.DisableShiftingBNV;
import diellza.touristguide.Home;
import diellza.touristguide.R;

public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    static BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new Home();
                    showFragment(fragment);
                    return true;
                case R.id.navigation_scan:
                    fragment=new ScanFragment();
                    showFragment(fragment);
                    return true;
                case R.id.navigation_monuments:
                    fragment=new CategoryFragment();
                    showFragment(fragment);
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



        fragment=new Home();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flContent, fragment, fragment.getClass().getSimpleName()).commit();

       navigation = (BottomNavigationView) findViewById(R.id.mainBN);

        DisableShiftingBNV.disableShiftingMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setTitle(String s)
    {
        getSupportActionBar().setTitle(s);

    }
    public static void setNavItemChecked(int i) {
        Menu m=navigation.getMenu();
        MenuItem mi=m.getItem(i);
        mi.setChecked(true);
    }

    public void showFragment(Fragment f)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flContent, f, f.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}
