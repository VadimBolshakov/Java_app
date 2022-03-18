package com.example.chapter_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<State> states=new ArrayList<>();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

       countriesList=(ListView) findViewById(R.id.countList);

       StateAdapter stateAdapter=new StateAdapter(this, R.layout.list_item, states);
       countriesList.setAdapter(stateAdapter);

       AdapterView.OnItemClickListener ittemListener=new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
               State selectState = (State)parent.getItemAtPosition(position);
               Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectState.getName(), Toast.LENGTH_SHORT).show();
           }
       };
       countriesList.setOnItemClickListener(ittemListener);
    }
    private void setInitialData(){
        states.add(new State("Бразилия", "Бразилиа",R.drawable.brazil));
        states.add(new State("Аргентина", "Буэнос-Айрес",R.drawable.argentina));
        states.add(new State("Колумбия", "Богота",R.drawable.colombia));
        states.add(new State("Чили", "Сантьяго",R.drawable.chile));
        states.add(new State("Уругвай", "Монтевидео",R.drawable.uruguay));
        states.add(new State("Венисуэла", "Каракас",R.drawable.venezuela));
    }

}
