package com.yc.tea.mvp.presenter

import android.widget.Toast
import com.yc.tea.base.BaseListPresenter
import com.yc.tea.bean.DataBean
import com.yc.tea.mar.MyApplication
import com.yc.tea.mvp.impl.OneContract
import com.yc.tea.mvp.impl.TwoContract
import java.util.ArrayList

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/25
 * Time: 11:46
 */
class TwoPresenter : BaseListPresenter<TwoContract.View>(), TwoContract.Presenter{

    override fun onRequest(page: Int) {
        val bean = DataBean()
        val list = ArrayList<DataBean>()
        for (i in 0..3) {
            list.add(bean)
        }
        mRootView?.setData(list as Object)

                /*val disposable = RetrofitManager.service.circlePage(page)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ bean ->
                mRootView?.apply {
                    if (bean.code == ErrorStatus.SUCCESS){
                        val data = bean.data
                        val list = data?.list
                        if (list != null){
                            mRootView?.setData(list as Object)
                        }
                        mRootView?.setRefreshLayoutMode(data?.totalRow as Int)
                    }
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