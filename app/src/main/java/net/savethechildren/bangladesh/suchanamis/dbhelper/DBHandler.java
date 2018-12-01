package net.savethechildren.bangladesh.suchanamis.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bappy on 8/15/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "suchana_db";

    private static final String CREATE_EMPLOYEE_INFO="employee_info";
    String[] credit_collection_table_Columns = {"_id","outlet_id","date","memo_no","memo_value","collect_date","inst_type","due_amount","paid_amount"};

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //.................................All table create into this method...........................................
//        String CREATE_EMPLOYEE_INFO = "CREATE TABLE IF NOT EXISTS " + "employee_info" + "("
//                + "_id" + " INTEGER PRIMARY KEY," +
//                "name"+		" VARCHAR,"+
//                "age" + " INTEGER,"	+
//                "salary" + " INTEGER"	+
//                ")";
//        db.execSQL(CREATE_EMPLOYEE_INFO);


        String CREATE_TRACKING_SERVICE = "CREATE TABLE IF NOT EXISTS " + "tracking_service_info" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" INTEGER,"+
                "trainingName" + " VARCHAR,"	+
                "training_no"+		" INTEGER,"+
                "date" + " VARCHAR,"	+
                "type" + " INTEGER,"	+
                "other" + " VARCHAR,"	+
                "receiver" + " INTEGER,"	+
                "comment" + " VARCHAR,"	+
                "measure" + " VARCHAR,"	+
                "status" + " VARCHAR,"	+
                "status_no" + " INTEGER,"	+
                "active" + " INTEGER"	+

                ")";
        db.execSQL(CREATE_TRACKING_SERVICE);





        String CREATE_CHECKLIST_101 = "CREATE TABLE IF NOT EXISTS " + "monitoring_checklist_101" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "ben_id"+		" INTEGER,"+
                "date" + " DATE,"	+
                "si_no" + " INTEGER," +
                "q1"+   " VARCHAR,"+
                "q1_2" + " VARCHAR,"	+
                "q2" + " VARCHAR,"	+
                "q2_1" + " VARCHAR,"	+
                "q3" + " DATE,"	+
                "q4" + " VARCHAR,"	+
                "q4_1" + " VARCHAR," +
                "q5"   + " VARCHAR," +
                "q5_2" + " VARCHAR," +
                "q5_3" + " VARCHAR," +
                "q5_4" + " VARCHAR," +
                "q5_5" + " VARCHAR," +
                "q6" + " VARCHAR,"	+
                "q7" + " VARCHAR,"	+

                "q8" + " VARCHAR,"	+
                "q9" + " VARCHAR,"	+
                "q10" + " INTEGER,"	+
                "q11" + " INTEGER ,"	+
                "q11_1" + " INTEGER,"	+
                "q11_2" + " INTEGER,"	+
                "q11_3" + " INTEGER,"	+
                "q11_4" + " INTEGER,"	+
                "q12" + " INTEGER,"	+
                "q13" + " INTEGER,"	+
                "q14" + " INTEGER,"	+

                "q15" + " INTEGER,"	+
                "q16" + " INTEGER,"	+
                "q17" + " INTEGER,"	+
                "q18" + " INTEGER,"	+
                "q19" + " INTEGER,"	+
                "q20" + " INTEGER,"	+
                "q21" + " INTEGER,"	+
                "q22" + " INTEGER,"	+
                "q23" + " INTEGER,"	+
                "q24" + " INTEGER,"	+
                "q25" + " INTEGER,"	+


                "q26" + " DATETIME," +
                "q27" + " INTEGER,"	+

                "q28_1_1" + " VARCHAR,"	+
                "q28_1_2" + " INTEGER,"	+
                "q28_1_3" + " INTEGER,"	+

                "q28_2_1" + " VARCHAR ," +
                "q28_2_2" + " INTEGER,"	+
                "q28_2_3" + " INTEGER,"	+

                "q28_3_1" + " VARCHAR ,"	+
                "q28_3_2" + " INTEGER,"	+
                "q28_3_3" + " INTEGER,"	+
                "q29" + " VARCHAR ,"	+
                "q30" + " DATETIME,"	+
                "q31" + " VARCHAR,"	+
                "q32" + " VARCHAR,"	+
                "status" + " VARCHAR,"	+
                "status_no" + " INTEGER,"	+
                "active" + " INTEGER"	+

                ")";

        db.execSQL(CREATE_CHECKLIST_101);


        String CREATE_CHECKLIST_104 = "CREATE TABLE IF NOT EXISTS " + "monitoring_checklist_104" + "("
                + "_id" + " INTEGER PRIMARY KEY," +
                "report_id"+		" VARCHAR,"+
                "questions" + " VARCHAR" +
                "values" + " VARCHAR" +
                "status" + " VARCHAR" +
                "date" + " DATE" +

                ")";
        db.execSQL(CREATE_CHECKLIST_104);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop all table
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_EMPLOYEE_INFO);
        // Create tables again
        onCreate(db);

    }


    public void deleteAllRow(String tableName)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE FROM " + tableName);

        Log.e("DELETED:",tableName);
    }

    public void deleteRow(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where gift_issue_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void deleteRowOFDraft(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where outlet_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void deleteRowOFSession(String tableName, String row)
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        db1.execSQL("DELETE  FROM " + tableName+" where session_id='"+row+"'");

        Log.e("DELETED:",tableName);
    }

    public void InsertTable(HashMap<String, String> data, String TableName) {

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        Iterator it = data.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            values.put(pair.getKey(), pair.getValue()); // Contact Name

            it.remove();
        }

        Log.e(" Content values  :",values.toString());
        Log.e(TableName,"   :"+"INSERTED");
        db.insert(TableName, null, values);
        db.close();

    }

    public Cursor SelectTable(String query) {



        ArrayList<HashMap<String, String>> Data= new ArrayList<HashMap<String, String>>();


        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    HashMap<String, String> map= new HashMap<String, String>();

                    for(int itertor=0;itertor<credit_collection_table_Columns.length;itertor++)
                    {
                        String column_value = c.getString(c.getColumnIndex(credit_collection_table_Columns[itertor]));

                        map.put(credit_collection_table_Columns[itertor], column_value);
                    }

                    Data.add(map);




                } while (c.moveToNext());
            }
        }



        return c;
    }


    public void excQuery(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(query);

    }



    public Cursor rawQuery(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
//		db.close();
        return c;
    }



    public void update_table_with_id(String table_name, String table_id, String newID, String previousID)
    {		SQLiteDatabase db = this.getReadableDatabase();

        String queryUpdateTable="UPDATE "+table_name+" SET "+table_id+"='"+ newID + "'  WHERE "+ table_id +"='"+previousID+"'";
        db.execSQL(queryUpdateTable);
        Log.e("queryUpdateTable : "+table_name, queryUpdateTable);
    }



    public void UpdateTable(HashMap<String,String> map, String tableName, String updateCullumn, String UpdateCullumnValue)
    {
        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE "+updateCullumn+"= "+UpdateCullumnValue;
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);

    }


    public void UpdateClaim(HashMap<String,String> map, String tableName, String updateCullumn, String UpdateCullumnValue)
    {
        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE "+updateCullumn+"= '"+UpdateCullumnValue+"'";
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);

    }


    public void delete_table_with_id(String table_name, String table_id, String previousID)
    {			SQLiteDatabase db = this.getReadableDatabase();

        String queryDeleteTable="DELETE FROM "+table_name+"  WHERE "+ table_id +"='"+previousID+"'";
        db.execSQL(queryDeleteTable);
        Log.e("queryDelete : "+table_name, queryDeleteTable);
    }



    public void dropTable(String table_name)
    {

        SQLiteDatabase db = this.getReadableDatabase();
//		db =  this.openOrCreateDatabase("SMC_SALES_db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
//		db.setVersion(1);
//		db.setLocale(Locale.getDefault());
        db.execSQL("DROP TABLE IF EXISTS '" + table_name + "'");
    }




    public String GetUpdatedDate(String tableName, String tableFieldId)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" ORDER BY "+tableFieldId+" DESC limit 1", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    getDate = c.getString(c.getColumnIndex("updated_at"));
                } while (c.moveToNext());
            }
        }
        return getDate;
    }

    public String GetMemoNO(String memoNo)
    {
        String memo_no = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM memos where memo_no='"+memoNo+"'", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    memo_no = c.getString(c.getColumnIndex("memo_no"));
                } while (c.moveToNext());
            }
        }
        return memo_no;
    }



    public boolean checkDuplicate(String tableName, String culumnName, String culumnValue)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();
        if(tableName.equalsIgnoreCase("sales_targets"))
            Log.e("Duplicate Check Query","SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'");

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'", null);
        if(c.getCount()>0)
            return true;
        else
            return false;
    }


    public boolean checkDuplicateForBonus(String tableName, String product_id, String outlet_id, String bonus_party_id)
    {
        String getDate = "";
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE product_id='"+product_id+"' and outlet_id='"+outlet_id+"' and bonus_party_id='"+bonus_party_id+"'", null);
        if(c.getCount()>0)
            return true;
        else
            return false;
    }


    public void UpdateForBonus(HashMap<String,String> map, String tableName, String product_id, String outlet_id, String bonus_party_id)
    {

        String Query="UPDATE "+tableName+" SET ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Query=Query+entry.getKey()+"= '"+entry.getValue()+"',";
        }
        Query=Query.substring(0,Query.length()-1)+" WHERE product_id='"+product_id+"' and outlet_id='"+outlet_id+"' and bonus_party_id='"+bonus_party_id+"'";
        Log.e("Query", Query);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(Query);


    }



    public String checkDuplicateForTarget(String tableName, String culumnName, String culumnValue)
    {
        String GetValue = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+culumnName+"= '"+culumnValue+"'", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    GetValue = c.getString(c.getColumnIndex("culumnName"));
                } while (c.moveToNext());
            }
        }
        return GetValue;
    }


    public ArrayList<HashMap<String, String>> AllDataFromTable(String table_name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+table_name,null);
        ArrayList<HashMap<String, String>> Data= new ArrayList<HashMap<String, String>>();

        try {

            if (cursor.moveToFirst()) {
                do {
                    HashMap<String, String> map= new HashMap<String, String>();
                    if(table_name.equalsIgnoreCase("doctor_table"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                        map.put("type", cursor.getString(3));
                    }

                    if(table_name.equalsIgnoreCase("bank_banch"))
                    {
                        map.put("id", cursor.getString(2));
                        map.put("name", cursor.getString(3));
                    }

                    if(table_name.equalsIgnoreCase("instrument_type"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }

                    if(table_name.equalsIgnoreCase("instrument_no"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }
                    if(table_name.equalsIgnoreCase("sales_weeks"))
                    {
                        map.put("id", cursor.getString(1));
                        map.put("name", cursor.getString(2));
                    }



                    Data.add(map);
                } while (cursor.moveToNext());
            }

        } finally {
            try { cursor.close(); } catch (Exception ignore) {}
        }



        return Data;

    }





}
