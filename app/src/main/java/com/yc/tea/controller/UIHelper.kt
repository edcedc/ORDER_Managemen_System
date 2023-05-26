package com.yc.tea.controller

import android.os.Bundle
import com.blankj.utilcode.util.ActivityUtils
import com.yc.tea.MainActivity
import com.yc.tea.base.BaseFragment
import com.yc.tea.ui.AddProductFrg
import com.yc.tea.ui.AddSupplierFrg
import com.yc.tea.ui.ForgetFrg
import com.yc.tea.ui.ManagementDescFrg
import com.yc.tea.ui.RegisterFrg
import com.yc.tea.ui.act.*


/**
 * Created by Administrator on 2017/2/22.
 */

class UIHelper private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        fun startMainAct() {
            ActivityUtils.startActivity(MainActivity::class.java)
        }

        /**
         *  登录
         */
        fun startLoginAct() {
            ActivityUtils.startActivity(LoginAct::class.java)
        }

        /**
         *  创建订单
         */
        fun startCreateOrderAct() {
            ActivityUtils.startActivity(CreateOrderAct::class.java)
        }

        /**
         *  各种H5
         */
        fun startHtmlAct(type: Int) {
            val bundle = Bundle()
            bundle.putInt("type", type)
            ActivityUtils.startActivity(bundle, HtmlAct::class.java)
        }

        fun startHtmlAct(type: Int, url: String?) {
            val bundle = Bundle()
            bundle.putInt("type", type)
            bundle.putString("url", url)
            ActivityUtils.startActivity(bundle, HtmlAct::class.java)
        }

        fun startHtmlAct(type: Int, url: String?, title: String?) {
            val bundle = Bundle()
            bundle.putInt("type", type)
            bundle.putString("url", url)
            bundle.putString("title", title)
            ActivityUtils.startActivity(bundle, HtmlAct::class.java)
        }

        /**
         *  视频页面
         */
        fun startVideoAct(video: String, image: String) {
            var bundle = Bundle()
            bundle.putString("video", video)
            bundle.putString("image", image)
//            ActivityUtils.startActivity(bundle, VideoAct::class.java)
        }

        /**
         *  忘记密码
         */
        fun startForgetFrg(root: BaseFragment) {
            val frg = ForgetFrg()
            val bundle = Bundle()
            frg.setArguments(bundle)
            root.start(frg)
        }

        /**
         *  注册
         */
        fun startRegisterFrg(root: BaseFragment) {
            val frg = RegisterFrg()
            val bundle = Bundle()
            frg.setArguments(bundle)
            root.start(frg)
        }

        /**
         *  添加商品编号
         */
        fun startAddProductFrg(root: BaseFragment) {
            val frg = AddProductFrg()
            val bundle = Bundle()
            frg.setArguments(bundle)
            root.start(frg)
        }

        /**
         *  订单详情
         */
        fun startOrderDescAct() {
            val bundle = Bundle()
            ActivityUtils.startActivity(bundle, OrderDescAct::class.java)
        }

        /**
         *  商品详情
         */
        fun startCommodityDescAct() {
            val bundle = Bundle()
            ActivityUtils.startActivity(bundle, CommodityDescAct::class.java)
        }

        /**
         *  买卖家管理
         */
        fun startSellerManagementAct() {
            val bundle = Bundle()
            ActivityUtils.startActivity(bundle, SellerManagementAct::class.java)
        }

        /**
         *  买卖家管理详情
         */
        fun startManagementDescFrg(root: BaseFragment) {
            val frg = ManagementDescFrg()
            val bundle = Bundle()
            frg.setArguments(bundle)
            root.start(frg)
        }

        /**
         *  添加供应商
         */
        fun startAddSupplierFrg(root: BaseFragment) {
            val frg = AddSupplierFrg()
            val bundle = Bundle()
            frg.setArguments(bundle)
            root.start(frg)
        }


    }

}