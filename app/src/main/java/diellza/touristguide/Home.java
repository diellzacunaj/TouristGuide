package diellza.touristguide;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;





public class Home extends Fragment {

    Button view_categories, qr_code;
    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.activity_home,container,false);



        searchView = new SearchView(getContext());
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo search view implementation
            }
        });



        return v;

    }



}
