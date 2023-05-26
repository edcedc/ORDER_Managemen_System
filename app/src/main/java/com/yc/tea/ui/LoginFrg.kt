package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.StringUtils
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.LoginContract
import com.yc.tea.mvp.presenter.LoginPresenter
import com.yc.tea.utils.cache.SharedAccount
import kotlinx.android.synthetic.main.f_login.*

/**
 * 登录
 */
class LoginFrg : BaseFragment(), LoginContract.View,View.OnClickListener{

    override fun setError() {
    }

    val mPresenter by lazy { LoginPresenter() }

    override fun getLayoutId(): Int = R.layout.f_login

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitleCenter(getString(R.string.login))
        mPresenter.init(this, activity)
        bt_sure.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        tv_forget.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_sure -> {
                //mPresenter.onLogin(et_phone.text.toString(), et_pwd.text.toString()
                UIHelper.startMainAct()
                activity!!.finish()
            }
            R.id.tv_register -> UIHelper.startRegisterFrg(this)
            R.id.tv_forget -> UIHelper.startForgetFrg(this)
        }
    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        val account = SharedAccount.getInstance(activity)
        val mobile = account.getMobile()
        val pwd = account.getPwd()
        if (!StringUtils.isEmpty(mobile) && !StringUtils.isEmpty(pwd)) {
            et_phone.setText(mobile)
            et_pwd.setText(pwd)
        }
    }

}