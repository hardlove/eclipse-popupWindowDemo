package com.example.popupwindowdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Open(View v) {
		showPopwindow();
	}
	
	
	/**
	 * ��ʾpopupWindow
	 */
	private void showPopwindow() {
		// ����layoutInflater���View
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.popuwindow_layout, null);

		// ���������ַ����õ���Ⱥ͸߶� getWindow().getDecorView().getWidth()

		PopupWindow window = new PopupWindow(view,
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.WRAP_CONTENT);

		// ����popWindow��������ɵ������仰������ӣ�������true
		window.setFocusable(true);


		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		window.setBackgroundDrawable(dw);

		
		// ����popWindow����ʾ����ʧ����
		window.setAnimationStyle(R.style.mypopwindow_anim_style);
		// �ڵײ���ʾ
		window.showAtLocation(MainActivity.this.findViewById(R.id.start),
				Gravity.BOTTOM, 0, 0);

		// �������popWindow���button�Ƿ���Ե��
		Button first = (Button) view.findViewById(R.id.first);
		first.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("��һ����ť�������");
			}
		});
		
		//popWindow��ʧ��������
		window.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss() {
				System.out.println("popWindow��ʧ");
			}
		});

	}

}
