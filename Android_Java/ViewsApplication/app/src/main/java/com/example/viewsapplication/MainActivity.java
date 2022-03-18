package com.example.viewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TextView textView=new TextView(this);
        //textView.setText("Hello Android");
        //textView.setTextSize(22);
        //setContentView(textView);
        //RelativeLayout relativeLayout=new RelativeLayout(this);
        setContentView(R.layout.activity_main);
        TextView textView=(TextView) findViewById(R.id.textView4);
        textView.setTextSize(20);
        textView.setText("Hello Android!!!");
        //textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //relativeLayout.addView(textView);
        //setContentView(relativeLayout);

    }
}
