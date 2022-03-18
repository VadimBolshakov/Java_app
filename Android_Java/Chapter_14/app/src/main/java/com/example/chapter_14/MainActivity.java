package com.example.chapter_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView loginText;
    boolean enabled;
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginText=(TextView) findViewById(R.id.login_text);

    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        enabled=prefs.getBoolean("enabled", false);
        login=prefs.getString("login", "не установлено");
        loginText.setText(login);
        if(enabled)
            loginText.setVisibility(View.VISIBLE);
        else
            loginText.setVisibility(View.INVISIBLE);
    }
    public void setPref(View view){
        Intent intent=new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
}
