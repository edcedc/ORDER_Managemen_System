package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.yc.tea.ORDER_DESC
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean


class CreateOrderAdapter(
    act: Context,
    root: BaseFragment,
    listBean: List<DataBean>,
    ORDER_TYPE: Int
) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    val ORDER_TYPE = ORDER_TYPE

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_craete_order, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]

        viewHolder.setText(R.id.tv_product_num, "P/0000" + position)
        viewHolder.setText(R.id.tv_prize_name, "龍果" )
        viewHolder.setText(R.id.tv_supplier, "S0001 - 123 Company" )
        viewHolder.setText(R.id.tv_unit_measurement, "噸" )
        viewHolder.setText(R.id.tv_purchase_price, "300,000,000" )
        viewHolder.setText(R.id.tv_selling_price, "500,000,000" )
        viewHolder.setText(R.id.tv_purchase_quantity, "21" )
        viewHolder.setText(R.id.tv_cost, "2312312" )
        viewHolder.setText(R.id.tv_sellin_price, "89789" )
        viewHolder.setText(R.id.tv_profit, "12" + "%")

        viewHolder.getView<TextView>(R.id.bt_del).visibility = (if (ORDER_TYPE === ORDER_DESC) View.GONE else View.VISIBLE)

        /*viewHolder.setOnItemClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                showToast("pos" + position)
            }

        })*/
        viewHolder.getView<TextView>(R.id.bt_del).setOnClickListener {
            if (listener != null)listener?.onDel(position)
        }
    }

    private var listener: OnClickListener? = null

    interface OnClickListener {
        fun onDel(position: Int)
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

}