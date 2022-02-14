package com.example.zt.util.Bom

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.TypefaceSpan
import android.widget.TextView

/**
 * 创建高亮字符串  使用字符串寻找索引的 方法
 *
 * @param srcTxt
 * @param highlightTxt  是srcTxt的一部分
 * @param highlightColor  默认红色高亮
 * @param isMedium  是否Medium 样式
 * @return
 */
fun TextView.setHighlightTextV2(
    srcTxt: String?,
    highlightTxt: String?,
    highlightColor: Int = Color.parseColor("#FF2641"),
    isMedium: Boolean = false
) {
    var spannable: SpannableStringBuilder? = null
    if (!TextUtils.isEmpty(srcTxt)) {
        spannable = SpannableStringBuilder(srcTxt)
        if (srcTxt?.contains(highlightTxt.toString()) != true) {
            return
        }
        // 获取目的串在源串中的索引位置
        var index = highlightTxt?.let {
            srcTxt.indexOf(it)
        }
        spannable.setSpan(
            ForegroundColorSpan(highlightColor),
            index!!,
            index + highlightTxt?.length!!,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (isMedium)
            spannable.setSpan(
                TypefaceSpan("sans-serif-medium"),
                index,
                index + highlightTxt.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
    }
    text = spannable ?: srcTxt
}