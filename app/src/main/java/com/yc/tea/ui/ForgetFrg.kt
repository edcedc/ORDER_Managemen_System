package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.mvp.impl.ForgetContract
import com.yc.tea.mvp.presenter.ForgetPresenter
import com.yc.tea.utils.CountDownTimerUtils
import kotlinx.android.synthetic.main.f_register.*

/**
 * 忘记密码
 */
class ForgetFrg : BaseFragment(), ForgetContract.View, View.OnClickListener{

    override fun setCode() {
        CountDownTimerUtils(activity, 60000, 1000, tv_code).start()
    }

    private val mPresenter by lazy { ForgetPresenter() }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_code -> {mPresenter.onCode(et_phone?.text.toString())}
            R.id.bt_sure -> {mPresenter.onSure(et_phone?.text.toString(), et_code?.text.toString(), et_pwd?.text.toString(), et_pwd1?.text.toString())}
        }
    }

    override fun getLayoutId(): Int = R.layout.f_register

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.forget_the_password))
        mPresenter.init(this, activity)
        tv_code.setOnClickListener(this)
        bt_sure.setOnClickListener(this)
        cb_agreement.visibility = View.GONE
    }

}