package com.firecontrolmanual.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firecontrolmanual.R;

/**
 * 
 * @author: Created by Lemon on 2015年6月28日 下午9:09:17
 * @Description: 登录界面
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
	
	private static final String TAG = "LoginActivity";
	/** 忘记密码按钮*/
	private TextView tvForgetPass;
	/** 用户名输入框*/
	private EditText etUserName;
	/** 密码输入框*/
	private EditText etPassWord;
	/** 登录按钮*/
	private TextView tvLogin;

	@Override
	protected int getContentView() {
		return R.layout.activity_login;
	}

	@Override
	protected void initView() {
		tvForgetPass = (TextView) findViewById(R.id.tvForgetPass);
		tvForgetPass.setOnClickListener(this);
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPassWord = (EditText) findViewById(R.id.etPassWord);
		tvLogin = (TextView) findViewById(R.id.tvLogin);
		tvLogin.setOnClickListener(this);
	}

	@Override
	protected void initData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tvForgetPass:
			//忘记密码
			
			break;
		case R.id.tvLogin:
			//登录按钮
			
			break;
		default:
			break;
		}
	}

}
