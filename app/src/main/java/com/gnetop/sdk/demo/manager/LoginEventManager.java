package com.gnetop.sdk.demo.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.gentop.ltgame.ltgamesdkcore.common.LTGameOptions;
import com.gentop.ltgame.ltgamesdkcore.common.LTGameSdk;
import com.gentop.ltgame.ltgamesdkcore.common.Target;
import com.gentop.ltgame.ltgamesdkcore.impl.OnLoginStateListener;
import com.gentop.ltgame.ltgamesdkcore.impl.OnRechargeListener;
import com.gentop.ltgame.ltgamesdkcore.manager.LoginManager;
import com.gentop.ltgame.ltgamesdkcore.manager.RechargeManager;
import com.gentop.ltgame.ltgamesdkcore.model.LoginObject;
import com.gentop.ltgame.ltgamesdkcore.model.RechargeObject;
import com.gentop.ltgame.ltgamesdkcore.util.DeviceUtils;
import com.sdk.ltgame.ltfacebook.FacebookEventManager;
import com.sdk.ltgame.ltnet.impl.OnUploadDeviceListener;
import com.sdk.ltgame.ltnet.manager.LoginRealizeManager;

import java.util.Map;
import java.util.concurrent.Executors;

public class LoginEventManager {

    private static String mAdID;
    private static String mLtAppID = "28576";
    private static String mLtAppKey = "MJwk6bLlpGErRgLKkJPLP7VavHRGvTpA";
    private static String mAuthID = "443503959733-0vhjo7df08ahd9i7d5lj9mdtt7bahsbq.apps.googleusercontent.com";
    private static String mFacebookId = "2717734461592670";
    private static final int REQUEST_CODE = 0X01;
    private static final String mGPPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAleVlYQtKhvo+lb83j73kXGH8xAMhHcaAZoS22Bo3Jdujix9Ou5DjtUW3i6MIFqWEbnb9da50iH5IrxkkdJCcqzeYDdLk2Y3Gc+kyaw5ch4I//hjC2hh8nHgo8eWfrxSFce/DpNBeS1j4mWcjWZhYJtxheEUk8iTyXIVWHC8dCyifibs7z8wCXMhy3Q66Zym5GarAYjpuQsXTxHuOYUXakLWCwIXG8d8ihoRxweI7PtLpVyNU5FKgse42uouMRz6TgVotgu+NdamNyTH/CutQMPGeNXUj6FpHUDEWQhsRp27k0KsA8YWJDJBj4R9bJ5GDqD8XJo2y5V7/vy1OH4afkQIDAQAB";
    private static final String mONEPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCu9RPDbvVqM8XWqVc75JXccIXN1VS8XViRZzATUq62kkFIXCeo52LKzBCh3iWFQIvX3jqDhim4ESqHMezEx8CxaTq8NpNoQXutBNmOEl+/7HTUsZxI93wgn9+7pFMyoFlasqmVjCcM7zbbAx5G0bySsm98TFxTu16OGmO01JGonQIDAQAB";
    private static final String QQ_APP_ID = "1108097616";


