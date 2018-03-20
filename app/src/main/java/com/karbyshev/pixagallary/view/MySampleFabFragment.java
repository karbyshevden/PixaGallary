package com.karbyshev.pixagallary.view;

import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.karbyshev.pixagallary.R;

import static com.karbyshev.pixagallary.view.MainActivity.CATEGORY;

public class MySampleFabFragment extends AAH_FabulousFragment implements View.OnClickListener{

    private TextView fashion, nature, backgrounds, science, education, people, feelings, religion,
            health, places, animals, industry, food, computer, sports, transportation, travel,
            buildings, business, music;


    public static MySampleFabFragment newInstance() {
        MySampleFabFragment f = new MySampleFabFragment();
        return f;
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.filter_sample_view, null);
        RelativeLayout rl_content = (RelativeLayout) contentView.findViewById(R.id.rl_content);
        LinearLayout ll_buttons = (LinearLayout) contentView.findViewById(R.id.ll_buttons);
        contentView.findViewById(R.id.my_ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFilter("closed");
            }
        });


        fashion = (TextView)contentView.findViewById(R.id.my_category_fashion);
        nature = (TextView)contentView.findViewById(R.id.my_category_nature);
        backgrounds = (TextView)contentView.findViewById(R.id.my_category_backgrounds);
        science = (TextView)contentView.findViewById(R.id.my_category_science);
        education = (TextView)contentView.findViewById(R.id.my_category_education);
        people = (TextView)contentView.findViewById(R.id.my_category_people);
        feelings = (TextView)contentView.findViewById(R.id.my_category_feelings);
        religion = (TextView)contentView.findViewById(R.id.my_category_religion);
        health = (TextView)contentView.findViewById(R.id.my_category_health);
        places = (TextView)contentView.findViewById(R.id.my_category_places);
        animals = (TextView)contentView.findViewById(R.id.my_category_animals);
        industry = (TextView)contentView.findViewById(R.id.my_category_industry);
        food = (TextView)contentView.findViewById(R.id.my_category_food);
        computer = (TextView)contentView.findViewById(R.id.my_category_computer);
        sports = (TextView)contentView.findViewById(R.id.my_category_sports);
        transportation = (TextView)contentView.findViewById(R.id.my_category_transportation);
        travel = (TextView)contentView.findViewById(R.id.my_category_travel);
        buildings = (TextView)contentView.findViewById(R.id.my_category_buildings);
        business = (TextView)contentView.findViewById(R.id.my_category_business);
        music = (TextView)contentView.findViewById(R.id.my_category_music);

        fashion.setOnClickListener(this);
        nature.setOnClickListener(this);
        backgrounds.setOnClickListener(this);
        science.setOnClickListener(this);
        education.setOnClickListener(this);
        people.setOnClickListener(this);
        feelings.setOnClickListener(this);
        religion.setOnClickListener(this);
        health.setOnClickListener(this);
        places.setOnClickListener(this);
        animals.setOnClickListener(this);
        industry.setOnClickListener(this);
        food.setOnClickListener(this);
        computer.setOnClickListener(this);
        sports.setOnClickListener(this);
        transportation.setOnClickListener(this);
        travel.setOnClickListener(this);
        buildings.setOnClickListener(this);
        business.setOnClickListener(this);
        music.setOnClickListener(this);

        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(300); // optional; default 400dp
        setCallbacks((Callbacks) getActivity()); //optional; to get back result
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
//        setViewPager(vp_types); //optional; if you use viewpager that has scrollview
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_category_fashion:
                CATEGORY = "fashion";
                fashion.setTextColor(Color.RED);
                break;
            case R.id.my_category_nature:
                CATEGORY = "nature";
                nature.setTextColor(Color.RED);
                break;
            case R.id.my_category_backgrounds:
                CATEGORY = "backgrounds";
                backgrounds.setTextColor(Color.RED);
                break;
            case R.id.my_category_science:
                CATEGORY = "science";
                science.setTextColor(Color.RED);
                break;
            case R.id.my_category_education:
                CATEGORY = "education";
                education.setTextColor(Color.RED);
                break;
            case R.id.my_category_people:
                CATEGORY = "people";
                people.setTextColor(Color.RED);
                break;
            case R.id.my_category_feelings:
                CATEGORY = "feelings";
                feelings.setTextColor(Color.RED);
                break;
            case R.id.my_category_religion:
                CATEGORY = "religion";
                religion.setTextColor(Color.RED);
                break;
            case R.id.my_category_health:
                CATEGORY = "health";
                health.setTextColor(Color.RED);
                break;
            case R.id.my_category_places:
                CATEGORY = "places";
                places.setTextColor(Color.RED);
                break;
            case R.id.my_category_animals:
                CATEGORY = "animals";
                animals.setTextColor(Color.RED);
                break;
            case R.id.my_category_industry:
                CATEGORY = "industry";
                industry.setTextColor(Color.RED);
                break;
            case R.id.my_category_food:
                CATEGORY = "food";
                food.setTextColor(Color.RED);
                break;
            case R.id.my_category_computer:
                CATEGORY = "computer";
                computer.setTextColor(Color.RED);
                break;
            case R.id.my_category_sports:
                CATEGORY = "sports";
                sports.setTextColor(Color.RED);
                break;
            case R.id.my_category_transportation:
                CATEGORY = "transportation";
                transportation.setTextColor(Color.RED);
                break;
            case R.id.my_category_travel:
                CATEGORY = "travel";
                travel.setTextColor(Color.RED);
                break;
            case R.id.my_category_buildings:
                CATEGORY = "buildings";
                buildings.setTextColor(Color.RED);
                break;
            case R.id.my_category_business:
                CATEGORY = "business";
                business.setTextColor(Color.RED);
                break;
            case R.id.my_category_music:
                CATEGORY = "music";
                music.setTextColor(Color.RED);
                break;
        }
    }
}
