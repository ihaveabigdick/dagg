package com.example.shen.hottohome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shen.hottohome.R;
import com.example.shen.hottohome.model.Meals;

import java.util.ArrayList;

public class AdapterMeals extends BaseAdapter {
    private Context context;
    private ArrayList<Meals> arrayList;
    ViewHold viewHold;

    public AdapterMeals(Context context) {
        this.context = context;
        this.arrayList = new ArrayList<>();
    }

    public AdapterMeals(Context context, ArrayList<Meals> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            viewHold = new ViewHold();
            view = LayoutInflater.from(context).inflate(R.layout.item_meals, null);
            viewHold.name = (TextView) view.findViewById(R.id.name);
            viewHold.price = (TextView) view.findViewById(R.id.price);
            view.setTag(viewHold);
        } else {
            view.getTag();
        }
        viewHold.name.setText(arrayList.get(i).name);
        viewHold.price.setText(String.valueOf(arrayList.get(i).price));

        return view;
    }

    public void Add(Meals meals) {
        arrayList.add(meals);
        this.notifyDataSetChanged();
    }

    public ArrayList<Meals> getList() {
        return arrayList;
    }

    class ViewHold {
        TextView name;
        TextView price;
    }
}
