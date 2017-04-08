package com.example.slidingmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getWindow().setBackgroundDrawableResource(R.mipmap.pic5);
    }

    private void initView() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(R.layout.sliding_menu);
        //获得屏幕宽度方法一
        int i = this.getWindowManager().getDefaultDisplay().getWidth() / 8;
        //获得屏幕宽度方法二
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth() / 2;
        //获得屏幕宽度方法三
        int widthPixels = getResources().getDisplayMetrics().widthPixels / 4;
        //   slidingMenu.setBehindOffset(i);//i是activity占整个屏幕的宽度
        slidingMenu.setBehindWidth(width);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setBehindScrollScale(0.5f);

    }
}
