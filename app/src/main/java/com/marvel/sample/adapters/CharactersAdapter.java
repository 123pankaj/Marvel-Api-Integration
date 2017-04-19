package com.marvel.sample.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.marvel.sample.R;
import com.marvel.sample.characters.CharactersDetailPageActivity;
import com.marvel.sample.controller.MarvelAppController;
import com.marvel.sample.fragments.models.CharactersResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pankaj on 4/17/2017.
 */

public class CharactersAdapter extends RecyclerView.Adapter {
    private List<CharactersResponse.Data.Result> data;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_PROGRESS_BAR = 2;
    private Context ctx;

    public CharactersAdapter(Context context, List<CharactersResponse.Data.Result> list) {
        this.data = list;
        this.ctx=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comics_view_inflator, parent, false);
            vh = new CharactersViewHolder(v);
        } else if (viewType == TYPE_PROGRESS_BAR) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item, parent, false);
            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharactersResponse.Data.Result model = data.get(position);
        if (holder instanceof CharactersViewHolder) {
            ((CharactersViewHolder) holder).title.setText(model.getName());
            Glide.with(((CharactersViewHolder) holder).image.getContext()).load(model.getThumbnail().getPath() + "." + model.getThumbnail().getExtension()).into(((CharactersViewHolder) holder).image);
        } else if (holder instanceof ProgressViewHolder) {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position) != null ? TYPE_ITEM : TYPE_PROGRESS_BAR;
    }

    public void setFilter(List<CharactersResponse.Data.Result> list) {
        data = new ArrayList<>();
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CharactersViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title) AppCompatTextView title;
        @BindView(R.id.image) AppCompatImageView image;

        CharactersViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener((View v)-> {
                CharactersDetailPageActivity.start(ctx,v, data.get(getAdapterPosition()).getThumbnail().getPath() + ".jpg");
            });
        }
    }

    class ProgressViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar progressBar;

        ProgressViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
