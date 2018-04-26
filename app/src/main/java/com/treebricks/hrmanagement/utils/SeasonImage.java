package com.treebricks.hrmanagement.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.util.Calendar;
import java.util.Date;
import com.treebricks.hrmanagement.R;

public class SeasonImage {
    public static Drawable getThisSeasonImage(Context context) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int month = calendar.get(Calendar.MONTH);

        Drawable drawable = null;

        switch (month)
        {
            case 0:
                drawable = context.getResources().getDrawable(R.drawable.d_january);
                break;
            case 1:
                drawable = context.getResources().getDrawable(R.drawable.d_february);
                break;
            case 2:
                drawable = context.getResources().getDrawable(R.drawable.d_march);
                break;
            case 3:
                drawable = context.getResources().getDrawable(R.drawable.d_april);
                break;
            case 4:
                drawable = context.getResources().getDrawable(R.drawable.d_may);
                break;
            case 5:
                drawable = context.getResources().getDrawable(R.drawable.d_june);
                break;
            case 6:
                drawable = context.getResources().getDrawable(R.drawable.d_july);
                break;
            case 7:
                drawable = context.getResources().getDrawable(R.drawable.d_august);
                break;
            case 8:
                drawable = context.getResources().getDrawable(R.drawable.d_september);
                break;
            case 9:
                drawable = context.getResources().getDrawable(R.drawable.d_october);
                break;
            case 10:
                drawable = context.getResources().getDrawable(R.drawable.d_november);
                break;
            case 11:
                drawable = context.getResources().getDrawable(R.drawable.d_december);
                break;
            default:
                drawable = context.getResources().getDrawable(R.drawable.d_january);
                break;
        }
        return drawable;
    }
}
