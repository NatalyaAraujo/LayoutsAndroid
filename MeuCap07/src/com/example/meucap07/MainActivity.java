package com.example.meucap07;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	TouchScreenView tsv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touch_screen_layout);
		
		tsv = (TouchScreenView) findViewById(R.id.touch);
		
		Button botaoImage1 = (Button) findViewById(R.id.direita);
		botaoImage1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(MainActivity.this, "Image 1 ok", Toast.LENGTH_SHORT).show();
				tsv.onClick(v);
			}
		});
		
		Button intents = (Button) findViewById(R.id.intent);
		intents.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("INTENT", "METODO ON CLICK");
				// TODO Auto-generated method stub
				Intent it = new Intent("ACAO_TESTE");
				it.putExtra("mensagem", "Mensagem de teste");
				startActivity(it);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
