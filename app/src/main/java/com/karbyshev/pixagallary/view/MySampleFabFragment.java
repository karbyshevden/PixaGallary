package com.karbyshev.pixagallary.view;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.karbyshev.pixagallary.R;

import java.util.Arrays;
import java.util.List;

import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch;
import belka.us.androidtoggleswitch.widgets.ToggleSwitch;

import static com.karbyshev.pixagallary.view.MainActivity.APP_PREFERENCES_POSITION_COLOR;
import static com.karbyshev.pixagallary.view.MainActivity.APP_PREFERENCES_POSITION_LIST;
import static com.karbyshev.pixagallary.view.MainActivity.APP_PREFERENCES_POSITION_ORIENTATION;
import static com.karbyshev.pixagallary.view.MainActivity.CATEGORY;
import static com.karbyshev.pixagallary.view.MainActivity.ORIENTATION;
import static com.karbyshev.pixagallary.view.MainActivity.SPAN_COUNT;

public class MySampleFabFragment extends AAH_FabulousFragment {
    private static final String ARG_CATEGORY_SELECTED = "MySampleFabFragment.ARG_CATEGORY_SELECTED";

    private ToggleSwitch mListToggle, mLandscapeToggle;
    public SharedPreferences sharedPreferences;

    private List<Integer> ids = Arrays.asList(
            R.id.my_category_fashion,
            R.id.my_category_nature,
            R.id.my_category_backgrounds,
            R.id.my_category_science,
            R.id.my_category_education,
            R.id.my_category_people,
            R.id.my_category_feelings,
            R.id.my_category_religion,
            R.id.my_category_health,
            R.id.my_category_places,
            R.id.my_category_animals,
            R.id.my_category_industry,
            R.id.my_category_food,
            R.id.my_category_computer,
            R.id.my_category_sports,
            R.id.my_category_transportation,
            R.id.my_category_travel,
            R.id.my_category_buildings,
            R.id.my_category_business,
            R.id.my_category_music
    );

    private List<String> labels = Arrays.asList(
           "fashion",
           "nature",
           "backgrounds",
           "science",
           "education",
           "people",
           "feelings",
           "religion",
           "health",
           "places",
           "animals",
           "industry",
           "food",
           "computer",
           "sports",
           "transportation",
           "travel",
           "buildings",
           "business",
           "music"
    );

    public static MySampleFabFragment newInstance(String selectedCategory) {
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY_SELECTED, selectedCategory);
        MySampleFabFragment fragment = new MySampleFabFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void setupDialog(Dialog dialog, int style) {
        final View contentView = View.inflate(getContext(), R.layout.filter_sample_view, null);
        RelativeLayout rl_content = (RelativeLayout) contentView.findViewById(R.id.rl_content);
        LinearLayout ll_buttons = (LinearLayout) contentView.findViewById(R.id.ll_buttons);
        contentView.findViewById(R.id.my_ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFilter("closed");
            }
        });

        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        mListToggle = (ToggleSwitch) contentView.findViewById(R.id.my_list_toggle);
        mListToggle.setCheckedTogglePosition(sharedPreferences.getInt(APP_PREFERENCES_POSITION_LIST, 0));
        mListToggle.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                position = mListToggle.getCheckedTogglePosition();
                if (position == 0){
                    SPAN_COUNT = 1;
                    editor.putInt(APP_PREFERENCES_POSITION_LIST, position);
                    editor.commit();
                } else if (position == 1){
                    SPAN_COUNT = 2;
                    editor.putInt(APP_PREFERENCES_POSITION_LIST, position);
                    editor.commit();
                }
            }
        });

        mLandscapeToggle = (ToggleSwitch)contentView.findViewById(R.id.my_lanscape_toggle);
        mLandscapeToggle.setCheckedTogglePosition(sharedPreferences.getInt(APP_PREFERENCES_POSITION_ORIENTATION, 1));
        mLandscapeToggle.setOnToggleSwitchChangeListener(new ToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                position = mLandscapeToggle.getCheckedTogglePosition();

                if (position == 0){
                    ORIENTATION = "vertical";
                    editor.putInt(APP_PREFERENCES_POSITION_ORIENTATION, position);
                    editor.commit();
                } else if (position == 1){
                    ORIENTATION = "all";
                    editor.putInt(APP_PREFERENCES_POSITION_ORIENTATION, position);
                    editor.commit();
                } else if (position == 2){
                    ORIENTATION = "horizontal";
                    editor.putInt(APP_PREFERENCES_POSITION_ORIENTATION, position);
                    editor.commit();
                }
            }
        });


        //params to set
        setAnimationDuration(200); //optional; default 500ms
        setPeekHeight(500); // optional; default 400dp
        setCallbacks((Callbacks) getActivity()); //optional; to get back result
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
//        setViewPager(vp_types); //optional; if you use viewpager that has scrollview
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (labels.contains(CATEGORY)) {
                    ((TextView)contentView.findViewById(ids.get(labels.indexOf(CATEGORY)))).setTextColor(Color.WHITE);
                }
                int index = ids.indexOf(view.getId());
                if (index >= 0) {
                    ((TextView)contentView.findViewById(ids.get(index))).setTextColor(Color.RED);
                    CATEGORY = labels.get(index);
                }
            }
        };

        for(Integer id: ids) {
            contentView.findViewById(id).setOnClickListener(onClickListener);
        }

        int selectedIndex = labels.indexOf(getArguments().getString(ARG_CATEGORY_SELECTED));
        if (selectedIndex >=0){
            onClickListener.onClick(contentView.findViewById(ids.get(selectedIndex)));
        }
    }
}
