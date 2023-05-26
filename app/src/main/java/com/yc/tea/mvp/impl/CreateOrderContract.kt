package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseView
import com.yc.tea.base.IPresenter

interface CreateOrderContract{

    interface View : IBaseView {
        fun setData(objects: Object)
    }

    interface Presenter: IPresenter<View> {
        fun onRequest()

    }

}