package com.example.chapter_7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products=new ArrayList();
    ListView productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(products.size()==0){
           products.add(new Product("Картофель", "кг."));
            products.add(new Product("Чай", "шт."));
            products.add(new Product("Яйца", "шт."));
            products.add(new Product("Молоко", "л."));
            products.add(new Product("Макароны", "кг."));
        }

        productList=(ListView) findViewById(R.id.productList);
        ProductAdapter adapter=new ProductAdapter(this,R.layout.list_item, products);
        productList.setAdapter(adapter);
    }
}
