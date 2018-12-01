package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;

public class Code104Ck2Activity extends AppCompatActivity {

    Button btnSub;
    Button btnPre;
    int value = 0;
    Spinner spinner;

    SharedPreferences sharedpreferences;

    DBHandler db;

    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20, et21, et22, et23, et24, et25, et26, et27, et28, et29, et30, et31, et32, et33, et34, et35, et36, et37, et38, et39, et40, et41, et42, et43,et44,et45,et46,et47,et48,et49,et50,et51,et52,et53,et54;

    String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27;

    CheckBox ck1;
    CheckBox ck2;
    CheckBox ck3;
    CheckBox ck4;
    CheckBox ck5;
    CheckBox ck6;
    CheckBox ck7;
    CheckBox ck8;
    CheckBox ck9;

    int ck1Vlaue;
    int ck2Vlaue;
    int ck3Vlaue;
    int ck4Vlaue;
    int ck5Vlaue;
    int ck6Vlaue;
    int ck7Vlaue;
    int ck8Vlaue;
    int ck9Vlaue;

    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    Spinner sp5;
    Spinner sp6;
    Spinner sp7;
    Spinner sp8;
    Spinner sp9;
    Spinner sp10;
    Spinner sp11;
    Spinner sp12;
    Spinner sp13;
    Spinner sp14;
    Spinner sp15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code104_ck2);



        et27=(EditText)findViewById(R.id.etq27);
        et28=(EditText)findViewById(R.id.etq28);
        et29=(EditText)findViewById(R.id.etDate);
        et30=(EditText)findViewById(R.id.etq30);
        et31=(EditText)findViewById(R.id.etq31);
        et32=(EditText)findViewById(R.id.etq32);
        et33=(EditText)findViewById(R.id.etq33);
        et34=(EditText)findViewById(R.id.etq34);
        et35=(EditText)findViewById(R.id.etq35);
        et36=(EditText)findViewById(R.id.etq36);
        et37=(EditText)findViewById(R.id.etq37);
        et38=(EditText)findViewById(R.id.etq38);
        et39=(EditText)findViewById(R.id.etq39);
        et40=(EditText)findViewById(R.id.etq40);
        et41=(EditText)findViewById(R.id.etq41);
        et42=(EditText)findViewById(R.id.etq42);
        et43=(EditText)findViewById(R.id.etq43);
        et44=(EditText)findViewById(R.id.etq44);
        et45=(EditText)findViewById(R.id.etq45);
        et46=(EditText)findViewById(R.id.etq46);
        et47=(EditText)findViewById(R.id.etq47);
        et48=(EditText)findViewById(R.id.etq48);
        et49=(EditText)findViewById(R.id.etq49);
        et50=(EditText)findViewById(R.id.etq50);
        et51=(EditText)findViewById(R.id.etq51);
        et52=(EditText)findViewById(R.id.etq52);
        et53=(EditText)findViewById(R.id.etq53);
        et54=(EditText)findViewById(R.id.etq54);
//        et55=(EditText)findViewById(R.id.etq55);


        sp9= (Spinner) findViewById(R.id.sp9);
        sp10= (Spinner) findViewById(R.id.sp10);
        sp11= (Spinner) findViewById(R.id.sp11);
        sp12= (Spinner) findViewById(R.id.sp12);
        sp13= (Spinner) findViewById(R.id.sp13);
        sp14= (Spinner) findViewById(R.id.sp14);

//        sp16= (Spinner) findViewById(R.id.sp8);




        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");

        db = new DBHandler(this);



        sharedpreferences = getSharedPreferences("checklist-104", Context.MODE_PRIVATE);

        btnSub = (Button) findViewById(R.id.btnSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                q1  = et1.getText().toString();
                q2  = et2.getText().toString();
                q3  = et3.getText().toString();
                q4  = et4.getText().toString();
                q5  = et5.getText().toString();
                q6  = et6.getText().toString();
                q7  = et7.getText().toString();
                q8  = et8.getText().toString();
                q9  = et9.getText().toString();
                q10  = et10.getText().toString();
                q11  = et11.getText().toString();
                q12  = et12.getText().toString();
                q13  = et13.getText().toString();
                q14  = et14.getText().toString();
                q15  = et15.getText().toString();
                q16 = et16.getText().toString();







                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("et1", q1);
                editor.putString("et2", q2);
                editor.putString("et3", q3);
                editor.putString("et4", q4);
                editor.putString("et5", q5);
                editor.putString("et6", q6);
                editor.putString("et7", q7);
                editor.putString("et8", q8);
                editor.putString("et9", q9);
                editor.putString("et10", q10);
                editor.putString("et11", q11);
                editor.putString("et12", q12);
                editor.putString("et13", q13);
                editor.putString("et14", q14);
                editor.putString("et15", q15);
                editor.putString("et16", q16);

                Intent i = new Intent(Code104Ck2Activity.this, MonitoringCheckListActivity.class);
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

                Intent i = new Intent(Code104Ck2Activity.this, Code104CkActivity.class);
                startActivity(i);

                finish();

            }
        });

    }




    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.ck22:
                if(ck1.isChecked()){
                    ck1Vlaue = 1;
                }
                if(ck2.isChecked()){
                    ck2Vlaue = 2;
                }
                if(ck3.isChecked()){
                    ck3Vlaue = 3;
                }
                if(ck4.isChecked()){
                    ck4Vlaue = 4;
                }
                if(ck5.isChecked()){
                    ck5Vlaue = 5;
                }
                if(ck6.isChecked()){
                    ck6Vlaue = 6;
                }
                if(ck7.isChecked()){
                    ck7Vlaue = 7;
                }
                if(ck8.isChecked()){
                    ck8Vlaue = 8;
                }
                if(ck9.isChecked()){
                    ck9Vlaue = 9;
                }

                else
                    //findAndRemove("sport");

                break;

        }
    }
}
