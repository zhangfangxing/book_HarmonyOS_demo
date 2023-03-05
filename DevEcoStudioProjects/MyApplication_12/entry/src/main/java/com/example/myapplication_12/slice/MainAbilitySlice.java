package com.example.myapplication_12.slice;

import com.example.myapplication_12.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.window.dialog.PopupDialog;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Component button = findComponentById(ResourceTable.Id_target_component);
        button.setClickedListener(component -> {
            PopupDialog popupDialog = new PopupDialog(getContext(), component);
            popupDialog.setText("This is PopupDialog");
            popupDialog.setHasArrow(true);
            popupDialog.setArrowSize(100, 75); // 设置箭头的宽和高
            popupDialog.setArrowOffset(100); // 设置箭头的偏移量
            popupDialog.show();
        });
    }
}