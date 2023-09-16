package com.athul97.wordcloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var wordCloudView: WordCloudView
    private val testData = listOf<WordCloud>(
        WordCloud("dog",1,"#000"),
        WordCloud("cat",2),
        WordCloud("parrot",3,"#000"),
        WordCloud("crow",4),
        WordCloud("cow",5,"#000")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordCloudView = findViewById(R.id.wordcloud)
        wordCloudView.setDataSet(testData)
        wordCloudView.getWordClicked {
            Log.e("CURRENT_WORD::",it.toString())
        }
        wordCloudView.notifyDataSetChanged()

    }
}