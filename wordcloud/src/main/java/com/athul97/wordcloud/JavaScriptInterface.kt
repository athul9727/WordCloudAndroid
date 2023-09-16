package com.athul97.wordcloud

import android.content.Context
import android.widget.Toast




    class JavascriptInterface(private val mContext: Context) {
        private var mCloudTitle: String? = null
        private lateinit var wordCallback: (result: String?) -> Unit
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
            wordCallback: (result: String?) -> Unit
        ) {
            this.mCloudTitle = mCloudTitle
            this.cloudString = mCloudString
            this.cloudFont = mCloudFont
            this.parentHeight = parentHeight
            this.parentWidth = parentWidth
            this.wordCallback = wordCallback

        }

        @android.webkit.JavascriptInterface
        fun showToast(message: String?) {
            wordCallback.invoke(message)
        }

    }

