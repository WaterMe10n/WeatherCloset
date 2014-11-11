package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup extends Activity  implements OnClickListener{

	private EditText Etext_id, Etext_nck, Etext_pw, Etext_cpw, Etext_age;
	private RadioGroup Radiog_sex;
	private RadioButton Radiob_sex;
	private Button backBtn;
	private Spinner Spinner_City;
	private String msg_id, msg_nck, msg_pw, msg_cpw, msg_age, msg_sex; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Etext_id = (EditText) findViewById(R.id.newid);
        Etext_nck = (EditText) findViewById(R.id.newnickname);
        Etext_pw = (EditText) findViewById(R.id.newpw);
        Etext_cpw = (EditText) findViewById(R.id.confirmpw);
        Etext_age = (EditText) findViewById(R.id.newage);
        Radiog_sex = (RadioGroup) findViewById(R.id.radioGroupGender);
        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        
        Spinner_City =(Spinner)findViewById(R.id.s_city);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(
        		this, R.array.city, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_City.setAdapter(adapter1);

        
 }
  
    public void onClick(View v) {
		// TODO Auto-generated method stub
		//통신
		switch (v.getId()) {
			case R.id.backBtn:
				String sID = Etext_id.getText().toString();
				String sNNAME = Etext_nck.getText().toString();
				String sPW = Etext_pw.getText().toString();
				String sCPW = Etext_cpw.getText().toString();
				String sAGE = Etext_age.getText().toString();
				
				Radiob_sex = (RadioButton)findViewById(Radiog_sex.getCheckedRadioButtonId());	//적당해요, 추워요, 더워요
				Radiob_sex.setOnClickListener(this);
				String sSex=Radiob_sex.getText().toString();
				
				Log.i("MyTag","000 >> ");
				// �씠踰ㅽ듃 �썑 �넻�떊�뒪�젅�뱶
				
				signup_thread sThread = new signup_thread(Signup.this, 11, sID, sNNAME, sPW, sCPW, sAGE, sSex);
				sThread.start();
				
				break;
			default:
				break;
		}
	}
	public void setItem(int what,String message){
 		if(what == 0){
 			msg_id = message;
 		}
 		else if(what == 1){
 			msg_nck = message;
 		}
 		else if(what == 2){
 			msg_pw = message;
 		}
 		else if(what == 3){
 			msg_cpw = message;
 		}
 		else if(what == 4){
 			msg_age = message;
 		}
 		else if(what == 5){
 			msg_sex = message;
 		}
  	}
 	
 	// �넻�떊 �썑�뿉 UI 嫄대뱶由� 硫붿냼�뱶
 	public void setView(){
 		Log.i("MyTag","666 >> ");
 		if(msg_pw==msg_cpw)
 		{
		Intent  intent = new Intent(Signup.this, Output1Activity.class);
		intent.putExtra("ID",msg_id);
		intent.putExtra("NICKNAME",msg_nck);
		intent.putExtra("PASSWORD",msg_pw);
		intent.putExtra("CONFIRM PW",msg_cpw);
		intent.putExtra("AGE",msg_age);
		intent.putExtra("SEX",msg_sex);
 		startActivity(intent);
 		}
 		else if(msg_pw!=msg_cpw)
 		{
 			String errorMessage="비밀번호가 일치하지 않습니다.";
			Toast toast = Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT);
			toast.show();
		}
	}
}