package com.example.exam_shop2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_product_main;
    EditText edit_count;
    TextView txt_price, txt_delivery, txt_pay;
    CheckBox chk_agree;
    int val_price;
    int val_delivery;
    int val_pay;
    int selected_product=2000;
    int selected_count=1;     // 선택한 수량

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_product_main = findViewById(R.id.img_product_main);
        edit_count=findViewById(R.id.edit_count);
        txt_price=findViewById(R.id.txt_price);
        txt_delivery=findViewById(R.id.txt_delivery);
        txt_pay=findViewById(R.id.txt_pay);
        chk_agree=findViewById(R.id.chk_agree);

        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.radio4).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        sumtotal();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.coffee1);
                selected_product=2000;
                sumtotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.coffee2);
                selected_product=3000;
                sumtotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.coffee3);
                selected_product=4000;
                sumtotal();
                break;
            case R.id.radio4:
                img_product_main.setImageResource(R.drawable.coffee4);
                selected_product=5000;
                sumtotal();
                break;
            case R.id.btn_minus:
                if(selected_count<=1)
                    Toast.makeText(this, "최소주문은 1개 입니다.", Toast.LENGTH_SHORT).show();
                else{
                    --selected_count;
                    edit_count.setText(selected_count+"");
                    sumtotal();
                }
                break;
            case R.id.btn_pay:
                if(chk_agree.isChecked()){
                    Intent intent= new Intent(MainActivity.this,SubActivity.class);
                    intent.putExtra("MSG","30413정윤수");
                    intent.putExtra("PRICE",val_pay);
                }
                break;
            case R.id.btn_plus:
                if(selected_count>=5)
                    Toast.makeText(this, "최대주문은 5개 입니다.", Toast.LENGTH_SHORT).show();
                else{
                    ++selected_count;
                    edit_count.setText(selected_count+"");
                    sumtotal();
                }
                break;
        }
    }

    private void sumtotal() {
        selected_count=Integer.parseInt(edit_count.getText().toString());
        val_price=selected_count*selected_product;
        if(val_price>=10000)
            val_delivery=0;
        else{
            val_delivery=2500;
        }
        val_pay=val_delivery+val_price;
        txt_price.setText(val_price+"원");
        txt_delivery.setText(val_delivery+"원");
        txt_pay.setText(val_pay+"원");

    }
}