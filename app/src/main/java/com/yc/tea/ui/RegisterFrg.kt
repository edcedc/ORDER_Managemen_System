package com.yc.tea.ui

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.RegisterContract
import com.yc.tea.mvp.presenter.RegisterPresenter
import com.yc.tea.utils.CountDownTimerUtils
import kotlinx.android.synthetic.main.f_register.*

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/23
 * Time: 14:48
 *  注册
 */
class RegisterFrg : BaseFragment(), RegisterContract.View, View.OnClickListener{

    override fun setCode() {
        CountDownTimerUtils(activity, 60000, 1000, tv_code).start()
    }

    private val mPresenter by lazy { RegisterPresenter() }

    override fun getLayoutId(): Int = R.layout.f_register

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.register))
        mPresenter.init(this, activity)
        tv_code.setOnClickListener(this)
        bt_sure.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        val colorSpan = ForegroundColorSpan(Color.parseColor("#FF5A60"))
        val hText = SpannableString("我已阅读并同意《茶叶注册协议》")
        hText.setSpan(colorSpan, hText.length - 8, hText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        tv_agreement.setText(hText)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_code -> {mPresenter.onCode(et_phone?.text.toString())}
            R.id.bt_sure -> {mPresenter.onSure(et_phone?.text.toString(), et_code?.text.toString(), et_pwd?.text.toString(), et_pwd1?.text.toString(), cb_agreement?.isChecked)}
//            R.id.tv_agreement -> UIHelper.startHtmlAct(HtmlAct.USER_AGREEMENT)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}