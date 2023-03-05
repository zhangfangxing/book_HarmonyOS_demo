package com.example.myapplication_09.provider;

import com.example.myapplication_09.ResourceTable;
import ohos.agp.components.*;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;
import ohos.app.Context;

import java.util.List;

public class MyPageProvider extends PageSliderProvider {
    //数据实体类
    public static class DataItem{
        String mText;
        public DataItem(String txt) {
            mText = txt;
        }
    }
    // 数据源，每个页面对应list中的一项
    private List<DataItem> list;//01
    private Context mContext; //02

    public MyPageProvider(List<DataItem> list, Context context) {
        this.list = list;
        this.mContext = context;
    }
    @Override
    public int getCount() {//03
        return list.size();
    }
    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        final DataItem data = list.get(i);//04
        Text label = new Text(null);
        label.setTextAlignment(TextAlignment.CENTER);//05
        label.setLayoutConfig(
                new StackLayout.LayoutConfig(
                        ComponentContainer.LayoutConfig.MATCH_PARENT,
                        ComponentContainer.LayoutConfig.MATCH_PARENT
                ));//06
        label.setText(data.mText);//07
        label.setTextColor(Color.BLACK);//08
        label.setTextSize(50);//09
        label.setMarginsLeftAndRight(24, 24);//10
        label.setMarginsTopAndBottom(24, 24);//11
        ShapeElement element = new ShapeElement(mContext, ResourceTable.Graphic_background_page);//12
        label.setBackground(element);//13
        componentContainer.addComponent(label);//14
        return label;
    }
    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((Component) o);//15
    }
    @Override
    public boolean isPageMatchToObject(Component component, Object o) {//16
        return true;
    }
}