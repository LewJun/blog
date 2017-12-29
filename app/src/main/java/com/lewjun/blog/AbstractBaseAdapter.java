package com.lewjun.blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器基类
 * Created by LewJun on 2017/12/29.
 */
public abstract class AbstractBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected LayoutInflater layoutInflater;
    protected List<T> itemList = new ArrayList<>();

    public AbstractBaseAdapter(@NonNull Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addItem(@NonNull T item) {
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(@NonNull List<T> itemList) {
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void removeItem(@NonNull T item) {
        this.itemList.remove(item);
        notifyDataSetChanged();
    }

    public void removeItems(@NonNull List<T> itemList) {
        this.itemList.removeAll(itemList);
        notifyDataSetChanged();
    }

    public void clear() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    public void setItemList(@NonNull List<T> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public List<T> getItemList() {
        return itemList;
    }

    @Override
    public boolean isEmpty() {
        return itemList == null || itemList.isEmpty();
    }

    @Override
    public int getCount() {
        return isEmpty() ? 0 : itemList.size();
    }

    @Override
    public T getItem(int position) {
        return isEmpty() ? null : itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    abstract public View getView(int position, View convertView, ViewGroup parent);
}
