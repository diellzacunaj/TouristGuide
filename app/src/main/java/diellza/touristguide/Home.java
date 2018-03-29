package diellza.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Activities.ScanQRCodeActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Fragments.CategoryFragment;
import diellza.touristguide.Fragments.ScanFragment;
import diellza.touristguide.Models.Category;

public class Home extends AppCompatActivity {

    Button view_categories, qr_code;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = new SearchView(this);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo search view implementation
            }
        });

        view_categories = (Button)findViewById(R.id.view_categories);
        qr_code = (Button)findViewById(R.id.qr_code);

        view_categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ScanQRCodeActivity.class);
                startActivity(intent);
            }
        });

    }

}
