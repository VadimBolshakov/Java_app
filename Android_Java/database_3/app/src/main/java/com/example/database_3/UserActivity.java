package com.example.database_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    EditText nameBox;
    EditText yearBox;
    Button delButton;
    Button saveButton;

    DataBaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    long userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        nameBox = (EditText) findViewById(R.id.name);
        yearBox = (EditText) findViewById(R.id.year);
        delButton = (Button) findViewById(R.id.deleteButton);
        saveButton = (Button) findViewById(R.id.saveButton);

        sqlHelper = new DataBaseHelper(this);
        db = sqlHelper.open();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }
        // если 0, то добавление
        if (userId > 0) {
            // получаем элемент по id из бд
            userCursor = db.rawQuery("select * from " + DataBaseHelper.TABLE + " where " +
                    DataBaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();
            nameBox.setText(userCursor.getString(1));
            yearBox.setText(String.valueOf(userCursor.getInt(2)));
            userCursor.close();
        } else {
            // скрываем кнопку удаления
            delButton.setVisibility(View.GONE);
        }
    }

    public void save(View view){
        long result;
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_NAME, nameBox.getText().toString());
        cv.put(DataBaseHelper.COLUMN_YEAR, Integer.parseInt(yearBox.getText().toString()));

        if (userId > 0) {
            result=db.update(DataBaseHelper.TABLE, cv, DataBaseHelper.COLUMN_ID + "=" + String.valueOf(userId), null);
        } else {
            result=db.insert(DataBaseHelper.TABLE, null, cv);
        }

        if (result<0){
            Toast toast=Toast.makeText(this, "Элемент успешно добавлен", Toast.LENGTH_LONG);
            toast.show();
        }
        db.close();
        //goHome();
    }
    public void delete(View view) {
        long result;
        result=db.delete(DataBaseHelper.TABLE, "_id = ?", new String[]{String.valueOf(userId)});
        if (result<0){
            Toast toast=Toast.makeText(this, "Элемент удален", Toast.LENGTH_LONG);
            toast.show();
        }
        db.close();
        //goHome();
    }
    private void goHome(){
        // закрываем подключение
        //db.close();
        // переход к главной activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
