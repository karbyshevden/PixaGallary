package com.karbyshev.pixagallary.view;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.karbyshev.pixagallary.R;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.Arrays;
>>>>>>> 8c00ec62ed109b1db81fcaba2cb300a9d934aa15
import java.util.List;

import static com.karbyshev.pixagallary.view.MainActivity.CATEGORY;
import static com.karbyshev.pixagallary.view.MainActivity.PACKAGE_NAME;

public class MySampleFabFragment extends AAH_FabulousFragment {

<<<<<<< HEAD
    private List<TextView> textViewList = new ArrayList<>();
    private static final int[] TEXTVIEW_IDS = {
            R.id.my_category_fashion,
            R.id.my_category_nature,
            R.id.my_category_backgrounds
    };

//    private int textViewCount = 3;
//    private TextView[] textViewArray = new TextView[textViewCount];
//    private String[] id = new String[]{"my_category_fashion", "my_category_nature", "my_category_backgrounds"};

//    private TextView fashion, nature, backgrounds, science, education, people, feelings, religion,
//            health, places, animals, industry, food, computer, sports, transportation, travel,
//            buildings, business, music;
=======
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
>>>>>>> 8c00ec62ed109b1db81fcaba2cb300a9d934aa15

    public static MySampleFabFragment newInstance() {
        return new MySampleFabFragment();
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

<<<<<<< HEAD
        for (int id : TEXTVIEW_IDS) {
            TextView textView = (TextView) contentView.findViewById(id);
            textView.setOnClickListener(this);
            textViewList.add(textView);
        }

//        for (int i = 0; i < id.length; i++) {
//            int temp = getResources().getIdentifier(id[i], "id", PACKAGE_NAME);
//            textViewArray[i] = (TextView)contentView.findViewById(temp);
//            textViewArray[i].setOnClickListener(this);
//        }

//        fashion = (TextView)contentView.findViewById(R.id.my_category_fashion);
//        nature = (TextView)contentView.findViewById(R.id.my_category_nature);
//        backgrounds = (TextView)contentView.findViewById(R.id.my_category_backgrounds);
//        science = (TextView)contentView.findViewById(R.id.my_category_science);
//        education = (TextView)contentView.findViewById(R.id.my_category_education);
//        people = (TextView)contentView.findViewById(R.id.my_category_people);
//        feelings = (TextView)contentView.findViewById(R.id.my_category_feelings);
//        religion = (TextView)contentView.findViewById(R.id.my_category_religion);
//        health = (TextView)contentView.findViewById(R.id.my_category_health);
//        places = (TextView)contentView.findViewById(R.id.my_category_places);
//        animals = (TextView)contentView.findViewById(R.id.my_category_animals);
//        industry = (TextView)contentView.findViewById(R.id.my_category_industry);
//        food = (TextView)contentView.findViewById(R.id.my_category_food);
//        computer = (TextView)contentView.findViewById(R.id.my_category_computer);
//        sports = (TextView)contentView.findViewById(R.id.my_category_sports);
//        transportation = (TextView)contentView.findViewById(R.id.my_category_transportation);
//        travel = (TextView)contentView.findViewById(R.id.my_category_travel);
//        buildings = (TextView)contentView.findViewById(R.id.my_category_buildings);
//        business = (TextView)contentView.findViewById(R.id.my_category_business);
//        music = (TextView)contentView.findViewById(R.id.my_category_music);
//
//        fashion.setOnClickListener(this);
//        nature.setOnClickListener(this);
//        backgrounds.setOnClickListener(this);
//        science.setOnClickListener(this);
//        education.setOnClickListener(this);
//        people.setOnClickListener(this);
//        feelings.setOnClickListener(this);
//        religion.setOnClickListener(this);
//        health.setOnClickListener(this);
//        places.setOnClickListener(this);
//        animals.setOnClickListener(this);
//        industry.setOnClickListener(this);
//        food.setOnClickListener(this);
//        computer.setOnClickListener(this);
//        sports.setOnClickListener(this);
//        transportation.setOnClickListener(this);
//        travel.setOnClickListener(this);
//        buildings.setOnClickListener(this);
//        business.setOnClickListener(this);
//        music.setOnClickListener(this);

=======
>>>>>>> 8c00ec62ed109b1db81fcaba2cb300a9d934aa15
        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(300); // optional; default 400dp
        setCallbacks((Callbacks) getActivity()); //optional; to get back result
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
//        setViewPager(vp_types); //optional; if you use viewpager that has scrollview
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last

<<<<<<< HEAD
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_category_fashion:
                CATEGORY = "fashion";
                textViewList.get(0).setTextColor(Color.RED);
//                fashion.setTextColor(Color.RED);
                break;
            case R.id.my_category_nature:
                CATEGORY = "nature";
//                nature.setTextColor(Color.RED);
                break;
            case R.id.my_category_backgrounds:
                CATEGORY = "backgrounds";
//                backgrounds.setTextColor(Color.RED);
                break;
//            case R.id.my_category_science:
//                CATEGORY = "science";
//                science.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_education:
//                CATEGORY = "education";
//                education.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_people:
//                CATEGORY = "people";
//                people.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_feelings:
//                CATEGORY = "feelings";
//                feelings.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_religion:
//                CATEGORY = "religion";
//                religion.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_health:
//                CATEGORY = "health";
//                health.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_places:
//                CATEGORY = "places";
//                places.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_animals:
//                CATEGORY = "animals";
//                animals.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_industry:
//                CATEGORY = "industry";
//                industry.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_food:
//                CATEGORY = "food";
//                food.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_computer:
//                CATEGORY = "computer";
//                computer.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_sports:
//                CATEGORY = "sports";
//                sports.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_transportation:
//                CATEGORY = "transportation";
//                transportation.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_travel:
//                CATEGORY = "travel";
//                travel.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_buildings:
//                CATEGORY = "buildings";
//                buildings.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_business:
//                CATEGORY = "business";
//                business.setTextColor(Color.RED);
//                break;
//            case R.id.my_category_music:
//                CATEGORY = "music";
//                music.setTextColor(Color.RED);
//                break;
=======
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (labels.contains(CATEGORY)) {
                    ((TextView)contentView.findViewById(ids.get(labels.indexOf(CATEGORY)))).setTextColor(Color.WHITE);
                }
                int index = ids.indexOf(view.getId());
                if (index > 0) {
                    ((TextView)contentView.findViewById(ids.get(index))).setTextColor(Color.RED);
                    CATEGORY = labels.get(index);
                }
            }
        };

        for(Integer id: ids) {
            contentView.findViewById(id).setOnClickListener(onClickListener);
>>>>>>> 8c00ec62ed109b1db81fcaba2cb300a9d934aa15
        }
    }
}
