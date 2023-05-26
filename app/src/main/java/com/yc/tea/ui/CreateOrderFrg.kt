package com.yc.tea.ui

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DividerItemDecoration
import com.yc.tea.ORDER_CREATE
import com.yc.tea.ORDER_DESC
import com.yc.tea.R
import com.yc.tea.adapter.CreateOrderAdapter
import com.yc.tea.base.BaseFragment
import com.yc.tea.bean.DataBean
import com.yc.tea.controller.UIHelper
import com.yc.tea.mvp.impl.CreateOrderContract
import com.yc.tea.mvp.presenter.CreateOrderPresenter
import com.yc.tea.utils.DatePickerUtils
import com.yc.tea.weight.LinearDividerItemDecoration
import kotlinx.android.synthetic.main.f_create_order.bt_add_product
import kotlinx.android.synthetic.main.f_create_order.bt_sure
import kotlinx.android.synthetic.main.f_create_order.recyclerView
import kotlinx.android.synthetic.main.f_create_order.tv_choose
import kotlinx.android.synthetic.main.f_create_order.tv_harvest_date1
import kotlinx.android.synthetic.main.f_create_order.tv_state


/**
 * 创建订单
 */
class CreateOrderFrg: BaseFragment(), CreateOrderContract.View, OnClickListener, CreateOrderAdapter.OnClickListener{

    val mPresenter by lazy { CreateOrderPresenter() }

    val listBean = ArrayList<DataBean>()

    val adapter by lazy { activity?.let { CreateOrderAdapter(it, this, listBean, ORDER_CREATE) } }

    override fun getLayoutId(): Int = R.layout.f_create_order

    override fun initParms(bundle: Bundle) {
    }

    override fun initView(rootView: View) {
        setTitle(getString(R.string.create_order))
        mPresenter.init(this)
        tv_state.setOnClickListener(this)
        tv_harvest_date1.setOnClickListener(this)
        tv_choose.setOnClickListener(this)
        bt_sure.setOnClickListener(this)
        bt_add_product.setOnClickListener(this)

        setRecyclerViewType(recyclerView = recyclerView)
        recyclerView.addItemDecoration(LinearDividerItemDecoration(activity, DividerItemDecoration.VERTICAL, 10))
        recyclerView.adapter = adapter
        mPresenter.onRequest()

        adapter?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_state ->{
                val list = ArrayList<DataBean>()
                for (i in 0..8) {
                    val bean = DataBean()
                    bean.name = "状态" + i
                    list.add(bean)
                }
                DatePickerUtils.onOptionPicker(activity, getString(R.string.state), list){
                        index, item ->
                    tv_state.text = item
                }
            }
            R.id.tv_harvest_date1 ->{
                DatePickerUtils.getYearMonthDayPicker(
                    activity, getString(R.string.creation_date)
                ) { year, month, day ->
                    tv_harvest_date1.text = year + "-" + month + "-" + day
                }
            }
            R.id.tv_choose ->{
                val list = ArrayList<DataBean>()
                for (i in 0..8) {
                    val bean = DataBean()
                    bean.name = "采购客户" + i
                    list.add(bean)
                }
                DatePickerUtils.onOptionPicker(activity, getString(R.string.purchasing_customers), list){
                        index, item ->
                    tv_choose.text = item
                }
            }
            R.id.bt_add_product ->{
                UIHelper.startAddProductFrg(this)
            }
            R.id.bt_sure ->{

            }
        }
    }

    override fun setData(objects: Object) {
        val list = objects as List<DataBean>
        if (pagerNumber == 1){
            listBean.clear()
        }
        listBean.addAll(list)
        adapter?.notifyDataSetChanged()
    }

    override fun onDel(position: Int) {
        listBean.removeAt(position)
        adapter?.notifyItemRemoved(position)
        adapter?.notifyItemChanged(position)
//        adapter?.notifyDataSetChanged()
    }

    /*private val REQ_MODIFY_FRAGMENT = 100
    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        super.onFragmentResult(requestCode, resultCode, data)
        if (requestCode == REQ_MODIFY_FRAGMENT && resultCode == RESULT_OK && data != null) {

        }
    }
                Bundle bundle = new Bundle();
                bundle.putString(DetailFragment.KEY_RESULT_TITLE, mEtModiyTitle.getText().toString());
                setFragmentResult(RESULT_OK, bundle);

    */

}