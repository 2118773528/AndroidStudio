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

public class HorRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);

        mRvHor = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHor.setLayoutManager(linearLayoutManager);
        mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int i) {
                Toast.makeText(HorRecyclerViewActivity.this,"click "+i,Toast.LENGTH_SHORT).show();
            }
        }));
        mRvHor.addItemDecoration(new MyDecoration());
    }

    //分割线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
