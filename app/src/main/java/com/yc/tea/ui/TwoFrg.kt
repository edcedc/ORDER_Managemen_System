package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.OrderListAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.TwoContract
import com.yc.tea.mvp.presenter.TwoPresenter
import com.yc.tea.utils.DatePickerUtils
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_two.bt_sure
import kotlinx.android.synthetic.main.f_two.recyclerView
import kotlinx.android.synthetic.main.f_two.refreshLayout
import kotlinx.android.synthetic.main.f_two.tv_choose
import kotlinx.android.synthetic.main.f_two.tv_harvest_date1
import kotlinx.android.synthetic.main.f_two.tv_harvest_date2
import kotlinx.android.synthetic.main.f_two.tv_shipping_date1
import kotlinx.android.synthetic.main.f_two.tv_shipping_date2
import kotlinx.android.synthetic.main.f_two.tv_state
import kotlinx.android.synthetic.main.f_two.tv_supplier

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/10/24
 * Time: 11:36
 */
class TwoFrg : BaseFragment(), TwoContract.View, View.OnClickListener{

    val mPresenter by lazy { TwoPresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { OrderListAdapter(it,this, listBean) } }

    private var isRefresh = false

    override fun getLayoutId(): Int = R.layout.f_two

    override fun initParms(bundle: Bundle) {

    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        if (!isRefresh){
//            refreshLayout.autoRefresh()
            mPresenter.onRequest(pagerNumber)
            isRefresh = true
        }
    }

    override fun setOnRightClickListener() {
        super.setOnRightClickListener()
        UIHelper.startCreateOrderAct()
    }

    override fun initView(rootView: View) {
        setTitleCenter( getString(R.string.order_list), getString(R.string.create_order))
        mPresenter.init(this)
        tv_choose.setOnClickListener(this)
        tv_supplier.setOnClickListener(this)
        tv_state.setOnClickListener(this)
        tv_harvest_date1.setOnClickListener(this)
        tv_harvest_date2.setOnClickListener(this)
        tv_shipping_date1.setOnClickListener(this)
        tv_shipping_date2.setOnClickListener(this)
        bt_sure.setOnClickListener(this)

        refreshLayout.setEnableLoadMore(false)
        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                pagerNumber = 1
                mPresenter.onRequest(pagerNumber)
            }
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                pagerNumber += 1
//                mPresenter.onRequest(pagerNumber)
            }
        })
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
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_choose ->{
                val list = ArrayList<DataBean>()
                for (i in 0..8) {
                    val bean = DataBean()
                    bean.name = "采购客户" + i
                    list.add(bean)
                }
                DatePickerUtils.onOptionPicker(activity, getString(R.string.purchasing_customers), list){
                        index, item ->
                    tv_choose.text = item
                }
            }
            R.id.tv_state ->{
                val list = ArrayList<DataBean>()
                for (i in 0..8) {
                    val bean = DataBean()
                    bean.name = "状态" + i
                    list.add(bean)
                }
                DatePickerUtils.onOptionPicker(activity, getString(R.string.purchasing_customers), list){
                        index, item ->
                    tv_state.text = item
                }
            }
            R.id.tv_supplier ->{
                val list = ArrayList<DataBean>()
                for (i in 0..8) {
                    val bean = DataBean()
                    bean.name = "供应商" + i
                    list.add(bean)
                }
                DatePickerUtils.onOptionPicker(activity, getString(R.string.purchasing_customers), list){
                        index, item ->
                    tv_supplier.text = item
                }
            }
            R.id.tv_harvest_date1 ->{
                DatePickerUtils.getYearMonthDayPicker(
                    activity, getString(R.string.harvest_date)
                ) { year, month, day ->
                    tv_harvest_date1.text = year + "-" + month + "-" + day
                }
            }
            R.id.tv_harvest_date2 ->{
                DatePickerUtils.getYearMonthDayPicker(
                    activity, getString(R.string.harvest_date)
                ) { year, month, day ->
                    tv_harvest_date2.text = year + "-" + month + "-" + day
                }
            }
            R.id.tv_shipping_date1 -> {
                DatePickerUtils.getYearMonthDayPicker(
                    activity, getString(R.string.shipping_date)
                ) { year, month, day ->
                    tv_shipping_date1.text = year + "-" + month + "-" + day
                }
            }
            R.id.tv_shipping_date2 ->{
                DatePickerUtils.getYearMonthDayPicker(
                    activity, getString(R.string.shipping_date)
                ) { year, month, day ->
                    tv_shipping_date2.text = year + "-" + month + "-" + day
                }
            }
            R.id.bt_sure ->{

            }
        }
    }

}