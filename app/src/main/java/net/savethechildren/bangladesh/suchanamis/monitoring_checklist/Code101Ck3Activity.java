package net.savethechildren.bangladesh.suchanamis.monitoring_checklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.savethechildren.bangladesh.suchanamis.MainActivity;
import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.adapter.TrainingServiceAdapter;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;
import net.savethechildren.bangladesh.suchanamis.module.TrainingServiceClass;
import net.savethechildren.bangladesh.suchanamis.service_tracking.TrainingServiceActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Code101Ck3Activity extends AppCompatActivity {

    Button btnSub;
    Button btnPre;
    int o;
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

    EditText q26,q27,q28_1_1,q28_1_2,q28_1_3,q28_2_1,q28_2_2,q28_2_3,q28_3_1,q28_3_2,q28_3_3,q29,q30,q31,q32;
    EditText ed26,ed27;
    String q1,q1_2,q2,q2_1,q3,q4,q4_1,q5,q5_2,q5_3,q5_4,q5_5,q6,q7,q8,q10,q11,q11_1,q11_2,q11_3,q11_4,q11_5,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,qt26,qt27,qt28_1_1,qt28_1_2,qt28_1_3,qt28_2_1,qt28_2_2,qt28_2_3,qt28_3_1,qt28_3_2,qt28_3_3,qt29,qt30,qt31,qt32;


    DBHandler db;
    String monitoring_checklist_101 = "monitoring_checklist_101";
    ArrayList<HashMap<String,String>> arrProductAndDeficiencyEdit=new ArrayList<HashMap<String,String>>();

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code101_ck3);




        q26=(EditText)findViewById(R.id.etq26);
        q27=(EditText)findViewById(R.id.etq27);
        q28_1_1=(EditText)findViewById(R.id.etq28_1_1);
        q28_1_2=(EditText)findViewById(R.id.etq28_1_2);
        q28_1_3=(EditText)findViewById(R.id.etq28_1_3);
        q28_2_1=(EditText)findViewById(R.id.etq28_2_1);
        q28_2_2=(EditText)findViewById(R.id.etq28_2_2);
        q28_2_3=(EditText)findViewById(R.id.etq28_2_3);
        q28_3_1=(EditText)findViewById(R.id.etq28_3_1);
        q28_3_2=(EditText)findViewById(R.id.etq28_3_2);
        q28_3_3=(EditText)findViewById(R.id.etq28_3_3);
        q29=(EditText)findViewById(R.id.etq29);
        q30=(EditText)findViewById(R.id.etq30);
        q31=(EditText)findViewById(R.id.etq31);
        q32=(EditText)findViewById(R.id.etq32);


        Typeface face = Typeface.createFromAsset(getAssets(),
                "kalpurush.ttf");

        db = new DBHandler(this);



        //Retrieve Data
       // getLocalData();



        sharedpreferences = getSharedPreferences("checklist-101", Context.MODE_PRIVATE);


        q1 =  sharedpreferences.getString("q1", null);
        q1_2 =  sharedpreferences.getString("q1_2", null);
        q2 =  sharedpreferences.getString("q2", null);
        q2_1 =  sharedpreferences.getString("q2_1", null);
        q3 =  sharedpreferences.getString("q3", null);
        q4 =  sharedpreferences.getString("q4", null);
        q4_1 =  sharedpreferences.getString("q4_1", null);
        q5 =  sharedpreferences.getString("q5", null);
        q5_2 =  sharedpreferences.getString("q5_2", null);
        q5_3 =  sharedpreferences.getString("q5_3", null);
        q5_4 =  sharedpreferences.getString("q5_4", null);
        q5_5 =  sharedpreferences.getString("q5_5", null);
        q6 =  sharedpreferences.getString("q6", null);
        q7 =  sharedpreferences.getString("q7", null);
        q8 =  sharedpreferences.getString("q8", null);
        q10 =  sharedpreferences.getString("q10", null);
        q11 =  sharedpreferences.getString("q11", null);
        q11_1 =  sharedpreferences.getString("q11_1", null);
        q11_2 =  sharedpreferences.getString("q11_2", null);
        q11_3 =  sharedpreferences.getString("q11_3", null);
        q11_4 =  sharedpreferences.getString("q11_4", null);
        q11_5 =  sharedpreferences.getString("q11_5", null);

        q12 =  sharedpreferences.getString("sp12Value",null);
        q13 =  sharedpreferences.getString("sp13Value",null);
        q14 =  sharedpreferences.getString("sp14Value",null);
        q15 =  sharedpreferences.getString("sp15Value",null);

        qt26 =  sharedpreferences.getString("qt26", null);
        qt27 =  sharedpreferences.getString("qt27", null);
        qt28_1_1 =  sharedpreferences.getString("qt28_1_1", null);
        qt28_1_2 =  sharedpreferences.getString("qt28_1_2", null);
        qt28_1_3 =  sharedpreferences.getString("qt28_1_3", null);
        qt28_2_1 =  sharedpreferences.getString("qt28_2_1", null);
        qt28_2_2 =  sharedpreferences.getString("qt28_2_2", null);
        qt28_2_3 =  sharedpreferences.getString("qt28_2_3", null);
        qt28_3_1 =  sharedpreferences.getString("qt28_3_1", null);
        qt28_3_2 =  sharedpreferences.getString("qt28_3_2", null);
        qt28_3_3 =  sharedpreferences.getString("qt28_3_3", null);
        qt29 =  sharedpreferences.getString("qt29", null);
        qt30 =  sharedpreferences.getString("qt30", null);
        qt31 =  sharedpreferences.getString("qt31", null);
        qt32 =  sharedpreferences.getString("qt32", null);


        q26.setText(qt26);
        q27.setText(qt27);
        q28_1_1.setText(qt28_1_1);
        q28_1_2.setText(qt28_1_2);
        q28_1_3.setText(qt28_1_3);
        q28_2_1.setText(qt28_2_1);
        q28_2_2.setText(qt28_2_2);
        q28_2_3.setText(qt28_2_3);
        q28_3_1.setText(qt28_3_1);
        q28_3_2.setText(qt28_3_2);
        q28_3_3.setText(qt28_3_3);
        q29.setText(qt29);
        q30.setText(qt30);
        q31.setText(qt31);
        q32.setText(qt32);







       // Log.e("test", q1+"->");
        Log.e("test", q1+"->"+q1_2+"->"+q2+"->"+q2_1+"->"+q3+"->"+q4+"->"+q4+"->"+q5+"->"+q5_2+"->"+q5_3+"->"+q5_4+"->"+q5_4+"->"+q6+"->"+q7+"->"+q8+"->"+q10+"->"+q11+"->"+q11_1+"->"+q11_2+"->"+q11_3+"->"+q11_4+"->"+q11_5+"->"+sp12Value+"->"+sp13Value+"->"+sp14Value+"->"+
                sp15Value+"->"+sp16Value+"->"+sp17Value+"->"+sp18Value+"->"+sp19Value+"->"+sp20Value+"->"+sp21Value+"->"+sp22Value+"->"+ sp23Value+"->"+sp24Value+"->"+sp25Value+"->"+qt26+"->"+qt27+"->"+qt28_1_1+"->"+qt28_1_2+"->"+qt28_1_3+"->"+qt28_2_1+"->"+qt28_2_2+"->"+qt28_2_3+"->"+qt28_3_1+"->"+qt28_3_2+"->"+qt28_3_3+"->"+qt29+"->"+qt30+"->"+qt31+"->"+qt32);




        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                qt26  = q26.getText().toString();
                qt27  = q27.getText().toString();

                qt28_1_1  = q28_1_1.getText().toString();
                qt28_1_2  = q28_1_2.getText().toString();
                qt28_1_3  = q28_1_3.getText().toString();
                qt28_2_1  = q28_2_1.getText().toString();
                qt28_2_2  = q28_2_2.getText().toString();
                qt28_2_3  = q28_2_3.getText().toString();
                qt28_3_1  = q28_3_1.getText().toString();
                qt28_3_2  = q28_3_2.getText().toString();
                qt28_3_3  = q28_3_3.getText().toString();





                qt30  = q29.getText().toString();
                qt31  = q31.getText().toString();
                qt32  = q32.getText().toString();



                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("qt26", qt26);
                editor.putString("qt27", qt27);

                editor.putString("qt28_1_1", qt28_1_1);
                editor.putString("qt28_1_2", qt28_1_2);
                editor.putString("qt28_1_3", qt28_1_3);

                editor.putString("qt28_2_1", qt28_2_1);
                editor.putString("qt28_2_2", qt28_2_2);
                editor.putString("qt28_2_3", qt28_2_3);
                editor.putString("qt28_3_1", qt28_3_1);
                editor.putString("qt28_3_2", qt28_3_2);
                editor.putString("qt28_3_3", qt28_3_3);

                editor.putString("qt30", qt30);
                editor.putString("qt31", qt31);
                editor.putString("qt32", qt32);




                editor.commit();

                HashMap<String,String> map1= new HashMap<String,String>();


                map1.put("ben_id","b1");
                map1.put("date","today");
                map1.put("q1",q1+"");
                map1.put("q1_2",q1_2+"");
                map1.put("q2",q2+"");
                map1.put("q2_1",q2_1+"");
                map1.put("q3",q3+"");
                map1.put("q4",q4+"");
                map1.put("q4_1",q4_1+"");
                map1.put("q5",q5+"");
                map1.put("q5_2",q5_2+"");
                map1.put("q5_3",q5_3+"");
                map1.put("q5_4", q5_4+"");
                map1.put("q5_5", q5_5+"");

                map1.put("q6", q6+"");
                map1.put("q7",q7+"");
                map1.put("q8",q8+"");
                map1.put("q9","q9");
                map1.put("q10",q10+"");
                map1.put("q11",q11+"");
                map1.put("q11_1",q11_1+"");
                map1.put("q11_2",q11_2+"");
                map1.put("q11_3",q11_3+"");
                map1.put("q11_4",q11_4+"");

               map1.put("q12", sp12Value+"");
