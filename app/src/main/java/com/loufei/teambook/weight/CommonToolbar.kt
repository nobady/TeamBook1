package com.loufei.teambook.weight

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.loufei.teambook.R

/**
 * Created by lvtengfei on 2019-12-24.
 */
class CommonToolbar(context: Context,attributeSet: AttributeSet) :Toolbar(context,attributeSet){

    private var backIv:ImageView
    private var arrowIv:ImageView
    private var moreIv:ImageView
    private var titleTv:TextView
    private var mRootView:View
    init {
        LayoutInflater.from(context).inflate(R.layout.title_layout,this)
        backIv = findViewById(R.id.iv_back)
        arrowIv = findViewById(R.id.iv_arrow)
        moreIv = findViewById(R.id.iv_toolbar_more)
        titleTv = findViewById(R.id.tv_centerText)
        mRootView = findViewById(R.id.rootView)
        mRootView.background = background
    }

    fun setBackImage(resId:Int){
        backIv.setImageResource(resId)
    }
    fun setArrowImage(resId: Int){
        arrowIv.setImageResource(resId)
    }
    fun setMoreImage(resId: Int){
        moreIv.setImageResource(resId)
    }
    fun setCenterText(text:String){
        titleTv.text = text
    }

    fun setCenterTextSize(textSize: Float){
        titleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize)
    }

    fun setCenterTextColor(colorRes:Int){
        titleTv.setTextColor(colorRes)
    }

    fun setBackground(resId: Int){
        mRootView.setBackgroundResource(resId)
    }
}