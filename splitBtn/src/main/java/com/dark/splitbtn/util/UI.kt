package com.dark.splitbtn.util;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

public class UI {

    private final Context context;

    public UI(Context context) {
        this.context = context;
    }

    public GradientDrawable setBackground(int backgroundColor, float[] cornerRadius, int sWidth, int sColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(backgroundColor);
        drawable.setCornerRadii(cornerRadius);
        drawable.setStroke(sWidth, sColor);
        return drawable;
    }

    public GradientDrawable setBackground(int backgroundColor, float[] cornerRadius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(backgroundColor);
        drawable.setCornerRadii(cornerRadius);
        return drawable;
    }



    public GradientDrawable setBackground(int backgroundColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(backgroundColor);
        return drawable;
    }

    public int dpToPx(float dp) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }

    public int pxToDp(float px) {
        return Math.round(px / context.getResources().getDisplayMetrics().density);
    }

    public float[] rad(float r) {
        return new float[]{r, r, r, r, r, r, r, r};
    }

    public float[] rad(float tl, float tr, float bl, float br) {
        return new float[]{tl, tl, tr, tr, br, br, bl, bl};
    }

    public int getResColor(@ColorRes int id) {
        return ContextCompat.getColor(context, id);
    }

    public Drawable getResDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(context, id);
    }

    public void changeStatusBarColor(int color, Activity activity, boolean nav) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(color);
        if (nav) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsetsController controller = window.getInsetsController();
            assert controller != null;
            controller.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);
        } else {
            View decorView = window.getDecorView();
            int flags = decorView.getSystemUiVisibility();
            flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(flags);
        }
    }

    public void spanTxt(TextView txt, String s, int start, int end, int color) {
        SpannableString spannableString = new SpannableString(s);
        spannableString.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt.setText(spannableString);
    }

    public void fadeOutView(View view) {
        Animation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setInterpolator(new DecelerateInterpolator());
        fadeOut.setDuration(300);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // No action needed here
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // No action needed here
            }
        });

        view.startAnimation(fadeOut);
    }

    public void fadeInView(View view) {
        view.setVisibility(VISIBLE);
        Animation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(500);
        view.startAnimation(fadeIn);
    }


}
