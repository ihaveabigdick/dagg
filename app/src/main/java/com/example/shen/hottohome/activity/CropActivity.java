package com.example.shen.hottohome.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shen.hottohome.R;
import com.example.shen.hottohome.helper.BitmapHelper;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CropActivity extends CommonActivity implements View.OnClickListener {

    // ui
    private CropImageView civ;

    // extra
    private Uri uri;
    private int ratioX, ratioY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        // ui reference
        civ = findViewById(R.id.civ);
        findViewById(R.id.ac_bt_rotate).setOnClickListener(this);
        findViewById(R.id.ac_bt_confirm).setOnClickListener(this);

        // extra
        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            uri = Uri.parse(extra.getString("uri"));
            ratioX = extra.getInt("ratioX");
            ratioY = extra.getInt("ratioY");
        }

        // init
        civ.setImageUriAsync(uri);
        Log.d("xxx",String.valueOf(uri));
        Log.d("xxx",String.valueOf(civ));
        if (ratioX != 0 && ratioY != 0) {
            civ.setAspectRatio(ratioX, ratioY);
        }

    }


    @SuppressLint("StaticFieldLeak")
    private class SaveCropFile extends AsyncTask<Void, Void, String> {
        Bitmap bitmap;

        SaveCropFile() {
            this.bitmap = civ.getCroppedImage();
            Log.d("xxx",String.valueOf(civ));
            Log.d("xxx",String.valueOf(civ.getCroppedImage()));
            Log.d("xxx",String.valueOf(bitmap));
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showLoadingDialog(getString(R.string.loading));
        }

        @Override
        protected String doInBackground(Void... params) {
            return BitmapHelper.bitmap2JPGFile(CropActivity.this, bitmap, "crop").getAbsolutePath();
        }

        @Override
        protected void onPostExecute(String path) {
            super.onPostExecute(path);
            dismissLoadingDialog();
            Intent intent = new Intent();
            intent.putExtra("path", path);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ac_bt_rotate:
                civ.setRotatedDegrees(civ.getRotatedDegrees() + 90);
                break;
            case R.id.ac_bt_confirm:
                new SaveCropFile().execute();
                break;
        }
    }
}
