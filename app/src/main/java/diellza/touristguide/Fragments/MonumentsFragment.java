package diellza.touristguide.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Helpers.MonumentArrayList;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class MonumentsFragment extends Fragment {


    private RecyclerView recyclerView;
    private static  List<Monument> monumentArrayList=new ArrayList<>();
    private static ArrayList<Monument> monuments1 = new ArrayList<>();
    public static List<Monument> getMonuments1() {
        return monuments1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monumentArrayList= MonumentArrayList.getArray();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String title = bundle.getString(CategoryRecyclerViewAdapter.CATEGORY_TITLE, "");

        if (title != "") {

            Log.e("MRENA",""+monumentArrayList.size());
            for (int i = 0; i < monumentArrayList.size(); i++) {
                Log.e("MRENA",monumentArrayList.get(i).getCategory()+" KATEGORY");
                if (monumentArrayList.get(i).getCategory().equals(title)) {
                    monuments1.add(monumentArrayList.get(i));
                }
            }

            Log.e("MRENA",""+monuments1.size());

        }

        ((MainActivity) getActivity()).setTitle(title);
        View v = inflater.inflate(R.layout.fragment_monuments, container, false);
        recyclerView = v.findViewById(R.id.rvMonument);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        MonumentRecyclerViewAdapter adapter = new MonumentRecyclerViewAdapter(monuments1, this.getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }

    public static Monument getMonumentById(String title)
    {
        monumentArrayList=MonumentArrayList.getArray();

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
        Log.e("STATE", "ON DESTROY VIEW");
        monuments1.clear();
    }

}
