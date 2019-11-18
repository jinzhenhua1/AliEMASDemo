package com.example.aliemasdemo.application;

import android.app.Application;
import android.util.Log;

import com.alibaba.ha.adapter.AliHaAdapter;
import com.alibaba.ha.adapter.AliHaConfig;
import com.alibaba.ha.adapter.Plugin;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2019/11/18 10:02
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initHa();
    }

    private void initHa() {
        Log.e("ha", "init");
        AliHaConfig config = new AliHaConfig();
        config.appKey = "28143892";         //appkey
        config.appVersion = "1.0";         //应用的版本号信箱
        config.appSecret = "482487636398615d0b2e28d283003fcd";  //appsecret
        config.channel = "mqc_test";        //应用的渠道号标记，自定义
        config.userNick = null;
        config.application = this;
        config.context = getApplicationContext();
        config.isAliyunos = false;          //是否为yunos
        config.rsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU/BSizx3FKf+ZTUgDBW+9gO93FkyvwSS7WTzKdmJv67c28wHgi9Dwsdx8Rg4u2YiPDEGBDOLqTfUAVnpVmMhLG3NH4ldCvqEYOpKJ9K/CQRHQlW5bklqSDb/ymOV7268UWKIM/x+blhpQdZFVzlCQL/QLA5DPREI+q+Ln8EI8qQIDAQAB";    //tlog公钥， 在控制台下载 aliyun-emas-services.json文件，文件内的appmonitor.tlog.rsaSecret字段即为公钥信息（文件下载方式：在 EMAS控制台-> 应用管理  找到对应的应用，点击应用所在区块右上角菜单内的“配置下载”），必填
        AliHaAdapter.getInstance().addPlugin(Plugin.tlog);
        AliHaAdapter.getInstance().start(config);
    }
}
