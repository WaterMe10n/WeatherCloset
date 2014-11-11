package com.example.weathercloset;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Posting extends Activity implements OnClickListener{

	private Button Button_Upld;
	private EditText Etext_Exp;
	private RadioGroup Radiog_Status;
	private RadioButton Radiob_Status;
	private String msg_explain, msg_status, msg_city, msg_outer, msg_top, msg_bottoms, msg_onepiece, msg_acc;
	private ImageButton Imageb_Upimg;
	private Spinner Spinner_City, Spinner_Outer, Spinner_Top, 
					Spinner_Bottoms, Spinner_Onepiece, Spinner_Acc;
	private static final int CAMERA_CAPTURE=1;
	private Uri picUri;
	final int PIC_CROP = 2;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        Etext_Exp = (EditText) findViewById(R.id.explain);
        Radiog_Status = (RadioGroup) findViewById(R.id.rg_status);
		Button_Upld = (Button) findViewById(R.id.btn_upload);
        Button_Upld.setOnClickListener(this);
        
       Spinner();
       
        // 업로드 이미지 설정
        Imageb_Upimg=(ImageButton)findViewById(R.id.imageButton1);
        Imageb_Upimg.setOnClickListener(this);
 
        // 업로드 이미지 설정 끝
	}
	
	public void Spinner(){
		 // Spinner 설정
        Spinner_City =(Spinner)findViewById(R.id.s_city);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(
        		this, R.array.city, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_City.setAdapter(adapter1);
        
        Spinner_Outer =(Spinner)findViewById(R.id.s_outer);
        ArrayAdapter adapter2=ArrayAdapter.createFromResource(
        		this, R.array.outer, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Outer.setAdapter(adapter2);
        
        Spinner_Top =(Spinner)findViewById(R.id.s_top);
        ArrayAdapter adapter3=ArrayAdapter.createFromResource(
        		this, R.array.top, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Top.setAdapter(adapter3);
        
        Spinner_Bottoms =(Spinner)findViewById(R.id.s_bottoms);
        ArrayAdapter adapter4=ArrayAdapter.createFromResource(
        		this, R.array.bottoms, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Bottoms.setAdapter(adapter4);
        
        Spinner_Onepiece =(Spinner)findViewById(R.id.s_onepiece);
        ArrayAdapter adapter5=ArrayAdapter.createFromResource(
        		this, R.array.onepiece, android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Onepiece.setAdapter(adapter5);
        
        Spinner_Acc =(Spinner)findViewById(R.id.s_acc);
        ArrayAdapter adapter6=ArrayAdapter.createFromResource(
        		this, R.array.acc, android.R.layout.simple_spinner_dropdown_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Acc.setAdapter(adapter6);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

   	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode==RESULT_OK){
			if(requestCode==CAMERA_CAPTURE){
				picUri = data.getData();
				performCrop();
			}
			else if(requestCode==PIC_CROP){
				//get the returned data
				Bundle extras = data.getExtras();
				//get the cropped bitmap
				Bitmap thePic = extras.getParcelable("data");
				//retrieve a reference to the ImageView
				ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton1);
				//display the returned cropped image
				Imageb_Upimg.setImageBitmap(thePic);
			}
		}
	}
	private void performCrop(){
		try {
		    //call the standard crop action intent (the user device may not support it)
			Intent cropIntent = new Intent("com.android.camera.action.CROP"); 
			    //indicate image type and Uri
			cropIntent.setDataAndType(picUri, "image/*");
			    //set crop properties
			cropIntent.putExtra("crop", "true");
			    //indicate aspect of desired crop
			cropIntent.putExtra("aspectX", 1);
			cropIntent.putExtra("aspectY", 1);
			    //indicate output X and Y
			cropIntent.putExtra("outputX", 256);
			cropIntent.putExtra("outputY", 256);
			    //retrieve data on return
			cropIntent.putExtra("return-data", true);
			    //start the activity - we handle returning in onActivityResult
			startActivityForResult(cropIntent, PIC_CROP);
		}
		catch(ActivityNotFoundException anfe){
		    //display an error message
		    String errorMessage = "Whoops - your device doesn't support the crop action!";
		    Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
		    toast.show();
		}
		 
	}
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//카메라
		if(v.getId()==R.id.imageButton1){
			try{
				Intent capintent= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(capintent, CAMERA_CAPTURE);
			}
			catch(ActivityNotFoundException anfe){
				String errorMessage="Whoops - your device doesn't support capturing images!";
				Toast toast = Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT);
				toast.show();
			}
		}
		
		//통신
		switch (v.getId()) {
			case R.id.btn_upload:
				String sExplain = Etext_Exp.getText().toString();	//설명 추가 부분
				
				Radiob_Status = (RadioButton)findViewById(Radiog_Status.getCheckedRadioButtonId());	//적당해요, 추워요, 더워요
				Radiob_Status.setOnClickListener(this);
				String sStatus=Radiob_Status.getText().toString();
				
				String sCity=Spinner_City.getSelectedItem().toString();
				String sOuter=Spinner_Outer.getSelectedItem().toString();
				String sTop=Spinner_Top.getSelectedItem().toString();
				String sBottoms=Spinner_Bottoms.getSelectedItem().toString();
				String sOnepiece=Spinner_Onepiece.getSelectedItem().toString();
				String sAcc=Spinner_Acc.getSelectedItem().toString();
				
				Log.i("MyTag","000 >> ");
				// �씠踰ㅽ듃 �썑 �넻�떊�뒪�젅�뱶
				
				posting_thread pThread = new posting_thread(Posting.this, 10, sExplain, sStatus, sCity, sOuter, sTop,sBottoms, sOnepiece, sAcc);
				pThread.start();
				
				break;
			default:
				break;
		}
	}
    // �넻�떊 以묒뿉 蹂��닔 ���옣�븯�뒗 硫붿냼�뱶
 	public void setItem(int what,String message){
 		if(what == 0){
 			msg_explain = message;
 		}
 		else if(what == 1){
 			msg_status = message;
 		}
 		else if(what == 2){
 			msg_city = message;
 		}
 		else if(what == 3){
 			msg_outer = message;
 		}
 		else if(what == 4){
 			msg_top = message;
 		}
 		else if(what == 5){
 			msg_bottoms = message;
 		}
 		else if(what == 6){
 			msg_onepiece = message;
 		}
 		else if(what == 7){
 			msg_acc = message;
 		}
  	}
 	
 	// �넻�떊 �썑�뿉 UI 嫄대뱶由� 硫붿냼�뱶
 	public void setView(){
 		Log.i("MyTag","666 >> ");
		Intent  intent = new Intent(Posting.this, OutputActivity.class);
		intent.putExtra("Explain",msg_explain);
		intent.putExtra("Status",msg_status);
		intent.putExtra("City",msg_city);
		intent.putExtra("outer",msg_outer);
		intent.putExtra("top",msg_top);
		intent.putExtra("bottoms",msg_bottoms);
		intent.putExtra("onepiece",msg_onepiece);
		intent.putExtra("acc",msg_acc);
 		startActivity(intent);
	}

}
