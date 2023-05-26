package com.yc.tea.mvp.presenter

import android.app.Activity
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.StringUtils
import com.yc.tea.R
import com.yc.tea.base.BasePresenter
import com.yc.tea.mvp.impl.ForgetContract
import com.yc.tea.net.exception.RetrofitManager

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/23
 * Time: 15:15
 */
class ForgetPresenter : BasePresenter<ForgetContract.View>(), ForgetContract.Presenter{

    override fun onCode(phone: String) {
        if (StringUtils.isEmpty(phone)) {
            showToast(act?.resources?.getString(R.string.please_phone) as  String)
            return
        }
        mRootView?.showLoading()
        /*var disposable = RetrofitManager.service.userGetForgetCode(phone)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ bean ->
                mRootView?.apply {
                    mRootView?.hideLoading()
                    if (bean.code == ErrorStatus.SUCCESS){
                        mRootView?.setCode()
                    }
                    showToast(bean.desc as String)
                }
            }, { t ->
                mRootView?.apply {
                    //处理异常
                    mRootView?.errorText(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                }
            })

        addSubscription(disposable)*/
    }

    override fun onSure(phone: String, code: String, pwd: String, pwd1: String) {
        if (!RegexUtils.isMobileExact(phone)) {
            showToast(act?.resources?.getString(R.string.error_phone) as String)
            return
        }
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code) || StringUtils.isEmpty(pwd) || StringUtils.isEmpty(pwd1)) {
            showToast(act?.resources?.getString(R.string.error_) as  String)
            return
        }
        if (!pwd.equals(pwd1)){
            showToast(act?.resources?.getString(R.string.please_pwd2) as String)
            return
        }

        mRootView?.showLoading()
        /*val disposable = RetrofitManager.service.userUpdateForgetPassword(phone, code, pwd, pwd1)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ bean ->
                mRootView?.apply {
                    mRootView?.hideLoading()
                    if (bean.code == ErrorStatus.SUCCESS){
                        SharedAccount.getInstance(act).save(phone, pwd)
                        act?.onBackPressed()
                    }
                    showToast(bean.desc as String)
                }
            }, { t ->
                mRootView?.apply {
                    //处理异常
                    mRootView?.errorText(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                }
            })

        addSubscription(disposable)*/
    }

}
