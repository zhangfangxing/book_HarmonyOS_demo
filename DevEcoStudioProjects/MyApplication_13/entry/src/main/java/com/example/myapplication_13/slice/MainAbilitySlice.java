package com.example.myapplication_13.slice;

import com.example.myapplication_13.ResourceTable;
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
            new ToastDialog(getContext())
                    .setText("This is a ToastDialog")
                    .show();
        });
    }
}