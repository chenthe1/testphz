package jxxsoft.com.cn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class PHZActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
        Button btnExit = new Button(this);
        btnExit.setTag("退出");
        btnExit.setBackgroundResource(R.drawable.btn_back_image);
        btnExit.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				finish();
			}
        });
        */
        
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.main_layout);
        layout.addView(new MyView(this));
      //  layout.addView(btnExit);
    }
    
	public class MyView extends View{

		public MyView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			Point pt = new Point();
			pt.x = (dm.widthPixels - 550) / 2;
			pt.y = dm.heightPixels * 2 / 5;

			Paint paintText=new Paint();		//创建一个采用默认设置的画笔
			paintText.setColor(0x11FFFFFF);		//设置画笔颜色
			paintText.setTextAlign(Align.LEFT);	//设置文字左对齐
			paintText.setTextSize(150);		//设置文字大小
			paintText.setAntiAlias(true);	//使用抗锯齿功能
		//	paintText.setFakeBoldText(true);
			float[] pos= new float[]{pt.x,pt.y, pt.x+200,pt.y, pt.x+400,pt.y};	//定义代表文字位置的数组
			canvas.drawPosText("跑胡子", pos, paintText);			//通过drawPosText()方法绘制文字
			super.onDraw(canvas);
		}
	}
}