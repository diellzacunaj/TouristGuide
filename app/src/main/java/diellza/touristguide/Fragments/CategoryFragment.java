package diellza.touristguide.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Models.Category;
import diellza.touristguide.R;


/**
 * Created by SINKOPA on 3/20/2018.
 */

public class CategoryFragment extends Fragment {

    RecyclerView recyclerView;
    List<Category> categories;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_category,container,false);
        initalizeData();
        MainActivity.setNavItemChecked(2);
        ((MainActivity)getActivity()).setTitle("Kategorite");
        recyclerView=v.findViewById(R.id.rvCategory);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));



        CategoryRecyclerViewAdapter adapter=new CategoryRecyclerViewAdapter(getContext(),categories);
        recyclerView.setAdapter(adapter);



        return v;
    }


    private void initalizeData()
    {
        categories=new ArrayList<>();
        categories.add(new Category("Xhamite",R.drawable.mosque));
        categories.add(new Category("Kishat",R.drawable.church));
        categories.add(new Category("Urat",R.drawable.bridge));
        categories.add(new Category("Monumente",R.drawable.fortress));
        categories.add(new Category("Ndertesa",R.drawable.house));
        categories.add(new Category("Natyre",R.drawable.nature));
    }


}
