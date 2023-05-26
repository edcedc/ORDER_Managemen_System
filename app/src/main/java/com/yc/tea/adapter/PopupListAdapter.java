package com.yc.tea.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatTextView;

import com.yc.tea.R;
import com.yc.tea.base.BaseListViewAdapter;
import com.yc.tea.bean.DataBean;

import java.util.List;

public class PopupListAdapter extends BaseListViewAdapter<DataBean> {

    public PopupListAdapter(Context act, List<DataBean> listBean) {
        super(act, listBean);
    }

    @Override
    protected View getCreateVieww(int position, View convertView, ViewGroup parent) {
        DataBean bean = listBean.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = convertView.inflate(act, R.layout.i_p_string, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_text.setText(bean.getName());


        return convertView;
    }

    class ViewHolder{

        AppCompatTextView tv_text;
        ViewHolder(View view) {
            tv_text = view.findViewById(R.id.tv_text);
        }
    }

}
