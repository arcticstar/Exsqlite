package com.auxgroup.exsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.auxgroup.exsqlite.dao.PersonDao;
import com.auxgroup.exsqlite.db.PersonSqliteDbHelper;
import com.auxgroup.exsqlite.entities.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //数据库什么时候创建
        PersonSqliteDbHelper mdbHelper = new PersonSqliteDbHelper(this);
        //第一次连接数据库时创建数据库文件，onCreate被调用
        mdbHelper.getReadableDatabase();
        testInsert();
        testUpdate();
        testQueryAll();
        testQueryItem();
        testDelete();

    }

    public void testInsert() {
        PersonDao dao = new PersonDao(this);
        dao.insert(new Person(0, "wangwu2", 88));
    }

    public void testDelete() {
        PersonDao dao = new PersonDao(this);
        dao.delete(1);

    }

    public void testUpdate() {
        PersonDao dao = new PersonDao(this);
        dao.update(1, "凤姐");
    }

    public void testQueryAll() {
        PersonDao dao = new PersonDao(this);
        List<Person> personList = dao.queryAll();
        for (Person person : personList) {
            Log.i(TAG, person.toString());
        }
    }

    public void testQueryItem() {
        PersonDao dao = new PersonDao(this);
        Person person = dao.queryItem(1);

        Log.i(TAG, person.toString());
    }
}
