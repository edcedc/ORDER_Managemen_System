package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean

class AddProductAdapter (act: Context, root: BaseFragment, listBean: List<DataBean>) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_add_product, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]

        viewHolder.setText(R.id.tv_product_num, "FE/000" + position)
        viewHolder.setText(R.id.tv_commodity_category, "水果")
        viewHolder.setText(R.id.tv_prize_name, "火龍果")
        viewHolder.setText(R.id.tv_supplier, "123 Company")
        viewHolder.setText(R.id.tv_unit_measurement, "吨")
        viewHolder.setText(R.id.tv_purchase_price, "10,000,000")
        viewHolder.setText(R.id.tv_selling_price, "20,000,000")
        viewHolder.setText(R.id.tv_profit, "69%")


        viewHolder.getView<AppCompatTextView>(R.id.tv_purchase_quantity).setOnClickListener {

        }
    }

}