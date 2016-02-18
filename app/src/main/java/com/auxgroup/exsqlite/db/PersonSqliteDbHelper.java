package com.auxgroup.exsqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016-2-18.
 */
public class PersonSqliteDbHelper extends SQLiteOpenHelper {
    /**
     * 数据库的构造方法
     * name 数据库名称
     * factory 数据库工厂
     * version 数据库版本不可以小于1*/
    public PersonSqliteDbHelper(Context context) {
        super(context, "itheima28.db", null, 1);
    }
/**
 * 数据库第一次创建时回调此方法
 * 初始化一些表*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        //操作数据库
        String sql = "create table person(_id integer primary key, name varchar(20),age integer);";
        db.execSQL(sql); //创建person表

    }
/**
 * 数据库版本号更新时调用此方法，
 * 更新数据库的内容（添加表，删除表、更改表）*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
