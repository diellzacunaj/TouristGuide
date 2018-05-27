package diellza.touristguide.Fragments;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class DetailFragment extends Fragment implements OnMapReadyCallback {
    public static final String TAG = "diellza.touristguide.Fragments.DetailFragment";

    ImageView itemDetailImg;
    ImageView directions;
    TextView addressTxt, uniqueNumberTxt, nameTxt, periodTxt, centuryTxt, classTxt, typeTxt, historyTxt, directionsTxt;
    Monument monument;
    CollapsingToolbarLayout layout;

    GoogleMap mMap;
    SupportMapFragment mapFragment;

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


        //initialization of mapFragment
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.googleMap);
        if (mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.googleMap, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

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
                mapIntent.setPackage("com.google.android.apps.maps");
                //checks if you have installed Google Maps
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    downloadMaps();
                }
            }
        });

        directionsTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destLabel = monument.getTitle();
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", monument.getLongitude(), monument.getLatitude(), destLabel);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    downloadMaps();
                }
            }
        });



        Picasso.with(getContext()).load(Uri.parse(monument.getOverviewImg()))
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(itemDetailImg, new Callback() {
                    @Override

                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        // Try again online if cache failed
                        Picasso.with(getContext())

                                .load(Uri.parse(monument.getOverviewImg()))
                                .error(R.drawable.nowifibg)
                                .into(itemDetailImg);
                    }
                });

        return v;
    }

    public void downloadMaps() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.google_maps_missing_title);
        builder.setMessage(R.string.google_maps_missing_message);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("OK", getGoogleMapsListener());
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public static DetailFragment newInstance(Monument monument) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG, monument);
        detailFragment.setArguments(bundle);
        return detailFragment;

    }

    public DialogInterface.OnClickListener getGoogleMapsListener() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.apps.maps"));
                startActivity(intent);
                getActivity().finish();
            }
        };
    }

    public boolean isGoogleMapsInstalled() {
        try {
            ApplicationInfo info = getActivity().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    //function that adds the marker pin in mapFragment
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(monument.getLongitude(), monument.getLatitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        markerOptions.title("Current Postition");
        markerOptions.snippet("My Position");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.setMinZoomPreference(17);
        mMap.addMarker(markerOptions);
    }
}
