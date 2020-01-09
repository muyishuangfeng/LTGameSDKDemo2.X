package com.gnetop.sdk.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gentop.ltgame.ltgamesdkcore.common.LTGameOptions;
import com.gentop.ltgame.ltgamesdkcore.common.LTGameSdk;
import com.gentop.ltgame.ltgamesdkcore.common.Target;
import com.gentop.ltgame.ltgamesdkcore.exception.LTGameError;
import com.gentop.ltgame.ltgamesdkcore.impl.OnLoginStateListener;
import com.gentop.ltgame.ltgamesdkcore.manager.LoginManager;
import com.gentop.ltgame.ltgamesdkcore.model.LoginObject;
import com.gentop.ltgame.ltgamesdkcore.model.LoginResult;
import com.gentop.ltgame.ltgamesdkcore.util.DeviceUtils;
import com.gnetop.sdk.demo.manager.LoginEventManager;
import com.sdk.ltgame.ltnet.impl.OnAutoCheckLoginListener;
import com.sdk.ltgame.ltnet.manager.LoginRealizeManager;


import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;

public class GoogleActivity extends AppCompatActivity {

    //当前包名
    Button mBtnStart, mBtnLoginOut, mBtnAuto;
    TextView mTxtResult;
    String LTAppKey = "MJwk6bLlpGErRgLKkJPLP7VavHRGvTpA";
    String LTAppID = "28576";
    private OnLoginStateListener mOnLoginListener;
    String mLtToken, mLtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        initView();
        initData();
    }

    private void initView() {
        LoginEventManager.googleInit(this,true,true);
        mTxtResult = findViewById(R.id.txt_result);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnAuto = findViewById(R.id.btn_auto);
        mBtnLoginOut = findViewById(R.id.btn_loginOut);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEventManager.googleLogin(GoogleActivity.this,false,false,mOnLoginListener);
            }
        });
        mBtnLoginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEventManager.googleLogin(GoogleActivity.this, true, false, mOnLoginListener);

            }
        });
        mBtnAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginRealizeManager.autoLoginCheck(GoogleActivity.this, LTAppID,
                        LTAppKey, mLtId, mLtToken,
                        new OnAutoCheckLoginListener() {
                            @Override
                            public void onCheckedSuccess(String result) {
                                mTxtResult.setText(result);
                            }

                            @Override
                            public void onCheckedFailed(String failed) {
                                Log.e("TAG", failed);
                            }

                            @Override
                            public void onCheckedException(LTGameError ex) {
                                if (ex != null) {
                                    switch (ex.getCode()) {
                                        case LTGameError.CODE_PARAM_ERROR: {
                                            Log.e("RESULT123", ex.getMsg());
                                            break;
                                        }
                                        case LTGameError.CODE_REQUEST_ERROR: {
                                            Log.e("RESULT123", "CODE_REQUEST_ERROR" + ex.getMsg());
                                            break;
                                        }
                                        case LTGameError.CODE_NOT_SUPPORT: {
                                            Log.e("RESULT123", "CODE_NOT_SUPPORT" + ex.getMsg());
                                            break;
                                        }
                                    }
                                }
                            }
                        });

            }
        });
    }


    /**
     * 初始化数据
     */
    private void initData() {
        mOnLoginListener = new OnLoginStateListener() {
            @Override
            public void onState(Activity activity, LoginResult result) {
                switch (result.state) {
                    case LoginResult.STATE_SUCCESS:
                        if (result.getResultModel() != null) {
                            mLtToken = result.getResultModel().getData().getLt_uid_token();
                            mLtId = result.getResultModel().getData().getLt_uid();
                            mTxtResult.setText(result.getResultModel().toString());
                        }
                        break;
                    case LoginResult.STATE_LOGIN_OUT:
                        if (result.getError().getMsg() != null) {
                            Toast.makeText(GoogleActivity.this, result.getError().getMsg(), Toast.LENGTH_SHORT).show();
                            mTxtResult.setText(result.getError().getMsg());
                        }
                        break;
                    case LoginResult.STATE_FAIL:
                        if (result.getError() != null) {
                            switch (result.getError().getCode()) {
                                case LTGameError.CODE_PARAM_ERROR: {
                                    Log.e("RESULT123", "CODE_PARAM_ERROR" + result.getError().getMsg());
                                    break;
                                }
                                case LTGameError.CODE_REQUEST_ERROR: {
                                    Log.e("RESULT123", "CODE_REQUEST_ERROR" + result.getError().getMsg());
                                    break;
                                }
                                case LTGameError.CODE_NOT_SUPPORT: {
                                    Log.e("RESULT123", "CODE_NOT_SUPPORT" + result.getError().getMsg());
                                    break;
                                }
                            }
                        }
                        break;

                }
            }

        };
    }


}
