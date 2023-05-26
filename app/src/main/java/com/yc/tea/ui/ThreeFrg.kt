package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ListView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import com.blankj.utilcode.util.LogUtils
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.yc.tea.R
import com.yc.tea.adapter.CommodityListAdapter
import com.yc.tea.adapter.PopupListAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.ThreeContract
import com.yc.tea.mvp.presenter.ThreePresenter
import com.yc.tea.utils.AnimationUtil
import com.yc.tea.weight.LinearDividerItemDecoration
import com.zyyoona7.popup.EasyPopup
import com.zyyoona7.popup.XGravity
import com.zyyoona7.popup.YGravity
import kotlinx.android.synthetic.main.f_three.cl_layout
import kotlinx.android.synthetic.main.f_three.recyclerView
import kotlinx.android.synthetic.main.f_three.refreshLayout
import kotlinx.android.synthetic.main.include_search.bt_move
import kotlinx.android.synthetic.main.include_search.tv_choose


class ThreeFrg : BaseFragment(), ThreeContract.View, OnClickListener{

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
        tv_choose.setOnClickListener(this)
        initPopupSearch()

        bt_move.setOnClickListener(this)

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

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_choose ->{
                //筛选点击弹窗
                setSearch(view!!.findViewById(R.id.tv_choose))
            }
            R.id.bt_move ->{
                if (cl_layout.isVisible){
                    AnimationUtil.fadeOut(cl_layout);
                }else{
                    AnimationUtil.fadeIn(cl_layout);
                }
            }
        }
    }

    private fun setSearch(view: View) {
        EasyPopup.create()
            .setContentView(activity, R.layout.p_string_list)
            .setAnimationStyle(R.style.TopPopAnim)
            .setOnViewListener { view, basePopup ->

                val listBean = ArrayList<DataBean>();
                val str = arrayOf("全部", "商品编号", "商品名称")
                for (i in str.indices) {
                    val bean = DataBean()
                    bean.name = str[i]
                    bean.position = i
                    listBean.add(bean)
                }

                val adapter = PopupListAdapter(activity, listBean)
                val listView = view.findViewById<ListView>(R.id.listview)
                listView.adapter = adapter;
                adapter.notifyDataSetChanged()
                listView.setOnItemClickListener { adapterView, view, i, l ->
                    val bean = listBean[i]
                    tv_choose.text = bean.name
                    basePopup?.dismiss()
                }
            }
            .setFocusAndOutsideEnable(true)
            .setWidth(view.width)
            .apply()
            .showAtAnchorView(view, YGravity.BELOW, XGravity.CENTER);
    }


    var mEpSearch: EasyPopup? = null

    private fun initPopupSearch() {
        mEpSearch = EasyPopup.create()
            .setContentView(activity, R.layout.p_string_list)
            .setAnimationStyle(R.style.TopPopAnim)
            .setOnViewListener { view, basePopup ->

                val listBean = ArrayList<DataBean>();
                val str = arrayOf("全部", "商品编号", "商品名称")
                for (i in str.indices) {
                    val bean = DataBean()
                    bean.name = str[i]
                    bean.position = i
                    listBean.add(bean)
                }

                val adapter = PopupListAdapter(activity, listBean)
                val listView = view.findViewById<ListView>(R.id.listview)
                listView.adapter = adapter;
                adapter.notifyDataSetChanged()
                listView.setOnItemClickListener { adapterView, view, i, l ->
                    val bean = listBean[i]
                    tv_choose.text = bean.name
//                    mEpSearch.hideSoftInput() .dismiss();
                    mEpSearch?.dismiss()
                }
            }
            .setFocusAndOutsideEnable(true)
            .apply()
    }

}