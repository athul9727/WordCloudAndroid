# WordCloudAndroid
WordCloudAndroid

## Installation

**Gradle**

```gradle
dependencies {
	compile 'net.alhazmy13.wordcloud:library:0.2.0-beta'
}
```

## Usage
To use the library, you must include the WordCloudView class in your project. A simple solution is to reference it directly into your layout:

```xml
<net.alhazmy13.wordcloud.WordCloudView
       android:id="@+id/wordCloud"
       android:layout_width="match_parent"
       android:layout_height="match_parent" />
```

Then, within your code, fetch the view and initialize it:

```java
WordCloudView wordCloud = (WordCloudView) findViewById(R.id.wordCloud);
        wordCloud.setDataSet(list);
        wordCloud.notifyDataSetChanged();
```

And make sure to call `notifyDataSetChanged` to update view.

## Additional Options
###Setting Color

there's two option to change the colors, either by passing an array of `int` or by using a predefined colors from `ColorTemplate` class

```java
wordCloud.setColors(ColorTemplate.MATERIAL_COLORS);
//OR
wordCloud.setColors(new int[] {Color.BLUE, Color.GRAY, Color.GREEN, Color.CYAN });
```
###Setting Scale Values

```java
wordCloud.setScale(MAX,MIN);
```

## Features to be added:
- `onClickEvent` for each word.
- ~~Custom color for each word~~.
- Custom font.

## Credits
- [d3-cloud](https://github.com/jasondavies/d3-cloud)



