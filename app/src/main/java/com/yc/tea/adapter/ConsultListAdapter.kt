package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper

/**
 * @auther ${Nike}
 * @date 2023/5/23
 * @time 11:09.
 */
class ConsultListAdapter(act: Context, root: BaseFragment, listBean: List<DataBean>) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_consult_list, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]
        viewHolder.setText(R.id.tv_order_num, "S000" + position)
        viewHolder.setText(R.id.tv_supplier, "123 Company")
        viewHolder.setText(R.id.tv_user, "S0002 - 456 Company")
        viewHolder.setText(R.id.tv_purchase, "15,500,000")
        viewHolder.setText(R.id.tv_profit, "2023-07-15")



        viewHolder.setOnItemClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                UIHelper.startOrderDescAct()
            }
        })
    }

}