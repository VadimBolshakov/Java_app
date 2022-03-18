package com.example.charter_3;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        TextView textView=(TextView) findViewById(R.id.text_view2);
        EditText editText=(EditText) findViewById(R.id.edit_text2);
        String num;
        num = editText.getText().toString();
        String rose=getResources().getQuantityString(R.plurals.flower,4,6);
        textView.setText("Welcome, " + rose);
        Toast toast=Toast.makeText(this,"Welcome "+rose,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,10,160);
        toast.show();

    }

    public void onClick(View view) {
        EditText editText=(EditText) findViewById(R.id.edit_text);
        Snackbar.make(view,"Welcome "+editText.getText(), Snackbar.LENGTH_LONG).show();
    }

    public void onCheckboxClicked(View view) {
        CheckBox language=(CheckBox) view;
        boolean checked=language.isChecked();
        TextView selection=(TextView) findViewById(R.id.text_view);
        switch(view.getId()) {
            case R.id.checkBox:
                if (checked){
                    selection.setText("Java");
                }
                break;
            case R.id.checkBox2:
                if (checked){
                    selection.setText("JavaScript");
                }
                break;

        }
    }

    public void onToggleClicked(View view) {
        boolean on=((ToggleButton) view).isChecked();
        if (on) Toast.makeText(this,"Свет включен", Toast.LENGTH_LONG).show();
        else Toast.makeText(this,"Свет выключен", Toast.LENGTH_LONG).show();

    }
}
