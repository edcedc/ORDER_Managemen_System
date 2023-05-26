package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import kotlinx.android.synthetic.main.f_management_desc.et_address
import kotlinx.android.synthetic.main.f_management_desc.et_enter
import kotlinx.android.synthetic.main.f_management_desc.et_phone
import kotlinx.android.synthetic.main.f_management_desc.tv_choose
import kotlinx.android.synthetic.main.f_management_desc.tv_harvest_date1
import kotlinx.android.synthetic.main.f_management_desc.tv_order_num
import kotlinx.android.synthetic.main.f_management_desc.tv_remar
import kotlinx.android.synthetic.main.f_management_desc.tv_remark
import kotlinx.android.synthetic.main.f_management_desc.tv_supplier
import kotlinx.android.synthetic.main.f_management_desc.tv_supplier_address

/**
 * @Author nike
 * @Date 2023/5/26 16:53
 * @Description 买卖家管理详情
 */
class ManagementDescFrg : BaseFragment(){

    override fun getLayoutId(): Int = R.layout.f_management_desc

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.buyer_management_desc))

        et_enter.text = "nino"
        tv_harvest_date1.text = "卖家"
        tv_choose.text = "+86 16116212"
        et_phone.text = "10/F, ABC Building, ABC District"
        et_address.text = "das56456@163.com"
        tv_supplier.text = "水果"
        tv_supplier_address.text = "华丰银行"
        tv_remark.text = "5641569+4541561"
        tv_remar.text = "无+4541561"
    }

}