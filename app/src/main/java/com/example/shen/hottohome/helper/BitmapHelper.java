package com.example.shen.hottohome.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BitmapHelper {

    public static Bitmap resize(Bitmap bmp, int maxW, int maxH) {
        if (bmp == null)
            return null;
        // old w , h
        int oldWidth = bmp.getWidth();
        int oldHeight = bmp.getHeight();
        // origin is ok
        if (oldWidth <= maxW && oldHeight <= maxH)
            return bmp;
        // new format
        int newWidth = oldWidth;
        int newHeight = oldHeight;
        do {
            newWidth *= 0.9;
            newHeight *= 0.9;
        } while (newWidth > maxW || newHeight > maxH);
        // scale %
        float scaleWidth = ((float) newWidth) / oldWidth;
        float scaleHeight = ((float) newHeight) / oldHeight;
        // scale matrix params
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bmp, 0, 0, oldWidth, oldHeight, matrix, true);
    }

    public static Bitmap drawTextToBitmap(Context mContext, int resourceId, String text) {
        Resources resources = mContext.getResources();
        float scale = resources.getDisplayMetrics().density;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);

        Bitmap.Config bitmapConfig = bitmap.getConfig();
        // set default bitmap config if none
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        // resource bitmaps are immutable,
        // so we need to convert it to mutable one
        bitmap = bitmap.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap);

        Rect r = new Rect();
        canvas.getClipBounds(r);
        int cHeight = r.height();
        int cWidth = r.width();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTextSize((int) (25 * scale));
        paint.setShadowLayer(1f, 0f, 1f, Color.WHITE);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.getTextBounds(text, 0, text.length(), r);
        float x = cWidth / 2f - r.width() / 2f - r.left;
        float y = cHeight / 2f + r.height() / 2f - r.bottom;
        canvas.drawText(text, x, y, paint);

        return bitmap;
    }

    public static Bitmap viewToBitmap(View view) {
        // Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        // Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        // Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            // has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            // does not have background drawable, then draw white background on
            // the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        // return the bitmap
        return returnedBitmap;
    }

    public static byte[] bitmap2PNGByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static byte[] bitmap2JPGByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }

    public static String bitmap2PNGBase64(Bitmap bitmap) {
        return Base64.encodeToString(bitmap2PNGByteArray(bitmap), Base64.DEFAULT);
    }

    public static String bitmap2JPGBase64(Bitmap bitmap) {
        return Base64.encodeToString(bitmap2JPGByteArray(bitmap), Base64.DEFAULT);
    }


    public static Bitmap byteArrayToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap uri2Bitmap(Context context, Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap file2Bitmap(File file) {
        return BitmapFactory.decodeFile(file.getPath());
    }

    public static File bitmap2PNGFile(Context context, Bitmap bitmap, String fileName) {
        // create a png file to cache dir
        File f = FileHelper.createFile(FileHelper.getPicturesDir(context), fileName + ".png");
        // convert to array
        byte[] bArr = bitmap2PNGByteArray(bitmap);
        // write to file
        return FileHelper.writeFile(bArr, f);
    }

    public static File bitmap2PNGFile(Context context, Bitmap bitmap) {
        return bitmap2PNGFile(context, bitmap, UUID.randomUUID().toString());
    }

    public static File bitmap2JPGFile(Context context, Bitmap bitmap, String fileName) {
        // create a png file to cache dir
        File f = FileHelper.createFile(FileHelper.getPicturesDir(context), fileName + ".jpg");
        // convert to array
        byte[] bArr = bitmap2JPGByteArray(bitmap);
        // write to file
        return FileHelper.writeFile(bArr, f);
    }

    public static File bitmap2JPGFile(Context context, Bitmap bitmap) {
        return bitmap2JPGFile(context, bitmap, UUID.randomUUID().toString());
    }
}
