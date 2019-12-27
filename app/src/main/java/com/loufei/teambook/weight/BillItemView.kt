package com.loufei.teambook.weight

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.loufei.teambook.R

/**
 * 账单详情的item
 * Created by lvtengfei on 2019-12-27.
 */
class BillItemView(context: Context,attributeSet: AttributeSet):LinearLayout(context,attributeSet) {

    private var secondTextNameTv:TextView
    private var textNameTv:TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_bill_item_view,this,true)
        val typedArray =
            context.obtainStyledAttributes(attributeSet, R.styleable.BillItemView)
        val text = typedArray.getString(R.styleable.BillItemView_firstText)
        val textSize =
            typedArray.getDimension(R.styleable.BillItemView_firstTextSize, 12F)
        val textColor =
            typedArray.getColor(R.styleable.BillItemView_firstTextColor, context.resources.getColor(R.color.second_text_color))
        val secondText = typedArray.getString(R.styleable.BillItemView_secondText)
        val secondTextSize = typedArray.getDimension(R.styleable.BillItemView_secondTextSize, 12F)
        val secondTextColor = typedArray.getColor(
            R.styleable.BillItemView_secondTextColor,
            context.resources.getColor(R.color.third_text_color)
        )
        val iconId = typedArray.getResourceId(R.styleable.BillItemView_billIcon, 0)
        val iconBill = findViewById<ImageView>(R.id.iv_icon_bill)
        textNameTv = findViewById<TextView>(R.id.tv_text_name)
        secondTextNameTv = findViewById<TextView>(R.id.tv_bill_value)

        iconBill.takeIf { iconId!=0 }?.setBackgroundResource(iconId)
        textNameTv.setTextColor(textColor)
        textNameTv.text = text
        textNameTv.textSize = textSize
        secondTextNameTv.setTextColor(secondTextColor)
        secondTextNameTv.text = secondText
        secondTextNameTv.textSize = secondTextSize

        typedArray.recycle()
    }

    fun setSecondTextClickListener(listener: View.OnClickListener){
        secondTextNameTv.setOnClickListener {
            listener.onClick(it)
        }
    }

    fun setSecondText(text:String){
        secondTextNameTv.text = text
    }
}