package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_product_main;
    RadioButton radio1,radio2,radio3;
    EditText edit_count;
    TextView txt_price,txt_delivery,txt_pay;
    CheckBox chk_agree;

    int selected_count=1;
    int selected_price=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        img_product_main=findViewById(R.id.img_product_main);
        radio1=findViewById(R.id.radio1);
        radio2=findViewById(R.id.radio1);
        radio3=findViewById(R.id.radio1);
        edit_count=findViewById(R.id.edit_count);
        txt_price=findViewById(R.id.txt_price);
        txt_delivery=findViewById(R.id.txt_delivery);
        txt_pay=findViewById(R.id.txt_pay);
        chk_agree=findViewById(R.id.chk_agree);


        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.txt_pay).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String str_count;
        switch (view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.product1);
                selected_price=1500;
                sumTotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.product2);
                selected_price=2000;
                sumTotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.product3);
                selected_price=3000;
                sumTotal();
                break;
            case R.id.btn_minus:
                str_count=edit_count.getText().toString();
                if(str_count.equals("1")){
                    Toast.makeText(this, "최소 수량은 1입니다.", Toast.LENGTH_SHORT).show();
                }else
                {
                    selected_count=Integer.parseInt(str_count)-1 ;
                    edit_count.setText(Integer.toString(selected_count));
                    sumTotal();
                }

                break;
            case R.id.btn_plus:
                str_count=edit_count.getText().toString();
                if(str_count.equals("5")){
                    Toast.makeText(this, "최대 수량은 5입니다.", Toast.LENGTH_SHORT).show();
                }else
                {
                    selected_count=Integer.parseInt(str_count)+1 ;
                    edit_count.setText(selected_count+"");
                    sumTotal();
                }
                break;
            case R.id.btn_pay:
                break;
        }
    }

    private void sumTotal() {
        int val_delivery=0;
        int val_pay=0;
        int val_price= selected_price * selected_count;
        if(val_price>=10000)
            val_delivery=0;
        else
            val_delivery=2500;
        val_pay=val_price+val_delivery;

        txt_price.setText(val_price+"원");
        txt_delivery.setText(val_delivery+"원");
        txt_pay.setText(val_pay+"원");

    }
}