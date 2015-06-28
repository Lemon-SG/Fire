package com.firecontrolmanual.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.widget.Toast;
/**
 *
 * @author: Created by Lemon on 2015年6月21日 下午3:24:14
 * @Description: 所有Activity的基类
 */
public abstract class BaseActivity extends Activity {
	
	protected Context mContext;
	//TODO 保存按下催单按钮的时间（催单功能每十分钟调用一次）
	protected static long PRESS_BTN_TIME;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mContext = this;
		setContentView(getContentView());
		initView();
		initData();
	}
	
	/***
	 * TOAST
	 * @param msg
	 */
	protected void prompt(String msg) {
		if(mContext != null) {
			Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
		}
	}
	/***
	 * TOAST
	 * @param StringId
	 */
	protected void prompt(int StringId) {
		if(mContext != null) {
			Toast.makeText(mContext, StringId, Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public final void startActivity(Intent intent) {
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
		super.startActivity(intent);
	}
	
	/***
	 * 修改部分文本字体颜色
	 * @param text :需要修改的文本整体字段
	 * @param color :色值
	 * @param startIndex :需要修改的文字开始下标
	 * @param endIindex :需要修改的文字结束下标
	 * @param isForeground :true->设置文本前景颜色  | false->设置背景文本背景颜色
	 * @return
	 */
	protected SpannableStringBuilder ModifyTextpartColor(String text, int color, int startIndex, int endIindex, Boolean isForeground) {
		SpannableStringBuilder builder = new SpannableStringBuilder(text);
		if(isForeground) {
			ForegroundColorSpan span= new ForegroundColorSpan(color);
			builder.setSpan(span, startIndex, endIindex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}else{
			BackgroundColorSpan span= new BackgroundColorSpan(color);
			builder.setSpan(span, startIndex, endIindex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		return builder;
	}
	
	/**
	 * 时间计数器，最多只能到99小时，如需要更大小时数需要改改方法
	 * @param time
	 * @return
	 */
	protected String showTimeCount(long time) {
		System.out.println("time=" + time);
		if (time >= 360000000) {
			return "00:00:00";
		}
		String timeCount = "";
		long hourc = time / 3600000;
		String hour = "0" + hourc;
		System.out.println("hour=" + hour);
		hour = hour.substring(hour.length() - 2, hour.length());
		System.out.println("hour2=" + hour);

		long minuec = (time - hourc * 3600000) / (60000);
		String minue = "0" + minuec;
		System.out.println("minue=" + minue);
		minue = minue.substring(minue.length() - 2, minue.length());
		System.out.println("minue2=" + minue);

		long secc = (time - hourc * 3600000 - minuec * 60000) / 1000;
		String sec = "0" + secc;
		System.out.println("sec=" + sec);
		sec = sec.substring(sec.length() - 2, sec.length());
		System.out.println("sec2=" + sec);
		timeCount = hour + ":" + minue + ":" + sec;
		System.out.println("timeCount=" + timeCount);
		return timeCount;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	protected abstract int getContentView();
	/**
	 * 初始化UI控件
	 */
	protected abstract void initView();
	/**
	 * 初始化数据
	 */
	protected abstract void initData();
}



