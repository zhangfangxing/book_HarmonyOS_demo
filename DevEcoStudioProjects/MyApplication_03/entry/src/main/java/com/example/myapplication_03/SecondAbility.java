package com.example.myapplication_03;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class SecondAbility extends Ability {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_second);
    }
}