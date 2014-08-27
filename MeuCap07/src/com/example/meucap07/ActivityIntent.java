package com.example.meucap07;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityIntent extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		if(extras != null)
		{
			String msg = extras.getString("mensagem");
			TextView text = new TextView(this);
			text.setText("Esta é a Activity1\nMensagem: " + msg);
			setContentView(text);
		}
		else{
			TextView text = new TextView(this);
			text.setText("Esta é a Activity1");
			setContentView(text);
		}
	}

}
