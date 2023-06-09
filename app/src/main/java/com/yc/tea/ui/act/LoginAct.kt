package com.yc.tea.ui.act

import android.content.Intent
import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.event.CameraInEvent
import com.yc.tea.ui.LoginFrg
import org.greenrobot.eventbus.EventBus

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/18
 * Time: 21:00
 *  登录
 */
class LoginAct : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initParms(bundle: Bundle) {
    }

    override fun initView() {
        if (findFragment(LoginFrg::class.java) == null) {
            loadRootFragment(R.id.fl_container, LoginFrg::class.java.newInstance())
        }
    }

}
