package com.example.myapplication_02.slice;

import com.example.myapplication_02.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class MainAbilitySlice extends AbilitySlice {
    private static int count = 1;//设置要传递的值
    private static Text mainAbilitySliceText;//设置本页面需要展示的内容

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        //跳转到Layout_ability_main 的XML页面之中
        super.setUIContent(ResourceTable.Layout_ability_main);

        //通过findComponentById参数找到Layout_ability_main 的XML页面中的Id_text_main文本
        mainAbilitySliceText = (Text)findComponentById(ResourceTable.Id_text_main);
        //找到Id_text_main文本之后对其进行修改
        mainAbilitySliceText.setText("Main count"+count);
        //对找到Id_text_main文本之后对其进行添加响应按钮
        mainAbilitySliceText.setClickedListener(component -> {
            //创建入参
            Intent in = new Intent();
            //设置入参，将count传入到下一页面之中
            in.setParam("count",count);
            //presentForResult是内置函数，可直接使用
            //最后100002数值随意定义即可，是回调之后会返回的resultIntent
            presentForResult(new SecondAbilitySlice(),in,100002);
        });
    }


    @Override
    protected void onResult(int requestCode, Intent resultIntent) {
        super.onResult(requestCode, resultIntent);
        if (requestCode == 100002){//确定是由100002进行返回的
            //获取上个页面传入的count值
            count = resultIntent.getIntParam("count",-1);
            count++;
            //在本页面中展示出该count值
            mainAbilitySliceText.setText("Main count"+count);
        }
    }
}
