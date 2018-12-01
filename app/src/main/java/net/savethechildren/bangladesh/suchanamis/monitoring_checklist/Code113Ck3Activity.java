package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import net.savethechildren.bangladesh.suchanamis.R;

public class Code113Ck3Activity extends AppCompatActivity {


    Button btnSub;
    Button btnPre;
    int value = 0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code113_ck3);









        btnSub = (Button) findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code113Ck3Activity.this, MonitoringCheckListActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),
                        "All Data Successfully Save ",
                        Toast.LENGTH_LONG).show();

                finish();

            }
        });


        btnPre = (Button) findViewById(R.id.btnPre);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code113Ck3Activity.this, Code113Ck2Activity.class);
                startActivity(i);

                finish();

            }
        });
    }
}