package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import net.savethechildren.bangladesh.suchanamis.R;

public class Code102Ck2Activity extends AppCompatActivity {

    Button btnNext;
    Button btnPre;
    int value = 0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code102_ck2);




        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");



    }
}
