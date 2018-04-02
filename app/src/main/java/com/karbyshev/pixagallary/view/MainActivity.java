package com.karbyshev.pixagallary.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.karbyshev.pixagallary.R;
import com.karbyshev.pixagallary.adapter.MyAdapter;
import com.karbyshev.pixagallary.model.Hit;
import com.karbyshev.pixagallary.model.PostModel;
import com.karbyshev.pixagallary.utils.AppController;
import com.karbyshev.pixagallary.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AAH_FabulousFragment.Callbacks, IMainView{
    public static final String KEY_SELECTED_ITEM = "MainActivity.KEY_SELECTED_ITEM";
    public static final String KEY_ORIENTATION_ITEM = "MainActivity.KEY_ORIENTATION_ITEM";
    public static final String KEY_SPAN_COUNT_ITEM = "MainActivity.KEY_SPAN_COUNT_ITEM";

    public static final String APP_PREFERENCES_POSITION_LIST = "positionList";
    public static final String APP_PREFERENCES_POSITION_ORIENTATION = "positionOrientation";

    public static final String FULLSCREEN_IMG_URL = "fullScreen";
    public static final String FULLSCREEN_LIKES = "likes";
    public static final String FULLSCREEN_DOWNLOADS = "downloads";
    public static final String FULLSCREEN_CREATOR_NAME = "creator";

    public static int SPAN_COUNT = 1;
    public static String CATEGORY = "all";
    public static String ORIENTATION = "all";


    private RecyclerView mRecyclerView;
    private HashMap<String,String> map;
    private GridLayoutManager mGridLayoutManager;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySampleFabFragment dialogFrag = MySampleFabFragment.newInstance(CATEGORY, ORIENTATION, SPAN_COUNT);
                dialogFrag.setParentFab(fab);
                dialogFrag.show(getSupportFragmentManager(), dialogFrag.getTag());
            }
        });

        CATEGORY = getSharedPreferences().getString(KEY_SELECTED_ITEM, "all");
        ORIENTATION = getSharedPreferences().getString(KEY_ORIENTATION_ITEM, "all");
        SPAN_COUNT = getSharedPreferences().getInt(KEY_SPAN_COUNT_ITEM, 1);

        map = new HashMap<>();
        map.put("key", "8334968-4779a336d920b0785293ef347");
        map.put("image_type", "photo");
        map.put("q", "all");
        map.put("orientation", ORIENTATION);
        map.put("category", CATEGORY);
        map.put("per_page", "100");
        map.put("page", "1");

        showData();
    }

    @Override
    public void onResult(Object result) {
        map.put("orientation", ORIENTATION);
        map.put("category", CATEGORY);
        showData();
    }

    private void showData(){
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mGridLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        myAdapter = new MyAdapter(MainActivity.this);
        myAdapter.setOnItemClickListiner(MainActivity.this);
        mRecyclerView.setAdapter(myAdapter);

        AppController.getApi().data(map).enqueue(new Callback<PostModel>() {
            private List<Hit> postsList = new ArrayList<>();
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                PostModel postModel = response.body();
                postsList =postModel.getHits();
                myAdapter.addAll(postsList);
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnItemClick(int position, ArrayList<Hit> list) {
        Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
        Hit hit = list.get(position);

        intent.putExtra(FULLSCREEN_IMG_URL, hit.getLargeImageURL());
        intent.putExtra(FULLSCREEN_LIKES, hit.getLikes().toString());
        intent.putExtra(FULLSCREEN_DOWNLOADS, hit.getDownloads().toString());
        intent.putExtra(FULLSCREEN_CREATOR_NAME, hit.getUser());
        startActivity(intent);
    }

    private SharedPreferences getSharedPreferences(){
        return getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
    }
}
