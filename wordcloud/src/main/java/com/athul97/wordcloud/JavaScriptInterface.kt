package com.athul97.wordcloud

import android.content.Context



    /**
     * The type Javascript interface.
     */
    class JavascriptInterface
    /**
     * Instantiate the interface and set the context
     *
     * @param c the c
     */(private val mContext: Context) {
        private var mCloudTitle: String? = null

        /**
         * Gets cloud string.
         *
         * @return the cloud string
         */
        @get:android.webkit.JavascriptInterface
        var cloudString: String? = null
            private set

        /**
         * Gets cloud font.
         *
         * @return the cloud font
         */
        @get:android.webkit.JavascriptInterface
        var cloudFont: String? = null
            private set

        /**
         * Gets parent width.
         *
         * @return the parent width
         */
        @get:android.webkit.JavascriptInterface
        var parentWidth = 0
            private set

        /**
         * Gets parent height.
         *
         * @return the parent height
         */
        @get:android.webkit.JavascriptInterface
        var parentHeight = 0
            private set

        /**
         * Sets cloud params.
         *
         * @param mCloudTitle  the m cloud title
         * @param mCloudString the m cloud string
         * @param mCloudFont   the m cloud font
         * @param parentWidth  the parent width
         * @param parentHeight the parent height
         */
        fun setCloudParams(
            mCloudTitle: String?, mCloudString: String?,
            mCloudFont: String?, parentWidth: Int, parentHeight: Int
        ) {
//        Log.d(TAG, "setCloudParams() called with: mCloudTitle = [" + mCloudTitle + "], mCloudString = [" + mCloudString + "], mCloudFont = [" + mCloudFont + "], parentWidth = [" + parentWidth + "], parentHeight = [" + parentHeight + "]");
            this.mCloudTitle = mCloudTitle
            cloudString = mCloudString
            cloudFont = mCloudFont
            this.parentHeight = parentHeight
            this.parentWidth = parentWidth
        }

        companion object {
            private const val TAG = "JavascriptInterface"
        }
    }

