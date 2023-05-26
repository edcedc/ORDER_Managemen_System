package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.OrderProgressAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.OneContract
import com.yc.tea.mvp.presenter.OnePresenter
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_one.recyclerView
import kotlinx.android.synthetic.main.f_one.refreshLayout
import kotlinx.android.synthetic.main.f_one.tv_amount
import kotlinx.android.synthetic.main.f_one.tv_order
import kotlinx.android.synthetic.main.f_one.tv_purchase_cost
import kotlinx.android.synthetic.main.f_one.tv_tate

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/10/23
 * Time: 18:19
 */
class OneFrg: BaseFragment(), OneContract.View{

    val mPresenter by lazy { OnePresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { OrderProgressAdapter(it,this, listBean) } }

    override fun getLayoutId(): Int = R.layout.f_one

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitleCenter(getString(R.string.order_progress))
        mPresenter.init(this)
        /*val colorSpan = ForegroundColorSpan(Color.parseColor("#FF5A60"))
        val hText = SpannableString(getString(R.string.order_num))
        hText.setSpan(colorSpan, hText.length - 1, hText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        tv_order_num.setText(hText)*/
        refreshLayout.setEnableLoadMore(false)
        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter
//        refreshLayout.autoRefresh()//第一次进入触发自动刷新，演示效果
        mPresenter.onRequest(pagerNumber)
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
        tv_order.text = "454"
        tv_amount.text = "$" + 668564
        tv_purchase_cost.text = "$" + 8998121
        tv_tate.text = "$" + 564841
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
