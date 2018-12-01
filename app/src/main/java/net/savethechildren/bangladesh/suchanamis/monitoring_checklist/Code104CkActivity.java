package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.app.DatePickerDialog;
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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Code104CkActivity extends AppCompatActivity {

    Button btnNext;
    int value = 0;
    EditText etDate;

    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20, et21, et22, et23, et24, et25, et26, et27, et28, et29, etq30, etq31, etq32, etq33, etq34, etq35, etq36, etq37, etq38, etq39, etq40, etq41, etq42, etq43,etq44,etq45,etq46,etq47,etq48,etq49,etq50,etq51,etq52,etq53,etq54;

    String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27;
    String etq1;

    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    Spinner sp5;
    Spinner sp6;
    Spinner sp7;
    Spinner sp8;



    ArrayAdapter sp1dataAdapter;
    ArrayAdapter sp2dataAdapter;
    ArrayAdapter sp3dataAdapter;
    ArrayAdapter sp4dataAdapter;
    ArrayAdapter sp5dataAdapter;
    ArrayAdapter sp6dataAdapter;
    ArrayAdapter sp7dataAdapter;
    ArrayAdapter sp8dataAdapter;



    int sp1Value;
    int sp2Value;
    int sp3Value;
    int sp4Value;
    int sp5Value;
    int sp6Value;
    int sp7Value;
    int sp8Value;

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





    public static String Report_date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;




    String[] sp1_arr = {" মহিলা (১৫-৪৫ বছর)  ", " কিশোরী (১৫-১৯ বছর)   "};
    int[] sp1_arr_no = {1,2};

    String[] sp2_arr = {"FIVDB", " RDRS " , " CNRS "};
    int[] sp2_arr_no = {1,2,3};


    String[] sp3_arr = {" নিজ  ", " বর্গা " , " খাস জমি ", " অন্যের জমি  ", " অন্যান্য "};
    int[] sp3_arr_no = {1,2,3,4,5};


    String[] sp4_arr = {"হ্যাঁ  ", "  না   "};
    int[] sp4_arr_no = {1,2};

    String[] sp5_arr = {"হ্যাঁ  ", "  না   "};
    int[] sp5_arr_no = {1,2};

    String[] sp6_arr = {"হ্যাঁ  ", "  না   "};
    int[] sp6_arr_no = {1,2};

    String[] sp7_arr = {" হ্যাঁ   ", "   না  "};
    int[] sp7_arr_no = {1,2};

    String[] sp8_arr = {" জীবন্ত বেড়া  ", "  সাধারণ বেড়া   "};
    int[] sp8_arr_no = {1,2};







    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code104_ck);


        ck1 = (CheckBox) findViewById(R.id.ck1);
        ck2 = (CheckBox) findViewById(R.id.ck1);
        ck3 = (CheckBox) findViewById(R.id.ck1);
        ck4 = (CheckBox) findViewById(R.id.ck1);
        ck5 = (CheckBox) findViewById(R.id.ck1);
        ck6 = (CheckBox) findViewById(R.id.ck1);
        ck7 = (CheckBox) findViewById(R.id.ck1);
        ck8 = (CheckBox) findViewById(R.id.ck1);
        ck9 = (CheckBox) findViewById(R.id.ck1);


        et1=(EditText)findViewById(R.id.etq1);
        et2=(EditText)findViewById(R.id.etq2);
        et3=(EditText)findViewById(R.id.etDate);
        et4=(EditText)findViewById(R.id.etq4);
        et5=(EditText)findViewById(R.id.etq5);
        et6=(EditText)findViewById(R.id.etq6);
        et7=(EditText)findViewById(R.id.etq7);
        et8=(EditText)findViewById(R.id.etq8);
        et9=(EditText)findViewById(R.id.etq9);
        et10=(EditText)findViewById(R.id.etq10);
        et11=(EditText)findViewById(R.id.etq11);
        et12=(EditText)findViewById(R.id.etq12);
        et13=(EditText)findViewById(R.id.etq13);
        et14=(EditText)findViewById(R.id.etq14);
        et15=(EditText)findViewById(R.id.etq15);
        et16=(EditText)findViewById(R.id.etq16);
        et17=(EditText)findViewById(R.id.etq17);
        et18=(EditText)findViewById(R.id.etq18);
        et19=(EditText)findViewById(R.id.etq19);
        et20=(EditText)findViewById(R.id.etq20);
        et21=(EditText)findViewById(R.id.etq21);
        et22=(EditText)findViewById(R.id.etq22);
        et23=(EditText)findViewById(R.id.etq23);
        et24=(EditText)findViewById(R.id.etq24);
        et25=(EditText)findViewById(R.id.etq25);
        et26=(EditText)findViewById(R.id.etq26);


        etDate = (EditText) findViewById(R.id.etDate);
        sp1= (Spinner) findViewById(R.id.sp1);
        sp2= (Spinner) findViewById(R.id.sp2);
        sp3= (Spinner) findViewById(R.id.sp3);
        sp4= (Spinner) findViewById(R.id.sp4);
        sp5= (Spinner) findViewById(R.id.sp5);
        sp6= (Spinner) findViewById(R.id.sp6);
        sp7= (Spinner) findViewById(R.id.sp7);
        sp8= (Spinner) findViewById(R.id.sp8);





        btnNext = (Button) findViewById(R.id.btnNext);
        sharedpreferences = getSharedPreferences("checklist-104", Context.MODE_PRIVATE);



        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");


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

        //SP2

        sp2dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp2_arr);
        sp2dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(sp2dataAdapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp2Value = sp2_arr_no[pos] ;
                Log.e("value","pos"+sp2Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP3

        sp3dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp3_arr);
        sp3dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(sp3dataAdapter);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp3Value = sp3_arr_no[pos] ;
                Log.e("value","pos"+sp3Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //SP4

        sp4dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp4_arr);
        sp4dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(sp4dataAdapter);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp4Value = sp4_arr_no[pos] ;
                Log.e("value","pos"+sp4Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP5

        sp5dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp5_arr);
        sp5dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp5.setAdapter(sp5dataAdapter);
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp5Value = sp5_arr_no[pos] ;
                Log.e("value","pos"+sp5Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP6

        sp6dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp6_arr);
        sp6dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp6.setAdapter(sp6dataAdapter);
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp6Value = sp6_arr_no[pos] ;
                Log.e("value","pos"+sp6Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //SP7

        sp7dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp7_arr);
        sp7dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp7.setAdapter(sp7dataAdapter);
        sp7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp7Value = sp7_arr_no[pos] ;
                Log.e("value","pos"+sp7Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //SP8

        sp8dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sp8_arr);
        sp8dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp8.setAdapter(sp8dataAdapter);
        sp8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                ((TextView) arg0.getChildAt(0)).setTextColor(Color.parseColor("#000000"));

                // get_status = Work_Status_Name.get(pos);
                sp8Value = sp8_arr_no[pos] ;
                Log.e("value","pos"+sp8Value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });




