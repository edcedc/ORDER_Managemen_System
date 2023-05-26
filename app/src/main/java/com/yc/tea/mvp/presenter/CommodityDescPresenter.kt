package com.yc.tea.mvp.presenter

import com.yc.tea.base.BaseListPresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.CommodityDescContract
import com.yc.tea.mvp.impl.ThreeContract
import java.util.ArrayList

class CommodityDescPresenter: BaseListPresenter<CommodityDescContract.View>(), CommodityDescContract.Presenter{

    override fun onRequest(page: Int) {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..3) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)
    }

}