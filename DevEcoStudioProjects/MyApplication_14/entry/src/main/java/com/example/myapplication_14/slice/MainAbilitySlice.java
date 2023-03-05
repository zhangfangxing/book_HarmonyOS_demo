package com.example.myapplication_14.slice;

import com.example.myapplication_14.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        ProgressBar progressBar = (ProgressBar) findComponentById(ResourceTable.Id_progressbar);
        progressBar.setProgressValue(60);
    }
}