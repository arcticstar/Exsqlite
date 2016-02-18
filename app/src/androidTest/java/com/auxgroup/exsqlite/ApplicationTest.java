package com.auxgroup.exsqlite;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.auxgroup.exsqlite.db.PersonSqliteDbHelper;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        //数据库什么时候创建测试
//        PersonSqliteDbHelper mdbHelper=new PersonSqliteDbHelper(getContext());
//        mdbHelper.getReadableDatabase();
    }
}