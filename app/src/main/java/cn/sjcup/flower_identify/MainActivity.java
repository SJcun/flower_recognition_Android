package cn.sjcup.flower_identify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    /**
     * 有关布局的一些声明
     */
    private Button mCamera;  //初始界面选择的相机按钮
    private Button mAlbum;   //初始界面选择的相册按钮

    public static int flag;
    public static final int camera = 1;
    public static final int album = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();  //初始化布局
        initEvent(); //初始化控件事件
    }

    /**
     * 初始化控价事件
     */
    private void initEvent() {

        //为拍照按钮设置监听
        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果拍照按钮被点击，则转向拍照界面
                Intent intent = new Intent(MainActivity.this, TakePhoto.class);
                startActivity(intent);
            }
        });

        //为相册按钮设置监听
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = album;
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(MainActivity.this, PhotoPreview.class);
                startActivity(intent);

            }
        });
    }

    /**
     * 初始化布局
     */
    private void initView() {

        //绑定控件
        mCamera = (Button) this.findViewById(R.id.camera_btn);
        mAlbum = (Button) this.findViewById(R.id.album_btn);
    }
}
