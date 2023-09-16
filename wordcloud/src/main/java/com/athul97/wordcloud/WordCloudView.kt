package com.athul97.wordcloud

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import java.util.Random
import java.util.Timer
import java.util.logging.Handler
import kotlin.concurrent.schedule

class WordCloudView(private val mContext: Context, attrs: AttributeSet?) : WebView(mContext, attrs) {
        private var dataSet: List<WordCloud>
        private var old_min = 0
        private var old_max = 0
        private var colors: IntArray
        private val random: Random
        private var parentHeight: Int
        private var parentWidth: Int
        private var max: Int
        private var min: Int
        private var rotation:RotationType = RotationType.VERTICAL_HORIZONTAL
        private var wordCallback: (result: String?) -> Unit = {}


        /**
         * Instantiates a new Word cloud view.
         *
         * @param context the context
         * @param attrs   the attrs
         */
        init {
            dataSet = ArrayList()
            parentHeight = 350
            parentWidth = 350
            max = 100
            min = 20
            colors = ColorTemplate.MATERIAL_COLORS
            random = Random()
            //  init();
        }

        /**
         * Init.
         */
        @SuppressLint("AddJavascriptInterface", "SetJavaScriptEnabled")
        fun init() {
            val myJavascriptInterface = JavascriptInterface(mContext)
            Log.d("CloudString::", data)
            myJavascriptInterface.setCloudParams("", data, "FreeSans", parentWidth, parentHeight,rotation,wordCallback)
            addJavascriptInterface(myJavascriptInterface, "jsinterface")
            val webSettings = settings
            webSettings.builtInZoomControls = false
            webSettings.javaScriptEnabled = true
            // Use HTML5 localstorage to maintain app state
            webSettings.defaultTextEncodingName = "utf-8"
            this.clearCache(true)
            this.clearHistory()
            webSettings.cacheMode = WebSettings.LOAD_NO_CACHE;
            webSettings.allowFileAccess = false
            webSettings.loadWithOverviewMode = false
            webSettings.useWideViewPort = true
            webSettings.userAgentString = "Android"
            loadUrl("file:///android_asset/wordcloud.html")

        }

        /**
         * Sets data set.
         *
         * @param dataSet the data set
         */
        fun setDataSet(dataSet: List<WordCloud>) {
            this.dataSet = dataSet
        }

        fun setRotationType(rotationType: RotationType){
            this.rotation = rotationType
        }
        fun getWordClicked(wordCallback: (result: String?) -> Unit){
            this.wordCallback = wordCallback
        }

        /**
         * Notify data set changed.
         */
        fun notifyDataSetChanged() {
            updateMaxMinValues()
            init()

        }

        /**
         * Gets data.
         *
         * @return the data
         */
        private val data: String
            get() {
                val sb = StringBuilder()
                sb.append("[")
                for (i in dataSet.indices) {
                    sb.append("{\"word\":\"").append(dataSet[i].text)
                    sb.append("\",\"size\":\"").append(scale(dataSet[i].weight))
                    sb.append("\",\"color\":\"")
                    if(dataSet[i].color==null) {
                        sb.append(color)
                    }
                    else{
                        sb.append(dataSet[i].color)
                    }
                        sb.append("\"}")
                    if (i < dataSet.size - 1) {
                        sb.append(",")
                    }

                }
                sb.append("]")
                return sb.toString()
            }

        @Deprecated("Deprecated in Java")
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            parentWidth = MeasureSpec.getSize(widthMeasureSpec)
            parentHeight = MeasureSpec.getSize(heightMeasureSpec)
            setMeasuredDimension(parentWidth, parentHeight)
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }


        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            parentWidth = w
            parentHeight = h
            super.onSizeChanged(w, h, oldw, oldh)
        }

        private fun scale(inputY: Int): Float {
            val x = (inputY - old_min).toFloat()
            val y = (old_max - old_min).toFloat()
            val percent = x / y
            return percent * (max - min) + min
        }

        private fun updateMaxMinValues() {
            old_min = Int.MAX_VALUE
            old_max = Int.MIN_VALUE
            for (wordCloud in dataSet) {
                if (wordCloud.weight < old_min) {
                    old_min = wordCloud.weight
                }
                if (wordCloud.weight > old_max) {
                    old_max = wordCloud.weight
                }
            }
        }

        fun setColors(colors: IntArray) {
            this.colors = colors
        }

        private val color: String
            get() = if (colors.isEmpty()) "0" else "#" + Integer.toHexString(
                colors[random.nextInt(colors.size - 1)]
            ).substring(2)

        /**
         * View size.
         *
         * @param width  the width
         * @param height the height
         */
        fun setSize(width: Int, height: Int) {
            parentWidth = width
            parentHeight = height
        }

        fun setScale(max: Int, min: Int) {
            if (min > max) {
                throw RuntimeException("MIN scale cannot be larger than MAX")
            }
            this.max = max
            this.min = min
        }
    }
