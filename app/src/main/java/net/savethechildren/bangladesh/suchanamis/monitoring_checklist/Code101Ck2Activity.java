package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import net.savethechildren.bangladesh.suchanamis.R;

public class Code101Ck2Activity extends AppCompatActivity  {
    Button btnNext;
    Button btnPre;
    Context context;
    SharedPreferences sharedpreferences;
    int value ;
    Spinner spinner;
    Spinner spq12;
    Spinner spq13;
    Spinner spq14;
    Spinner spq15;
    Spinner spq16;
    Spinner spq17;
    Spinner spq18;
    Spinner spq19;
    Spinner spq20;
    Spinner spq21;
    Spinner spq22;
    Spinner spq23;
    Spinner spq24;
    Spinner spq25;

    ArrayAdapter sp12dataAdapter;
    ArrayAdapter sp13dataAdapter;
    ArrayAdapter sp14dataAdapter;
    ArrayAdapter sp15dataAdapter;
    ArrayAdapter sp16dataAdapter;
    ArrayAdapter sp17dataAdapter;
    ArrayAdapter sp18dataAdapter;
    ArrayAdapter sp19dataAdapter;
    ArrayAdapter sp20dataAdapter;
    ArrayAdapter sp21dataAdapter;
    ArrayAdapter sp22dataAdapter;
    ArrayAdapter sp23dataAdapter;
    ArrayAdapter sp24dataAdapter;
    ArrayAdapter sp25dataAdapter;


    int sp12Value;
    int sp13Value;
    int sp14Value;
    int sp15Value;
    int sp16Value;
    int sp17Value;
    int sp18Value;
    int sp19Value;
    int sp20Value;
    int sp21Value;
    int sp22Value;
    int sp23Value;
    int sp24Value;
    int sp25Value;



    String q12 ;
    String[] sp_arr = {"খুব ভাল ", "ভাল ","মোটামুটি", "দূর্বল  "};
    int[] sp_arr_no = {1,2,3,4};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code101_ck2);


        spq12 = (Spinner) findViewById(R.id.q12);
        spq13 = (Spinner) findViewById(R.id.q13);
        spq14 = (Spinner) findViewById(R.id.q14);
        spq15 = (Spinner) findViewById(R.id.q15);
        spq16 = (Spinner) findViewById(R.id.q16);
        spq17 = (Spinner) findViewById(R.id.q17);
        spq18 = (Spinner) findViewById(R.id.q18);
        spq19 = (Spinner) findViewById(R.id.q19);
        spq20 = (Spinner) findViewById(R.id.q20);
        spq21 = (Spinner) findViewById(R.id.q21);
        spq22 = (Spinner) findViewById(R.id.q22);
        spq23 = (Spinner) findViewById(R.id.q23);
        spq24 = (Spinner) findViewById(R.id.q24);
        spq25 = (Spinner) findViewById(R.id.q25);

        sharedpreferences = getSharedPreferences("checklist-101", Context.MODE_PRIVATE);

        sp12Value =  sharedpreferences.getInt("q12", 0);
        sp13Value =  sharedpreferences.getInt("q13", 0);
        sp14Value =  sharedpreferences.getInt("q14", 0);
        sp15Value =  sharedpreferences.getInt("q15", 0);
        sp16Value =  sharedpreferences.getInt("q16", 0);
        sp17Value =  sharedpreferences.getInt("q17", 0);
        sp18Value =  sharedpreferences.getInt("q18", 0);
        sp19Value =  sharedpreferences.getInt("q19", 0);
        sp20Value =  sharedpreferences.getInt("q20", 0);
        sp21Value =  sharedpreferences.getInt("q21", 0);
        sp22Value =  sharedpreferences.getInt("q22", 0);
        sp23Value =  sharedpreferences.getInt("q23", 0);
        sp24Value =  sharedpreferences.getInt("q24", 0);
        sp25Value =  sharedpreferences.getInt("q25", 0);

       // Log.e("test", sp12Value+"->"+sp13Value);


//SP12

        sp12dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp12dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq12.setAdapter(sp12dataAdapter);
        spq12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp12Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp12Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

//SP13

        sp13dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp13dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq13.setAdapter(sp13dataAdapter);
        spq13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp13Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp13Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP14

        sp14dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp14dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq14.setAdapter(sp14dataAdapter);
        spq14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp14Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp14Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP15

        sp15dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp15dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq15.setAdapter(sp15dataAdapter);
        spq15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp15Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp15Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP16

        sp16dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp16dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq16.setAdapter(sp16dataAdapter);
        spq16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp16Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp16Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP17

        sp17dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp17dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq17.setAdapter(sp17dataAdapter);
        spq17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp17Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp17Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP18

        sp18dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp18dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq18.setAdapter(sp18dataAdapter);
        spq18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp18Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp18Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP19

        sp19dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp19dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq19.setAdapter(sp19dataAdapter);
        spq19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp19Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp19Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP20

        sp20dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp20dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq20.setAdapter(sp20dataAdapter);
        spq20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp20Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp20Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //SP21

        sp21dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp21dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq21.setAdapter(sp21dataAdapter);
        spq21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp21Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp21Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP22

        sp22dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp22dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq22.setAdapter(sp22dataAdapter);
        spq22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp22Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp22Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP23

        sp23dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp23dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq23.setAdapter(sp23dataAdapter);
        spq23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp23Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp23Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP24

        sp24dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp24dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq24.setAdapter(sp24dataAdapter);
        spq24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp24Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp24Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP25

        sp25dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp_arr);
        sp25dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spq25.setAdapter(sp25dataAdapter);
        spq25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp25Value = sp_arr_no[pos] ;
                Log.e("value","pos"+sp25Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });








        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");


        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //String q12  = spq12.getText().toString();




                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putInt("q12",sp12Value);
                editor.putInt("q13",sp13Value);
                editor.putInt("q14",sp14Value);
                editor.putInt("q15",sp15Value);
                editor.putInt("q16",sp16Value);
                editor.putInt("q17",sp17Value);
                editor.putInt("spq18",sp18Value);
                editor.putInt("spq19",sp19Value);
                editor.putInt("spq20",sp20Value);
                editor.putInt("spq21",sp21Value);
                editor.putInt("spq22",sp22Value);
                editor.putInt("spq23",sp23Value);
                editor.putInt("spq24",sp24Value);
                editor.putInt("spq25",sp25Value);

                editor.commit();

                Log.e("test", sp12Value+"->"+sp13Value+"->"+sp14Value+"->"+sp15Value+"->"+sp16Value+"->"+sp17Value+"->"+sp18Value+"->"+sp19Value+"->"+sp20Value+"->"+sp21Value+"->"+sp22Value+"->"+sp23Value+"->"+sp24Value+"->"+sp25Value);


                Intent i = new Intent(Code101Ck2Activity.this, Code101Ck3Activity.class);
                startActivity(i);

            }
        });

        btnPre = (Button) findViewById(R.id.btnPre);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Code101Ck2Activity.this, Code101CkActivity.class);
                startActivity(i);

                finish();

            }
        });



    }
}