//
//
         q1 =  sharedpreferences.getString("et1", null);
         q2 =  sharedpreferences.getString("et2", null);
         q3 =  sharedpreferences.getString("et3", null);
//        q4 =  sharedpreferences.getString("et4", null);
//
//
//
//
//       et1.setText(q1);
//        et2.setText(q2);
//        et3.setText(q3);
//        et4.setText(q4);






        btnNext.setOnClickListener(new View.OnClickListener() {
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
                editor.putInt("sp1",sp1Value);
                editor.putInt("sp2",sp2Value);
                editor.putInt("sp3",sp3Value);
                editor.putInt("sp4",sp4Value);
                editor.putInt("sp5",sp5Value);
                editor.putInt("sp6",sp6Value);
                editor.putInt("sp7",sp7Value);
                editor.putInt("sp8",sp8Value);


//                editor.putString("q5", et5.getText().toString());
                editor.commit();

                Log.e("sp_postion",q1+"->"+q2+"->"+ q3+"->"+q4+"->"+q5+"->"+q6+"->"+q7+"->"+q8+"->"+sp1Value+"->"+sp2Value+"->"+sp3Value+"->"+sp4Value+"->"+sp5Value+"->"+sp6Value+"->"+sp7Value+"->"+sp8Value);



                //slNo = etslNo.getText().toString();
                //benNo = etbenNo.getText().toString();

                //benTypeCodeValue
                //nutCodeValue <->
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

               // other = etOther.getText().toString();

                //suchanaYearCodeValue
                //Report_date
                //ipNameCodeValue
                //villageName  <->
                //wardNo  <->
                //Report_date_scm
                //Report_date_ben_condition
                //benConditionValue
               // benCondition = etbenCondition.getText().toString();
                // Report_date_VMFDate
                //vmfDpValue
                //Report_date_disconDate
                //Report_date_skipSuchana
                //skipSuchanaOtherValue = etskipSuchanaOther.getText().toString();
                //OtherNotPresentValue = etOtherNotPresent.getText().toString();


                Intent i = new Intent(Code104CkActivity.this, Code104Ck2Activity.class);
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
        DatePickerDialog dpDialog = new DatePickerDialog(Code104CkActivity.this, listener, year, month, day);
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
