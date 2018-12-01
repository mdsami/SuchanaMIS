package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import net.savethechildren.bangladesh.suchanamis.R;

public class Code105Ck2Activity extends AppCompatActivity {

    Button btnNext;
    Button btnPre;
    int value = 0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code105_ck2);



        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");


        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code105Ck2Activity.this, Code105Ck3Activity.class);
                startActivity(i);

            }
        });

        btnPre = (Button) findViewById(R.id.btnPre);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code105Ck2Activity.this, Code105CkActivity.class);
                startActivity(i);

                finish();

            }
        });
    }
}
