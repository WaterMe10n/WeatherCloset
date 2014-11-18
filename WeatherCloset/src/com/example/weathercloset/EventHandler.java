package com.example.weathercloset;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class EventHandler extends Handler {
	Context mcontext;

	// 湲곕낯 �깮�꽦�옄
	public EventHandler() {
	}

	// �깮�꽦�옄
	public EventHandler(Context context) {
		this.mcontext = context; // �븸�떚鍮꾪떚 媛앹껜
//		this.mcontext2 = context; // �븸�떚鍮꾪떚 媛앹껜

	}

	public void handleMessage(Message msg) {
		try {
			if (msg.what == 10) {	// �꽦怨�
				((Posting) mcontext).setView();
			} else if (msg.what == -10) {	// �떎�뙣
				//
			} else if (msg.what == 11) {	//  �꽦怨�
				((Signup) mcontext).setView();
			} else if (msg.what == -11) {	//  �떎�뙣
				// �떎�뙣�뿉 ���븳 硫붿냼�뱶
			}

		} catch (Exception e) {
			
		}
		return;
	}
}

