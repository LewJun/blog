package com.lewjun.blog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtn_clear;
    private EditText edittext_search;
    private Button btn_new;
    private Button btn_menu;

    private ListView listview_blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        initBlogList();
        BlogAdapter adapter = new BlogAdapter(this, R.layout.listitem_blog, bloglist);
        listview_blog.setAdapter(adapter);
        // 列表项单击事件
        listview_blog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                BlogEntity blogEntity = bloglist.get(pos);
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

    private List<BlogEntity> bloglist = new ArrayList<>();

    /**
     * 初始化bloglist
     */
    private void initBlogList() {
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
