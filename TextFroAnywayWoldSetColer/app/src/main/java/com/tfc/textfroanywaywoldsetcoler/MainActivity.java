package com.tfc.textfroanywaywoldsetcoler;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * tfc
 */
public class MainActivity extends AppCompatActivity {
    private TextView test_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_tv = (TextView) findViewById(R.id.test_tv);
        String source="AABAACAAABDFC";
        String setString[]={"AA","B","C"};
        setTextStyleColor(setString,Color.BLUE,source,test_tv);
    }

    /**
     * 此方法还可以拓展 为指定文字设置不同的 颜色
     *
     * @param setString 需要设置颜色的文字
     * @param color     文字颜色
     * @param source    源文字
     * @param textView
     */
    public void setTextStyleColor(String setString[], int color, String source, TextView textView) {
        int index = 0;
        SpannableStringBuilder style = new SpannableStringBuilder(source);
        if (setString != null && setString.length > 0) {
            for (String setStr : setString) {

                String temp = source;

                while (true) {

                    if (temp.indexOf(setStr) >= 0) {
                        index++;
                        int start = (source.length() - temp.length()) + temp.indexOf(setStr);
                        int end = start + setStr.length();
                        style.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                        textView.setText(style);
                        temp = source.substring(end, source.length());

                    } else {
                        if (index <= 0) {
                            textView.setText(source);
                        }
                        break;
                    }

                }
            }

        }
    }
}
