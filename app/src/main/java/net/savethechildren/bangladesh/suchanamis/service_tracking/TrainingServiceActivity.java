package net.savethechildren.bangladesh.suchanamis.service_tracking;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.adapter.TrainingServiceAdapter;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;
import net.savethechildren.bangladesh.suchanamis.module.DataClass;
import net.savethechildren.bangladesh.suchanamis.module.TrainingServiceClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingServiceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Context context;
    Spinner spTrainingType;
    EditText etDate;
    Spinner spType;
    Spinner spReceiver;
    Spinner spTrainingNo;
    EditText etOther;
    EditText etMeasure;
    Button btnSubmit;

    List<String> district = new ArrayList<String>();
    List<String> code = new ArrayList<String>();

    ArrayAdapter dataAdapter;
    ArrayAdapter adapterType;
    ArrayAdapter adapterReceiver;
    ArrayAdapter adapterNo;
    String trainingName;
    int trainingNameId;
    int trainingtype;
    int trainingreceiver;
    int trainingno;
    String status;
    int measureNo;

    public static String Report_date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    ArrayList<TrainingServiceClass> userClassAray;
    ListView lvTraining;
    TrainingServiceAdapter adapter;

    DBHandler db;
    String tracking_service_info = "tracking_service_info";
    ArrayList<HashMap<String,String>> arrProductAndDeficiencyEdit=new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_service);

        context = this;
        userClassAray = new ArrayList<TrainingServiceClass>();
        spTrainingType = (Spinner) findViewById(R.id.spTrainingType);
        etDate = (EditText) findViewById(R.id.etDate);
        spType = (Spinner) findViewById(R.id.spType);
        spReceiver = (Spinner) findViewById(R.id.spReceiver);
        etOther = (EditText) findViewById(R.id.etOther);
        etMeasure = (EditText) findViewById(R.id.etMeasure);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        lvTraining = (ListView) findViewById(R.id.lvTraining);
        spTrainingNo = (Spinner) findViewById(R.id.spTrainingNo);

        dataAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_list_type_arr);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTrainingType.setAdapter(dataAdapter);
        spTrainingType.setOnItemSelectedListener(this);

        db = new DBHandler(this);

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
        getLocalData();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etDate.getText().toString().equals("")) {
                    etDate.setError("Date Empty");
                } else {
                    etDate.setError(null);
                    String other = etOther.getText().toString();


                    if(status.equalsIgnoreCase("training1")){
                        Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", trainingno+"");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", other);
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("status", "training1");
                        map1.put("measure", "0");
                        map1.put("status_no","0");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");


                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , trainingreceiver+"","1114",other,trainingno+"",0+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etOther.setText("");
                    }else if(status.equalsIgnoreCase("training2")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", trainingno+"");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", other);
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("status", "training2");
                        map1.put("measure", "0");
                        map1.put("status_no","1");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , trainingreceiver+"","1114",other,trainingno+"",1+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etOther.setText("");
                    }else if(status.equalsIgnoreCase("training3")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", trainingno+"");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", other);
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("status", "training3");
                        map1.put("measure", "0");
                        map1.put("status_no","2");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , trainingreceiver+"","1114",other,trainingno+"",2+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etOther.setText("");

                    } else if(status.equalsIgnoreCase("courtyard_meeting")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", "0");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", "");
                        map1.put("receiver", "0");
                        map1.put("measure", "0");
                        map1.put("status", "courtyard_meeting");
                        map1.put("status_no","3");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("courtyard_meeting data", trainingName+"->"+trainingtype+"->"+Report_date);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , "0","1114","",0+"",3+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }else if(status.equalsIgnoreCase("anc_pnc")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", "0");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", "");
                        map1.put("receiver", "0");
                        map1.put("measure", "0");
                        map1.put("status", "anc_pnc");
                        map1.put("status_no","4");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("anc_pnc data", trainingName+"->"+trainingtype+"->"+Report_date);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , "0","1114","",0+"",4+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }else if(status.equalsIgnoreCase("baby_nutation")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", "0");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");

                        map1.put("other", "");
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("status", "baby_nutation");
                        map1.put("measure", "0");
                        map1.put("status_no","5");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("baby_nutation data", trainingName+"->"+trainingtype+"->"+Report_date+"->1"+trainingreceiver);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , trainingreceiver+"","1114","",0+"",5+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }else if(status.equalsIgnoreCase("iga_input")){
//                        if(etMeasure.getText().toString().length()>0){
//                            String measure = etMeasure.getText().toString();
//                            measureNo = Integer.parseInt(measure);
//                        }else{
//                            String measure = "0";
//                            measureNo = Integer.parseInt(measure);
//                        }

                        //  String measure = etMeasure.getText().toString();

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", trainingno+"");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", other);
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("measure", etMeasure.getText().toString()+"");
                        map1.put("status", "iga_input");
                        map1.put("status_no","6");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("iga_input data", trainingName+"->"+trainingtype+"->"+Report_date+"->1"+measureNo);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , "0","1114",other,trainingno+"",6+"",etMeasure.getText().toString()+"");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etMeasure.setText("");
                        etOther.setText("");

                    }else if(status.equalsIgnoreCase("iga_uses")){

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", "0");
                        map1.put("date", Report_date);
                        map1.put("type", trainingtype+"");
                        map1.put("other", other);
                        map1.put("receiver", trainingreceiver+"");
                        map1.put("measure", measureNo+"");
                        map1.put("status", "iga_uses");
                        map1.put("status_no","7");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");

                        Log.e("iga_uses data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+trainingreceiver);
                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", trainingtype+"" , trainingreceiver+"","1114",other,0+"",7+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etOther.setText("");

                    }else if(status.equalsIgnoreCase("comment")){

                        String comment = etMeasure.getText().toString();
                        Log.e("comment data", comment+"->"+Report_date);

                        HashMap<String,String> map1= new HashMap<String,String>();
                        map1.put("ben_id", "1");
                        map1.put("trainingName", trainingName+"");
                        map1.put("training_no", "0");
                        map1.put("date", Report_date);
                        map1.put("type", "0");
                        map1.put("receiver", "0");
                        map1.put("comment", comment+"");
                        map1.put("status", "comment");
                        map1.put("status_no","8");
                        map1.put("measure", comment+"");
                        map1.put("active", "0");

                        db.InsertTable(map1, "tracking_service_info");


                        TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", "0", "0","1114",comment,0+"",8+"","0");
                        userClassAray.add(userClass);
                        Collections.reverse(userClassAray);
                        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
                        lvTraining.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        etMeasure.setText("");
                    }







                }




            }
        });



    }

    public void getLocalData(){

        Cursor c1=db.rawQuery("SELECT * FROM tracking_service_info");

        Log.e("tracking system_register", ""+c1.getCount()) ;
        Log.e("data",c1.toString());

        if(c1!=null)
        {
            if(c1.moveToFirst())
            {
                do{


                    HashMap<String,String> map=new HashMap<String,String>();
                    map.put("ben_id", c1.getString(1));
                    map.put("trainingName", c1.getString(2));
                    map.put("training_no", c1.getString(3));
                    map.put("date", c1.getString(4));
                    map.put("type", c1.getString(5));
                    map.put("other", c1.getString(6));
                    map.put("receiver", c1.getString(7));
                    map.put("comment", c1.getString(8));
                    map.put("measure", c1.getString(9));
                    map.put("status", c1.getString(10));
                    map.put("status_no", c1.getString(11));
                    map.put("active", c1.getString(12));
                    arrProductAndDeficiencyEdit.add(map);

                }while(c1.moveToNext());
            }
        }


        for(int i=0;i<arrProductAndDeficiencyEdit.size();i++)
        {
            String ben_id_lp =  arrProductAndDeficiencyEdit.get(i).get("ben_id");
            String trainingName_lp =  arrProductAndDeficiencyEdit.get(i).get("trainingName");
            String training_no_lp =  arrProductAndDeficiencyEdit.get(i).get("training_no");
            String date_lp =  arrProductAndDeficiencyEdit.get(i).get("date");
            String type_lp =  arrProductAndDeficiencyEdit.get(i).get("type");
            String other_lp =  arrProductAndDeficiencyEdit.get(i).get("other");
            String receiver_lp =  arrProductAndDeficiencyEdit.get(i).get("receiver");
            String comment_lp =  arrProductAndDeficiencyEdit.get(i).get("comment");
            String measure_lp =  arrProductAndDeficiencyEdit.get(i).get("measure");
            String status_lp =  arrProductAndDeficiencyEdit.get(i).get("status");
            String status_no_lp =  arrProductAndDeficiencyEdit.get(i).get("status_no");
            String active_lp =  arrProductAndDeficiencyEdit.get(i).get("active");


            //  Log.e("Data-"+i, n+"->"+a+"->"+s);
           Log.e("Tag-Measure",measure_lp);

            TrainingServiceClass userClass = new TrainingServiceClass(trainingName_lp,date_lp, type_lp , receiver_lp,ben_id_lp,other_lp,training_no_lp,status_no_lp,measure_lp);
            userClassAray.add(userClass);


        }
        Log.e("data", userClassAray.toString());
        Collections.reverse(userClassAray);
        adapter = new TrainingServiceAdapter(TrainingServiceActivity.this, userClassAray);
        lvTraining.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
        DatePickerDialog dpDialog = new DatePickerDialog(TrainingServiceActivity.this, listener, year, month, day);
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


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        adapterView.getItemAtPosition(pos);
        switch (adapterView.getId()){

            case R.id.spTrainingType:
                Toast.makeText(getApplicationContext(),pos+"",Toast.LENGTH_LONG).show();
                if(pos==0){
                    status = "training1";
                    etMeasure.setVisibility(View.GONE);

                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;


                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    spReceiver.setOnItemSelectedListener(this);




                }else  if(pos == 1){
                    status = "training2";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId=pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);


                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    spReceiver.setOnItemSelectedListener(this);



                }else if(pos == 2){
                    status = "training3";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId=pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    spTrainingNo.setOnItemSelectedListener(this);

                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.other_training_type_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);


                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    spReceiver.setOnItemSelectedListener(this);


                }else if(pos==3){
                    status = "courtyard_meeting";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId=pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    //  spTrainingNo.setOnItemSelectedListener(this);

                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.courtyard_meeting_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);


                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    // spReceiver.setOnItemSelectedListener(this);


                }else if(pos == 4){
                    status = "anc_pnc";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    // spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.anc_pnc_type_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    // spReceiver.setOnItemSelectedListener(this);

                }else if(pos==5){
                    status = "baby_nutation";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    // spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.baby_nutation_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.baby_gender_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    spReceiver.setOnItemSelectedListener(this);

                }else if(pos==6){
                    status = "iga_input";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_input_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    //spReceiver.setOnItemSelectedListener(this);

                    etMeasure.setVisibility(View.VISIBLE);
                    etMeasure.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etMeasure.setHint("Number/Measurement");

                }else if(pos==7){
                    status = "iga_uses";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;
                    etMeasure.setVisibility(View.GONE);

                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    //spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_input_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_uses_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    spReceiver.setOnItemSelectedListener(this);



                }else if(pos==8){

                    status = "comment";
                    trainingName = DataClass.moulic_training_list_type_arr[pos];
                    trainingNameId= pos;
                    etMeasure.setVisibility(View.VISIBLE);
                    etMeasure.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                    // etMeasure.setHeight(100);
                    etMeasure.setHint("Comment");
                    final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
                    etMeasure.setLayoutParams(lparams);

                    final LinearLayout.LayoutParams lvparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);

                    lvTraining.setLayoutParams(lvparams);


                    adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spTrainingNo.setAdapter(adapterNo);
                    //spTrainingNo.setOnItemSelectedListener(this);


                    adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spType.setAdapter(adapterType);
                    // spType.setOnItemSelectedListener(this);



                    adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                    adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spReceiver.setAdapter(adapterReceiver);
                    //spReceiver.setOnItemSelectedListener(this);
                }





                break;

            case R.id.spType:

                etOther.setVisibility(View.GONE);

                if(status.equalsIgnoreCase("training1")){
                    etOther.setVisibility(View.GONE);
                    etOther.setText("");


                    if(trainingNameId == 0){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId == 1){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId==2){
                        trainingtype = DataClass.other_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }
                }else if(status.equalsIgnoreCase("training2")){
                    etOther.setVisibility(View.GONE);
                    etOther.setText("");


                    if(trainingNameId == 0){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId == 1){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId==2){
                        trainingtype = DataClass.other_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }
                }else if(status.equalsIgnoreCase("training3")){
                    etOther.setVisibility(View.GONE);
                    etOther.setText("");


                    if(trainingNameId == 0){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId == 1){
                        trainingtype = DataClass.moulic_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }else if(trainingNameId==2){
                        trainingtype = DataClass.other_training_type_arr_no[pos];

                        if(trainingtype == 99){

                            etOther.setVisibility(View.VISIBLE);

                        }
                    }
                } else if(status.equalsIgnoreCase("courtyard_meeting")){

                    trainingtype = DataClass.courtyard_meeting_arr_no[pos];
                }else if(status.equalsIgnoreCase("anc_pnc")){
                    trainingtype = DataClass.anc_pnc_type_arr_no[pos];
                }else if(status.equalsIgnoreCase("baby_nutation")){
                    trainingtype = DataClass.baby_nutation_arr_no[pos];

                }else if(status.equalsIgnoreCase("iga_input")){
                    trainingtype = DataClass.iga_input_arr_no[pos];
                    if(trainingtype == 99){

                        etOther.setVisibility(View.VISIBLE);

                    }

                }else if(status.equalsIgnoreCase("iga_uses")){
                    trainingtype = DataClass.iga_input_arr_no[pos];
                    if(trainingtype == 99){

                        etOther.setVisibility(View.VISIBLE);

                    }
                }





                break;

            case R.id.spReceiver:
                if(status.equalsIgnoreCase("training1")){
                    trainingreceiver = DataClass.moulic_training_receiver_type_arr_no[pos];
                }else if(status.equalsIgnoreCase("training2")){
                    trainingreceiver = DataClass.moulic_training_receiver_type_arr_no[pos];
                }else if(status.equalsIgnoreCase("training3")){
                    trainingreceiver = DataClass.moulic_training_receiver_type_arr_no[pos];
                } else if(status.equalsIgnoreCase("baby_nutation")){
                    trainingreceiver = DataClass.baby_gender_arr_no[pos];
                }else if(status.equalsIgnoreCase("iga_uses")){
                    trainingreceiver = DataClass.iga_uses_arr_no[pos];
                }


                break;

            case R.id.spTrainingNo:
                if(status.equalsIgnoreCase("training1")){
                    trainingno = pos+1;
                }else if(status.equalsIgnoreCase("training2")){
                    trainingno = pos+1;
                }else if(status.equalsIgnoreCase("training3")){
                    trainingno = pos+1;
                } else if(status.equalsIgnoreCase("iga_input")){
                    trainingno = pos+1;
                }

                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
