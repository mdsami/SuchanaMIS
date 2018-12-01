package net.savethechildren.bangladesh.suchanamis.adapter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.savethechildren.bangladesh.suchanamis.R;
import net.savethechildren.bangladesh.suchanamis.dbhelper.DBHandler;
import net.savethechildren.bangladesh.suchanamis.module.DataClass;
import net.savethechildren.bangladesh.suchanamis.module.TrainingServiceClass;
import net.savethechildren.bangladesh.suchanamis.service_tracking.TrainingServiceActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by stccon on 8/27/2017.
 */

public class TrainingServiceAdapter extends BaseAdapter {
    Context context;
    ArrayList<TrainingServiceClass> userClassArray = new ArrayList<TrainingServiceClass>();
    private static LayoutInflater inflater=null;
    String trainingName;
    int trainingNameId;
    int trainingtype;
    int trainingreceiver;
    int trainingno;
    String status;
    int typePosition;
    String other;

    EditText etDate;
    EditText etMeasure;

    ArrayAdapter dataAdapter;
    ArrayAdapter adapterType;
    ArrayAdapter adapterReceiver;
    ArrayAdapter adapterNo;

    public static String Report_date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;

    DBHandler db;


    public TrainingServiceAdapter (Context mainActivity, ArrayList<TrainingServiceClass> userClassArray) {
        // TODO Auto-generated constructor stub
//        result=prgmNameList;
        context = mainActivity;
//        imageId=prgmImages;
        db = new DBHandler(context);

        this.userClassArray = userClassArray;
        Collections.reverse(userClassArray);
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return userClassArray.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class Holder
    {
        TextView tvUser;
        TextView tvTraining;
        TextView tvDate;
        TextView tvType;
        TextView tvReceiver;
        ImageView btnEdit;
        ImageView btnDelete;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final Holder holder=new Holder();
        final View rowView;


        rowView = inflater.inflate(R.layout.training_service_adapter, null);

        holder.tvTraining=(TextView) rowView.findViewById(R.id.tvTraining);
        holder.tvDate=(TextView) rowView.findViewById(R.id.tvDate);
        holder.tvType=(TextView) rowView.findViewById(R.id.tvType);
        holder.tvReceiver = (TextView) rowView.findViewById(R.id.tvReceiver);
        holder.tvUser = (TextView) rowView.findViewById(R.id.tvUser);
        holder.btnEdit = (ImageView) rowView.findViewById(R.id.btnEdit);
        holder.btnDelete = (ImageView) rowView.findViewById(R.id.btnDelete);



        holder.tvTraining.setText(userClassArray.get(position).getTrainingName());
        holder.tvDate.setText(userClassArray.get(position).getTrainingDate());
        holder.tvType.setText(userClassArray.get(position).getTrainingType());
        holder.tvReceiver.setText(userClassArray.get(position).getTrainingReceiver());
        holder.tvUser.setText(userClassArray.get(position).getUser());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.training_service_dialog, null);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                typePosition = Integer.parseInt(userClassArray.get(position).getTypePosition());
                trainingtype = Integer.parseInt(userClassArray.get(position).getTrainingType());
                trainingreceiver = Integer.parseInt(userClassArray.get(position).getTrainingReceiver());
                trainingno =  Integer.parseInt(userClassArray.get(position).getMeasure());
                other = userClassArray.get(position).getOther();

                Log.e("Click position",position+"->"+userClassArray.get(position).getTypePosition());

                final Spinner spTrainingType = (Spinner) promptsView.findViewById(R.id.spTrainingType);
                etDate = (EditText) promptsView.findViewById(R.id.etDate);
                final Spinner spType = (Spinner) promptsView.findViewById(R.id.spType);
                final Spinner spReceiver = (Spinner) promptsView.findViewById(R.id.spReceiver);
                final Spinner spTrainingNo = (Spinner) promptsView.findViewById(R.id.spTrainingNo);
                final EditText etOther = (EditText) promptsView.findViewById(R.id.etOther);
                etMeasure=(EditText) promptsView.findViewById(R.id.etMeasure);


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

                etOther.setText(other);


                // Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);


                dataAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_list_type_arr);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spTrainingType.setAdapter(dataAdapter);
                spTrainingType.setSelection(typePosition);




