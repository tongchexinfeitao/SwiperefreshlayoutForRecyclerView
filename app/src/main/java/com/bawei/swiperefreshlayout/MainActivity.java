package com.bawei.swiperefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;

public class MainActivity extends AppCompatActivity {

    private SwipyRefreshLayout srl;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        srl = (SwipyRefreshLayout) findViewById(R.id.srl);

        //设置颜色
        srl.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, android.R.color.holo_red_dark);

        //设置是否支持刷新和加载更多
        srl.setDirection(SwipyRefreshLayoutDirection.BOTH);
        srl.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(int index) {
                Toast.makeText(MainActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        srl.setRefreshing(false);

                    }
                }, 2000);
            }

            @Override
            public void onLoad(int index) {
                Toast.makeText(MainActivity.this, "上拉加载", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.setRefreshing(false);

                    }
                }, 2000);

            }
        });

    }
}
