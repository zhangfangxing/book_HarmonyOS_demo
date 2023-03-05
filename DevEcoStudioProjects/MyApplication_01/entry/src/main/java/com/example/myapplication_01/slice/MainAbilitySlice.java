package com.example.myapplication_01.slice;

import com.example.myapplication_01.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        //获取页面上的按钮
        Button button = (Button) findComponentById(ResourceTable.Id_button);
        //给按钮添加监听器，点击按钮跳转至第二个页面
        button.setClickedListener(listener -> present(new MyAbilitySlice(), new Intent()));
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
