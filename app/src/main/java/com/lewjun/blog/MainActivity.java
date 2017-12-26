package com.lewjun.blog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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
        btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(this);

        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);

        imgbtn_clear = findViewById(R.id.imgbtn_clear);
        imgbtn_clear.setOnClickListener(this);

        listview_blog = findViewById(R.id.listview_blog);
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
