package com.yc.tea;

import android.view.animation.AlphaAnimation;

import com.yc.tea.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther ${Nike}
 * @date 2023/5/23
 * @time 12:08.
 */
public class a   {



    private boolean isRefresh = false;

    String[] str = {"", ""};

    public void  dsadas(){
        DataBean bean = new DataBean();
        List list = new ArrayList();
        for (int i = 0; i < str.length; i++){
            list.add(bean);
        }
    }

    private AlphaAnimation alphaAniShow, alphaAniHide;


    //透明度动画
    private void alphaAnimation() {
        //显示
        alphaAniShow = new AlphaAnimation(0, 1);//百分比透明度，从0%到100%显示
        alphaAniShow.setDuration(1000);//一秒

        //隐藏
        alphaAniHide = new AlphaAnimation(1, 0);
        alphaAniHide.setDuration(1000);
    }
}
