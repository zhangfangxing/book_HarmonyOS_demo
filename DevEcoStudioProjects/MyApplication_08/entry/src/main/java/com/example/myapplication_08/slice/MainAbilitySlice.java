package com.example.myapplication_08.slice;


import com.example.myapplication_08.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.TabList;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice {

    Text tabContent;
    TabList tabList;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initComponent();
        addTabSelectedListener();
    }

    private void initComponent() {
        tabContent = (Text) findComponentById(ResourceTable.Id_tab_content);
        tabContent.setTextSize(100);
        tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        initTab();
    }

    private void initTab() {
        if (tabList.getTabCount() == 0) {
            tabList.addTab(createTab("微信"));
            tabList.addTab(createTab("通讯录"));
            tabList.addTab(createTab("发现"));
            tabList.addTab(createTab("我"));
            tabList.setFixedMode(true);
            tabList.getTabAt(0).select();
            tabContent.setText("进入" + tabList.getTabAt(0).getText() + "页面");
        }
    }

    private TabList.Tab createTab(String text) {
        TabList.Tab tab = tabList.new Tab(this);
        tab.setText(text);
        tab.setMinWidth(64);
        tab.setPadding(12, 0, 12, 0);
        return tab;
    }

    private void addTabSelectedListener() {
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                tabContent.setText("进入" + tab.getText() + "页面");
            }

            @Override
            public void onUnselected(TabList.Tab tab) {
            }

            @Override
            public void onReselected(TabList.Tab tab) {
            }
        });
    }
}