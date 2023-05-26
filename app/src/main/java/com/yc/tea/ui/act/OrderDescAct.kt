package com.yc.tea.ui.act

import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.ui.OrderDescFrg

/**
 *  订单详情
 */
class OrderDescAct: BaseActivity() {

    var bean :String? = null

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initView() {
        val frg = OrderDescFrg::class.java.newInstance()
        var bundle = Bundle()
        bundle.putString("bean", bean)
        frg.arguments = bundle
        if (findFragment(OrderDescFrg::class.java) == null) {
            loadRootFragment(R.id.fl_container, frg)
        }
    }

    override fun initParms(bundle: Bundle) {
        bean =  bundle.getString("bean");
    }

}