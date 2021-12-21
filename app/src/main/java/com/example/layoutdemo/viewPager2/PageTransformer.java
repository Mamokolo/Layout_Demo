package com.example.layoutdemo.viewPager2;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class PageTransformer implements ViewPager2.PageTransformer {
    private final float MIN_ALPHA = 0.5f;
    private final float MIN_SCALE = 0.5f;
    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if(position < -1 || position > 1){
            page.setAlpha(MIN_ALPHA);
        }
        else{
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vMargin = pageHeight * (1 - scaleFactor) / 2;
            float hMargin = pageWidth * (1 - scaleFactor) / 2;
            if(position < 0){
                page.setAlpha(MIN_ALPHA + ( 1 + position ) * ( 1 - MIN_ALPHA ));
                page.setTranslationX(hMargin - vMargin / 2);
            }
            else {
                page.setAlpha(MIN_ALPHA + ( 1 - position ) * ( 1 - MIN_ALPHA ));
                page.setTranslationX(-hMargin + vMargin / 2);
            }
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
    }
}