                spTrainingType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                        if(pos==0){
                            status = "training1";
                            etMeasure.setVisibility(View.GONE);

                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            trainingNameId= pos;

                            adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                            adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spTrainingNo.setAdapter(adapterNo);
                            // spTrainingNo.setOnItemSelectedListener(this);


                            adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_arr);
                            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spType.setAdapter(adapterType);
                            // spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            //spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.moulic_training_type_arr_no));
                            spReceiver.setSelection(getIndex(trainingreceiver,DataClass.moulic_training_receiver_type_arr_no));
                            spTrainingNo.setSelection(getIndex(trainingno,DataClass.moulic_training_type_no_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();
                            // etOther.setText(other);

//                            if(etOther.getText().length()>0){
//                                etOther.setVisibility(View.VISIBLE);
//                                etOther.setText(userClassArray.get(position).getOther());
//                            }



                        }else  if(pos == 1){
                            status = "training2";
                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            trainingNameId=pos;
                            etMeasure.setVisibility(View.GONE);

                            adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                            adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spTrainingNo.setAdapter(adapterNo);
                            // spTrainingNo.setOnItemSelectedListener(this);


                            adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_arr);
                            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spType.setAdapter(adapterType);
                            // spType.setOnItemSelectedListener(this);


                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            // spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.moulic_training_type_arr_no));
                            spReceiver.setSelection(getIndex(trainingreceiver,DataClass.moulic_training_receiver_type_arr_no));
                            spTrainingNo.setSelection(getIndex(trainingno,DataClass.moulic_training_type_no_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();

//                            if(etOther.getText().length()>0){
//                                etOther.setVisibility(View.VISIBLE);
//                                etOther.setText(userClassArray.get(position).getOther());
//                            }

                        }else if(pos == 2){
                            status = "training3";
                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            trainingNameId=pos;
                            etMeasure.setVisibility(View.GONE);

                            adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                            adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spTrainingNo.setAdapter(adapterNo);
                            //  spTrainingNo.setOnItemSelectedListener(this);

                            adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.other_training_type_arr);
                            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spType.setAdapter(adapterType);
                            // spType.setOnItemSelectedListener(this);


                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_receiver_type_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            //spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.other_training_type_arr_no));
                            spReceiver.setSelection(getIndex(trainingreceiver,DataClass.moulic_training_receiver_type_arr_no));
                            spTrainingNo.setSelection(getIndex(trainingno,DataClass.moulic_training_type_no_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();

//                            if(etOther.getText().length()>0){
//                                etOther.setVisibility(View.VISIBLE);
//                                etOther.setText(userClassArray.get(position).getOther());
//                            }

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
                            //spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            // spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.courtyard_meeting_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();



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
                            //spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            // spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.anc_pnc_type_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();


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
                            //spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.baby_gender_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            // spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.baby_nutation_arr_no));
                            spReceiver.setSelection(getIndex(trainingreceiver,DataClass.baby_gender_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();


                        }else if(pos==6){
                            status = "iga_input";
                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            trainingNameId= pos;

                            adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.moulic_training_type_no_arr);
                            adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spTrainingNo.setAdapter(adapterNo);
                            // spTrainingNo.setOnItemSelectedListener(this);


                            adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_input_arr);
                            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spType.setAdapter(adapterType);
                            //spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            //spReceiver.setOnItemSelectedListener(this);

                            etMeasure.setVisibility(View.VISIBLE);
                            etMeasure.setInputType(InputType.TYPE_CLASS_NUMBER);
                            etMeasure.setHint("Number/Measurement");

                            spType.setSelection(getIndex(trainingtype,DataClass.iga_input_arr_no));
                            spTrainingNo.setSelection(getIndex(trainingno,DataClass.moulic_training_type_no_arr_no));

                            etMeasure.setText(userClassArray.get(position).getIga_no());
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();

//                            if(etOther.getText().length()>0){
//                                etOther.setVisibility(View.VISIBLE);
//                                etOther.setText(userClassArray.get(position).getOther());
//                            }

                        }else if(pos==7){
                            status = "iga_uses";
                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            etMeasure.setVisibility(View.GONE);

                            adapterNo = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.empty_arr);
                            adapterNo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spTrainingNo.setAdapter(adapterNo);
                            //spTrainingNo.setOnItemSelectedListener(this);


                            adapterType = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_input_arr);
                            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spType.setAdapter(adapterType);
                            //spType.setOnItemSelectedListener(this);



                            adapterReceiver = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DataClass.iga_uses_arr);
                            adapterReceiver.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spReceiver.setAdapter(adapterReceiver);
                            //spReceiver.setOnItemSelectedListener(this);

                            spType.setSelection(getIndex(trainingtype,DataClass.iga_input_arr_no));
                            spReceiver.setSelection(getIndex(trainingreceiver,DataClass.iga_uses_arr_no));
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();
                            etMeasure.setText(other+"");

//                            if(etOther.getText().length()>0){
//                                etOther.setVisibility(View.VISIBLE);
//                                etOther.setText(userClassArray.get(position).getOther());
//                            }

                        }else if(pos==8){

                            status = "comment";
                            trainingName = DataClass.moulic_training_list_type_arr[pos];
                            trainingNameId= pos;
                            etMeasure.setVisibility(View.VISIBLE);
                            // etMeasure.setHeight(100);
                            etMeasure.setHint("Comment");
                            etMeasure.setInputType(InputType.TYPE_CLASS_TEXT);
                            final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
                            etMeasure.setLayoutParams(lparams);

                            final LinearLayout.LayoutParams lvparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);

