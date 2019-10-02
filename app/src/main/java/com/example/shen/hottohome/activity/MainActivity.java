package com.example.shen.hottohome.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.shen.hottohome.R;
import com.example.shen.hottohome.helper.FileHelper;
import com.example.shen.hottohome.helper.GenericFileProvider;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends CommonActivity implements View.OnClickListener{

    //data
    private File file_user_picture;
    private Uri uriTakePicture;
    // request
    public static final int REQUEST_FROM_GALLERY = 1;
    public static final int REQUEST_TAKE_PHOTO = 2;
    public static final int REQUEST_TAKE_CROP = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ui
        findViewById(R.id.iv_activity_main_identification).setOnClickListener(this);
        findViewById(R.id.fab_activity_main).setOnClickListener(this);
    }

    private void choosePicture() {
        alertWithItems(getResources().getStringArray(R.array.choose_picture), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_FROM_GALLERY);
                } else {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    uriTakePicture = FileProvider.getUriForFile(MainActivity.this, GenericFileProvider.AUTH,
                            new File(FileHelper.getPicturesDir(MainActivity.this) + "/take_picture.jpg"));
                    file_user_picture = new File(Environment.getExternalStorageDirectory(), "take_picture.jpg");
                    //uriTakePicture = Uri.fromFile(file_user_picture);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uriTakePicture);
                    startActivityForResult(intent, REQUEST_TAKE_PHOTO);
                }
            }
        });
    }

    private void showPictureDialog() {
        ImageView ll = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(10, 10, 10, 10);
        ll.setLayoutParams(params);
        int w = (int) (getResources().getDisplayMetrics().density * 100);
        Picasso.with(this)
                .load(file_user_picture)
                .resize(w, w)
                .centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(ll);
        alertWithView(ll, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 傳送圖片至後端
                t("success");
            }
        }, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_activity_main_identification:
                choosePicture();
                break;
            case R.id.fab_activity_main:
            //
            break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        Bundle b = new Bundle();
        switch (requestCode) {
            case REQUEST_FROM_GALLERY:
                if (data.getData() != null) {
                    b.putString("uri", data.getData().toString());
                }
                b.putInt("ratioX", 1);
                b.putInt("ratioY", 1);
                openActivityForResult(CropActivity.class, REQUEST_TAKE_CROP, b);
                break;
            case REQUEST_TAKE_PHOTO:
                b.putString("uri", uriTakePicture.toString());
                b.putInt("ratioX", 1);
                b.putInt("ratioY", 1);
                openActivityForResult(CropActivity.class, REQUEST_TAKE_CROP, b);
                break;
            case REQUEST_TAKE_CROP:
                file_user_picture = new File(data.getStringExtra("path"));
                showPictureDialog();
                break;
        }
    }
}
