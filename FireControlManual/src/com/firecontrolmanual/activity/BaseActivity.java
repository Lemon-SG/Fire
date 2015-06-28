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
 * @author: Created by Lemon on 2015��6��21�� ����3:24:14
 * @Description: ����Activity�Ļ���
 */
public abstract class BaseActivity extends Activity {
	
	protected Context mContext;
	//TODO ���水�´ߵ���ť��ʱ�䣨�ߵ�����ÿʮ���ӵ���һ�Σ�
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
	 * �޸Ĳ����ı�������ɫ
	 * @param text :��Ҫ�޸ĵ��ı������ֶ�
	 * @param color :ɫֵ
	 * @param startIndex :��Ҫ�޸ĵ����ֿ�ʼ�±�
	 * @param endIindex :��Ҫ�޸ĵ����ֽ����±�
	 * @param isForeground :true->�����ı�ǰ����ɫ  | false->���ñ����ı�������ɫ
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
	 * ʱ������������ֻ�ܵ�99Сʱ������Ҫ����Сʱ����Ҫ�ĸķ���
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
	 * ��ʼ��UI�ؼ�
	 */
	protected abstract void initView();
	/**
	 * ��ʼ������
	 */
	protected abstract void initData();
}



