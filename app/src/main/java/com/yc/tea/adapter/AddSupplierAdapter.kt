package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean

class AddSupplierAdapter (act: Context, root: BaseFragment, listBean: List<DataBean>) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {
    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_add_supplier, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]
        viewHolder.setText(R.id.tv_supplier_num, "S000" + position)
        viewHolder.setText(R.id.tv_supply_category, "123 Company")
        viewHolder.setText(R.id.tv_supplier_name, "Company")
    }

}