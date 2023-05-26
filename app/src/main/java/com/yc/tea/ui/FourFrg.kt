package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.controller.UIHelper
import com.yc.tea.utils.PictureSelectorTool
import com.yc.tea.utils.PopupWindowTool
import kotlinx.android.synthetic.main.f_four.tv_dynamic
import kotlinx.android.synthetic.main.f_four.tv_out

class FourFrg  : BaseFragment(), OnClickListener{

    override fun getLayoutId(): Int = R.layout.f_four

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        tv_dynamic.setOnClickListener(this)
        tv_out.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_dynamic ->{
                UIHelper.startSellerManagementAct()
            }
            R.id.tv_out ->{
                PopupWindowTool.showDialog(activity).asConfirm("是否退出账号？", "", "取消", "确定", {
                    activity?.let {
                        UIHelper.startLoginAct()
                        activity!!.finish()
                    }
                }, null, false).bindLayout(R.layout.p_dialog).show()
            }
        }
    }

}