package diellza.touristguide.Fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Activities.ScanQRCodeActivity;
import diellza.touristguide.R;

/**
 * Created by SINKOPA on 3/28/2018.
 */

public class ScanFragment extends Fragment {

    TextView scantxt;
    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scan, container, false);
        MainActivity.setNavItemChecked(1);
       ((MainActivity) getActivity()).setTitle("Scan");
        scantxt = v.findViewById(R.id.scanQRCode);

        scantxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kontrollon per permission,nese ska atehere user mund te lejoje duke shtypur Allow ose e kunderta me Deny
                if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED) {
                    requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                            MY_CAMERA_REQUEST_CODE);

                } else {

                    startScanQRCodeActivity();
                }
            }
        });


        return v;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                startScanQRCodeActivity();

            } else {

                Toast.makeText(getContext(), "Camera permission denied", Toast.LENGTH_LONG).show();

            }
        }
    }


    private void startScanQRCodeActivity()
    {
        Intent intent = new Intent(getContext(), ScanQRCodeActivity.class);
        startActivity(intent);
    }
}
