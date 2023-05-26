package com.yc.tea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.yc.tea.base.BaseRecyclerviewAdapter
import com.yc.tea.R
import com.yc.tea.STATE_0
import com.yc.tea.STATE_1
import com.yc.tea.STATE_2
import com.yc.tea.base.BaseFragment
import com.yc.tea.base.ViewHolder
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper

/**
 * @auther ${Nike}
 * @date 2023/5/23
 * @time 11:09.
 */
class OrderListAdapter(act: Context, root: BaseFragment, listBean: List<DataBean>) : BaseRecyclerviewAdapter<DataBean>(act, listBean as ArrayList<DataBean>) {

    override fun onCreateViewHolde(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.i_order_list, parent, false))
    }

    override fun onBindViewHolde(viewHolder: ViewHolder, position: Int) {
        val bean = listBean[position]
        viewHolder.setText(R.id.tv_order_num, "023/0000" + position)
        viewHolder.setText(R.id.tv_user, "C0001 - ABC Company")
        viewHolder.setText(R.id.tv_supplier, "S0001 - 123 Company")
        viewHolder.setText(R.id.tv_purchase, "1,000,000,000")
        viewHolder.setText(R.id.tv_profit, "6.67%")
        viewHolder.setText(R.id.tv_estimated_data, "2023/05/23")
        viewHolder.setText(R.id.tv_actual_date, "2023/05/46")
        viewHolder.setText(R.id.tv_estimated_delivery_date, "2023/06/46")
        viewHolder.setText(R.id.tv_actual_delivery_date, "2023/06/88")

        when(position){
            STATE_0 ->{
                viewHolder.setText(R.id.tv_state, "新建")
                viewHolder.getView<AppCompatTextView>(R.id.tv_state).setTextColor(ContextCompat.getColor(act!!,R.color.red_FF5A60) )
            }
            STATE_1 ->{
                viewHolder.setText(R.id.tv_state, "已入库")
                viewHolder.getView<AppCompatTextView>(R.id.tv_state).setTextColor(ContextCompat.getColor(act!!,R.color.colorPrimaryDark) )
            }
            STATE_2 ->{
                viewHolder.setText(R.id.tv_state, "已出库")
                viewHolder.getView<AppCompatTextView>(R.id.tv_state).setTextColor(ContextCompat.getColor(act!!,R.color.blue_00acc1) )
            }
            else ->{

            }
        }

        viewHolder.setOnItemClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                UIHelper.startOrderDescAct()
            }
        })
    }

}