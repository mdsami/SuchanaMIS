package net.savethechildren.bangladesh.suchanamis.service_tracking;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Spinner;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.module.DataClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiceGeneralActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnFinish;

    EditText etslNo;
    String slNo;
    EditText etbenNo;
    String benNo;
    EditText etskipSuchanaOther;
    String skipSuchanaOtherValue;
    EditText etOtherNotPresent;
    String OtherNotPresentValue;
    EditText etOther;
    EditText etbenCondition;
    String benCondition;
    String other;
    String skipSuchanaOther;
    String OtherNotPresent;
    Spinner spbenTypeCode;
    Spinner spsuchanaYearCode;
    Spinner spipNameCode;
    Spinner spbenCondition;
    Spinner spvmfDp;
    Spinner spskipSuchana;
    ArrayAdapter benTypeCodeAdapter;
    ArrayAdapter suchanaYearCodeAdapter;
    ArrayAdapter ipNameCodeAdapter;
    ArrayAdapter benConditionAdapter;
    ArrayAdapter vmfDpAdapter;
    ArrayAdapter skipSuchanaAdapter;
    Context context;
    int benTypeCodeValue;
    int suchanaYearCodeValue;
    int ipNameCodeValue;
    int benConditionValue;
    int vmfDpValue;
    int skipSuchanaValue;
    int nutCodeValue=0;
    int villageName = 0;
    int wardNo = 0;

    public static String Report_date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;

    public static String Report_date_scm;
    private Calendar cal_scm;
    private int day_scm;
    private int month_scm;
    private int year_scm;

    public static String Report_date_ben_condition;
    private Calendar cal_ben_condition;
    private int day_ben_condition;
    private int month_ben_condition;
    private int year_ben_condition;

    public static String Report_date_VMFDate;
    private Calendar cal_VMFDate;
    private int day_VMFDate;
    private int month_VMFDate;
    private int year_VMFDate;

    public static String Report_date_disconDate;
    private Calendar cal_disconDate;
    private int day_disconDate;
    private int month_disconDate;
    private int year_disconDate;

    public static String Report_date_skipSuchana;
    private Calendar cal_skipSuchana;
    private int day_skipSuchana;
    private int month_skipSuchana;
    private int year_skipSuchana;


    EditText etDate;
    EditText etSCMVisitDate;
    EditText etbenConditionDate;
    EditText etVMFDate;
    EditText etdisconDate;
    EditText etskipSuchana;


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_general);

        context = this;

        btnFinish = (Button) findViewById(R.id.btnFinish);

        etslNo = (EditText) findViewById(R.id.etslNo);
        etbenNo = (EditText) findViewById(R.id.etbenNo);
        spbenTypeCode = (Spinner) findViewById(R.id.spbenTypeCode);
        spsuchanaYearCode = (Spinner) findViewById(R.id.spsuchanaYearCode);
        spipNameCode = (Spinner) findViewById(R.id.spipNameCode);
        etDate = (EditText) findViewById(R.id.etDate);
        etSCMVisitDate = (EditText) findViewById(R.id.etSCMVisitDate);
        spbenCondition = (Spinner) findViewById(R.id.spbenCondition);
        etbenConditionDate = (EditText) findViewById(R.id.etbenConditionDate);
        etVMFDate = (EditText) findViewById(R.id.etVMFDate);
        etdisconDate = (EditText) findViewById(R.id.etdisconDate);
        spvmfDp = (Spinner) findViewById(R.id.spvmfDp);
        spskipSuchana = (Spinner) findViewById(R.id.spskipSuchana);
        etskipSuchanaOther = (EditText) findViewById(R.id.etskipSuchanaOther);
        etOtherNotPresent = (EditText) findViewById(R.id.etOtherNotPresent);
        etskipSuchana = (EditText) findViewById(R.id.etskipSuchana);
        etOther = (EditText) findViewById(R.id.etOther);
        etbenCondition = (EditText) findViewById(R.id.etbenCondition);

        ck1 = (CheckBox) findViewById(R.id.ck1);
        ck2 = (CheckBox) findViewById(R.id.ck1);
        ck3 = (CheckBox) findViewById(R.id.ck1);
        ck4 = (CheckBox) findViewById(R.id.ck1);
        ck5 = (CheckBox) findViewById(R.id.ck1);
        ck6 = (CheckBox) findViewById(R.id.ck1);
        ck7 = (CheckBox) findViewById(R.id.ck1);
        ck8 = (CheckBox) findViewById(R.id.ck1);
        ck9 = (CheckBox) findViewById(R.id.ck1);



        benTypeCodeAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.beneficiary_type_arr);
        benTypeCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spbenTypeCode.setAdapter(benTypeCodeAdapter);
        spbenTypeCode.setOnItemSelectedListener(this);

        suchanaYearCodeAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.suchanaYearCode_arr);
        suchanaYearCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spsuchanaYearCode.setAdapter(suchanaYearCodeAdapter);
        spsuchanaYearCode.setOnItemSelectedListener(this);

        ipNameCodeAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.ipNameCode_arr);
        ipNameCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spipNameCode.setAdapter(ipNameCodeAdapter);
        spipNameCode.setOnItemSelectedListener(this);

        benConditionAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.benCondition_arr);
        benConditionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spbenCondition.setAdapter(benConditionAdapter);
        spbenCondition.setOnItemSelectedListener(this);

        vmfDpAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.vmf_dp_arr);
        vmfDpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spvmfDp.setAdapter(vmfDpAdapter);
        spvmfDp.setOnItemSelectedListener(this);

        skipSuchanaAdapter = new ArrayAdapter(context, R.layout.spinner, DataClass.skipSuchana_arr);
        skipSuchanaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spskipSuchana.setAdapter(skipSuchanaAdapter);
        spskipSuchana.setOnItemSelectedListener(this);


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


        //date initial
        cal_scm = Calendar.getInstance();
        day_scm = cal_scm.get(Calendar.DAY_OF_MONTH);
        month_scm = cal_scm.get(Calendar.MONTH);
        year_scm = cal_scm.get(Calendar.YEAR);

        DateFormat dateFormat_scm = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1_scm = new SimpleDateFormat("dd-MM-yyyy");
        Date date_scm = new Date();

        etSCMVisitDate.setText("" + dateFormat1_scm.format(date_scm));
        Report_date_scm = "" + dateFormat_scm.format(date_scm);

        etSCMVisitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog_scm();
            }
        });



        //date initial
        cal_ben_condition = Calendar.getInstance();
        day_ben_condition = cal_ben_condition.get(Calendar.DAY_OF_MONTH);
        month_ben_condition = cal_ben_condition.get(Calendar.MONTH);
        year_ben_condition = cal_ben_condition.get(Calendar.YEAR);

        DateFormat dateFormat_ben_condition = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1_ben_condition = new SimpleDateFormat("dd-MM-yyyy");
        Date date_ben_condition = new Date();

        etbenConditionDate.setText("" + dateFormat1_ben_condition.format(date_ben_condition));
        Report_date_ben_condition = "" + dateFormat_ben_condition.format(date_ben_condition);

        etbenConditionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog_ben_condition();
            }
        });


        //date initial
        cal_VMFDate = Calendar.getInstance();
        day_VMFDate = cal_VMFDate.get(Calendar.DAY_OF_MONTH);
        month_VMFDate = cal_VMFDate.get(Calendar.MONTH);
        year_VMFDate = cal_VMFDate.get(Calendar.YEAR);

        DateFormat dateFormat_VMFDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1_dateFormat_VMFDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date_dateFormat_VMFDate = new Date();

        etVMFDate.setText("" + dateFormat1_dateFormat_VMFDate.format(date_dateFormat_VMFDate));
        Report_date_VMFDate = "" + dateFormat_VMFDate.format(date_dateFormat_VMFDate);

        etVMFDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog_VMFDate();
            }
        });

        //date initial
        cal_disconDate = Calendar.getInstance();
        day_disconDate = cal_disconDate.get(Calendar.DAY_OF_MONTH);
        month_disconDate = cal_disconDate.get(Calendar.MONTH);
        year_disconDate = cal_disconDate.get(Calendar.YEAR);

        DateFormat dateFormat_disconDate = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1_dateFormat_disconDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date_dateFormat_disconDate = new Date();

        etdisconDate.setText("" + dateFormat1_dateFormat_disconDate.format(date_dateFormat_disconDate));
        Report_date_disconDate = "" + dateFormat_disconDate.format(date_dateFormat_disconDate);

        etdisconDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog_disconDate();
            }
        });

        //date initial
        cal_skipSuchana = Calendar.getInstance();
        day_skipSuchana = cal_skipSuchana.get(Calendar.DAY_OF_MONTH);
        month_skipSuchana = cal_skipSuchana.get(Calendar.MONTH);
        year_skipSuchana = cal_skipSuchana.get(Calendar.YEAR);

        DateFormat dateFormat_skipSuchana = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1_dateFormat_skipSuchana= new SimpleDateFormat("dd-MM-yyyy");
        Date date_dateFormat_skipSuchana = new Date();

        etskipSuchana.setText("" + dateFormat1_dateFormat_skipSuchana.format(date_dateFormat_skipSuchana));
        Report_date_skipSuchana = "" + dateFormat_skipSuchana.format(date_dateFormat_skipSuchana);

        etskipSuchana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog_skipSuchana();
            }
        });


        spbenCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                benTypeCodeValue = DataClass.benCondition_arr_no[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slNo = etslNo.getText().toString();
                benNo = etbenNo.getText().toString();

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

                other = etOther.getText().toString();

                //suchanaYearCodeValue
                //Report_date
                //ipNameCodeValue
                //villageName  <->
                 //wardNo  <->
                //Report_date_scm
                //Report_date_ben_condition
                //benConditionValue
                benCondition = etbenCondition.getText().toString();
               // Report_date_VMFDate
                //vmfDpValue
                //Report_date_disconDate
                //Report_date_skipSuchana
                skipSuchanaOtherValue = etskipSuchanaOther.getText().toString();
                OtherNotPresentValue = etOtherNotPresent.getText().toString();








                //Log.e("Registration Log", slNo+"->")



                Intent i = new Intent(ServiceGeneralActivity.this, TrainingServiceActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        adapterView.getItemAtPosition(pos);

        switch (adapterView.getId()){

            case R.id.spbenTypeCode:
                //Toast.makeText(getApplicationContext(),pos+"",Toast.LENGTH_LONG).show();

                benTypeCodeValue = DataClass.beneficiary_type_arr_no[pos];

                break;

            case R.id.spsuchanaYearCode:

                suchanaYearCodeValue = DataClass.suchanaYearCode_arr_no[pos];

                break;


            case R.id.spipNameCode:

                ipNameCodeValue = DataClass.ipNameCode_arr_no[pos];

                break;

            case R.id.spbenCondition:

                benConditionValue = DataClass.benCondition_arr_no[pos];

                break;

            case R.id.spvmfDp:

                etdisconDate.setVisibility(View.GONE);
                etdisconDate.setText("");

                vmfDpValue = DataClass.vmf_dp_arr_no[pos];
                 if(vmfDpValue==3){
                     etdisconDate.setVisibility(View.VISIBLE);
                 }

                break;

            case R.id.spskipSuchana:
                etskipSuchanaOther.setVisibility(View.GONE);
                etOtherNotPresent.setVisibility(View.GONE);
                etskipSuchanaOther.setText("");
                etOtherNotPresent.setText("");

                skipSuchanaValue = DataClass.skipSuchana_no[pos];
                if(skipSuchanaValue==4){
                    etskipSuchanaOther.setVisibility(View.VISIBLE);
                }else if(skipSuchanaValue==99){
                    etOtherNotPresent.setVisibility(View.VISIBLE);
                }

                break;



        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year, month, day);
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
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }

    public void DateDialog_scm() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet_scm(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year_scm, month_scm, day_scm);
        dpDialog.show();
    }
    private void onPopulateSet_scm(int year, int i, int dayOfMonth) {

        etSCMVisitDate.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date_scm = year + "-" + i + "-" + dayOfMonth;
        etSCMVisitDate.setError(null);

        if (etSCMVisitDate.getText().toString().equals("")) {
            etSCMVisitDate.setError("Date Empty");
        } else {
            etSCMVisitDate.setError(null);

            Log.e("date", etSCMVisitDate.getText().toString());
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }


    public void DateDialog_ben_condition() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet_ben_condition(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year_ben_condition, month_ben_condition, day_ben_condition);
        dpDialog.show();
    }
    private void onPopulateSet_ben_condition(int year, int i, int dayOfMonth) {

        etbenConditionDate.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date_ben_condition = year + "-" + i + "-" + dayOfMonth;
        etbenConditionDate.setError(null);

        if (etbenConditionDate.getText().toString().equals("")) {
            etbenConditionDate.setError("Date Empty");
        } else {
            etbenConditionDate.setError(null);

            Log.e("date", etbenConditionDate.getText().toString());
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }

    public void DateDialog_VMFDate() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet_VMFDate(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year_VMFDate, month_VMFDate, day_VMFDate);
        dpDialog.show();
    }
    private void onPopulateSet_VMFDate(int year, int i, int dayOfMonth) {

        etVMFDate.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date_VMFDate = year + "-" + i + "-" + dayOfMonth;
        etVMFDate.setError(null);

        if (etVMFDate.getText().toString().equals("")) {
            etVMFDate.setError("Date Empty");
        } else {
            etVMFDate.setError(null);

            Log.e("date", etVMFDate.getText().toString());
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }


    public void DateDialog_disconDate() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet_disconDate(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year_disconDate, month_disconDate, day_disconDate);
        dpDialog.show();
    }
    private void onPopulateSet_disconDate(int year, int i, int dayOfMonth) {

        etdisconDate.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date_disconDate = year + "-" + i + "-" + dayOfMonth;
        etdisconDate.setError(null);

        if (etdisconDate.getText().toString().equals("")) {
            etdisconDate.setError("Date Empty");
        } else {
            etdisconDate.setError(null);

            Log.e("date", etdisconDate.getText().toString());
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }

    public void DateDialog_skipSuchana() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                onPopulateSet_skipSuchana(year, monthOfYear + 1, dayOfMonth);
                // onPopulateSet(year, monthOfYear, dayOfMonth);

            }
        };
        //  DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month + 1, day);
        DatePickerDialog dpDialog = new DatePickerDialog(ServiceGeneralActivity.this, listener, year_skipSuchana, month_skipSuchana, day_skipSuchana);
        dpDialog.show();
    }
    private void onPopulateSet_skipSuchana(int year, int i, int dayOfMonth) {

        etskipSuchana.setText(dayOfMonth + "-" + i + "-" + year);
        Report_date_skipSuchana= year + "-" + i + "-" + dayOfMonth;
        etskipSuchana.setError(null);

        if (etskipSuchana.getText().toString().equals("")) {
            etskipSuchana.setError("Date Empty");
        } else {
            etskipSuchana.setError(null);

            Log.e("date", etskipSuchana.getText().toString());
//
//            if (isConnectingToInternet()) {
////            DpSubListThread projectListActivity = new DpSubListThread(Login_Sr_Group_ID,Category_Name, Group_Code);
////            projectListActivity.start();
//                response(Login_Sr_ID_order, edt_Report_order_date.getText().toString());
//
//                // mProgressBar.setVisibility(View.VISIBLE);
//            } else {
//                Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
//            }
//            userClassAray.clear();

        }

    }



}