//                map1.put("q13", q13+"");
//                map1.put("q14",q14+"");
//                map1.put("q15",q15+"");
//                map1.put("q16",q16+"");
//                map1.put("q17",q17+"");
//                map1.put("q18",q18+"");
//                map1.put("q19",q19+"");
//                map1.put("q20",q20+"");
//                map1.put("q21",q21+"");
//                map1.put("q22",q22+"");
//                map1.put("q23", q23+"");
//                map1.put("q24", q24+"");
//                map1.put("q25", q25+"");


                map1.put("q26",qt26+"");
                map1.put("q27",qt27+"");
                map1.put("q28_1_1", qt28_1_1+"");
                map1.put("q28_1_2", qt28_1_2+"");
                map1.put("q28_1_3", qt28_1_3+"");
                map1.put("q28_2_1", qt28_2_1+"");
                map1.put("q28_2_2", qt28_2_2+"");
                map1.put("q28_2_3", qt28_2_3+"");
                map1.put("q28_3_1", qt28_3_1+"");
                map1.put("q28_3_2", qt28_3_2+"");
                map1.put("q28_3_3", qt28_3_3+"");
                map1.put("q29", qt29+"");
                map1.put("q30", qt30+"");
                map1.put("q31", qt31+"");
                map1.put("q32", qt32+"");


                db.InsertTable(map1, "monitoring_checklist_101");

                //Log.e(qt27,"db insert >"+qt27);


                Intent i = new Intent(Code101Ck3Activity.this, MonitoringCheckListActivity.class);
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

                Intent i = new Intent(Code101Ck3Activity.this, Code101Ck2Activity.class);
                startActivity(i);

                finish();

            }
        });




    }



    //Get localData

