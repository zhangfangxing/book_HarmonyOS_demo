package com.example.myapplication_04.slice;

import com.example.myapplication_04.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button01 = (Button)findComponentById(ResourceTable.Id_button_01);
        button01.setClickedListener(component -> {
            Intent intent1 = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withBundleName("com.example.myapplication_04")
                    .withAbilityName("MyServiceAbility")
                    .build();
            intent1.setOperation(operation);
            startAbility(intent1);//01
        });

        Button button02 = (Button)findComponentById(ResourceTable.Id_button_02);
        button02.setClickedListener(component -> {
            Intent intent1 = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withBundleName("com.example.myapplication_04")
                    .withAbilityName("MyServiceAbility")
                    .build();
            intent1.setOperation(operation);
            stopAbility(intent1);//02
        });
    }
}
