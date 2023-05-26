package com.yc.tea.mvp.presenter

import com.yc.tea.base.BasePresenter
import com.yc.tea.mvp.impl.HtmlContract
import com.yc.tea.ui.act.HtmlAct

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/23
 * Time: 19:34
 */
class HtmlPresenter  : BasePresenter<HtmlContract.View>(), HtmlContract.Presenter{

    override fun onUrl(type: Int) {
        when(type){
            HtmlAct.USER_AGREEMENT -> {
                informationAgreement()
            }
        }
    }

    fun informationAgreement(){
//        var disposable = RetrofitManager.service.informationAgreement()
//            .compose(SchedulerUtils.ioToMain())
//            .subscribe({ bean ->
//                mRootView?.apply {
//                    if (bean.code == ErrorStatus.SUCCESS){
//                        val data = bean.data
//                        mRootView?.setUrl(data?.title, data?.content)
//                    }
//                }
//            }, { t ->
//                mRootView?.apply {
//                    //处理异常
//                    mRootView?.errorText(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
//                }
//            })
//
//        addSubscription(disposable)
    }

}