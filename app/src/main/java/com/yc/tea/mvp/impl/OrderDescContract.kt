package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseListView
import com.yc.tea.base.IListPresenter

interface OrderDescContract {

    interface View : IBaseListView {

    }

    interface Presenter: IListPresenter<View> {

        fun onRequest(page: Int)

    }

}