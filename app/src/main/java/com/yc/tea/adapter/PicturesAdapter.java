package com.yc.tea.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luck.picture.lib.entity.LocalMedia;
import com.yc.tea.R;
import com.yc.tea.base.BaseListViewAdapter;
import com.yc.tea.bean.DataBean;
import com.yc.tea.weight.GlideLoadingUtils;

import java.util.ArrayList;
import java.util.List;

public class PicturesAdapter extends BaseListViewAdapter<DataBean> {

    public PicturesAdapter(Context act, List<DataBean> listBean) {
        super(act, listBean);
    }

    @Override
    protected View getCreateVieww(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = convertView.inflate(act, R.layout.i_image, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GlideLoadingUtils.load(act, "https://img2.baidu.com/it/u=535987199,1308008521&fm=253&fmt=auto&app=120&f=JPEG?w=720&h=720", viewHolder.iv_image);


        ArrayList<LocalMedia> localMedia = new ArrayList<>();

        return convertView;
    }

    class ViewHolder{

        ImageView iv_image;
        ViewHolder(View view) {
            iv_image = view.findViewById(R.id.iv_image);
        }
    }

}
