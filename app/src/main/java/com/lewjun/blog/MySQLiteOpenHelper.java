package com.lewjun.blog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * A helper class to manage database creation and version management.
 * Created by LewJun on 2017/12/28.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySQLiteOpenHelper";
    private static final String CREATE_BLOG_SQL = "create table Blog (\n" +
            "    id integer primary key autoincrement,\n" +
            "    title text,\n" +
            "    description text,\n" +
            "    content text ,\n" +
            "    pubTime time,\n" +
            "    readTimes integer,\n" +
            "    useFlag integer,\n" +
            "    createTime time,\n" +
            "    updateTime time\n" +
            ")";
    private static final String ALTER_BLOG_SQL = "alter table Blog add rate integer";
    private Context context;

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BLOG_SQL);
        Toast.makeText(context, "Create db successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 自从第一次创建数据库之后，今后的都是升级数据库
        db.execSQL(ALTER_BLOG_SQL);
        Toast.makeText(context, "Upgrade db successful", Toast.LENGTH_SHORT).show();
    }
}
