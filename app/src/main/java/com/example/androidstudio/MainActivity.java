package com.example.androidstudio;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.androidstudio.datastorage.DataStorageActivity;
import com.example.androidstudio.fragment.ContainerActivity;
import com.example.androidstudio.jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;
    private Button mBtnEvent;
    private Button mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = findViewById(R.id.btn_ui);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);

        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        OnClick onClick1 = new OnClick();
        mBtnLifeCycle.setOnClickListener(onClick1);

        mBtnJump = findViewById(R.id.btn_jump);
        OnClick onClick2 = new OnClick();
        mBtnJump.setOnClickListener(onClick2);

        mBtnFragment = findViewById(R.id.btn_fragment);
        OnClick onClick3 = new OnClick();
        mBtnFragment.setOnClickListener(onClick3);

        mBtnEvent = findViewById(R.id.btn_event);
        OnClick onClick4 = new OnClick();
        mBtnEvent.setOnClickListener(onClick4);

        mBtnData =findViewById(R.id.btn_data);
        OnClick onClick5 = new OnClick();
        mBtnData.setOnClickListener(onClick5);

        //动态权限申请
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
