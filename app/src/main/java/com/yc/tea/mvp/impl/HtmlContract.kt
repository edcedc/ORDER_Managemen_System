package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseView
import com.yc.tea.base.IPresenter


/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/23
 * Time: 19:33
 */
interface HtmlContract{

    interface View : IBaseView {
        fun setUrl(title: String?, content: String?)
    }

    interface Presenter: IPresenter<View> {

        fun onUrl(type : Int)

    }

}
