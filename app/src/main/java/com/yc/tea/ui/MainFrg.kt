package com.yc.tea.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.blankj.utilcode.util.ActivityUtils
import com.yc.tea.MAIN_FIRST
import com.yc.tea.MAIN_FOUR
import com.yc.tea.MAIN_SECOND
import com.yc.tea.MAIN_THIRD
import com.yc.tea.R
import com.yc.tea.base.BaseFragment
import com.yc.tea.weight.buttonBar.BottomBar
import com.yc.tea.weight.buttonBar.BottomBarTab
import kotlinx.android.synthetic.main.f_main.*
import me.yokeyword.fragmentation.SupportFragment

/**
 * Created by Android Studio.
 * User: ${edison}
 * Date: 2019/9/24
 * Time: 11:13
 */
class MainFrg : BaseFragment(){

    private val mFragments = arrayOfNulls<SupportFragment>(4)

    override fun getLayoutId(): Int = R.layout.f_main

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        bottomBar
            .addItem(BottomBarTab(_mActivity, R.mipmap.icon_5, "首页"))
            .addItem(BottomBarTab(_mActivity, R.mipmap.icon_10, "订单管理"))
            .addItem(BottomBarTab(_mActivity, R.mipmap.icon_12, "商品管理"))
            .addItem(BottomBarTab(_mActivity, R.mipmap.icon_8, "我的"))
        bottomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener {

            override fun onTabSelected(position: Int, prePosition: Int) {
                showHideFragment(mFragments[position], mFragments[prePosition])
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabReselected(position: Int) {
            }

        })
        bottomBar.setCurrentItem(0)
        setSwipeBackEnable(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val firstFragment = findChildFragment(OneFrg::class.java)
        if (firstFragment == null) {
            mFragments[MAIN_FIRST] = OneFrg::class.java.newInstance()
            mFragments[MAIN_SECOND] = TwoFrg::class.java.newInstance()
            mFragments[MAIN_THIRD] = ThreeFrg::class.java.newInstance()
            mFragments[MAIN_FOUR] = FourFrg::class.java.newInstance()
            loadMultipleRootFragment(
                R.id.fl_container,
                MAIN_FIRST,
                mFragments[MAIN_FIRST],
                mFragments[MAIN_SECOND],
                mFragments[MAIN_THIRD],
                mFragments[MAIN_FOUR]
            )
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[MAIN_FIRST] = firstFragment
            mFragments[MAIN_SECOND] = TwoFrg::class.java.newInstance()
            mFragments[MAIN_THIRD] = ThreeFrg::class.java.newInstance()
            mFragments[MAIN_FOUR] = FourFrg::class.java.newInstance()
        }
    }

    /**
     * start other BrotherFragment
     */
    fun startBrotherFragment(targetFragment: SupportFragment) {
        start(targetFragment)
    }

   override fun onBackPressedSupport(): Boolean {
        exitBy2Click()// 调用双击退出函数
        //        return super.onBackPressedSupport();
        return true
    }

    private var isExit: Boolean? = false

    private fun exitBy2Click() {
        var tExit: Handler? = null
        if (isExit == false) {
            isExit = true // 准备退出
            showToast("再按一次退出程序")
            tExit = Handler()
            tExit.postDelayed({
                isExit = false // 取消退出
            }, 2000)// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
            return
        } else {
            //            Cockroach.uninstall();
            ActivityUtils.finishAllActivities()
            System.exit(0)
        }
    }

}