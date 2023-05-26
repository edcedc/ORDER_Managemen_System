package com.yc.tea.mvp.impl

import com.yc.tea.base.IBaseView
import com.yc.tea.base.IPresenter


/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/19
 * Time: 17:02
 */
interface LoginContract{

    interface View : IBaseView {

        fun setError()

    }

    interface Presenter: IPresenter<View> {

        fun onLogin(phone : String, pwd : String)

    }

}