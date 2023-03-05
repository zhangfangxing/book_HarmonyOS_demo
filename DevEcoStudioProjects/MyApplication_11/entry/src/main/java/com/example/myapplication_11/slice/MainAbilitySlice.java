package com.example.myapplication_11.slice;

import com.example.myapplication_11.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.dialog.IDialog;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button = (Button)findComponentById(ResourceTable.Id_button);
        button.setClickedListener(component -> {
            CommonDialog dialog = new CommonDialog(getContext());
            dialog.setTitleText("提示信息");
            dialog.setContentText("必须关掉对话框才能回到app");
            dialog.setButton(IDialog.BUTTON2, "关掉对话框", (iDialog, i) -> iDialog.destroy());
            dialog.show();
        });
    }
}
