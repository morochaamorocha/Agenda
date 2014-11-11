package com.proyectotema6.ricardo.agenda;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by rals1_000 on 08/11/2014.
 */
public class ImagenRedondeada extends ImageView {

    public ImagenRedondeada(Context context) {
        super(context);
    }

    public ImagenRedondeada(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImagenRedondeada(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null){
            return;
        }

        if (getWidth() == 0 && getHeight() == 0){
            return;
        }

        Bitmap b = ((BitmapDrawable)drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap redondeadoBitMap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(redondeadoBitMap, 0, 0, null);
    }

    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius){

        final int color = 0xffa19774;
        final Paint paint = new Paint();

        Bitmap sbmp;

        if (bmp.getWidth() != radius || bmp.getHeight() != radius){
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        }
        else {
            sbmp = bmp;
        }

        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0,0,0,0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(sbmp.getWidth()/2+0.7f, sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }
}
