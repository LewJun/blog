package com.lewjun.blog;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private ImageButton imgbtn_clear;
    private EditText edittext_search;
    private Button btn_new;
    private Button btn_menu;

    private ListView listview_blog;

    private BlogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        edittext_search = findViewById(R.id.edittext_search);
        edittext_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(this);

        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);

        imgbtn_clear = findViewById(R.id.imgbtn_clear);
        imgbtn_clear.setOnClickListener(this);

        listview_blog = findViewById(R.id.listview_blog);

        adapter = new BlogAdapter(this);
        listview_blog.setAdapter(adapter);
        // 列表项单击事件
        listview_blog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                BlogEntity blogEntity = adapter.getItem(pos);
                new AlertDialog.Builder(MainActivity.this).setTitle(blogEntity.getTitle())
                        .setMessage(blogEntity.getContent())
                        .create().show();
            }
        });
        // 列表项长按事件
        listview_blog.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                return false;
            }
        });
    }

    /**
     * 初始化bloglist
     */
    @SuppressLint("StaticFieldLeak")
    private void initBlogList() {
        List<BlogEntity> bloglist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            BlogEntity blogEntity = new BlogEntity();
            blogEntity.setId(i + 1);
            blogEntity.setTitle("title " + i);
            blogEntity.setDescription("description " + i);
            blogEntity.setContent("content " + i);
            blogEntity.setPubTime(System.currentTimeMillis());
            blogEntity.setReadTimes((i + 1) * 2);

            bloglist.add(blogEntity);
        }

        new AsyncTask<Void, Void, ResponseInfo<List<BlogEntity>>>() {
            @Override
            protected ResponseInfo<List<BlogEntity>> doInBackground(Void... voids) {
                Type type = new TypeToken<ResponseInfo<List<BlogEntity>>>() {
                }.getType();
                Map<String, String> paramsMap = new HashMap<>();
                paramsMap.put("reqmethod", "list");
                try {
                    return HttpUtil.post(paramsMap, type);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(ResponseInfo<List<BlogEntity>> listResponseInfo) {
                super.onPostExecute(listResponseInfo);
                if(listResponseInfo.isSuccess()) {
                    List<BlogEntity> blogEntityList = listResponseInfo.getData();
                    for (BlogEntity blogEntity : blogEntityList) {
                        Log.d(TAG, "onPostExecute: " + blogEntity);
                    }
                }
            }
        }.execute();
        adapter.setItemList(bloglist);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_clear:
                Toast.makeText(this, "imgbtn_clear", Toast.LENGTH_SHORT).show();
                edittext_search.setText(null);
                break;
            case R.id.btn_new:
                Toast.makeText(this, "btn_new", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_menu:
                Toast.makeText(this, "btn_menu", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
