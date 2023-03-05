package com.example.myapplication_23.slice;

import com.example.myapplication_23.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.AdaptiveBoxLayout;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        AdaptiveBoxLayout adaptiveBoxLayout = (AdaptiveBoxLayout)findComponentById(ResourceTable.Id_adaptive_box_layout);

        findComponentById(ResourceTable.Id_add_rule_btn).setClickedListener((component-> {
            // 添加规则
            adaptiveBoxLayout.addAdaptiveRule(100, 2000, 3);
            // 更新布局
            adaptiveBoxLayout.postLayout();
        }));

        findComponentById(ResourceTable.Id_remove_rule_btn).setClickedListener((component-> {
            // 移除规则
            adaptiveBoxLayout.removeAdaptiveRule(100, 2000, 3);
            // 更新布局
            adaptiveBoxLayout.postLayout();
        }));
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
