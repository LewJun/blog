package com.lewjun.blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Blog适配器
 * Created by LewJun on 2017/12/27.
 */
public class BlogAdapter extends AbstractBaseAdapter<BlogEntity> {

    public BlogAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BlogEntity blogEntity = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.listitem_blog, parent, false);
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
