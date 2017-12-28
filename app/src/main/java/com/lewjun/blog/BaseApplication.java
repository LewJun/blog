package com.lewjun.blog;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * 自定义Application基类
 * Created by LewJun on 2017/12/28.
 */
public class BaseApplication extends Application {
    private SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        MySQLiteOpenHelper sqLiteOpenHelper = new MySQLiteOpenHelper(this, "mydb", null, 2);
        db = sqLiteOpenHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
