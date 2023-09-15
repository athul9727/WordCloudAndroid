package com.athul97.wordcloud

import android.content.Context
import android.widget.Toast

class SampleToaster {
    fun msg(con: Context,text:String){
        Toast.makeText(con,text,Toast.LENGTH_SHORT).show()
    }
}