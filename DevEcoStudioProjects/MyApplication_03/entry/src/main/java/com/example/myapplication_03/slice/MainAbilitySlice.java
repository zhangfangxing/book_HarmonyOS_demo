package com.example.myapplication_03.slice;

import com.example.myapplication_03.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button = (Button)findComponentById(ResourceTable.Id_button);
        button.setClickedListener(component -> {
            Intent intent1 = new Intent();
            // 指定待启动FA的bundleName和abilityName
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("com.example.myapplication_03")
                    .withAbilityName("SecondAbility")
                    .build();
            intent1.setOperation(operation);
            startAbility(intent1); // 通过AbilitySlice的startAbility接口实现启动另一个页面
        });
    }
}
