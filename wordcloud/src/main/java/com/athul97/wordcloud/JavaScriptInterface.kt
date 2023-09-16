package com.athul97.wordcloud

import android.content.Context
import android.widget.Toast
import kotlin.math.ceil
import kotlin.math.floor


class JavascriptInterface(private val mContext: Context) {
        private var mCloudTitle: String? = null
        private lateinit var wordCallback: (result: String?) -> Unit
        @get:android.webkit.JavascriptInterface
        var rotationType:RotationType?=null
            private set
        @get:android.webkit.JavascriptInterface
        var cloudString: String? = null
            private set
        @get:android.webkit.JavascriptInterface
        var cloudFont: String? = null
            private set
        @get:android.webkit.JavascriptInterface
        var parentWidth = 0
            private set
        @get:android.webkit.JavascriptInterface
        var parentHeight = 0
            private set
        fun setCloudParams(
            mCloudTitle: String?, mCloudString: String?,
            mCloudFont: String?, parentWidth: Int, parentHeight: Int,
            rotationType: RotationType,
            wordCallback: (result: String?) -> Unit
        ) {
            this.mCloudTitle = mCloudTitle
            this.cloudString = mCloudString
            this.cloudFont = mCloudFont
            this.parentHeight = parentHeight
            this.parentWidth = parentWidth
            this.wordCallback = wordCallback
            this.rotationType = rotationType

        }

        @android.webkit.JavascriptInterface
        fun calculateRotation():Int{
            return when (rotationType) {
                RotationType.VERTICAL -> {
                    90
                }

                RotationType.HORIZONTAL -> {
                    0
                }
                else -> {
                    -1
                }
            }
        }

        @android.webkit.JavascriptInterface
        fun showToast(message: String?) {
            wordCallback.invoke(message)
        }

    }

