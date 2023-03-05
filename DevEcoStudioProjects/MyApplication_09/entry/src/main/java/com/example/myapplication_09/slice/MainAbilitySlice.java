package com.example.myapplication_09.slice;

import com.example.myapplication_09.provider.MyPageProvider;
import com.example.myapplication_09.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.PageSlider;

import java.util.ArrayList;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initPageSlider();
    }

    private void initPageSlider() {
        PageSlider pageSlider = (PageSlider) findComponentById(ResourceTable.Id_page_slider);
        pageSlider.setProvider(new MyPageProvider(getData(), this));
    }
    private ArrayList<MyPageProvider.DataItem> getData() {
        ArrayList<MyPageProvider.DataItem> dataItems = new ArrayList<>();
        dataItems.add(new MyPageProvider.DataItem("Page A"));
        dataItems.add(new MyPageProvider.DataItem("Page B"));
        dataItems.add(new MyPageProvider.DataItem("Page C"));
        dataItems.add(new MyPageProvider.DataItem("Page D"));
        return dataItems;
    }
}
