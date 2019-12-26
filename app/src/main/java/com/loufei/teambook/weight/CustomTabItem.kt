package com.loufei.teambook.weight

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.loufei.teambook.R

/**
 * 根据是否选中来改变文本大小的tabItem
 * Created by lvtengfei on 2019-12-23.
 */
class CustomTabItem(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {


    private var content: String?
    private var isSelect = false
    private var selectTextColor = 0
    private var textColor = 0
    private var selectTextSize = 0F
    private var textSize = 0F
    private var indicatorHeight = 0F
    private var indicatorBackgroundId = 0

    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomTabItem)
        content = typedArray.getString(R.styleable.CustomTabItem_text)
        isSelect = typedArray.getBoolean(R.styleable.CustomTabItem_isSelect, false)
        selectTextColor = typedArray.getColor(
            R.styleable.CustomTabItem_selectedTextColor,
            context.resources.getColor(R.color.main_text_color)
        )
        textColor = typedArray.getColor(
            R.styleable.CustomTabItem_textColor,
            context.resources.getColor(R.color.second_text_color)
        )
        selectTextSize = typedArray.getDimension(R.styleable.CustomTabItem_selectedTextSize, 18F)
        textSize = typedArray.getDimension(R.styleable.CustomTabItem_textSize, 14F)
        indicatorHeight = typedArray.getDimension(R.styleable.CustomTabItem_tabIndicatorHeight, 2F)
        indicatorBackgroundId =
            typedArray.getResourceId(R.styleable.CustomTabItem_tabIndicatorBackground, 0)

        LayoutInflater.from(context).inflate(R.layout.layout_tab_item, this, true)

        setViews()
        typedArray.recycle()
    }

    private fun setViews(){
        val tabTextView = findViewById<TextView>(R.id.tv_tabItem_text)
        val indicatorIv = findViewById<ImageView>(R.id.indicator_iv)
        content?.let { tabTextView.text = it }
        indicatorBackgroundId.takeIf { isSelect }?.apply {
            tabTextView.setTextColor(selectTextColor)
            tabTextView.textSize = selectTextSize
            indicatorIv.visibility = View.VISIBLE
        }.takeIf { it!=0 }?.let {
            indicatorIv.setImageResource(it)
        }
        indicatorBackgroundId.takeUnless { isSelect }?.apply {
            tabTextView.setTextColor(textColor)
            tabTextView.textSize = textSize
            indicatorIv.visibility = View.INVISIBLE
        }
    }

}