package com.yc.tea.ui.act

import android.os.Bundle
import com.yc.tea.R
import com.yc.tea.base.BaseActivity
import com.yc.tea.ui.CommodityDescFrg
import com.yc.tea.ui.OrderDescFrg

/**
 *  商品详情
 */
class CommodityDescAct : BaseActivity() {

    var bean: String? = null

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun initView() {
        val frg = CommodityDescFrg::class.java.newInstance()
        var bundle = Bundle()
        bundle.putString("bean", bean)
        frg.arguments = bundle
        if (findFragment(CommodityDescFrg::class.java) == null) {
            loadRootFragment(R.id.fl_container, frg)
        }
    }

    override fun initParms(bundle: Bundle) {
        bean = bundle.getString("bean");
    }

}