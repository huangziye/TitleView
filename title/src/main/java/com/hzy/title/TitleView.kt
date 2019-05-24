package com.hzy.title

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.title_view.view.*

/**
 * 自定义title标题栏
 * @author: ziye_huang
 * @date: 2019/2/18
 */
open class TitleView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr), View.OnClickListener {
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
    private var mLeftDrawable: Drawable? = null
    private var mRightDrawable: Drawable? = null
    private var mTitleDrawable: Drawable? = null
    @ColorInt
    private var mTitleViewBgColor: Int
    private var mLeftMarginLeft: Int
    private var mLeftMarginRight: Int
    private var mRightMarginLeft: Int
    private var mRightMarginRight: Int

    init {
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
        mTitleViewBgColor = typedArray.getColor(
            R.styleable.TitleView_titleViewBgColor,
            ContextCompat.getColor(context, R.color.defaultTitleViewBgColor)
        )
        mLeftMarginLeft = typedArray.getDimensionPixelSize(R.styleable.TitleView_leftMarginLeft, 0)
        mLeftMarginRight = typedArray.getDimensionPixelSize(R.styleable.TitleView_leftMarginRight, 0)
        mRightMarginLeft = typedArray.getDimensionPixelSize(R.styleable.TitleView_rightMarginLeft, 0)
        mRightMarginRight = typedArray.getDimensionPixelSize(R.styleable.TitleView_rightMarginRight, 0)
        typedArray.recycle()

        initView()
    }

    private fun initView() {
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
        setTitleViewBgColor()
        setLeftMargin()
        setRightMargin()
        setLeftClickListener(this)
        setRightClickListener(this)
        setTitleClickListener(this)
    }

    private fun setLeftText() {
        tv_left_text.text = mLeftText
    }

    private fun setTitleText() {
        tv_title_text.text = mTitleText
    }

    private fun setRightText() {
        tv_right_text.text = mRightText
    }

    private fun setLeftTextColor() {
        tv_left_text.setTextColor(mLeftTextColor)
    }

    private fun setRightTextColor() {
        tv_right_text.setTextColor(mRightTextColor)
    }

    private fun setTitleTextColor() {
        tv_title_text.setTextColor(mTitleTextColor)
    }

    private fun setTitleViewBgColor() {
        toolbar.setBackgroundColor(mTitleViewBgColor)
    }

    private fun setLeftTextSize() {
        tv_left_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftTextSize.toFloat())
    }

    private fun setRightTextSize() {
        tv_right_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize.toFloat())
    }

    private fun setTitleTextSize() {
        tv_title_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTitleTextSize.toFloat())
    }

    private fun setLeftMargin() {
        val params = tv_left_text.layoutParams
        if (params is LayoutParams) {
            params.leftMargin = mLeftMarginLeft
            params.rightMargin = mLeftMarginRight
        }
        tv_left_text.layoutParams = params
    }

    private fun setRightMargin() {
        val params = tv_right_text.layoutParams
        if (params is LayoutParams) {
            params.leftMargin = mRightMarginLeft
            params.rightMargin = mRightMarginRight
        }
        tv_right_text.layoutParams = params
    }

    private fun setLeftDrawable() {
        mLeftDrawable?.let {
            mLeftDrawable!!.setBounds(0, 0, mLeftDrawable!!.minimumWidth, mLeftDrawable!!.minimumHeight)
            tv_left_text.setCompoundDrawables(mLeftDrawable, null, null, null)
            tv_left_text.compoundDrawablePadding = 4
        }
    }

    private fun setRightDrawable() {
        mRightDrawable?.let {
            mRightDrawable!!.setBounds(0, 0, mRightDrawable!!.minimumWidth, mRightDrawable!!.minimumHeight)
            tv_right_text.setCompoundDrawables(mRightDrawable, null, null, null)
            tv_right_text.compoundDrawablePadding = 4
        }
    }

    private fun setTitleDrawable() {
        mTitleDrawable?.let {
            mTitleDrawable!!.setBounds(0, 0, mTitleDrawable!!.minimumWidth, mTitleDrawable!!.minimumHeight)
            tv_title_text.setCompoundDrawables(mTitleDrawable, null, null, null)
            tv_title_text.compoundDrawablePadding = 4
        }
    }

    private fun setLeftClickListener(listener: OnClickListener) {
        tv_left_text.setOnClickListener(listener)
    }

    private fun setRightClickListener(listener: OnClickListener) {
        tv_right_text.setOnClickListener(listener)
    }

    private fun setTitleClickListener(listener: OnClickListener) {
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