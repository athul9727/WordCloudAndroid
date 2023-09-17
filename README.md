# WordCloudAndroid
WordCloudAndroid in kotlin

## Installation

**Gradle**

```gradle
dependencies {
    implementation "com.github.athul9727:WordCloudAndroid:1.0.0"
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
 val wordCloudView: WordCloudView = findViewById(R.id.wordcloud)
        wordCloudView.setDataSet(testData)
        wordCloudView.notifyDataSetChanged()
```

And make sure to call `notifyDataSetChanged` to update view.

## Additional Options
###Setting Color

there's two option to change the colors, either by passing an array of `int` or by using a predefined colors from `ColorTemplate` class

```kotlin
wordCloudView.setColors(ColorTemplate.MATERIAL_COLORS);
//OR
wordCloudView.setColors(new int[] {Color.BLUE, Color.GRAY, Color.GREEN, Color.CYAN });
```
###Setting Scale Values

```kotlin
wordCloudView.setScale(MAX,MIN);
```


## Credits
- [d3-cloud](https://github.com/jasondavies/d3-cloud)
- https://github.com/alhazmy13/AndroidWordCloud



