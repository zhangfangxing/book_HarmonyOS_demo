package com.example.myapplication_22.slice;

import com.example.myapplication_22.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.AttrHelper;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Text title = (Text)findComponentById(ResourceTable.Id_position_text_1);
        Text content1 = (Text)findComponentById(ResourceTable.Id_position_text_2);
        Text content2 = (Text)findComponentById(ResourceTable.Id_position_text_3);

        title.setPosition(vp2px(50), vp2px(8));
        content1.setPosition(vp2px(8), vp2px(64));
        content2.setPosition(vp2px(92), vp2px(188));
    }

    private int vp2px(float vp){
        return AttrHelper.vp2px(vp,this);
    }
}
