package com.example.myapplication_06.entity;

import ohos.data.orm.OrmDatabase;
import ohos.data.orm.annotation.Database;

@Database(entities = {Student.class},version = 1)
public abstract class School extends OrmDatabase {

}
