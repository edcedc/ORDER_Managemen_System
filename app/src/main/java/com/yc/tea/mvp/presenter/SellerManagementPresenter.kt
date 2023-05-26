package com.yc.tea.mvp.presenter

import com.yc.tea.base.BaseListPresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.OneContract
import com.yc.tea.mvp.impl.SellerManagementContract
import java.util.ArrayList

class SellerManagementPresenter : BaseListPresenter<SellerManagementContract.View>(), SellerManagementContract.Presenter{
    override fun onRequest(page: Int) {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..8) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)
    }
}