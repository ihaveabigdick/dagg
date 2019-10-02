package com.example.shen.hottohome.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shen.hottohome.R;
import com.example.shen.hottohome.adapter.AdapterMeals;
import com.example.shen.hottohome.model.Meals;

public class ChooeseActivity extends AppCompatActivity {

    private LinearLayout layHome, lay1, lay2, lay3, lay4, lay5;
    private LinearLayout from1, from2, from2_1, from2_2;
    private Button btnLay1, btnLay2, btnLay3, btnLay4, btnlay5;
    private Button btnMenu1_1, btnMenu1_2, btnMenu1_3, btnMenu1_4;
    private Button btnMenu2_1, btnMenu2_2, btnMenu2_3, btnMenu2_4, btnMenu2_5;
    private Button btnMenu3_1, btnMenu3_2, btnMenu3_3, btnMenu3_4, btnMenu3_5, btnMenu3_6, btnMenu3_7, btnMenu3_8, btnMenu3_9;
    private Button btnMenu4_1, btnMenu4_2, btnMenu4_3, btnMenu4_4, btnMenu4_5, btnMenu4_6;
    private Button btnMenu5_1, btnMenu5_2, btnMenu5_3;
    private ImageButton imgbtnMenu2_2, imgbtnMenu3_2, imgbtnMenu4_2;
    private ListView listView;
    private AdapterMeals adapterMeals;
    private Button submit, btn_nextpage, btn_backpage;
    private TextView textView;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooese);

        btnLay1 = (Button) findViewById(R.id.btnlay1);
        btnLay2 = (Button) findViewById(R.id.btnlay2);
        btnLay3 = (Button) findViewById(R.id.btnlay3);
        btnLay4 = (Button) findViewById(R.id.btnlay4);
        btnlay5 = (Button) findViewById(R.id.btnlay5);

        layHome = (LinearLayout) findViewById(R.id.lay_home);
        lay1 = (LinearLayout) findViewById(R.id.lay_1);
        lay2 = (LinearLayout) findViewById(R.id.lay_2);
        lay3 = (LinearLayout) findViewById(R.id.lay_3);
        lay4 = (LinearLayout) findViewById(R.id.lay_4);
        lay5 = (LinearLayout) findViewById(R.id.lay_5);
        from1 = (LinearLayout) findViewById(R.id.from1);
        from2 = (LinearLayout) findViewById(R.id.from2);
        from2_1 = (LinearLayout) findViewById(R.id.from2_1);
        from2_2 = (LinearLayout) findViewById(R.id.from2_2);

        btnMenu1_1 = (Button) findViewById(R.id.btnMenu1_1);
        btnMenu1_2 = (Button) findViewById(R.id.btnMenu1_2);
        btnMenu1_3 = (Button) findViewById(R.id.btnMenu1_3);
        btnMenu1_4 = (Button) findViewById(R.id.btnMenu1_4);

        btnMenu2_1 = (Button) findViewById(R.id.btnMenu2_1);
        btnMenu2_2 = (Button) findViewById(R.id.btnMenu2_2);
        btnMenu2_3 = (Button) findViewById(R.id.btnMenu2_3);
        btnMenu2_4 = (Button) findViewById(R.id.btnMenu2_4);
        btnMenu2_5 = (Button) findViewById(R.id.btnMenu2_5);

        btnMenu3_1 = (Button) findViewById(R.id.btnMenu3_1);
        btnMenu3_2 = (Button) findViewById(R.id.btnMenu3_2);
        btnMenu3_3 = (Button) findViewById(R.id.btnMenu3_3);
        btnMenu3_4 = (Button) findViewById(R.id.btnMenu3_4);
        btnMenu3_5 = (Button) findViewById(R.id.btnMenu3_5);
        btnMenu3_6 = (Button) findViewById(R.id.btnMenu3_6);
        btnMenu3_7 = (Button) findViewById(R.id.btnMenu3_7);
        btnMenu3_8 = (Button) findViewById(R.id.btnMenu3_8);
        btnMenu3_9 = (Button) findViewById(R.id.btnMenu3_9);

        btnMenu4_1 = (Button) findViewById(R.id.btnMenu4_1);
        btnMenu4_2 = (Button) findViewById(R.id.btnMenu4_2);
        btnMenu4_3 = (Button) findViewById(R.id.btnMenu4_3);
        btnMenu4_4 = (Button) findViewById(R.id.btnMenu4_4);
        btnMenu4_5 = (Button) findViewById(R.id.btnMenu4_5);
        btnMenu4_6 = (Button) findViewById(R.id.btnMenu4_6);

        btnMenu5_1 = (Button) findViewById(R.id.btnMenu5_1);
        btnMenu5_2 = (Button) findViewById(R.id.btnMenu5_2);
        btnMenu5_3 = (Button) findViewById(R.id.btnMenu5_3);

        submit = (Button) findViewById(R.id.submit);
        btn_nextpage = (Button) findViewById(R.id.btn_nextpage);
        btn_backpage = (Button) findViewById(R.id.btn_backpage);

        listView = (ListView) findViewById(R.id.list);

        adapterMeals = new AdapterMeals(this);
        listView.setAdapter(adapterMeals);

        textView = (TextView) findViewById(R.id.total);

        btnLay1.setOnClickListener(onClickListener);
        btnLay2.setOnClickListener(onClickListener);
        btnLay3.setOnClickListener(onClickListener);
        btnLay4.setOnClickListener(onClickListener);
        btnlay5.setOnClickListener(onClickListener);

        btnMenu1_1.setOnClickListener(onClickListener);
        btnMenu1_2.setOnClickListener(onClickListener);
        btnMenu1_3.setOnClickListener(onClickListener);
        btnMenu1_4.setOnClickListener(onClickListener);

        btnMenu2_1.setOnClickListener(onClickListener);
        btnMenu2_2.setOnClickListener(onClickListener);
        btnMenu2_3.setOnClickListener(onClickListener);
        btnMenu2_4.setOnClickListener(onClickListener);
        btnMenu2_5.setOnClickListener(onClickListener);

        btnMenu3_1.setOnClickListener(onClickListener);
        btnMenu3_2.setOnClickListener(onClickListener);
        btnMenu3_3.setOnClickListener(onClickListener);
        btnMenu3_4.setOnClickListener(onClickListener);
        btnMenu3_5.setOnClickListener(onClickListener);
        btnMenu3_6.setOnClickListener(onClickListener);
        btnMenu3_7.setOnClickListener(onClickListener);
        btnMenu3_8.setOnClickListener(onClickListener);
        btnMenu3_9.setOnClickListener(onClickListener);

        btnMenu4_1.setOnClickListener(onClickListener);
        btnMenu4_2.setOnClickListener(onClickListener);
        btnMenu4_3.setOnClickListener(onClickListener);
        btnMenu4_4.setOnClickListener(onClickListener);
        btnMenu4_5.setOnClickListener(onClickListener);
        btnMenu4_6.setOnClickListener(onClickListener);

        btnMenu5_1.setOnClickListener(onClickListener);
        btnMenu5_2.setOnClickListener(onClickListener);
        btnMenu5_3.setOnClickListener(onClickListener);

        submit.setOnClickListener(onClickListener);
        btn_nextpage.setOnClickListener(onClickListener);
        btn_backpage.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Meals meals = new Meals();
            switch (view.getId()) {

                case R.id.btnlay1:
                    layHome.setVisibility(View.GONE);
                    lay1.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnlay2:
                    layHome.setVisibility(View.GONE);
                    lay2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnlay3:
                    layHome.setVisibility(View.GONE);
                    lay3.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnlay4:
                    layHome.setVisibility(View.GONE);
                    lay4.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnlay5:
                    layHome.setVisibility(View.GONE);
                    lay5.setVisibility(View.VISIBLE);

                case R.id.btn_nextpage:
                    from1.setVisibility(View.GONE);
                    from2.setVisibility(View.GONE);
                    from2_1.setVisibility(View.VISIBLE);
                    from2_2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_backpage:
                    from1.setVisibility(View.VISIBLE);
                    from2.setVisibility(View.VISIBLE);
                    from2_1.setVisibility(View.GONE);
                    from2_2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu1_1:
                    adapterMeals.Add(chooseMeals(16));
                    layHome.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu1_2:
                    adapterMeals.Add(chooseMeals(17));
                    layHome.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu1_3:
                    adapterMeals.Add(chooseMeals(18));
                    layHome.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu1_4:
                    adapterMeals.Add(chooseMeals(19));
                    layHome.setVisibility(View.VISIBLE);
                    lay1.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu2_1:
                    adapterMeals.Add(chooseMeals(20));
                    layHome.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu2_2:
                    adapterMeals.Add(chooseMeals(21));
                    layHome.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu2_3:
                    adapterMeals.Add(chooseMeals(22));
                    layHome.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu2_4:
                    adapterMeals.Add(chooseMeals(23));
                    layHome.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu2_5:
                    adapterMeals.Add(chooseMeals(24));
                    layHome.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_1:
                    adapterMeals.Add(chooseMeals(1));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_2:
                    adapterMeals.Add(chooseMeals(2));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_3:
                    adapterMeals.Add(chooseMeals(3));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_4:
                    adapterMeals.Add(chooseMeals(4));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_5:
                    adapterMeals.Add(chooseMeals(5));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_6:
                    adapterMeals.Add(chooseMeals(6));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_7:
                    adapterMeals.Add(chooseMeals(7));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_8:
                    adapterMeals.Add(chooseMeals(8));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu3_9:
                    adapterMeals.Add(chooseMeals(9));
                    layHome.setVisibility(View.VISIBLE);
                    lay3.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_1:
                    adapterMeals.Add(chooseMeals(10));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_2:
                    adapterMeals.Add(chooseMeals(11));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_3:
                    adapterMeals.Add(chooseMeals(12));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_4:
                    adapterMeals.Add(chooseMeals(13));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_5:
                    adapterMeals.Add(chooseMeals(14));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu4_6:
                    adapterMeals.Add(chooseMeals(15));
                    layHome.setVisibility(View.VISIBLE);
                    lay4.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu5_1:
                    adapterMeals.Add(chooseMeals(25));
                    layHome.setVisibility(View.VISIBLE);
                    lay5.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu5_2:
                    adapterMeals.Add(chooseMeals(26));
                    layHome.setVisibility(View.VISIBLE);
                    lay5.setVisibility(View.GONE);
                    break;
                case R.id.btnMenu5_3:
                    adapterMeals.Add(chooseMeals(27));
                    layHome.setVisibility(View.VISIBLE);
                    lay5.setVisibility(View.GONE);
                    break;
                case R.id.submit:
                    Intent intent = new Intent(ChooeseActivity.this, OrderActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("data", adapterMeals.getList());
                    bundle.putString("total", String.valueOf(total));
                    intent.putExtras(bundle);
                    startActivity(intent);
            }
        }
    };

    private Meals chooseMeals(int i) {
        Meals meals = new Meals();
        switch (i) {
            case 1:
                meals.id = 1;
                meals.name = "鳥人水果茶";
                meals.price = 200;
                break;
            case 2:
                meals.id = 2;
                meals.name = "天空柚子茶";
                meals.price = 200;
                break;
            case 3:
                meals.id = 3;
                meals.name = "原味可可";
                meals.price = 200;
                break;
            case 4:
                meals.id = 4;
                meals.name = "黑芝麻豆漿抹茶";
                meals.price = 200;
                break;
            case 5:
                meals.id = 5;
                meals.name = "炭焙烏龍奶茶";
                meals.price = 200;
                break;
            case 6:
                meals.id = 6;
                meals.name = "桂花鮮奶茶";
                meals.price = 200;
                break;
            case 7:
                meals.id = 7;
                meals.name = "蘋果雪梨茶";
                meals.price = 200;
                break;
            case 8:
                meals.id = 8;
                meals.name = "鮮桔小紫蘇";
                meals.price = 200;
                break;
            case 9:
                meals.id = 9;
                meals.name = "蔓越莓鳳梨果汁";
                meals.price = 200;
                break;
            case 10:
                meals.id = 10;
                meals.name = "精選當令包種茶";
                meals.price = 200;
                break;
            case 11:
                meals.id = 11;
                meals.name = "寧靜紓壓茶";
                meals.price = 200;
                break;
            case 12:
                meals.id = 12;
                meals.name = "萊茵野莓果粒茶";
                meals.price = 200;
                break;
            case 13:
                meals.id = 13;
                meals.name = "元氣養蔘茶";
                meals.price = 200;
                break;
            case 14:
                meals.id = 14;
                meals.name = "桂圓紅棗茶";
                meals.price = 200;
                break;
            case 15:
                meals.id = 15;
                meals.name = "玫瑰四物飲";
                meals.price = 200;
                break;
            case 16:
                meals.id = 16;
                meals.name = "原味拿鐵";
                meals.price = 200;
                break;
            case 17:
                meals.id = 17;
                meals.name = "卡布奇諾";
                meals.price = 200;
                break;
            case 18:
                meals.id = 18;
                meals.name = "焦糖瑪奇朵";
                meals.price = 200;
                break;
            case 19:
                meals.id = 19;
                meals.name = "摩卡咖啡";
                meals.price = 200;
                break;
            case 20:
                meals.id = 20;
                meals.name = "鳥人瘋薯條";
                meals.price = 200;
                break;
            case 21:
                meals.id = 21;
                meals.name = "私房豆干";
                meals.price = 100;
                break;
            case 22:
                meals.id = 22;
                meals.name = "茴香毛豆";
                meals.price = 100;
                break;
            case 23:
                meals.id = 23;
                meals.name = "招牌素捲";
                meals.price = 120;
                break;
            case 24:
                meals.id = 24;
                meals.name = "甜不辣";
                meals.price = 120;
                break;
            case 25:
                meals.id = 25;
                meals.name = "南瓜";
                meals.price = 350;
                break;
            case 26:
                meals.id = 26;
                meals.name = "夏威夷";
                meals.price = 350;
                break;
            case 27:
                meals.id = 27;
                meals.name = "墨西哥";
                meals.price = 350;
                break;
        }
        total += meals.price;
        textView.setText(String.valueOf(total) + "元");
        return meals;
    }

}
