package diellza.touristguide.Activities;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Fragments.CategoryFragment;
import diellza.touristguide.Fragments.DetailFragment;
import diellza.touristguide.Fragments.MonumentsFragment;
import diellza.touristguide.Fragments.ScanFragment;
import diellza.touristguide.Helpers.DisableShiftingBNV;
import diellza.touristguide.Fragments.HomeFragment;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;

public class MainActivity extends AppCompatActivity implements MonumentRecyclerViewAdapter.OnItemClickListener {
public  static final String COUNT_KEY="touristguide.activities.MainActivity";
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY,count);
    }

    Fragment fragment;
    static BottomNavigationView navigation;
    int count=0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment=new HomeFragment();
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
        if(savedInstanceState!=null) {
            count = savedInstanceState.getInt(COUNT_KEY, 0);
        }
        setContentView(R.layout.activity_main);


if(count==0) {
     fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction()
          .replace(R.id.flContent, fragment, fragment.getClass().getSimpleName()).commit();
        count++;
}

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
    @Override
    public void onItemClick(int position) {

        Monument m = MonumentsFragment.getMonuments1().get(position);
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra(DetailFragment.TAG, m);
            startActivity(i);

        }
    }



