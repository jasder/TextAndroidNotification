package com.textjpush55;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

/*
// notifications package 
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
*/


import java.util.Arrays;
import java.util.List;

import cn.jpush.reactnativejpush.JPushPackage;


public class MainApplication extends Application implements ReactApplication {

  // jPush configuration 

  private boolean SHUTDOWN_TOAST = false; // 设置为true将不弹出toast
  private boolean SHUTDOWN_LOG = true; // 设置为true将不打印log

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new JPushPackage(SHUTDOWN_TOAST, SHUTDOWN_LOG)
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);

    // nofication setting
    /* 
      NotificationManagerCompat notification = NotificationManagerCompat.from(this);
      boolean isEnabled = notification.areNotificationsEnabled();

      if (isEnabled) {
         Toast.makeText(this, "通知栏打开", Build.VERSION_CODES.BASE).show(); 
      } else {
        Toast.makeText(this, "通知栏未打开", Build.VERSION_CODES.BASE).show(); 
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
          Intent intent = new Intent()
                  .setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                  .setData(Uri.fromParts("package",
                          getApplicationContext().getPackageName(), null));
          startActivity(intent);
          return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent()
                    .setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.fromParts("package",
                            getApplicationContext().getPackageName(), null));
            startActivity(intent);
            return;
        }
      }
    */

  }
}
