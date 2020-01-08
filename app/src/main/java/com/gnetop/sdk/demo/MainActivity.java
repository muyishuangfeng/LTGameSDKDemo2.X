package com.gnetop.sdk.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.FaceDetector;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gnetop.sdk.demo.manager.LoginEventManager;

public class MainActivity extends AppCompatActivity {

    Button mBtnGoogle, mBtnFB, mBtnGP, mBtnGuest, mBtnQQ, mBtnPhone, mBtnOneStore;
    TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        LoginEventManager.statsInit(this);
        mTxtResult = findViewById(R.id.txt_result);
        mBtnGuest = findViewById(R.id.btn_guest);
        mBtnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GuestActivity.class));
            }
        });

        mBtnGoogle = findViewById(R.id.btn_google);
        mBtnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GoogleActivity.class));
            }
        });
        mBtnFB = findViewById(R.id.btn_fb);
        mBtnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FacebookActivity.class));
            }
        });
        mBtnGP = findViewById(R.id.btn_gp);
        mBtnGP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GooglePlayActivity.class));
            }
        });
        mBtnOneStore = findViewById(R.id.btn_onestore);
        mBtnOneStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OneStoreActivity.class));
            }
        });
        mBtnPhone = findViewById(R.id.btn_phone);
        mBtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhoneActivity.class));
            }
        });
        mBtnQQ = findViewById(R.id.btn_QQ);
        mBtnQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QQActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoginEventManager.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoginEventManager.unRegister(this);
    }
}