    /**
     * 初始化google
     */
    public static void googleInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .google(mAuthID)
                                .requestCode(REQUEST_CODE)
                                .build();
                        LTGameSdk.init(options);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    /**
     * 初始化fb
     */
    public static void fbInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .facebookEnable()
                                .facebook(mFacebookId)
                                .requestCode(REQUEST_CODE)
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化gp
     */
    public static void gpInit(final Context context, final boolean isDebug, final boolean isTest,
                              final int mTestPay) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .payTest(mTestPay)
                                .googlePlay(true)
                                .requestCode(REQUEST_CODE)
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化gp
     */
    public static void guestInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .guestEnable(true)
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化gp
     */
    public static void qqInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .qq(QQ_APP_ID)
                                .setQQEnable(true)
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化gp
     */
    public static void phoneInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .phoneEnable()
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化oneStore
     */
    public static void oneStoreInit(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .isServerTest(isTest)
                                .setAdID(mAdID)
                                .oneStore()
                                .goodsType("inapp")
                                .requestCode(REQUEST_CODE)
                                .build();
                        LTGameSdk.init(options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    /**
     * Google登录
     *
     * @param context          上下文
     *                         //@param mAuthID          google 平台申请的web版的AuthID
     *                         //@param mRequestCode     请求码
     * @param isLoginOut       是否退出登录，true、退出登录，false、不退出登录
     * @param isStats          是否开启统计，true、开启，false、不开启
     * @param mOnLoginListener 结果回调
     */
    public static void googleLogin(Activity context, boolean isLoginOut, boolean isStats,
                                   OnLoginStateListener mOnLoginListener) {
        LoginObject object = new LoginObject();
        object.setmAdID(mAdID);
        object.setLTAppID(mLtAppID);
        object.setLTAppKey(mLtAppKey);
        object.setmGoogleClient(mAuthID);
        object.setSelfRequestCode(REQUEST_CODE);
        object.setStats(isStats);
        object.setLoginOut(isLoginOut);
        LoginManager.login(context, Target.LOGIN_GOOGLE, object, mOnLoginListener);
    }

    /**
     * Facebook登录
     *
     * @param context          上下文
     *                         //@param mFacebookId      Facebook申请的AppID
     *                         //@param mRequestCod      请求码
     * @param isLoginOut       是否退出登录，true、退出登录，false、不退出登录
     * @param isStats          是否开启统计，true、开启，false、不开启
     * @param mOnLoginListener 结果回调
     */
    public static void fbLogin(Activity context, boolean isLoginOut, boolean isStats,
                               OnLoginStateListener mOnLoginListener) {
        LoginObject object = new LoginObject();
        object.setFacebookAppID(mFacebookId);
        object.setmAdID(mAdID);
        object.setLTAppID(mLtAppID);
        object.setLTAppKey(mLtAppKey);
        object.setSelfRequestCode(REQUEST_CODE);
        object.setStats(isStats);
        object.setLoginOut(isLoginOut);
        LoginManager.login(context,
                Target.LOGIN_FACEBOOK, object, mOnLoginListener);
    }

    /**
     * QQ登录
     *
     * @param context          上下文
     *                         //@param mQQAppID         QQ平台申请的AppID
     * @param isLoginOut       是否退出登录，true、退出登录，false、不退出登录
     * @param mOnLoginListener 结果回调
     */
    public static void qqLogin(Activity context, boolean isLoginOut,
                               OnLoginStateListener mOnLoginListener) {
        LoginObject object = new LoginObject();
        object.setmAdID(mAdID);
        object.setLTAppID(mLtAppID);
        object.setLTAppKey(mLtAppKey);
        object.setQqAppID(QQ_APP_ID);
        object.setLoginOut(isLoginOut);
        LoginManager.login(context, Target.LOGIN_QQ,
                object, mOnLoginListener);
    }

    /**
     * @param context          上下文
     *                         //@param mFacebookId      Facebook平台申请的AppID
     *                         //@param mRequestCod      请求码
     *                         //@param mAuthID          google AuthID
     * @param guestType        登录类型: 1、游客登陆，2、绑定FB，3、绑定Google
     * @param isStats          是否开启统计，true、开启，false、不开启
     * @param mOnLoginListener 结果回调
     */
    public static void guestLogin(Activity context, String guestType, boolean isStats,
                                  OnLoginStateListener mOnLoginListener) {
        LoginObject object = new LoginObject();
        object.setmAdID(mAdID);
        object.setFacebookAppID(mFacebookId);
        object.setLTAppID(mLtAppID);
        object.setLTAppKey(mLtAppKey);
        object.setSelfRequestCode(REQUEST_CODE);
        object.setmGoogleClient(mAuthID);
        object.setStats(isStats);
        object.setGuestType(guestType);
        LoginManager.login(context, Target.LOGIN_GUEST, object, mOnLoginListener);
    }

    /**
     * 手机登录
     *
     * @param context          上下文
     * @param mPhone           手机号
     * @param mPassword        密码
     * @param loginType        登录类型：1、注册，2、登录、3、修改密码
     * @param mOnLoginListener 结果回调
     */
    public static void phoneLogin(Activity context, String mPhone, String mPassword, String loginType,
                                  OnLoginStateListener mOnLoginListener) {
        LoginObject object = new LoginObject();
        object.setmAdID(mAdID);
        object.setLTAppID(mLtAppID);
        object.setLTAppKey(mLtAppKey);
        object.setmPhone(mPhone);
        object.setmPassword(mPassword);
        object.setmLoginCode(loginType);
        LoginManager.login(context, Target.LOGIN_PHONE, object, mOnLoginListener);
    }

    /**
     * Google支付
     *
     * @param context             上下文
     * @param sku                 商品
     * @param mGoodsID            商品ID
     *                            //@param mPublicKey          公钥
     * @param params              自定义参数
     * @param payType             支付类型
     * @param isStats             是否开启统计，true、开启，false、不开启
     * @param mOnRechargeListener 回调
     */
    public static void gpRecharge(Activity context, String sku, String mGoodsID,
                                  Map<String, Object> params, int payType,
                                  boolean isStats,
                                  OnRechargeListener mOnRechargeListener) {
        RechargeObject result = new RechargeObject();
        result.setLTAppID(mLtAppID);
        result.setLTAppKey(mLtAppKey);
        result.setSku(sku);
        result.setGoodsID(mGoodsID);
        result.setPublicKey(mGPPublicKey);
        result.setParams(params);
        result.setStats(isStats);
        result.setPayTest(payType);
        RechargeManager.recharge(context, Target.RECHARGE_GOOGLE,
                result, mOnRechargeListener);
    }

    /**
     * oneStore支付
     *
     * @param context             上下文
     * @param sku                 商品
     * @param mGoodsID            商品ID
     *                            //@param mPublicKey          公钥
     * @param params              自定义参数
     * @param payType             支付类型
     * @param mOnRechargeListener 回调
     */
    public static void oneStoreRecharge(Activity context, String sku, String mGoodsID,
                                        Map<String, Object> params, int payType,
                                        OnRechargeListener mOnRechargeListener) {
        RechargeObject result = new RechargeObject();
        result.setLTAppID(mLtAppID);
        result.setLTAppKey(mLtAppKey);
        result.setSku(sku);
        result.setGoodsID(mGoodsID);
        result.setGoodsType("inapp");
        result.setPublicKey(mONEPublicKey);
        result.setParams(params);
        result.setPayTest(payType);
        RechargeManager.recharge(context, Target.RECHARGE_ONE_STORE,
                result, mOnRechargeListener);
    }

    /**
     * 统计初始化
     */
    public static void statsInit(Context context) {
        FacebookEventManager.getInstance().start(context, mFacebookId);
    }

    /**
     * 注册
     */
    public static void register(Context context, boolean fbEnable, boolean googleEnable,
                                boolean gpEnable, boolean guestEnable) {
        FacebookEventManager.getInstance().registerBroadcast(context,
                fbEnable, googleEnable, gpEnable, guestEnable);
    }

    /**
     * 反注册
     */
    public static void unRegister(Context context) {
        FacebookEventManager.getInstance().unRegisterBroadcast(context);
    }

    /**
     * 获取手机信息
     */
    public static void getDeviceInfo(final Context context, final boolean isDebug, final boolean isTest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mAdID = DeviceUtils.getGoogleAdId(context.getApplicationContext());
                    if (!TextUtils.isEmpty(mAdID)) {
                        LTGameOptions options = new LTGameOptions.Builder(context)
                                .debug(isDebug)
                                .appID(mLtAppID)
                                .appKey(mLtAppKey)
                                .setAdID(mAdID)
                                .isServerTest(isTest)
                                .build();
                        LTGameSdk.init(options);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        LoginRealizeManager.uploadDeviceInfo(context, new OnUploadDeviceListener() {
            @Override
            public void onSuccess() {
                Log.e("TAG", "onSuccess");
            }

            @Override
            public void onFailed(String msg) {
                Log.e("TAG", msg);
            }
        });
    }


}
