package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper

class ManagementAdapter(
    act: Context,
    root: BaseFragment,
    listBean: List<DataBean>
) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    val root = root

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_mangement, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]
        viewHolder.setText(R.id.tv_product_num, "CGH00" + position)
        viewHolder.setText(R.id.tv_prize_name, "XYZ Trading Company")
        viewHolder.setText(R.id.tv_commodity_category, "買家 + 賣家")
        viewHolder.setText(R.id.tv_supplier, "FE - 家具/電器")
        viewHolder.setText(R.id.tv_purchase_price, "NIKA")
        viewHolder.setText(R.id.tv_selling_price, "+84-893497748")
        viewHolder.setText(R.id.tv_unit_measurement, "leo@xyz.com")

        viewHolder.itemView.setOnClickListener {
            UIHelper.startManagementDescFrg(root)
        }
    }

}