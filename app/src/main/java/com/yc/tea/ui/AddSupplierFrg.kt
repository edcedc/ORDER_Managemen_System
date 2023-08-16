package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.AddSupplierAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.AddSupplierContract
import com.yc.tea.mvp.presenter.AddSupplierPresenter
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_add_supplier.recyclerView
import kotlinx.android.synthetic.main.f_add_supplier.refreshLayout

/**
 *  添加供应商
 */
class AddSupplierFrg : BaseFragment(), AddSupplierContract.View {

    val mPresenter by lazy { AddSupplierPresenter() }
    val listBean = ArrayList<DataBean>()
    val adapter by lazy { activity?.let { AddSupplierAdapter(it, this, listBean) } }

    override fun getLayoutId(): Int = R.layout.f_add_supplier

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.add_supplier))
        mPresenter.init(this)

        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity,DividerItemDecoration.VERTICAL,2))
        recyclerView.adapter = adapter
        refreshLayout.autoRefresh()
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
        if (pagerNumber == 1) {
            listBean.clear()
        }
        listBean.addAll(list)
        adapter?.notifyDataSetChanged()
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }

}