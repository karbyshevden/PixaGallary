package com.karbyshev.pixagallary.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.karbyshev.pixagallary.R;
import com.karbyshev.pixagallary.model.Hit;
import com.karbyshev.pixagallary.view.IMainView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.karbyshev.pixagallary.view.MainActivity.SPAN_COUNT;

/**
 * Created by vilen on 20.03.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Hit> hits = new ArrayList<>();
    private IMainView mListiner;

    public void setOnItemClickListiner(IMainView mListiner){
        this.mListiner = mListiner;
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hit hit = hits.get(position);
        String creatorName = hit.getUser();
        String imageUrl = hit.getWebformatURL();
        String avatarUrl = hit.getUserImageURL();
        String likes = hit.getLikes().toString();
        String downloads = hit.getDownloads().toString();

        holder.mCreatorTextView.setText(creatorName);
        holder.mLikesTextView.setText(likes);
        holder.mDownloadsTextView.setText(downloads);

        if (SPAN_COUNT > 1){
            holder.mRelativeLayout.setVisibility(View.INVISIBLE);
        }

        try {
            Picasso.get().load(imageUrl).into(holder.mMainImageView);
            Picasso.get().load(avatarUrl).into(holder.mCreatorImageView);
        } catch (IllegalArgumentException e){

        }
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout mRelativeLayout;
        private ImageView mMainImageView;
        private CircleImageView mCreatorImageView;
        private TextView mCreatorTextView, mLikesTextView, mDownloadsTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.footer_relativeLayout);
            mMainImageView = (ImageView) itemView.findViewById(R.id.my_item_imageView);
            mCreatorImageView = (CircleImageView) itemView.findViewById(R.id.my_item_creator_image);
            mCreatorTextView = (TextView) itemView.findViewById(R.id.my_creatorName);
            mLikesTextView = (TextView) itemView.findViewById(R.id.my_likes);
            mDownloadsTextView = (TextView) itemView.findViewById(R.id.my_downloads);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListiner != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){

                            System.out.println("CLICKED!!!!");
                            mListiner.OnItemClick(position, hits);
                        }
                    }
                }
            });
        }
    }

    public void addAll(List<Hit> hitList) {
        hits.clear();
        hits.addAll(hitList);
        notifyDataSetChanged();
    }
}
