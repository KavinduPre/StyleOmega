package com.example.kavindu.styleomega;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kavindu on 8/23/2017.
 */



public class DB_Con extends SQLiteOpenHelper {

    private  static final String tablename ="CustomerDetails";

    private static  final String Database="StyleOmega2";

    private static  final String col1="fname";
    private static  final String col2="lname";
    private static  final String col3="username";
    private static  final String col4="password";
    private static  final String col5="email";

    public String getMfname() {
        return mfname;
    }

    public String getMlname() {
        return mlname;
    }

    public String getMuname() {
        return muname;
    }

    public String getMpw() {
        return mpw;
    }

    public String getMemail() {
        return memail;
    }

    private String mfname;
    private String mlname;
    private String muname;
    private String mpw;
    private String memail;



    public  SQLiteDatabase db;
    public Cursor updateCursor;


    public DB_Con(Context context ) {
        super(context, Database,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db=db;
        db.execSQL("CREATE TABLE  "+tablename+"(fname TEXT,lname TEXT,username TEXT,password TEXT,email TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   /* @Override
    public void onUpgrade(db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ Database);
        onCreate(db);

    }*/

    public boolean register(String fname,String lname,String uname,String pw,String email)
    {
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,fname);
        contentValues.put(col2,lname);
        contentValues.put(col3,uname);
        contentValues.put(col4,pw);
        contentValues.put(col5,email);
        long result=db.insert(tablename ,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public void getDetails(String userName)
    {
        db=this.getWritableDatabase();
        Cursor cursor=db.query("CustomerDetails",null, "username=?",new String[]{userName}, null, null, null);

        mfname=cursor.getString(cursor.getColumnIndex("fname"));
        mlname=cursor.getString(cursor.getColumnIndex("lname"));
        muname=cursor.getString(cursor.getColumnIndex("username"));
        mpw=cursor.getString(cursor.getColumnIndex("password"));
        memail=cursor.getString(cursor.getColumnIndex("email"));

    }

    public String login(String userName)
    {
        db=this.getWritableDatabase();

        Cursor cursor=db.query("CustomerDetails",null, "username=?",new String[]{userName}, null, null, null);
        /*updateCursor=cursor;*/

        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "Invalid Credentials";

        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("password"));




        cursor.close();
        return password;
    }

    public Cursor loadImages(String id)
    {
        db=this.getWritableDatabase();
        Cursor cursor=db.query("ItemDetails",null, "ID=?",new String[]{id}, null, null, null);
        cursor.moveToFirst();
        return cursor;

    }

}
