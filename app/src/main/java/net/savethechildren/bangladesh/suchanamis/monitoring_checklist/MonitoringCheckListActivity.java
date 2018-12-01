package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import net.savethechildren.bangladesh.suchanamis.MainActivity;
import net.savethechildren.bangladesh.suchanamis.R;

public class MonitoringCheckListActivity extends AppCompatActivity {

    Button btn101Checklist;
    Button btn102Checklist;
    Button btn103Checklist;
    Button btn104Checklist;
    Button btn105Checklist;
    Button btn106Checklist;
    Button btn107Checklist;
    Button btn108Checklist;
    Button btn109Checklist;
    Button btn110Checklist;
    Button btn111Checklist;
    Button btn112Checklist;
    Button btn113Checklist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_check_list);

        btn101Checklist = (Button) findViewById(R.id.btn101Checklist);

        btn101Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code101ListActivity.class);
                startActivity(i);

            }
        });



        btn102Checklist = (Button) findViewById(R.id.btn102Checklist);

        btn102Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code102CkActivity.class);
                startActivity(i);

            }
        });


        btn103Checklist = (Button) findViewById(R.id.btn103Checklist);

        btn103Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code103CkActivity.class);
                startActivity(i);

            }
        });


        btn104Checklist = (Button) findViewById(R.id.btn104Checklist);

        btn104Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code104CkActivity.class);
                startActivity(i);

            }
        });


        btn104Checklist = (Button) findViewById(R.id.btn104Checklist);

        btn104Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code104CkActivity.class);
                startActivity(i);

            }
        });


        btn105Checklist = (Button) findViewById(R.id.btn105Checklist);

        btn105Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code105CkActivity.class);
                startActivity(i);

            }
        });


        btn106Checklist = (Button) findViewById(R.id.btn106Checklist);

        btn106Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code106CkActivity.class);
                startActivity(i);

            }
        });



        btn107Checklist = (Button) findViewById(R.id.btn107Checklist);

        btn107Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code107CkActivity.class);
                startActivity(i);

            }
        });


        btn108Checklist = (Button) findViewById(R.id.btn108Checklist);

        btn108Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code108CkActivity.class);
                startActivity(i);

            }
        });


        btn109Checklist = (Button) findViewById(R.id.btn109Checklist);

        btn109Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code109CkActivity.class);
                startActivity(i);

            }
        });



        btn110Checklist = (Button) findViewById(R.id.btn110Checklist);

        btn110Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code110CkActivity.class);
                startActivity(i);

            }
        });



        btn111Checklist = (Button) findViewById(R.id.btn111Checklist);

        btn111Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code111CkActivity.class);
                startActivity(i);

            }
        });



        btn112Checklist = (Button) findViewById(R.id.btn112Checklist);

        btn112Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code112CkActivity.class);
                startActivity(i);

            }
        });




        btn113Checklist = (Button) findViewById(R.id.btn113Checklist);

        btn113Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MonitoringCheckListActivity.this, Code113CkActivity.class);
                startActivity(i);

            }
        });




    }


}
