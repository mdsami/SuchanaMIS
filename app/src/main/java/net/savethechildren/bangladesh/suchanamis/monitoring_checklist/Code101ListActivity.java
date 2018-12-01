package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.service_tracking.ServiceGeneralActivity;
import net.savethechildren.bangladesh.suchanamis.service_tracking.ServiceUserListActivity;

public class Code101ListActivity extends AppCompatActivity {

    ImageView imgAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code101_list);


        imgAdd = (ImageView) findViewById(R.id.imgAdd);

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Code101ListActivity.this, Code101CkActivity.class);
                startActivity(i);

            }
        });

    }
}
