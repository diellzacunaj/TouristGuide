package diellza.touristguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import diellza.touristguide.Activities.MainActivity;

public class WelcomePage extends Activity {

    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //delete the title bar from welcome screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcome_page);

        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }


    private void doWork() {
        for (int progress = 0; progress < 100; progress+=10 ) {
            try {
                Thread.sleep(300);
                mProgress.setProgress(progress);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp () {
        Intent intent = new Intent (WelcomePage.this,MainActivity.class);
        startActivity(intent);
    }

}
