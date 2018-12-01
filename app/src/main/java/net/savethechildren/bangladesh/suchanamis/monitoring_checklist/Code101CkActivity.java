package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;
import net.savethechildren.bangladesh.suchanamis.service_tracking.TrainingServiceActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Code101CkActivity extends AppCompatActivity {

    Button btnNext;
    EditText etDate;
    int typePosition;
    int value = 0;
    Spinner sp1;
    int sp1Value;
    EditText ed1,ed1_2,ed2,ed2_2,ed3,ed4,ed4_1,ed5,ed5_2,ed5_3,ed5_4,ed5_5,ed6,ed7,ed8,ed9,ed10,ed11,ed11_1,ed11_2,ed11_3,ed11_4;


    ArrayAdapter sp1dataAdapter;

    String[] sp1_arr = {"FIVDB", " RDRS " , " CNRS "};
    int[] sp1_arr_no = {1,2,3};

    public static String Report_date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;

//    DBHandler db;



    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code101_ck);

        ed1=(EditText)findViewById(R.id.etq1);
        ed1_2=(EditText)findViewById(R.id.etq1_2);
        ed2=(EditText)findViewById(R.id.etq2);
        ed2_2=(EditText)findViewById(R.id.etq2_2);
        ed3=(EditText)findViewById(R.id.etDate);
        ed4=(EditText)findViewById(R.id.etq4);
        ed4_1=(EditText)findViewById(R.id.etq4_1);
        ed5=(EditText)findViewById(R.id.etq5);
        ed5_2=(EditText)findViewById(R.id.etq5_2);
        ed5_3=(EditText)findViewById(R.id.etq5_3);
        ed5_4=(EditText)findViewById(R.id.etq5_4);
        ed5_5=(EditText)findViewById(R.id.etq5_5);
        ed6=(EditText)findViewById(R.id.etq6);
        ed7=(EditText)findViewById(R.id.etq7);
        ed8=(EditText)findViewById(R.id.etq8);

        ed10=(EditText)findViewById(R.id.etq10);

        ed11=(EditText)findViewById(R.id.etq11);
        ed11_1=(EditText)findViewById(R.id.etq11_1);
        ed11_2=(EditText)findViewById(R.id.etq11_2);
        ed11_3=(EditText)findViewById(R.id.etq11_3);
        ed11_4=(EditText)findViewById(R.id.etq11_4);

        sp1= (Spinner) findViewById(R.id.spq9);
        etDate = (EditText) findViewById(R.id.etDate);


        btnNext = (Button) findViewById(R.id.btnNext);
        sharedpreferences = getSharedPreferences("checklist-101", Context.MODE_PRIVATE);


        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");


        //db = new DBHandler(this);


        //date initial
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        etDate.setText("" + dateFormat1.format(date));
        Report_date = "" + dateFormat.format(date);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog();
            }
        });


        //Retrieve Data
        //getLocalData();










        //SP1



        sp1dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp1_arr);
        sp1dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(sp1dataAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp1Value = sp1_arr_no[pos] ;
                Log.e("value","pos"+sp1Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



        String q1 =  sharedpreferences.getString("q1", null);
        String q1_2 =  sharedpreferences.getString("q1_2", null);
        String q2 =  sharedpreferences.getString("q2", null);
        String q2_2 =  sharedpreferences.getString("q2_2", null);
        String q3 =  sharedpreferences.getString("q3", null);
        String q4 =  sharedpreferences.getString("q4", null);
        String q4_1 =  sharedpreferences.getString("q4_1", null);
        String q5 =  sharedpreferences.getString("q5", null);
        String q5_2 =  sharedpreferences.getString("q5_2", null);
        String q5_3 =  sharedpreferences.getString("q5_3", null);
        String q5_4 =  sharedpreferences.getString("q5_4", null);
        String q5_5 =  sharedpreferences.getString("q5_5", null);
        String q6 =  sharedpreferences.getString("q6", null);
        String q7 =  sharedpreferences.getString("q7", null);
        String q8 =  sharedpreferences.getString("q8", null);
        String q10 =  sharedpreferences.getString("q10", null);
        String q11 =  sharedpreferences.getString("q11", null);
        String q11_1 =  sharedpreferences.getString("q11_1", null);
        String q11_2 =  sharedpreferences.getString("q11_2", null);
        String q11_3 =  sharedpreferences.getString("q11_3", null);
        String q11_4 =  sharedpreferences.getString("q11_4", null);


        ed1.setText(q1);
        ed1_2.setText(q1_2);
        ed2.setText(q2);
        ed2_2.setText(q2_2);
        ed3.setText(q3);
        ed4.setText(q4);
        ed4_1.setText(q4_1);
        ed5.setText(q5);
        ed5_2.setText(q5_2);
        ed5_3.setText(q5_3);
        ed5_4.setText(q5_4);
        ed5_5.setText(q5_5);
        ed6.setText(q6);
        ed7.setText(q7);
        ed8.setText(q8);
        ed10.setText(q10);
        ed11.setText(q11);
        ed11_1.setText(q11_1);
        ed11_2.setText(q11_2);
        ed11_3.setText(q11_3);
        ed11_4.setText(q11_4);


//        HashMap<String,String> map1= new HashMap<String,String>();
//        map1.put("q1", "b1");
//        map1.put("q2", "c");
//        map1.put("q3", "d");
//        map1.put("q4", "e");

        //db.InsertTable(map1, "monitoring_checklist_101");


       // Log.e("test", q1+"->"+q1_2+"->"+q2+"->"+q2_2+"->"+q3+"->"+q4+"->"+q4+"->"+q5+"->"+q5_2+"->"+q5_3+"->"+q5_4+"->"+q5_4+"->"+q6+"->"+q7+"->"+q8+"->"+q10+"->"+q11+"->"+q11_1+"->"+q11_2+"->"+q11_3+"->"+q11_4+"->"+q11_5);





        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String q1  = ed1.getText().toString();
                String q1_2  = ed1_2.getText().toString();
                String q2  = ed2.getText().toString();
                String q2_2  = ed2_2.getText().toString();
                String q3  = ed3.getText().toString();
                String q4  = ed4.getText().toString();
                String q4_1  = ed4_1.getText().toString();

                String q5  = ed5.getText().toString();
                String q5_2  = ed5_2.getText().toString();
                String q5_3  = ed5_3.getText().toString();
                String q5_4  = ed5_3.getText().toString();
                String q5_5  = ed5_3.getText().toString();

                String q6  = ed6.getText().toString();
                String q7  = ed7.getText().toString();
                String q8  = ed8.getText().toString();

                String q10 = ed10.getText().toString();

                String q11 = ed11.getText().toString();
                String q11_1 = ed11.getText().toString();
                String q11_2 = ed11.getText().toString();
                String q11_3 = ed11.getText().toString();
                String q11_4 = ed11.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("q1", q1);
                editor.putString("q1_2", q1_2);
                editor.putString("q2", q2);
                editor.putString("q2_2", q2_2);
                editor.putString("q3", q3);
                editor.putString("q4", q4);
                editor.putString("q4_1", q4_1);
                editor.putString("q5", q5);
                editor.putString("q5_2", q5_2);
                editor.putString("q5_3", q5_3);
                editor.putString("q5_4", q5_4);
                editor.putString("q5_5", q5_5);
                editor.putString("q6", q6);
                editor.putString("q7", q7);
                editor.putString("q8", q8);
                editor.putString("q10", q10);
                editor.putString("q11", q11);
                editor.putString("q11_1", q11_1);
                editor.putString("q11_2", q11_2);
                editor.putString("q11_3", q11_3);
                editor.putString("q11_4", q11_4);
                editor.commit();




                        Intent i = new Intent(Code101CkActivity.this, Code101Ck2Activity.class);
                        startActivity(i);

                        finish();



            }
        });


    }


    public void DateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(Code101CkActivity.this, listener, year, month, day);
        dpDialog.show();
    }

    private void onPopulateSet(int year, int i, int dayOfMonth) {

        etDate.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date = year + "-" + i + "-" + dayOfMonth;
        etDate.setError(null);

        if (etDate.getText().toString().equals("")) {
            etDate.setError("Date Empty");
        } else {
            etDate.setError(null);

            Log.e("date", etDate.getText().toString());


        }

    }
}
