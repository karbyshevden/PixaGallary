package com.karbyshev.pixagallary.view;

import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.karbyshev.pixagallary.R;

import java.util.Arrays;
import java.util.List;

import static com.karbyshev.pixagallary.view.MainActivity.CATEGORY;

public class MySampleFabFragment extends AAH_FabulousFragment {

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

        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(300); // optional; default 400dp
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
                if (index > 0) {
                    ((TextView)contentView.findViewById(ids.get(index))).setTextColor(Color.RED);
                    CATEGORY = labels.get(index);
                }
            }
        };

        for(Integer id: ids) {
            contentView.findViewById(id).setOnClickListener(onClickListener);
        }
    }
}
