package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseListView
import com.yc.tea.base.IListPresenter

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/25
 * Time: 11:46
 */
interface OneContract {

    interface View : IBaseListView {

    }

    interface Presenter: IListPresenter<View> {

        fun onRequest(page: Int)

    }

}