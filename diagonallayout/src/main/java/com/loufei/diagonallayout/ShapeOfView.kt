package com.loufei.diagonallayout

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by lvtengfei on 2019-10-29.
 */
class ShapeOfView constructor(context: Context):FrameLayout(context) {

    private val clipPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val clipPath = Path()


    constructor(context: Context,attributeSet: AttributeSet) : this(context) {

    }

    constructor(context: Context,attributeSet: AttributeSet,defStyleAttr:Int):this(context,attributeSet){

    }

    private fun init(context: Context,attributeSet: AttributeSet){
        clipPaint.isAntiAlias = true
        isDrawingCacheEnabled = true
        setWillNotDraw(true)
        clipPaint.color = Color.BLUE
        clipPaint.style = Paint.Style.FILL
        clipPaint.strokeWidth = 1f

    }
}