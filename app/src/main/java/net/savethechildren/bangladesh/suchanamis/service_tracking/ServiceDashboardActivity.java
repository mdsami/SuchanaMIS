package net.savethechildren.bangladesh.suchanamis.service_tracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.savethechildren.bangladesh.suchanamis.MainActivity;
import net.savethechildren.bangladesh.suchanamis.R;

public class ServiceDashboardActivity extends AppCompatActivity {

    Button btnTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_dashboard);

        btnTraining = (Button) findViewById(R.id.btnTraining);

        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(ServiceDashboardActivity.this, TrainingServiceActivity.class);
                startActivity(i);

            }
        });


    }
}
