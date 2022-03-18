package com.example.databasa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        SQLiteDatabase db=getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user (name TEXT, age INTEGER)");
        db.execSQL("INSERT INTO user VALUES ('Tom Smith', 23);" );
        db.execSQL("INSERT INTO user VALUES ('John Dow', 31);" );
        db.execSQL("INSERT INTO user VALUES ('Mishel Snow', 35);" );

        Cursor query=db.rawQuery("SELECT * FROM user;", null);
        TextView textView=(TextView) findViewById(R.id.textView);
        if (query.moveToFirst()){
            do{
                String name=query.getString(0);
                int age=query.getInt(1);
                textView.append("Name: "+name+" Age: "+age+"\n");
            }
            while (query.moveToNext());
        }
        query.close();
        db.close();
    }
}
