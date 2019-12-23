package com.loufei.teambook.weight

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.google.android.material.tabs.TabItem
import com.loufei.teambook.R

/**
 * 根据是否选中来改变文本大小的tabItem
 * Created by lvtengfei on 2019-12-23.
 */
class CustomTabItem(context: Context,attrs: AttributeSet):LinearLayout(context,attrs) {


    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomTabItem)
        val content = typedArray.getString(R.styleable.CustomTabItem_text)
        val isSelected = typedArray.getBoolean(R.styleable.CustomTabItem_isSelect, false)
        val selectTextColor = typedArray.getColor(
            R.styleable.CustomTabItem_selectedTextColor,
            context.resources.getColor(R.color.main_text_color)
        )
        val textColor = typedArray.getColor(
            R.styleable.CustomTabItem_textColor,
            context.resources.getColor(R.color.second_text_color)
        )
        val selectTextSize = typedArray.getDimension(R.styleable.CustomTabItem_selectedTextSize, 18F)
        val textSize = typedArray.getDimension(R.styleable.CustomTabItem_textSize, 14F)
        val indicatorHeight = typedArray.getDimension(R.styleable.CustomTabItem_tabIndicatorHeight, 2F)
        typedArray.getColorStateList(R.styleable.CustomTabItem_tabIndicatorBackground,
            context.resources.getColorStateList(R.color.main_text_color))


        typedArray.recycle()
    }
}