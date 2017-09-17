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




     
    public DB_Con(Context context ) {
        super(context, Database,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  "+tablename+"(fname TEXT,lname TEXT,username TEXT,password TEXT,email TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ Database);
        onCreate(db);

    }

    public boolean register(String fname,String lname,String uname,String pw,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
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

    public Cursor getDetails(String username)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+tablename+" where username=kavindu",null);

        return  res;
    }

    public String login(String userName)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.query("CustomerDetails", null, " username=?", new String[]{userName}, null, null, null);


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

}
