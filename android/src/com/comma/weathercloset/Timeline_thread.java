package com.example.weathercloset;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.util.Log;

public class Timeline_thread extends Communication_Thread{

	public Timeline_thread(Context context, int menu, 
			String signup, String signup2, String signup3, String signup4,String signup5,String signup6) {
		super(context, menu);
		Log.i("MyTag","111 >> ");
		url += "&signup=" + signup + "&signup2=" + signup2 + "&signup3=" + signup3 + "&signup4=" + signup4+ 
				"&signup5=" + signup5+ "&signup6=" + signup6;
	}
	
	// �냼酉대쪟 諛쏆븘�삤�뒗 �븿�닔
	public void xmlParser(XmlPullParser xpp) {
		// ------------------------------------- xml �뙆�꽌 ------------------------------------//
		try {
			eventType = xpp.getEventType(); // �씠踰ㅽ듃 ���엯 �뼸�뼱�삤湲� �삁瑜쇰뱾�뼱 <start> �씤吏� </start> �씤吏� 援щ텇�븯湲� �쐞�븳.
			while (eventType != XmlPullParser.END_DOCUMENT) { // xml�씠 �걹�궇�븣源뚯� 怨꾩냽 �룎由곕떎.
				if (eventType == XmlPullParser.START_TAG) {
					tagname = xpp.getName(); // �깭洹몃�� 諛쏆븘�삩�떎.
				} else if (eventType == XmlPullParser.TEXT) {
					if (tagname.equals("signup_message")||tagname.equals("signup2_message")||tagname.equals("signup3_message")||tagname.equals("signup4_message")
							||tagname.equals("signup5_message")||tagname.equals("signup6_message")) {
						ret = xpp.getText(); // id �깭洹몄뿉 �빐�떦�릺�뒗 TEXT瑜� �엫�떆濡� ���옣
					}
				} else if (eventType == XmlPullParser.END_TAG) {
					// �깭洹멸� �떕�엳�뒗 遺�遺꾩뿉�꽌 �엫�떆 ���옣�맂 TEXT瑜� Array�뿉 ���옣�븳�떎.
					tagname = xpp.getName();
					if(tagname.equals("signup_message")){
						((Signup) mcontext).setItem(0, ret);
						Log.i("MyTag","222 >> " + ret);
					}
					else if(tagname.equals("signup2_message")){
						((Signup) mcontext).setItem(1, ret);
						Log.i("MyTag","333 >> " + ret);
					}
					else if(tagname.equals("signup3_message")){
						((Signup) mcontext).setItem(2, ret);
						Log.i("MyTag","444 >> " + ret);
					}
					else if(tagname.equals("signup4_message")){
						((Signup) mcontext).setItem(3, ret);
						Log.i("MyTag","555 >> " + ret);
					}
					else if(tagname.equals("signup5_message")){
						((Signup) mcontext).setItem(4, ret);
						Log.i("MyTag","666 >> " + ret);
					}
					else if(tagname.equals("signup6_message")){
						((Signup) mcontext).setItem(5, ret);
						Log.i("MyTag","777 >> " + ret);
					}
				}
				eventType = xpp.next();
			} // end while

			
			msg.what = 11;		// �넻�떊�씠 �걹�굹怨� �떎�뻾�븷 寃쎌슦
			mHandler.sendMessage(msg); // Handler�뿉 �떎�쓬 �닔�뻾�븷 �옉�뾽�쓣 �꽆湲대떎
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
