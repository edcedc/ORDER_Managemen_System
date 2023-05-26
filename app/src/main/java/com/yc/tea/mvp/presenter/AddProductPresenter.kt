package com.yc.tea.mvp.presenter

import com.yc.tea.base.BaseListPresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mvp.impl.AddProductContract
import com.yc.tea.mvp.impl.TwoContract
import java.util.ArrayList

class AddProductPresenter  : BaseListPresenter<AddProductContract.View>(), AddProductContract.Presenter{

    override fun onRequest(page: Int) {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..3) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)
    }

}