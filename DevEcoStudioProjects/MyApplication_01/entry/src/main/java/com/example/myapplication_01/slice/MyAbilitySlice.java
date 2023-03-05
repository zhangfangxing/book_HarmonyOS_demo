package com.example.myapplication_01.slice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.components.DependentLayout.LayoutConfig;

public class MyAbilitySlice extends AbilitySlice{
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        // 声明布局
        DependentLayout myLayout = new DependentLayout(this);

        // 设置布局宽高
        myLayout.setWidth(LayoutConfig.MATCH_PARENT);
        myLayout.setHeight(LayoutConfig.MATCH_PARENT);

        // 设置布局背景为白色
        ShapeElement background = new ShapeElement();
        background.setRgbColor(new RgbColor(255, 255, 255));
        myLayout.setBackground(background);

        // 创建一个文本
        Text text = new Text(this);
        text.setText("Hi 第二个页面");
        text.setWidth(LayoutConfig.MATCH_PARENT);
        text.setTextSize(100);
        text.setTextColor(Color.BLACK);

        // 设置文本的布局
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(LayoutConfig.MATCH_CONTENT, LayoutConfig.MATCH_CONTENT);
        textConfig.addRule(LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);
        myLayout.addComponent(text);
        super.setUIContent(myLayout);
    }
}
