package com.example.chapter_7_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Product> productList;

    ProductAdapter(Context context, int resource, ArrayList<Product> products){
        super(context,resource,products);
        this.productList=products;
        this.layout=resource;
        this.inflater=LayoutInflater.from(context);
    }
    public View getView(int position, View converView, ViewGroup parent){
        final ViewHolder viewHolder;
        if (converView==null){
            converView=inflater.inflate(this.layout, parent, false);
            viewHolder=new ViewHolder(converView);
            converView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)converView.getTag();
        }
        final Product product=productList.get(position);

        viewHolder.nameView.setText(product.getName());
        viewHolder.countView.setText(formatValue(product.getCount(),product.getUnit()));

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=product.getCount()-1;
                if(count<0) count=0;
                product.setCount(count);
                viewHolder.countView.setText(formatValue(count, product.getUnit()));
            }
        });

        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int count = product.getCount()+1;
               product.setCount(count);
               viewHolder.countView.setText(formatValue(count, product.getUnit()));
            }
        });

        return converView;
    }

    private String formatValue(int count, String unit){
        return String.valueOf(count)+" "+unit;
    }
    private class ViewHolder{
        final Button addButton, removeButton;
        final TextView nameView, countView;
        ViewHolder(View view){
            addButton=(Button) view.findViewById(R.id.addButton);
            removeButton=(Button) view.findViewById(R.id.removeButton);
            nameView=(TextView) view.findViewById(R.id.nameView);
            countView=(TextView) view.findViewById(R.id.countView);
        }
    }
}
