package com.firecontrolmanual.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firecontrolmanual.R;

/**
 * 
 * @author: Created by Lemon on 2015��6��28�� ����9:09:17
 * @Description: ��¼����
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
	
	private static final String TAG = "LoginActivity";
	/** �������밴ť*/
	private TextView tvForgetPass;
	/** �û��������*/
	private EditText etUserName;
	/** ���������*/
	private EditText etPassWord;
	/** ��¼��ť*/
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
			//��������
			
			break;
		case R.id.tvLogin:
			//��¼��ť
			
			break;
		default:
			break;
		}
	}

}
