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
class CommodityListAdapter(act: Context, root: BaseFragment, listBean: List<DataBean>) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_commodity_list, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]
        viewHolder.setText(R.id.tv_product_num, "FE/0000" + position)
        viewHolder.setText(R.id.tv_prize_name, "火龍果")
        viewHolder.setText(R.id.tv_commodity_category, "FU - 水果")
        viewHolder.setText(R.id.tv_supplier, "123 Company")
        viewHolder.setText(R.id.tv_unit_measurement, "噸")
        viewHolder.setText(R.id.tv_purchase_price, "10,000,000.00")
        viewHolder.setText(R.id.tv_selling_price, "2023-3-09 14:14:21")

        viewHolder.setOnItemClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                UIHelper.startCommodityDescAct()
            }
        })
    }

}