package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import net.savethechildren.bangladesh.suchanamis.R;

public class Code105CkActivity extends AppCompatActivity {

    Button btnNext;
    int value = 0;
    Spinner spinner;
    EditText pDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code105_ck);


        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");


        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code105CkActivity.this, Code105Ck2Activity.class);
                startActivity(i);

                finish();

            }
        });
    }
}
