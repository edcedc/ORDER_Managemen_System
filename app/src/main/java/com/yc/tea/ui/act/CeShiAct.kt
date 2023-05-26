package com.yc.tea.ui.act

import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.mvp.impl.LoginContract
import com.yc.tea.mvp.presenter.LoginPresenter
import java.io.File

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2020/7/2
 * Time: 11:55
 */
class CeShiAct : BaseActivity(), LoginContract.View{

    val mPresenter by lazy { LoginPresenter() }


    override fun getLayoutId(): Int = R.layout.b_title_recycler

    override fun initView() {
        setTitle1("ggggg")
        mPresenter.init(this)

        mPresenter.onLogin("", "")
    }

    override fun initParms(bundle: Bundle) {
    }

    override fun setError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}