                            //lvTraining.setLayoutParams(lvparams);


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

                            Log.e("Reporting",userClassArray.get(position).getOther()+"->"+userClassArray.get(position).getMeasure()+"->"+userClassArray.get(position).getIga_no());
                            etMeasure.setText(userClassArray.get(position).getIga_no()+"");
                            etDate.setText(userClassArray.get(position).getTrainingDate());
                            Report_date = userClassArray.get(position).getTrainingDate();


                        }



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



                spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                        etOther.setVisibility(View.GONE);
                        etMeasure.setVisibility(View.GONE);

                        if(status.equalsIgnoreCase("training1")){
                            etOther.setVisibility(View.GONE);
                            // etOther.setText("");


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
                            //etOther.setText("");


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
                        }else  if(status.equalsIgnoreCase("training3")){
                            etOther.setVisibility(View.GONE);
                            //etOther.setText("");


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
                            etMeasure.setVisibility(View.VISIBLE);
                            trainingtype = DataClass.iga_input_arr_no[pos];
                            if(trainingtype == 99){

                                etOther.setVisibility(View.VISIBLE);

                            }

                        }else if(status.equalsIgnoreCase("iga_uses")){
                            trainingtype = DataClass.iga_input_arr_no[pos];
                            etOther.setVisibility(View.VISIBLE);
                            if(trainingtype == 99){

                                etOther.setVisibility(View.VISIBLE);

                            }
                        }else if(status.equalsIgnoreCase("comment")){
                            etMeasure.setVisibility(View.VISIBLE);
                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



                spReceiver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {


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

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



                spTrainingNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                        if(status.equalsIgnoreCase("training1")){
                            trainingno = pos+1;
                        }else if(status.equalsIgnoreCase("training2")){
                            trainingno = pos+1;
                        }else if(status.equalsIgnoreCase("training3")){
                            trainingno = pos+1;
                        } else if(status.equalsIgnoreCase("iga_input")){
                            trainingno = pos+1;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                //   -------------------
                // set dialog message
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Done", null);
                alertDialogBuilder.setNegativeButton("Close", null);
                // create alert dialog
                final AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

                Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //  Log.e("Test SP", trainingno);
                        int increaseId = getid(position);

                        Log.e("Delete id", position+"->"+increaseId);

                        //Edit page dialog
                        if(status.equalsIgnoreCase("training1")){


                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+trainingno+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+etOther.getText().toString()+"', receiver = '"+trainingreceiver+"', status = '"+"training1"+"', measure = '"+"0"+"', status_no = '"+"0"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

//                            HashMap<String,String> map1= new HashMap<String,String>();
//                            map1.put("ben_id", "b1");
//                            map1.put("trainingName", trainingName+"");
//                            map1.put("training_no", trainingno+"");
//                            map1.put("date", Report_date);
//                            map1.put("type", trainingtype+"");
//                            map1.put("other", etOther.getText().toString());
//                            map1.put("receiver", trainingreceiver+"");
//                            map1.put("status", "training1");
//                            map1.put("measure", "0");
//                            map1.put("status_no","0");
//                            map1.put("active", "0");


                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver(trainingreceiver+"");
                            userClassArray.get(position).setUser("b1");
                            userClassArray.get(position).setOther(etOther.getText().toString());
                            userClassArray.get(position).setMeasure(trainingno+"");
                            userClassArray.get(position).setTypePosition("0");


                        }else if(status.equalsIgnoreCase("training2")){


                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+trainingno+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+etOther.getText().toString()+"', receiver = '"+trainingreceiver+"', status = '"+"training2"+"', measure = '"+"0"+"', status_no = '"+"1"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver(trainingreceiver+"");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther(etOther.getText().toString());
                            userClassArray.get(position).setMeasure(trainingno+"");
                            userClassArray.get(position).setTypePosition("1");

                        }else if(status.equalsIgnoreCase("training3")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+trainingno+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+etOther.getText().toString()+"', receiver = '"+trainingreceiver+"', status = '"+"training3"+"', measure = '"+"0"+"', status_no = '"+"2"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("training data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+other+"->"+trainingreceiver+"->"+trainingno);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver(trainingreceiver+"");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther(etOther.getText().toString());
                            userClassArray.get(position).setMeasure(trainingno+"");
                            userClassArray.get(position).setTypePosition("2");

                        } else if(status.equalsIgnoreCase("courtyard_meeting")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+"0"+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+""+"', receiver = '"+"0"+"', status = '"+"courtyard_meeting"+"', measure = '"+"0"+"', status_no = '"+"3"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("courtyard_meeting data", trainingName+"->"+trainingtype+"->"+Report_date);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver("0");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther("");
                            userClassArray.get(position).setMeasure("0");
                            userClassArray.get(position).setTypePosition("3");

                        }else if(status.equalsIgnoreCase("anc_pnc")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+"0"+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+""+"', receiver = '"+"0"+"', status = '"+"anc_pnc"+"', measure = '"+"0"+"', status_no = '"+"4"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("anc_pnc data", trainingName+"->"+trainingtype+"->"+Report_date);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver("0");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther("");
                            userClassArray.get(position).setMeasure("0");
                            userClassArray.get(position).setTypePosition("4");

                        }else if(status.equalsIgnoreCase("baby_nutation")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+"0"+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+""+"', receiver = '"+trainingreceiver+"', status = '"+"baby_nutation"+"', measure = '"+"0"+"', status_no = '"+"5"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("baby_nutation data", trainingName+"->"+trainingtype+"->"+Report_date+"->1"+trainingreceiver);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver(trainingreceiver+"");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther("");
                            userClassArray.get(position).setMeasure("0");
                            userClassArray.get(position).setTypePosition("5");


                        }else if(status.equalsIgnoreCase("iga_input")){
                            //String measure = etMeasure.getText().toString();
                            //int measureNo = Integer.parseInt(measure);

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+trainingno+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+etOther.getText().toString()+"', receiver = '"+trainingreceiver+"', status = '"+"iga_input"+"', measure = '"+etMeasure.getText().toString()+"', status_no = '"+"6"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);


                            Log.e("iga_input data", trainingName+"->"+trainingtype+"->"+Report_date+"->1"+etMeasure.getText().toString());
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver("0");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther(etOther.getText().toString());
                            userClassArray.get(position).setIga_no(etMeasure.getText().toString());
                            userClassArray.get(position).setMeasure(trainingno+"");
                            userClassArray.get(position).setTypePosition("6");

                            etMeasure.setText(etMeasure.getText().toString());

                        }else if(status.equalsIgnoreCase("iga_uses")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+"0"+"', date = '"+Report_date+"', type = '"+trainingtype+"', other = '"+etOther.getText().toString()+"', receiver = '"+trainingreceiver+"', status = '"+"iga_uses"+"', measure = '"+etMeasure.getText().toString()+"', status_no = '"+"7"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);

                            Log.e("iga_uses data", trainingName+"->"+trainingtype+"->"+Report_date+"->"+trainingreceiver);
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType(trainingtype+"");
                            userClassArray.get(position).setTrainingReceiver(trainingreceiver+"");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther(etOther.getText().toString());
                            userClassArray.get(position).setMeasure("0");
                            userClassArray.get(position).setTypePosition("7");

                        }else if(status.equalsIgnoreCase("comment")){

                            String queryUpdateTable="UPDATE tracking_service_info SET ben_id = '"+"1"+"',trainingName = '"+trainingName+"', training_no = '"+"0"+"', date = '"+Report_date+"', type = '"+"0"+"', other = '"+etMeasure.getText().toString()+"', receiver = '"+"0"+"', comment = '"+etMeasure.getText().toString()+"', status = '"+"comment"+"', measure = '"+etMeasure.getText().toString()+"', status_no = '"+"8"+"', active = '"+"0"+"' WHERE _id="+ increaseId;
                            Log.e("update query", queryUpdateTable);
                            db.excQuery(queryUpdateTable);


                            String comment = etMeasure.getText().toString();
                            Log.e("comment data", comment+"->"+Report_date);
                            //  TrainingServiceClass userClass = new TrainingServiceClass(trainingName+"",Report_date+"", "0", "0","1114",comment,0+"",8+"");
                            userClassArray.get(position).setTrainingName(trainingName);
                            userClassArray.get(position).setTrainingDate(Report_date);
                            userClassArray.get(position).setTrainingType("0");
                            userClassArray.get(position).setTrainingReceiver("0");
                            userClassArray.get(position).setUser("1114");
                            userClassArray.get(position).setOther(etMeasure.getText().toString());
                            userClassArray.get(position).setMeasure("0");
                            userClassArray.get(position).setTypePosition("8");
                            etMeasure.setText("");
                        }




                        notifyDataSetChanged();
                        alertDialog.dismiss();

                    }
                });

                Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                // override the text color of negative button
                // negativeButton.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                // provides custom implementation to negative button click
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  onNegativeButtonClicked(alertDialog);
                        alertDialog.dismiss();
                        Toast.makeText(context,"Finish",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.warning_dialog, null);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                TextView tvWarning = promptsView.findViewById(R.id.tvWarning);
                tvWarning.setText("Do you want delete?");

                //   -------------------
                // set dialog message
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Done", null);
                alertDialogBuilder.setNegativeButton("Close", null);
                // create alert dialog
                final AlertDialog alertDialog = alertDialogBuilder.create();


                // show it
                alertDialog.show();

                Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        userClassArray.remove(position);

                        int deleteId = getid(position);
                        Log.e("Delete id", position+"->"+deleteId);


                        String queryDeleteTable="DELETE FROM tracking_service_info  WHERE _id='"+deleteId+"'";
                        db.excQuery(queryDeleteTable);

                        notifyDataSetChanged();
                        alertDialog.dismiss();

                    }
                });

                Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                // override the text color of negative button
                // negativeButton.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                // provides custom implementation to negative button click
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  onNegativeButtonClicked(alertDialog);
                        alertDialog.dismiss();
                        Toast.makeText(context,"Finish",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Log.e("Particular user Data into: ", deptlist);
////                Intent i = new Intent(context, OrderSummeryDetailsActivity.class);
////                i.putExtra("sr_id", Login_Sr_ID_order);
////                i.putExtra("outlet_id", outletId);
////                i.putExtra("date", date);
////                i.putExtra("Order_ID",Order_ID);
////                i.putExtra("Order_Amount", Order_Amount);
////                i.putExtra("outletName",outletName);
//
//              //  context.startActivity(i);
//
//                LayoutInflater li = LayoutInflater.from(context);
//                View promptsView = li.inflate(R.layout.training_service_dialog, null);
//
//                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                        context);
//
//                // set prompts.xml to alertdialog builder
//                alertDialogBuilder.setView(promptsView);
//
//                final TextView tvStatus = (TextView) promptsView
//                        .findViewById(R.id.tvStatus);
//                tvStatus.setText("Do you want edit?");
//
//                //   -------------------
//                // set dialog message
//                alertDialogBuilder.setCancelable(false);
//                alertDialogBuilder.setPositiveButton("Done", null);
//                alertDialogBuilder.setNegativeButton("Close", null);
//                // create alert dialog
//                final AlertDialog alertDialog = alertDialogBuilder.create();
//
//                // show it
//                alertDialog.show();
//
//                Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
//                positiveButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//
//
//                        notifyDataSetChanged();
//                        alertDialog.dismiss();
//
//                    }
//                });
//
//                Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
//                // override the text color of negative button
//                // negativeButton.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
//                // provides custom implementation to negative button click
//                negativeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //  onNegativeButtonClicked(alertDialog);
//                        alertDialog.dismiss();
//                        Toast.makeText(context,"Finish",Toast.LENGTH_LONG).show();
//                    }
//                });
//
//            }
//        });

        return rowView;
    }

    int getid(int position){

        ArrayList<HashMap<String,String>> arrProductAndDeficiencyEdit=new ArrayList<HashMap<String,String>>();

        Cursor c1=db.rawQuery("SELECT * FROM tracking_service_info");
        if(c1!=null){

            if(c1.moveToFirst()){
                do{
                    HashMap<String,String> map=new HashMap<String,String>();
                    map.put("_id", c1.getString(0));
                    arrProductAndDeficiencyEdit.add(map);
                }while(c1.moveToNext());

            }
        }


        int id_lp = Integer.parseInt(arrProductAndDeficiencyEdit.get(position).get("_id"));



        return id_lp;
    }

    int getIndex(int val, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
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
        DatePickerDialog dpDialog = new DatePickerDialog(context, listener, year, month, day);
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

}
