package diellza.touristguide.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Database.DBAdapter;
import diellza.touristguide.Database.DBHelper;
import diellza.touristguide.Fragments.CategoryFragment;
import diellza.touristguide.Fragments.DetailFragment;
import diellza.touristguide.Fragments.MonumentsFragment;
import diellza.touristguide.Fragments.ScanFragment;
import diellza.touristguide.Helpers.DisableShiftingBNV;
import diellza.touristguide.Fragments.HomeFragment;
import diellza.touristguide.Helpers.MonumentArrayList;
import diellza.touristguide.Helpers.RefreshService;
import diellza.touristguide.Helpers.UpdaterService;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;

public class MainActivity extends AppCompatActivity implements MonumentRecyclerViewAdapter.OnItemClickListener {
    public static final String COUNT_KEY = "touristguide.activities.MainActivity";
    public static final String RESULT_KEY = "JSONResult";

    public static String JSON_STRING;
    public static String jsonResult;
    public static String jsonRstSaved;
    static BackgroundTask backgroundTask;


    public static String getJsonResult(){
        if(jsonResult!=""){
        return jsonResult;}
        else{
            return  jsonRstSaved;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, count);
        outState.putString(RESULT_KEY, jsonResult);
    }

    Fragment fragment;
    static BottomNavigationView navigation;
    int count = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    showFragment(fragment);
                    return true;
                case R.id.navigation_scan:
                    fragment = new ScanFragment();
                    showFragment(fragment);
                    return true;
                case R.id.navigation_monuments:
                    fragment = new CategoryFragment();
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
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT_KEY, 0);
            jsonRstSaved = savedInstanceState.getString(RESULT_KEY, "");
        }
        setContentView(R.layout.activity_main);

        getJson();


        if (count == 0) {
            fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flContent, fragment, fragment.getClass().getSimpleName()).commit();
            count++;
        }

        navigation = (BottomNavigationView) findViewById(R.id.mainBN);

        DisableShiftingBNV.disableShiftingMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setTitle(String s) {
        getSupportActionBar().setTitle(s);

    }

    public static void setNavItemChecked(int i) {
        Menu m = navigation.getMenu();
        MenuItem mi = m.getItem(i);
        mi.setChecked(true);
    }

    public void showFragment(Fragment f) {
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


    public static void getJson() {
        backgroundTask = new BackgroundTask();
        backgroundTask.execute();
    }

    static class BackgroundTask extends AsyncTask<Void, Void, String> {

        String jsonUrl;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            jsonUrl = "http://workshop-maker.space/TourGuide/monuments.php";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            jsonResult = s;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... voids) {
            URL url = null;
            try {
                Log.e("ASYNC","do in background");
                url = new URL(jsonUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine()) != null) {

                    stringBuilder.append(JSON_STRING);
                }
                bufferedReader.close();
                inputStream.close();
                connection.disconnect();
                jsonResult=stringBuilder.toString();
                return stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}