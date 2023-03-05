package com.example.myapplication_15.slice;

import com.example.myapplication_15.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Component button = findComponentById(ResourceTable.Id_target_component);
        button.setClickedListener(component -> {
            Checkbox checkbox = (Checkbox)findComponentById(ResourceTable.Id_check_box);
            if (checkbox.isChecked()){
                new ToastDialog(getContext()).setText("已选择！").show();
            } else {
                new ToastDialog(getContext()).setText("未选择！").show();
            }
        });
    }
}