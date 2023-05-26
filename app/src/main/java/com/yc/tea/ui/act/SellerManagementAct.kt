package com.yc.tea.ui.act

import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.ui.SellerManagementFrg

class SellerManagementAct : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        val frg = SellerManagementFrg::class.java.newInstance()
        var bundle = Bundle()
        frg.arguments = bundle
        if (findFragment(SellerManagementFrg::class.java) == null) {
            loadRootFragment(R.id.fl_container, frg)
        }
    }

    override fun initParms(bundle: Bundle) {
    }
}