package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.ManagementAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.SellerManagementContract
import com.yc.tea.mvp.presenter.SellerManagementPresenter
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_seller_management.recyclerView
import kotlinx.android.synthetic.main.f_seller_management.refreshLayout

/**
 *  买卖家管理
 */
class SellerManagementFrg : BaseFragment(), SellerManagementContract.View{

    val mPresenter by lazy { SellerManagementPresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { ManagementAdapter(it,this, listBean) } }

    override fun getLayoutId(): Int = R.layout.f_seller_management

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.buyer_management))
        mPresenter.init(this)
        refreshLayout.setEnableLoadMore(false)
        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter
//        refreshLayout.autoRefresh()
        mPresenter.onRequest(pagerNumber)
        refreshLayout.setEnableLoadMore(false)
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

}