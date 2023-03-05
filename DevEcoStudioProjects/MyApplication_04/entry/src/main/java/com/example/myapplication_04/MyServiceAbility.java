package com.example.myapplication_04;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
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
    protected void onCommand(Intent intent, boolean restart, int startId) {//01
        super.onCommand(intent, restart, startId);
        ToastDialog toastDialog = new ToastDialog(getContext());//02
        toastDialog.setText("已经使用Service"+startId);//03
        toastDialog.setAlignment(LayoutAlignment.CENTER);//04
        toastDialog.show();//05
    }
}
