package com.firecontrolmanual.activity;

import android.content.Intent;

import com.example.firecontrolmanual.R;

/**
 * 
 * @author: Created by Lemon on 2015年6月28日 下午9:04:40
 * @Description: 主页入口，暂当闪屏处理
 */
public class MainActivity extends BaseActivity {

	@Override
	protected int getContentView() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initData() {
		startActivity(new Intent(this, LoginActivity.class));
	}

}
