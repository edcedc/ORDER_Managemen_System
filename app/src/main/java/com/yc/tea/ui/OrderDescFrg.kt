package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.yc.tea.ORDER_DESC
import com.yc.tea.R
import com.yc.tea.adapter.CreateOrderAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.OrderDescContract
import com.yc.tea.mvp.presenter.OrderDescPresenter
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_one.refreshLayout
import kotlinx.android.synthetic.main.f_order_desc.et_address
import kotlinx.android.synthetic.main.f_order_desc.et_enter
import kotlinx.android.synthetic.main.f_order_desc.et_phone
import kotlinx.android.synthetic.main.f_order_desc.recyclerView
import kotlinx.android.synthetic.main.f_order_desc.tv_choose
import kotlinx.android.synthetic.main.f_order_desc.tv_harvest_date1
import kotlinx.android.synthetic.main.f_order_desc.tv_remark
import kotlinx.android.synthetic.main.f_order_desc.tv_state
import kotlinx.android.synthetic.main.f_order_desc.tv_supplier
import kotlinx.android.synthetic.main.f_order_desc.tv_supplier_address
import kotlinx.android.synthetic.main.f_order_desc.tv_supplier_phone

/**
 *  订单详情
 */
class OrderDescFrg: BaseFragment(), OrderDescContract.View{

    val mPresenter by lazy { OrderDescPresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { CreateOrderAdapter(it,this, listBean, ORDER_DESC) } }

    override fun getLayoutId(): Int = R.layout.f_order_desc

    override fun initParms(bundle: Bundle) {
        //Gson().fromJson(bundle.getString("bean"), DataBean::class.java)
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.order_desc))
        mPresenter.init(this)

        et_enter.text = "023/0002"
        tv_state.text = "新建"
        tv_state.setTextColor(ContextCompat.getColor(activity!!,R.color.blue_00acc1))
        tv_harvest_date1.text = "2023/06/15"
        tv_choose.text = "C0001 - ABC Company"
        et_phone.text = "+84-888954174"
        et_address.text = "10/F, ABC Building, ABC District"
        tv_supplier.text = "S0002 - 456 Company"
        tv_supplier_phone.text = "+84-888645603"
        tv_supplier_address.text = "0/F, 456 Building, 456 District"
        tv_remark.text = "无"

        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter
        mPresenter.onRequest(1)
    }

    override fun setRefreshLayoutMode(totalRow: Int) {
        super.setRefreshLayoutMode(listBean.size, totalRow, refreshLayout)
    }

    override fun setData(objects: Object) {
        val list = objects as List<DataBean>
        if (pagerNumber == 1){
            listBean.clear()
        }
        listBean.addAll(list)
        adapter?.notifyDataSetChanged()
//        refreshLayout.finishRefresh()
//        refreshLayout.finishLoadMore()
    }

}