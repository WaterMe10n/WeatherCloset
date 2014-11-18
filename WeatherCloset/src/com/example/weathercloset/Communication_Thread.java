package com.example.weathercloset;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.os.Message;

public class Communication_Thread extends Thread {
	protected String ret = ""; // xml�뿉�꽌 諛쏆븘�삩 TEXT瑜� �엫�떆濡� 諛쏅뒗 蹂��닔
	protected String tagname = ""; // xml�쓽 �깭洹몃꽕�엫�쓣 �쐞�븳 蹂��닔
	protected String url; // url
	protected int eventType;

	protected EventHandler mHandler; // �씠踰ㅽ듃 �빖�뱾�윭
	protected Message msg; // 硫붿떆吏�
	protected Context mcontext; // �븸�떚鍮꾪떚 媛앹껜

	protected int menu; // �뼱�뼡 �젙蹂대�� 泥섎━�븷吏� �쐞�븳 蹂��닔

	// 湲곕낯 �깮�꽦�옄
	public Communication_Thread(Context context, int menu) {
		this.mHandler = new EventHandler(context);
		this.msg = mHandler.obtainMessage();
		this.mcontext = context; // �븸�떚鍮꾪떚 媛앹껜
		this.menu = menu; // �뼱�뼡 �옉�뾽�쓣 �븷 寃껋씤媛�
		this.url = "http://14.63.172.125/Weathercloset/menu.php?menu=" + menu;
	}

	// �뒪�젅�뱶 湲곕낯 �븿�닔
	@Override
	public void run() {
		try {
			xmlParser(connect(url)); // XML �뙆�떛 �븿�닔
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// �꽌踰꾩� �넻�떊�븯�뒗 �븿�닔
	public XmlPullParser connect(String url) {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet httpMethod = new HttpGet(url); // url
			HttpResponse response = client.execute(httpMethod); // �꽌踰꾩� �넻�떊
			InputStream is = response.getEntity().getContent();

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance(); // xmlPullparser瑜� �쐞�븳 以�鍮꾧낵�젙.
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(is, "UTF-8"); // �씤肄붾뵫 諛⑹떇 �꽕�젙

			return xpp;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	// �냼酉대쪟 諛쏆븘�삤�뒗 �븿�닔
	public void xmlParser(XmlPullParser xpp) {

	}

}
