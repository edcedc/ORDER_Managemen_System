package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DividerItemDecoration
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.entity.LocalMedia
import com.yc.tea.R
import com.yc.tea.adapter.ConsultListAdapter
import com.yc.tea.adapter.OrderRecordListAdapter
import com.yc.tea.adapter.PicturesAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.CommodityDescContract
import com.yc.tea.mvp.presenter.CommodityDescPresenter
import com.yc.tea.utils.PictureSelectorTool
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_commodity_desc.gv_pictures
import kotlinx.android.synthetic.main.f_commodity_desc.recyclerView
import kotlinx.android.synthetic.main.f_commodity_desc.refreshLayout
import kotlinx.android.synthetic.main.f_commodity_desc.ry_consult
import kotlinx.android.synthetic.main.f_commodity_desc.tv_add_consulting
import kotlinx.android.synthetic.main.f_commodity_desc.tv_commodity_category
import kotlinx.android.synthetic.main.f_commodity_desc.tv_prize_name
import kotlinx.android.synthetic.main.f_commodity_desc.tv_product_name
import kotlinx.android.synthetic.main.f_commodity_desc.tv_remark
import kotlinx.android.synthetic.main.f_commodity_desc.tv_selling_price
import kotlinx.android.synthetic.main.f_commodity_desc.tv_unit_measurement

/**
 *  商品详情
 */
class CommodityDescFrg  : BaseFragment(), CommodityDescContract.View, OnClickListener{

    val mPresenter by lazy { CommodityDescPresenter() }

    val consultdListBean = ArrayList<DataBean>()
    val consultdAdapter by lazy { activity?.let { ConsultListAdapter(it,this, consultdListBean) } }

    val picturesListBean = ArrayList<DataBean>()
    val picturesAdapter by lazy { activity?.let { PicturesAdapter(it,consultdListBean) } }
    var localMedia = ArrayList<LocalMedia>()

    val listBean = ArrayList<DataBean>()
    val adapter by lazy { activity?.let { OrderRecordListAdapter(it,this, listBean) } }

    override fun getLayoutId(): Int = R.layout.f_commodity_desc

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.prize_desc))
        mPresenter.init(this)
        tv_add_consulting.setOnClickListener(this)

        tv_prize_name.text = "FE/00001"
        tv_product_name.text = "SAMSUNG S23 ULTRA"
        tv_commodity_category.text = "火龙果"
        tv_unit_measurement.text = "吨"
        tv_selling_price.text = "16,800,000"
        tv_remark.text = "无"

        setRecyclerViewType(recyclerView = ry_consult)
        ry_consult.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        ry_consult.adapter = consultdAdapter
        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter

        gv_pictures.adapter = picturesAdapter
        gv_pictures.setOnItemClickListener { adapterView, view, i, l ->
            activity?.let { PictureSelectorTool.PictureMediaType(it, localMedia, i) }
        }

//        refreshLayout.autoRefresh()//第一次进入触发自动刷新，演示效果

        mPresenter.onRequest(pagerNumber)
        /*refreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                pagerNumber = 1
                mPresenter.onRequest(pagerNumber)
            }
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                pagerNumber += 1
                mPresenter.onRequest(pagerNumber)
            }
        })*/
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

        consultdListBean.addAll(list)
        consultdAdapter?.notifyDataSetChanged()

        localMedia.clear()
        for (i in 0..8) {
            val bean = LocalMedia()
            bean.pictureType = PictureConfig.IMAGE
            bean.path = "https://img2.baidu.com/it/u=535987199,1308008521&fm=253&fmt=auto&app=120&f=JPEG?w=720&h=720"
            localMedia.add(bean)
        }

        picturesListBean.addAll(list)
        picturesAdapter?.notifyDataSetChanged()

        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_add_consulting ->{
                UIHelper.startAddSupplierFrg(this)
            }
        }
    }

}