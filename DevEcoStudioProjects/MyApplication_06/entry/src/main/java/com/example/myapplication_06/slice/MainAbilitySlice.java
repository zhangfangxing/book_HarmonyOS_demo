package com.example.myapplication_06.slice;

import com.example.myapplication_06.ResourceTable;
import com.example.myapplication_06.entity.Student;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.DataAbilityHelper;
import ohos.aafwk.ability.DataAbilityRemoteException;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.data.rdb.ValuesBucket;
import ohos.data.resultset.ResultSet;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.net.Uri;

import java.util.ArrayList;

public class MainAbilitySlice extends AbilitySlice {
    public String MyDataAbilityURI = "dataability:///com.example.myapplication_06.MyDataAbility";
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "MainAbilitySlice");

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button01 = (Button)findComponentById(ResourceTable.Id_button_01);
        button01.setClickedListener(component -> {
            DataAbilityHelper helper = DataAbilityHelper.creator(this);//根据对应的URI访问Ability
            Uri uri = Uri.parse(MyDataAbilityURI+"/Student");
            ValuesBucket valuesBucket = new ValuesBucket();
            valuesBucket.putBoolean("sex",true);
            valuesBucket.putString("age","16");
            try {
                int insert = helper.insert(uri, valuesBucket);
                myShow("insert",String.valueOf(insert));
            } catch (DataAbilityRemoteException e) {
                HiLog.error(LABEL_LOG, e.toString());
                e.printStackTrace();
            }
        });

        Button button02 = (Button)findComponentById(ResourceTable.Id_button_02);
        button02.setClickedListener(component -> {
            DataAbilityHelper helper = DataAbilityHelper.creator(this);//根据对应的URI访问Ability
            Uri uri = Uri.parse(MyDataAbilityURI+"/Student");
            DataAbilityPredicates predicates = new DataAbilityPredicates();
            try {
                ResultSet query = helper.query(uri, new String[]{"studentId", "sex", "age"}, predicates);
                query.goToFirstRow();
                int rowCount = query.getRowCount();
                ArrayList<Student> students = new ArrayList<>();
                for(int i=0;i<rowCount;i++){
                    int studentId = query.getInt(query.getColumnIndexForName("studentId"));
                    String age = query.getString(query.getColumnIndexForName("age"));
                    String sex = query.getString(query.getColumnIndexForName("sex"));//TRUE == 1,FALSE == 0
                    students.add(new Student(studentId,age, sex.equals("1")));
                }
                query.close();
                myShow("query",String.valueOf(students));
            } catch (DataAbilityRemoteException e) {
                e.printStackTrace();
            }

        });
    }

    void myShow(String method,String message){
        ToastDialog toastDialog = new ToastDialog(this);
        toastDialog.setText("已经使用"+method+"():"+message);
        toastDialog.setAlignment(LayoutAlignment.CENTER);
        toastDialog.show();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
