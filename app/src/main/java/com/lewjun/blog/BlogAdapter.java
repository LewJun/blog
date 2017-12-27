package com.lewjun.blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Blog适配器
 * Created by LewJun on 2017/12/27.
 */
public class BlogAdapter extends ArrayAdapter<BlogEntity> {

    private int itemlistBlogRes = 0;

    public BlogAdapter(@NonNull Context context, int resource, @NonNull List<BlogEntity> objects) {
        super(context, resource, objects);
        itemlistBlogRes = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BlogEntity blogEntity = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(itemlistBlogRes, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_title = view.findViewById(R.id.tv_title);
            viewHolder.tv_pubtime = view.findViewById(R.id.tv_pubtime);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd", Locale.CHINA);
        viewHolder.tv_pubtime.setText(sdf.format(new Date(blogEntity.getPubTime())));
        viewHolder.tv_title.setText(blogEntity.getTitle());

        return view;
    }

    class ViewHolder {
        TextView tv_pubtime;
        TextView tv_title;
    }
}
