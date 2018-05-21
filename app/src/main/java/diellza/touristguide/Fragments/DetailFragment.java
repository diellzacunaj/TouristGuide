package diellza.touristguide.Fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.Locale;

import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class DetailFragment extends Fragment {
    public static final String TAG = "diellza.touristguide.Fragments.DetailFragment";

    ImageView itemDetailImg;
    ImageView directions;
    TextView addressTxt, uniqueNumberTxt, nameTxt, periodTxt, centuryTxt, classTxt, typeTxt, historyTxt, directionsTxt;
    Monument monument;
    CollapsingToolbarLayout layout;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        monument = (Monument) getArguments().getSerializable(TAG);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_item_detail, container, false);
        itemDetailImg = v.findViewById(R.id.detailImage);
        directions = v.findViewById(R.id.getDirections);
        addressTxt = v.findViewById(R.id.addressTextView);
        uniqueNumberTxt = v.findViewById(R.id.uniqueNumbertTextView);
        nameTxt = v.findViewById(R.id.nameTextView);
        periodTxt = v.findViewById(R.id.periodTextView);
        centuryTxt = v.findViewById(R.id.centuryTextView);
        classTxt = v.findViewById(R.id.classTextView);
        typeTxt = v.findViewById(R.id.typeTextView);
        historyTxt = v.findViewById(R.id.historyTextView);
        layout = v.findViewById(R.id.toolbar_layout);
        directionsTxt = v.findViewById(R.id.getDirectionsTxt);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added to favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        layout.setTitle(monument.getTitle());
        // getActivity().setTitle(monument.getTitle());
        uniqueNumberTxt.setText(monument.getID() + "");
        nameTxt.setText(monument.getTitle());
        historyTxt.setText(monument.getHistory());
        addressTxt.setText(monument.getAddress());
        periodTxt.setText(monument.getPeriod());
        centuryTxt.setText(monument.getCentury());
        classTxt.setText(monument.getClassName());
        typeTxt.setText(monument.getType());

        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destLabel = monument.getTitle();
                /**
                 * By the standards of Google, we must first give the parameters of Latitude
                 * then Longitude, but when the database was created we swapped the parameters
                 * unknowingly, so the parameters given in the line below are swapped also
                 * to give the correct location
                 * It's the same rule for @directionsTxt listener
                 * */
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", monument.getLongitude(), monument.getLatitude(), destLabel);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                //checks if you have installed Google Maps
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getContext().startActivity(mapIntent);
                }
            }
        });

        directionsTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destLabel = monument.getTitle();
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", monument.getLongitude(), monument.getLatitude(), destLabel);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getContext().startActivity(mapIntent);
                }
            }
        });

        // itemDetailImg.setImageResource(monument.getHistoryImg());
        Glide.with(getContext()).load(monument.getOverviewImg()).override(500, 220).into(itemDetailImg);

        return v;
    }


    public static DetailFragment newInstance(Monument monument) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG, monument);
        detailFragment.setArguments(bundle);
        return detailFragment;

    }


}
