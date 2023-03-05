package com.example.myapplication_02.slice;
import com.example.myapplication_02.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class SecondAbilitySlice extends AbilitySlice {

    private int count;
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_second);
        //获取上个页面传入的count
        //如果没有找到则设置为-1
        count = intent.getIntParam("count", -1);
        count++;
        Text text = (Text)findComponentById(ResourceTable.Id_text_second);
        text.setText("Second count"+count);
        text.setClickedListener(component -> {
            Intent in = new Intent();
            in.setParam("count",count);
            setResult(in);
            terminate();
        });
    }
}
