package com.yc.tea.mvp.presenter

import com.yc.tea.base.BasePresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.CreateOrderContract
import com.yc.tea.mvp.impl.ForgetContract
import java.util.ArrayList

class CreateOrderPresenter  : BasePresenter<CreateOrderContract.View>(), CreateOrderContract.Presenter{

    override fun onRequest() {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..8) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)
    }

}