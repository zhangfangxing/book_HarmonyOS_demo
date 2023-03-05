package com.example.myapplication_06;

import com.example.myapplication_06.entity.School;
import com.example.myapplication_06.entity.Student;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.data.DatabaseHelper;
import ohos.data.dataability.DataAbilityUtils;
import ohos.data.orm.OrmContext;
import ohos.data.orm.OrmPredicates;
import ohos.data.resultset.ResultSet;
import ohos.data.rdb.ValuesBucket;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.net.Uri;

public class MyDataAbility extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");

    private OrmContext ormContext;//数据库的资源句柄

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.info(LABEL_LOG, "MyDataAbility onStart");
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ormContext = databaseHelper.getOrmContext("School","School.db", School.class);

    }
    @Override
    public int insert(Uri uri, ValuesBucket value) {
        HiLog.error(LABEL_LOG, "MyDataAbility insert");
        if (ormContext == null || (!uri.getDecodedPathList().get(1).equals("Student"))){
            HiLog.error(LABEL_LOG, uri.getDecodedPathList().get(1));
            HiLog.error(LABEL_LOG, "MyDataAbility insert ormContext != null && !uri Right");
            return -1;
        } else {
            HiLog.error(LABEL_LOG, "MyDataAbility insert ormContext == null && uri Right");
        }
        Student student = new Student();
        student.setAge(value.getString("age"));
        student.setSex(value.getBoolean("sex"));

        boolean insert = ormContext.insert(student);
        boolean flush = ormContext.flush();
        if (insert && flush){
            return student.getStudentId();
        } else {
            return -1;
        }
    }
    @Override
    public ResultSet query(Uri uri, String[] columns, DataAbilityPredicates predicates) {
        if (ormContext == null) {
            HiLog.error(LABEL_LOG, "failed to query, ormContext is null");
            return null;
        }

        // 查询数据库
        OrmPredicates ormPredicates = DataAbilityUtils.createOrmPredicates(predicates,Student.class);
        ResultSet resultSet = ormContext.query(ormPredicates, columns);
        if (resultSet == null) {
            HiLog.info(LABEL_LOG, "resultSet is null");
        }
        // 返回结果
        return resultSet;
    }
}