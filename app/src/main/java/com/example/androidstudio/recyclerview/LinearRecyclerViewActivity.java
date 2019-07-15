package com.example.androidstudio.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.androidstudio.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mRvMain = findViewById(R.id.rv_main);
        //列表
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        //分割线
        mRvMain.addItemDecoration(new MyDecoration());
        //适配器
        mRvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this,new LinearAdapter.OnItemClickListener(){
            @Override
            public void onClick(int i) {
                Toast.makeText(LinearRecyclerViewActivity.this,"click "+i,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //分割线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
