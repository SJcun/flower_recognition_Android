package cn.sjcup.flower_identify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static cn.sjcup.flower_identify.MainActivity.album;
import static cn.sjcup.flower_identify.MainActivity.camera;
import static cn.sjcup.flower_identify.MainActivity.flag;

public class PhotoPreview extends AppCompatActivity {

    //private SmartImageView siv;
    private ImageView mPic;
    private Button mPicOk;
    //private Button mPicAgain;
    private Uri uri;
    private long firstPressedTime;
    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - firstPressedTime < 2000) {
            //super.onBackPressed();
            System.exit(0);
        } else {
            Toast.makeText(PhotoPreview.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            firstPressedTime = System.currentTimeMillis();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_preview);

        initView();  //初始化布局
        initEvent(); //初始化事件
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            uri = data.getData();
            //接收相册传递过来的图片
            mPic.setImageURI(uri);
        }
    }

    /**
     * 从相册获取图片
     */
    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);
    }

    private void initEvent() {

        //为“确定”按钮设置监听
        mPicOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果被点击，将图片信息上传到服务端，并且转至最后的结果显示界面

            }
        });

        /*
        //为“重拍”按钮设置监听
        mPicAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果按钮被点击，跳回拍照界面
                Intent intent = new Intent(PhotoPreview.this, TakePhoto.class);
                startActivity(intent);
                //finish();
            }
        });

         */
    }

    private void initView() {

        //绑定控件
        //siv = (SmartImageView) this.findViewById(R.id.siv_pic);
        mPic = (ImageView) this.findViewById(R.id.pic_imv);
        mPicOk = (Button) this.findViewById(R.id.picture_OK_btn);
        //mPicAgain = (Button) this.findViewById(R.id.picture_again_btn);

        System.out.println(flag);
        //如果图片从相机处传来
        if (flag == camera) {
            //接收TakePhoto传递的图片
            Intent picIntent = getIntent();
            byte[] bytes = picIntent.getByteArrayExtra("pic_data");
            final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            if (bitmap != null) {
                mPic.setImageBitmap(bitmap);
            }
        }
        //如果图片由相册传来
        else if (flag == album){

            System.out.println(uri);
            getPicFromAlbm();//调用相册
            //System.out.println(uri);

        }

    }
}
