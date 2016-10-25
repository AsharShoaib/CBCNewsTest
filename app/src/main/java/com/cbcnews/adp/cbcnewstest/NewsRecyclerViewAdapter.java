package com.cbcnews.adp.cbcnewstest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cbcnews.adp.cbcnewstest.Activities.MainActivity;
import com.cbcnews.adp.cbcnewstest.Activities.WebViewActivity;
import com.cbcnews.adp.cbcnewstest.Models.News;


import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

/**
 * Created by asharshoaib on 2016-10-24.
 */

public class NewsRecyclerViewAdapter extends RealmBasedRecyclerViewAdapter<News, NewsRecyclerViewAdapter.ViewHolder> {

    private ShareActionProvider mShareActionProvider;

    public NewsRecyclerViewAdapter(RealmResults<News> mNews, Context mContext, boolean automaticUpdate, boolean animateIdType) {
        super(mContext, mNews, automaticUpdate, animateIdType);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.item_news_card, viewGroup, false);
        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(final ViewHolder viewHolder, int position) {
        final News news = realmResults.get(position);
        TextView titletextView = viewHolder.titleTextView;
        titletextView.setText(news.getTitle());
        TextView descriptiontextView = viewHolder.descriptionTextView;
        descriptiontextView.setText(news.getDescription());
        TextView publishDatetextView = viewHolder.publishDateTextView;
        publishDatetextView.setText(news.getReadablePublishedAt());
        Glide.with(getContext())
                .load(news.getImageLarge())
                .override(100, 100)
                .into(viewHolder.image);

        viewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(viewHolder.overflow);
            }
        });

    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_news, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }


    public class ViewHolder extends RealmViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final ImageView image, overflow;
        private final TextView descriptionTextView;
        private final TextView publishDateTextView;
        private final CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.cv);
            titleTextView = (TextView) itemView.findViewById(R.id.news_title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.news_description);
            publishDateTextView = (TextView) itemView.findViewById(R.id.news_published);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }

        @Override
        public void onClick(View v) {
//        MainActivity.editNewNews(v.getContext(), realmResults.get(getLayoutPosition()));
            Intent intent = new Intent(v.getContext(), WebViewActivity.class);
            intent.putExtra(App.GETURL, realmResults.get(getLayoutPosition()).getUrl());
            v.getContext().startActivity(intent);
        }


    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_item_share:
                    return true;
                default:
            }
            return false;
        }
    }
}

