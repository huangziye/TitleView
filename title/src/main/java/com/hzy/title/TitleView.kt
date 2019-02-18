package com.hzy.title

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.title_view.view.*

/**
 *
 * @author: ziye_huang
 * @date: 2019/2/18
 */
class TitleView : Toolbar, View.OnClickListener {
    /**
     *
     */
    private var mLeftText: String? = null
    private var mRightText: String? = null
    private var mTitleText: String? = null
    @ColorInt
    private var mLeftTextColor: Int
    @ColorInt
    private var mRightTextColor: Int
    @ColorInt
    private var mTitleTextColor: Int
    private var mLeftTextSize: Int
    private var mRightTextSize: Int
    private var mTitleTextSize: Int
    @DrawableRes
    private var mLeftDrawable: Drawable? = null
    @DrawableRes
    private var mRightDrawable: Drawable? = null
    @DrawableRes
    private var mTitleDrawable: Drawable? = null

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        LayoutInflater.from(context).inflate(R.layout.title_view, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleView)
        mLeftText = typedArray.getString(R.styleable.TitleView_leftText)
        mTitleText = typedArray.getString(R.styleable.TitleView_titleText)
        mRightText = typedArray.getString(R.styleable.TitleView_rightText)
        mLeftTextColor = typedArray.getColor(R.styleable.TitleView_leftTextColor, 0)
        mRightTextColor = typedArray.getColor(R.styleable.TitleView_rightTextColor, 0)
        mTitleTextColor = typedArray.getColor(R.styleable.TitleView_titleTextColor, 0)
        mLeftTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleView_leftTextSize, 0)
        mRightTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleView_rightTextSize, 0)
        mTitleTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleView_titleTextSize, 0)
        mLeftDrawable = typedArray.getDrawable(R.styleable.TitleView_leftDrawable)
        mRightDrawable = typedArray.getDrawable(R.styleable.TitleView_rightDrawable)
        mTitleDrawable = typedArray.getDrawable(R.styleable.TitleView_titleDrawable)
        typedArray.recycle()

        initView()
    }

    fun initView() {
        setLeftText()
        setTitleText()
        setRightText()
        setLeftTextColor()
        setRightTextColor()
        setTitleTextColor()
        setLeftTextSize()
        setRightTextSize()
        setTitleTextSize()
        setLeftDrawable()
        setRightDrawable()
        setTitleDrawable()
        setLeftClickListener(this)
        setRightClickListener(this)
        setTitleClickListener(this)
    }

    fun setLeftText() {
        tv_left_text.text = mLeftText
    }

    fun setTitleText() {
        tv_title_text.text = mTitleText
    }

    fun setRightText() {
        tv_right_text.text = mRightText
    }

    fun setLeftTextColor() {
        tv_left_text.setTextColor(mLeftTextColor)
    }

    fun setRightTextColor() {
        tv_right_text.setTextColor(mRightTextColor)
    }

    fun setTitleTextColor() {
        tv_title_text.setTextColor(mTitleTextColor)
    }

    fun setLeftTextSize() {
        tv_left_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftTextSize.toFloat())
    }

    fun setRightTextSize() {
        tv_right_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize.toFloat())
    }

    fun setTitleTextSize() {
        tv_title_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTitleTextSize.toFloat())
    }

    fun setLeftDrawable() {
        mLeftDrawable?.let {
            mLeftDrawable!!.setBounds(0, 0, mLeftDrawable!!.minimumWidth, mLeftDrawable!!.minimumHeight)
            tv_left_text.setCompoundDrawables(mLeftDrawable, null, null, null)
            tv_left_text.compoundDrawablePadding = 4
        }
    }

    fun setRightDrawable() {
        mRightDrawable?.let {
            mRightDrawable!!.setBounds(0, 0, mRightDrawable!!.minimumWidth, mRightDrawable!!.minimumHeight)
            tv_right_text.setCompoundDrawables(mRightDrawable, null, null, null)
            tv_right_text.compoundDrawablePadding = 4
        }
    }

    fun setTitleDrawable() {
        mTitleDrawable?.let {
            mTitleDrawable!!.setBounds(0, 0, mTitleDrawable!!.minimumWidth, mTitleDrawable!!.minimumHeight)
            tv_title_text.setCompoundDrawables(mTitleDrawable, null, null, null)
            tv_title_text.compoundDrawablePadding = 4
        }
    }

    fun setLeftClickListener(listener: OnClickListener) {
        tv_left_text.setOnClickListener(listener)
    }

    fun setRightClickListener(listener: OnClickListener) {
        tv_right_text.setOnClickListener(listener)
    }

    fun setTitleClickListener(listener: OnClickListener) {
        tv_title_text.setOnClickListener(listener)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_left_text -> {
                if (context is Activity) {
                    (context as Activity).onBackPressed()
                }
            }
        }
    }
}