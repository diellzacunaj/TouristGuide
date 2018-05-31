package diellza.touristguide.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Database.DBAdapter;
import diellza.touristguide.Helpers.MonumentArrayList;
import diellza.touristguide.Helpers.RefreshService;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class MonumentsFragment extends Fragment implements SearchView.OnQueryTextListener{
    public static final String ACTION_STATUS = "com.diellza.fragments.UPDATE_STATUS";
    String title;
    private RecyclerView recyclerView;
   static DBAdapter db;
    private ListReciever receiver;
    private static  List<Monument> monumentArrayList=new ArrayList<>();
    private static ArrayList<Monument> monuments1 = new ArrayList<>();
    MonumentRecyclerViewAdapter adapter;
    public static List<Monument> getMonuments1() {
        return monuments1;
    }

    public static DBAdapter getDb() {
        return db;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


setHasOptionsMenu(true);
 db= new DBAdapter(getContext());

           monumentArrayList = db.getMonuments();


        if(isNetworkAvailable() && MainActivity.getJsonResult()!=""){
           monumentArrayList=MonumentArrayList.getArray();
        }
        if (receiver == null)
            receiver = new ListReciever();


        getActivity().registerReceiver(receiver,
                new IntentFilter(MonumentsFragment.ACTION_STATUS));


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.action_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.refreshService:
                if(isNetworkAvailable()) {
                    getActivity().startService(new Intent(getActivity(), RefreshService.class));
                }else{
                    Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        ((MainActivity) getActivity()).setTitle(title);
        View v = inflater.inflate(R.layout.fragment_monuments, container, false);
        recyclerView = v.findViewById(R.id.rvMonument);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MonumentRecyclerViewAdapter(getMonumentsByCategory(), this.getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }


    public ArrayList<Monument> getMonumentsByCategory(){


            monumentArrayList = db.getMonuments();


        if(isNetworkAvailable()){
            monumentArrayList=MonumentArrayList.getArray();
      }

        Bundle bundle = getArguments();
        title = bundle.getString(CategoryRecyclerViewAdapter.CATEGORY_TITLE, "");


        if (title != "") {

            ((MainActivity) getActivity()).setTitle(title);
            for (int i = 0; i < monumentArrayList.size(); i++) {

                if (monumentArrayList.get(i).getCategory().equals(title)) {
                    monuments1.add(monumentArrayList.get(i));
                }
            }
        }
        return  monuments1;
    }

    public static Monument getMonumentById(String title)
    {



        if( MainActivity.getJsonResult()!=""){
            monumentArrayList=MonumentArrayList.getArray();
        }

        for (int i = 0; i < monumentArrayList.size(); i++) {
            if (monumentArrayList.get(i).getTitle().equals(title)) {
             return  (monumentArrayList.get(i));
            }
        }
        return monumentArrayList.get(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        monuments1.clear();
    }

    class ListReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {


if (monuments1.size()!=0){
    monuments1.clear();
}
                adapter=new MonumentRecyclerViewAdapter(getMonumentsByCategory(),getContext());
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();



        }
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (receiver == null)
            receiver = new ListReciever();


        getActivity().registerReceiver(receiver,
                new IntentFilter(MonumentsFragment.ACTION_STATUS));
    }


    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Monument> filteredModelList = filter(monuments1, newText);
        if (filteredModelList.size() > 0) {
            adapter.setFilter(filteredModelList);
            return true;
        } else {
            Toast.makeText(this.getContext(), "Not Found", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private List<Monument> filter(List<Monument> monumentsList, String query) {
        query = query.toLowerCase();

        final List<Monument> filteredModelList = new ArrayList<>();
        for (Monument model : monumentsList) {
            final String text = model.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);

            }
        }
        adapter = new MonumentRecyclerViewAdapter(filteredModelList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return filteredModelList;
    }
}
