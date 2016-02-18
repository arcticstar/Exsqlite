package com.auxgroup.exsqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.auxgroup.exsqlite.db.PersonSqliteDbHelper;
import com.auxgroup.exsqlite.entities.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-2-18.
 */
public class PersonDao {
    private PersonSqliteDbHelper mDbHelper;//数据库的帮助类对象

    public PersonDao(Context context) {
        mDbHelper = new PersonSqliteDbHelper(context);
    }

    /**
     * 添加到person表一条数据
     */
    public void insert(Person person) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {   //如果数据库打开，执行添加的操作
            //执行添加到数据库的操作
            db.execSQL("insert into person(name,age) values(?,?);", new Object[]{person.getName(), person.getAge()});

            db.close();//数据库关闭
        }
    }

    public void delete(int id) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.execSQL("delete from person where _id=?;", new Integer[]{id});
            db.close();
        }
    }

    public void update(int id, String name) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.execSQL("update person set name=? where _id=?;", new Object[]{name, id});
            db.close();
        }
    }

    public List<Person> queryAll() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {

            Cursor cursor = db.rawQuery("select _id,name,age from person;", null);
            if (cursor != null && cursor.getCount() > 0) {
                List<Person> personList = new ArrayList<>();
                int id, age;
                String name;
                while (cursor.moveToNext()) {
                    id = cursor.getInt(0);//取第0列的数据id；
                    name = cursor.getString(1);
                    age = cursor.getInt(2);
                    personList.add(new Person(id, name, age));
                }
                db.close();
                return personList;

            }
            db.close();
        }

        return null;
    }

    public Person queryItem(int id) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select _id,name,age from person where _id=?;", new String[]{id + ""});
            if (cursor != null && cursor.moveToFirst()) {
                int id1 = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                db.close();
                return new Person(id1, name, age);

            }

            db.close();
        }
        return null;
    }
}
