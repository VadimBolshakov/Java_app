package com.example.database_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView userList;
    TextView header;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header=(TextView) findViewById(R.id.header);
        userList=(ListView) findViewById(R.id.list);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        dataBaseHelper= new DataBaseHelper(getApplicationContext());
        dataBaseHelper.create_db();
    }
    @Override
    public  void onResume() {
        super.onResume();
        db=dataBaseHelper.open();

        userCursor=db.rawQuery("select * from "+DataBaseHelper.TABLE, null);
        String[] headers=new String[] { DataBaseHelper.COLUMN_ID, DataBaseHelper.COLUMN_NAME, DataBaseHelper.COLUMN_YEAR };
        userAdapter=new SimpleCursorAdapter(this, R.layout.my_layout_items, userCursor,headers, new int[]{R.id.text1, R.id.text2, R.id.text3},0);
        header.setText("Find items: "+String.valueOf(userCursor.getCount()));
        userList.setAdapter(userAdapter);
    }

    public void add(View view) {
        Intent intent=new Intent(this,UserActivity.class);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        db.close();
        userCursor.close();
    }


}
