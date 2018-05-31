package diellza.touristguide.Activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Database.DBAdapter;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView rv;
    MonumentRecyclerViewAdapter adapter;
    ArrayList<Monument> monumentsList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        this.setTitle("Favorites");
        //RECYCLERVIEW
        rv= (RecyclerView) findViewById(R.id.rvMonument);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter=new MonumentRecyclerViewAdapter(monumentsList, this);

        retrieve();
    }

    private void retrieve()
    {
        monumentsList.clear();
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        Cursor c=db.getFavorites();
        while (c.moveToNext())
        {
            String title=c.getString(0);
            String url=c.getString(1);

            Monument monument = new Monument();
            monument.setTitle(title);
            monument.setOverviewImg(url);

            monumentsList.add(monument);
        }

        if(monumentsList.size()>0)
        {
            rv.setAdapter(adapter);
        }

        db.closeDB();
    }

}
