package com.yc.tea.mvp.presenter

import android.app.Activity
import com.yc.tea.base.BaseListPresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.ThreeContract
import com.yc.tea.mvp.impl.TwoContract
import java.util.ArrayList

class ThreePresenter : BaseListPresenter<ThreeContract.View>(), ThreeContract.Presenter{

    override fun onRequest(page: Int) {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..8) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)
    }

}