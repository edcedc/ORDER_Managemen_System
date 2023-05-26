package com.yc.tea.ui.act

import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.ui.CreateOrderFrg
/**
 * 创建订单
 */
class CreateOrderAct : BaseActivity(){

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initParms(bundle: Bundle) {
    }

    override fun initView() {
        if (findFragment(CreateOrderFrg::class.java) == null) {
            loadRootFragment(R.id.fl_container, CreateOrderFrg::class.java.newInstance())
        }
    }

}