# WordCloudAndroid
WordCloudAndroid in kotlin

[![](https://jitpack.io/v/athul9727/WordCloudAndroid.svg)](https://jitpack.io/#athul9727/WordCloudAndroid)

## Screenshots

![Screenshot_20230917_173436](https://github.com/athul9727/WordCloudAndroid/assets/99319393/4bfbf702-47a1-4851-b61f-26ebee8f19de)


## Installation

**Gradle**

```gradle
dependencies {
    implementation 'com.github.athul9727:WordCloudAndroid:1.8'
}
```

## Usage
To use the library, you must include the WordCloudView class in your project. A simple solution is to reference it directly into your layout:

```xml
<com.athul97.wordcloud.WordCloudView
       android:id="@+id/wordcloud"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"/>
```

Then, within your code, fetch the view and initialize it:

```kotlin

private val testData = listOf<WordCloud>(
        WordCloud("dog",1,"#000"),
        WordCloud("cat",2),
        WordCloud("parrot",3,"#000"),
        WordCloud("crow",4),
        WordCloud("cow",5,"#000")

 val wordCloudView: WordCloudView = findViewById(R.id.wordcloud)
        wordCloudView.setDataSet(testData)
        wordCloudView.notifyDataSetChanged()
```

And make sure to call `notifyDataSetChanged` to update view.

###Setting Color

```kotlin

wordCloudView.setColors(ColorTemplate.LIBERTY_COLORS); // default is ColorTemplate.MATERIAL_COLORS
//OR
wordCloudView.setColors(new int[] {Color.BLUE, Color.GRAY, Color.GREEN, Color.CYAN });
//OR
//set color as hex string for each word as below
WordCloud("dog",1,"#000") //if no color provided then color will be choosen from ColorTemplate 

```
###Setting Scale Values

```kotlin
wordCloudView.setScale(MAX,MIN);
```
###Getting word clicked

```kotlin
      wordCloudView.getWordClicked {
            Log.e("CURRENT_WORD::",it.toString())
        }
```

###Setting Word Rotation Type

setup rotation as vertical, horizontal or both

```kotlin
   //default rotation type is RotationType.VERTICAL_HORIZONTAL
    wordCloudView.setRotationType(RotationType.VERTICAL)
```

###Setting Size

```kotlin
   wordCloudView.setSize(width,height);
```

## Credits
- [d3-cloud](https://github.com/jasondavies/d3-cloud)
- https://github.com/alhazmy13/AndroidWordCloud



