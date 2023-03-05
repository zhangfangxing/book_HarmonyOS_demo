package com.example.myapplication_24.slice;

import com.example.myapplication_24.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button1 = (Button)findComponentById(ResourceTable.Id_button1);
        button1.setClickedListener(component -> {
            TextField textField = (TextField)findComponentById(ResourceTable.Id_text3);
            String name = textField.getText();

            RadioButton radioButton = (RadioButton)findComponentById(ResourceTable.Id_rb_1);
            boolean checked = radioButton.isChecked();

            DatePicker datePicker = (DatePicker)findComponentById(ResourceTable.Id_date_pick);
            int getYear = datePicker.getYear();

            String user = new User(name, String. valueOf(2021-getYear), checked ? "男" : "女").toString();

            ToastDialog toastDialog = new ToastDialog(getContext());
            toastDialog.setText(user);
            toastDialog.setAlignment(LayoutAlignment.CENTER);
            toastDialog.show();
        });
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
