package com.example.myapplication_08;

import com.example.myapplication_08.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.media.image.Image;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {

        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
