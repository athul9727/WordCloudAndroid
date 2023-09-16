package com.athul97.wordcloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var wordCloudView: WordCloudView
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

        wordCloudView = findViewById(R.id.wordcloud)
        wordCloudView.setDataSet(testData)
        wordCloudView.setColors(ColorTemplate.MATERIAL_COLORS);
        wordCloudView.notifyDataSetChanged()

    }
}