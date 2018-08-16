package com.textjpush55;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import cn.jpush.android.api.JPushInterface;

// notification pacakage
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import android.content.Intent;
import android.provider.Settings;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.NotificationManagerCompat;


public class MainActivity extends ReactActivity {
		private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering 
     * of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "TextJPush55";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JPushInterface.init(this);

        NotificationManagerCompat notification = NotificationManagerCompat.from(this);
        boolean isEnabled = notification.areNotificationsEnabled();


    //     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
    // 				// 进入设置系统应用权限界面
				//     Intent intent = new Intent(Settings.ACTION_SETTINGS);
				//     startActivity(intent);
				//     return;
				// } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
				//     // 进入设置系统应用权限界面
				//     Intent intent = new Intent(Settings.ACTION_SETTINGS);
				//     startActivity(intent);
				//     return;
				// }
				// 
				// 
				// 
				
        // Toast.makeText(this, "version" + Build.VERSION.RELEASE+ " :" + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show(); 
        // Toast.makeText("isEnabled:", isEnabled).show();

        // Toast toast=Toast.makeText(getApplicationContext(), "默认的Toast", Toast.LENGTH_SHORT);
				// //显示toast信息
				// toast.show();
				// 
				// 
				// 

				if (isEnabled) {
					 Toast.makeText(this, "通知栏打开", Build.VERSION_CODES.BASE).show(); 
				} else {
					Toast.makeText(this, "通知栏未打开", Build.VERSION_CODES.BASE).show(); 
					

	        // 检测到手机通知权限未开启，弹出提示框，让用户手机设置
	        builder = new AlertDialog.Builder(this);
	        alertDialog = builder.setIcon(R.mipmap.ic_launcher)
	          .setTitle("系统提示:")
	          .setMessage("‘通知’主要包括促销活动、下单、接单信息提醒，请在 ’设置‘ 中打开。")
	          .setNegativeButton("取消", new DialogInterface.OnClickListener() {
	              @Override
	              public void onClick(DialogInterface dialogInterface, int i) {

	              }
	          })
	          .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
	              @Override
	              public void onClick(DialogInterface dialogInterface, int i) {
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
	          }).create();
	        alertDialog.show();

				}



				        // AlertDialog.Builder builder=new AlertDialog.Builder(this);
				        // builder.setIcon(R.drawable.logo_mini);
				        // builder.setTitle("下线通知").setMessage("该账号在另一台Android设备上登录。")
				        // .setPositiveButton("重新登陆", new DialogInterface.OnClickListener() {
				 
				        //     @Override
				        //     public void onClick(DialogInterface dialog, int which) {
				        //         //do somthing
				        //     }
				        // }).setNegativeButton("退出",new DialogInterface.OnClickListener() {
				 
				        //     @Override
				        //     public void onClick(DialogInterface dialog, int which) {
				        //         Intent i=new Intent(CoreService.this,LoginActivity.class);
				        //         i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				        //         startActivity(i);
				        //     }
				        // });
				        // alertDialog = builder.create();
				        // alertDialog.setCancelable(false);
				        // alertDialog.setCanceledOnTouchOutside(false);
				        // alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
				        // alertDialog.show();

				/*
					供应商想给你发送推送通知

					’通知’主要包括促销活动、下单、接单信息提醒，请在‘设置’中打开。	
				*/

				// builder = new AlertDialog.Builder(this);
    //     alertDialog = builder.setIcon(R.mipmap.ic_launcher)
    //       .setTitle("系统提示:")
    //       .setMessage("‘通知’主要包括促销活动、下单、接单信息提醒，请在 ’设置‘ 中打开。")
    //       .setNegativeButton("取消", new DialogInterface.OnClickListener() {
    //           @Override
    //           public void onClick(DialogInterface dialogInterface, int i) {

    //           }
    //       })
    //       .setPositiveButton("确定", new DialogInterface.OnClickListener() {
    //           @Override
    //           public void onClick(DialogInterface dialogInterface, int i) {

    //           }
    //       }).create();
    //     alertDialog.show();
				

    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }
}
