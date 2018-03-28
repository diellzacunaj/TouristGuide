package diellza.touristguide.Activities;

import android.content.res.Configuration;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.io.IOException;

import diellza.touristguide.R;

/**
 * Created by SINKOPA on 3/28/2018.
 */


public class ScanQRCodeActivity extends AppCompatActivity {


    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Camera camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);
        try {
            camera = Camera.open();
        }
        catch (Exception e){
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
        }
        surfaceView=(SurfaceView) findViewById(R.id.surface);
        surfaceView.setZOrderMediaOverlay(true);
        surfaceHolder = surfaceView.getHolder();


        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Camera.Parameters parameters = camera.getParameters();

                if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    parameters.set("orientation", "portrait");
                    camera.setDisplayOrientation(90);
                    parameters.setRotation(90);
                } else {
                    parameters.set("orientation", "landscape");
                    camera.setDisplayOrientation(0);
                    parameters.setRotation(0);
                }
                camera.setParameters(parameters);

                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            camera.stopPreview();
            camera.setPreviewCallback(null);
            camera.release();
            camera = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            camera = Camera.open();
            camera.setPreviewCallback(null);
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
            camera.startPreview();
        } catch (Exception e) {
            Log.d("CAMERA", "Error starting camera preview: " + e.getMessage());
        }

    }
}
