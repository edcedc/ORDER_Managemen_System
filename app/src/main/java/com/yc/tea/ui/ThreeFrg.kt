package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.AddProductAdapter
import com.yc.tea.adapter.CommodityListAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.ThreeContract
import com.yc.tea.mvp.presenter.ThreePresenter
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_three.recyclerView
import kotlinx.android.synthetic.main.f_three.refreshLayout

class ThreeFrg : BaseFragment(), ThreeContract.View{

    val mPresenter by lazy { ThreePresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { CommodityListAdapter(it,this, listBean) } }

    private var isRefresh = false

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
        UIHelper.startCommodityDescAct()
    }

    override fun getLayoutId(): Int = R.layout.f_three

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitleCenter( getString(R.string.commodity_list), getString(R.string.create_commodity))
        mPresenter.init(this)

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
                mPresenter.onRequest(pagerNumber)
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

}