package com.example.meucap07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class TouchScreenView extends View implements OnClickListener
{
	private static final String CATEGORIA = "livro";
	private Drawable img;
	private Drawable points;
	int x,y;
	private boolean selecionou;
	private int larguraTela;
	private int alturaTela;
	private int larguraImg;
	private int alturaImg;
	
	private int larguraPoints;
	private int alturaPoints;
	
	public TouchScreenView (Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, null);
		img = context.getResources().getDrawable(R.drawable.lua_menor1);
		points = context.getResources().getDrawable(R.drawable.moeda); 
		larguraImg = img.getIntrinsicWidth();
		alturaImg  = img.getIntrinsicHeight();
		
		larguraPoints = points.getIntrinsicWidth();
		alturaPoints = points.getIntrinsicHeight();
		setFocusable(true);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		this.larguraTela = w;
		this.alturaTela = h;
		x = w / 2 - (this.larguraImg / 2);
		y = h / 2 - (this.alturaImg / 2);
		Log.i(CATEGORIA, "onSizeChanged x/y: " + x + "/" + y);
	}
	
	//metodo pra desenhar pontos na tela
	private void onDrawnPoints(Canvas canvas)
	{
		super.onDraw(canvas);
		points.setBounds(0, 0, larguraImg, alturaImg);
		points.draw(canvas);
	}
	
	private void explosao(Canvas canvas, Context context)
	{
		if( (x > 0 && x < larguraPoints) && (y > 0 && y < alturaPoints) )
		{
			//explode!
			points = context.getResources().getDrawable(R.drawable.moeda); 
		}
			
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint pincel = new Paint();
		pincel.setColor(Color.WHITE);
		canvas.drawRect(0, 0, larguraTela, alturaTela, pincel);
		img.setBounds(x,y,x+larguraImg, y + alturaImg);
		img.draw(canvas);
		//onDrawnPoints(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		Log.i(CATEGORIA, "onTouchEvent x/y > " + x + "/" + y);
		switch (event.getAction()) 
		{
			case MotionEvent.ACTION_DOWN:
				selecionou = img.copyBounds().contains((int) x, (int) y);
				break;
			case MotionEvent.ACTION_MOVE:
				if(selecionou)
				{
					this.x = (int) x - (larguraImg / 2);
					this.y = (int) y - (alturaImg / 2);
				}
				break;
			case MotionEvent.ACTION_UP:
				selecionou = false;
				break;
		}
		invalidate();
		//return super.onTouchEvent(event);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(null, "clicou ok", Toast.LENGTH_SHORT).show();
	}
	
}
