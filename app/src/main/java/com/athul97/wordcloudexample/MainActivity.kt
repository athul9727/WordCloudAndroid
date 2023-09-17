package com.athul97.wordcloudexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.athul97.wordcloud.WordCloud
import com.athul97.wordcloud.WordCloudView

class MainActivity : AppCompatActivity() {

    private val testData = listOf<WordCloud>(
        WordCloud("dog",1),
        WordCloud("cat",2),
        WordCloud("parrot",3),
        WordCloud("crow",4),
        WordCloud("cow",5)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordCloudView: WordCloudView = findViewById(R.id.wordcloud)
        wordCloudView.setDataSet(testData)
        wordCloudView.getWordClicked {
            Log.e("CURRENT_WORD::",it.toString())
        }
        wordCloudView.notifyDataSetChanged()

    }
}