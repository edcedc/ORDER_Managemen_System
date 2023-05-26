package com.yc.tea.base


/**
 * @author Jake.Ho
 * created: 2017/10/25
 * desc: Presenter 基类
 */


interface IListPresenter<in V: IBaseListView> {

    fun init(mRootView: V)

    fun detachView()

}
