package com.example.shen.hottohome.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shen.hottohome.R;
import com.example.shen.hottohome.adapter.AdapterMeals;
import com.example.shen.hottohome.model.Meals;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ArrayList<Meals> arrayList;
    private ListView listView;
    private AdapterMeals adapterMeals;
    private TextView textView;
    private String total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bundle bundle=getIntent().getExtras();
        arrayList=bundle.getParcelableArrayList("data");
        total=bundle.getString("total");
        textView=(TextView)findViewById(R.id.total);
        listView=(ListView)findViewById(R.id.list);
        adapterMeals=new AdapterMeals(this,arrayList);
        listView.setAdapter(adapterMeals);
        textView.setText("總計"+total+"元");
    }
}
