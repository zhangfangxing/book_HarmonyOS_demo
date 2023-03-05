package com.example.myapplication_05;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.event.notification.NotificationRequest;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MyServiceAbility extends Ability{
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001101, "MyServiceAbility");
    @Override
    public void onStart(Intent intent) {
        HiLog.error(LABEL_LOG, "MyServiceAbility::onStart");
        super.onStart(intent);
    }

    @Override
    protected void onCommand(Intent intent, boolean restart, int startId) {
        super.onCommand(intent, restart, startId);
        //restart  Ability启动的状态，true=销毁后的重启，false=正常的重启
        //startId   onCommand每被调用一次则增加1
        ToastDialog toastDialog = new ToastDialog(getContext());
        toastDialog.setText("已经使用Service"+startId);
        toastDialog.setAlignment(LayoutAlignment.CENTER);
        toastDialog.show();

        //创建通知内容
        NotificationRequest.NotificationNormalContent notificationNormalContent = new NotificationRequest.NotificationNormalContent();//01
        notificationNormalContent.setTitle("测试应用");//02
        notificationNormalContent.setText("该Service会常驻");//03

        //创建通知对象
        NotificationRequest.NotificationContent notificationContent = new NotificationRequest.NotificationContent(notificationNormalContent);//04

        //创建通知请求
        NotificationRequest notificationRequest = new NotificationRequest(1001);//05
        notificationRequest.setContent(notificationContent);
        keepBackgroundRunning(1005,notificationRequest);//06
    }

    @Override
    protected void onStop() {
        super.onStop();
        cancelBackgroundRunning();//07
    }
}