//
//    public void getLocalData(){
//
//        Cursor c1=db.rawQuery("SELECT * FROM monitoring_checklist_101");
//
//        Log.e("checklist monitor", ""+c1.getCount()) ;
//        Log.e("data",c1.toString());
//
//        if(c1!=null)
//        {
//            if(c1.moveToFirst())
//            {
//                do{
//
//
//                    HashMap<String,String> map=new HashMap<String,String>();
//                    map.put("ben_id", c1.getString(1));
//                    map.put("q1", c1.getString(2));
//                    map.put("q2", c1.getString(3));
//                    map.put("q3", c1.getString(4));
//                    map.put("q4", c1.getString(5));
//                    map.put("q5", c1.getString(6));
//                    map.put("q6", c1.getString(7));
//                    map.put("q7", c1.getString(8));
//                    map.put("q8", c1.getString(9));
//                    map.put("q9", c1.getString(10));
//                    map.put("q10", c1.getString(11));
//                    map.put("q11", c1.getString(12));
//                    map.put("q12", c1.getString(13));
//                    map.put("active", c1.getString(14));
//                    arrProductAndDeficiencyEdit.add(map);
//
//                }while(c1.moveToNext());
//            }
//        }
//
//
////        for(int i=0;i<arrProductAndDeficiencyEdit.size();i++)
////        {
////            String ben_id_lp =  arrProductAndDeficiencyEdit.get(i).get("ben_id");
////            String trainingName_lp =  arrProductAndDeficiencyEdit.get(i).get("trainingName");
////            String training_no_lp =  arrProductAndDeficiencyEdit.get(i).get("training_no");
////            String date_lp =  arrProductAndDeficiencyEdit.get(i).get("date");
////            String type_lp =  arrProductAndDeficiencyEdit.get(i).get("type");
////            String other_lp =  arrProductAndDeficiencyEdit.get(i).get("other");
////            String receiver_lp =  arrProductAndDeficiencyEdit.get(i).get("receiver");
////            String gender_lp =  arrProductAndDeficiencyEdit.get(i).get("gender");
////            String uses_lp =  arrProductAndDeficiencyEdit.get(i).get("uses");
////            String comment_lp =  arrProductAndDeficiencyEdit.get(i).get("comment");
////            String measure_lp =  arrProductAndDeficiencyEdit.get(i).get("measure");
////            String status_lp =  arrProductAndDeficiencyEdit.get(i).get("status");
////            String status_no_lp =  arrProductAndDeficiencyEdit.get(i).get("status_no");
////            String active_lp =  arrProductAndDeficiencyEdit.get(i).get("active");
////
////
////            //  Log.e("Data-"+i, n+"->"+a+"->"+s);
////
////            // TrainingServiceClass userClass = new TrainingServiceClass(trainingName_lp,date_lp, type_lp , receiver_lp,ben_id_lp,other_lp,training_no_lp,status_no_lp,measure_lp);
////            // userClassAray.add(userClass);
////
////
////        }
////        Log.e("data", userClassAray.toString());
////        adapter = new TrainingServiceAdapter(Code101Ck3Activity.this, userClassAray);
////        lvTraining.setAdapter(adapter);
////        adapter.notifyDataSetChanged();
//    }



}
