package com.example.myapplication_07.slice;

import com.example.myapplication_07.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Image image1 = (Image)findComponentById(ResourceTable.Id_image1);
        image1.setClickedListener(component -> {
            if (image1.getHeight() == 500){
                image1.setHeight(1000);
                image1.setWidth(1000);
            } else {
                image1.setHeight(500);
                image1.setWidth(500);
            }
        });
    }
}