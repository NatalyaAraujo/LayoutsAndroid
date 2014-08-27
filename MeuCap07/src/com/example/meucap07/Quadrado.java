package com.example.meucap07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Quadrado extends View 
{
	private Paint picelVermelho;
	private Paint picelPreto;
	private Paint picelAzul;
	
	public Quadrado(Context context) {
		// TODO Auto-generated constructor stub
		this(context, null);
	}
	
	public Quadrado(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, attrs);
		setBackgroundColor(Color.LTGRAY);
		//vermelho
		picelVermelho = new Paint();
		picelVermelho.setARGB(255, 255, 0, 0);
		//preto
		picelPreto = new Paint();
		picelPreto.setARGB(255, 0, 0, 0);
		//azul
		picelAzul = new Paint();
		picelAzul.setARGB(255, 0, 0, 255);
		setFocusable(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int y = 10;
		canvas.drawRect(10, y, 10+50, y+50, picelAzul);
		canvas.drawLine(50, 50, 100, 100, picelPreto);
		canvas.drawCircle(100, 100, 20, picelVermelho);
	}
}
