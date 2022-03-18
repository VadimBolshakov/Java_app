package com.example.database_3;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_PATH;
    private static String DATABASE_NAME="db_3.db";
    private static final int SCHEMA=1;
    static final String TABLE="users";

    public static final String COLUMN_ID="_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_YEAR="year";
    private Context myContext;

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,SCHEMA);
        this.myContext=context;
        DATABASE_PATH=context.getFilesDir().getPath()+DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    void create_db(){
        InputStream myInput=null;
        OutputStream myOutput=null;
        try{
            File file=new File(DATABASE_PATH);
            if(!file.exists()) {
                this.getReadableDatabase();
                myInput=myContext.getAssets().open(DATABASE_NAME);
                String outFileName=DATABASE_PATH;
                myOutput=new FileOutputStream(outFileName);

                byte[] buffer=new byte[1024];
                int length;
                while ((length=myInput.read(buffer)) >0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch (IOException ex){
            Log.d("DataBaseHelper", ex.getMessage());
        }
    }
    public SQLiteDatabase open()throws SQLException{
        return SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
    }

}
