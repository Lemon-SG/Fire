package com.firecontrolmanual.activity;

import android.content.Intent;

import com.example.firecontrolmanual.R;

/**
 * 
 * @author: Created by Lemon on 2015��6��28�� ����9:04:40
 * @Description: ��ҳ��ڣ��ݵ���������
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
