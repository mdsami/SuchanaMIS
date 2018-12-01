package net.savethechildren.bangladesh.suchanamis.service_tracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import net.savethechildren.bangladesh.suchanamis.R;

public class ServiceUserListActivity extends AppCompatActivity {

    ImageView imgAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_user_list);

        imgAdd = (ImageView) findViewById(R.id.imgAdd);

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ServiceUserListActivity.this, ServiceGeneralActivity.class);
                startActivity(i);

            }
        });




    }

}
