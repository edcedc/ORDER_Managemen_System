package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseListView
import com.yc.tea.base.IBaseView
import com.yc.tea.base.IListPresenter
import com.yc.tea.base.IPresenter

interface ThreeContract {

    interface View : IBaseListView {

    }

    interface Presenter: IListPresenter<View> {

        fun onRequest(page: Int)

    }

}