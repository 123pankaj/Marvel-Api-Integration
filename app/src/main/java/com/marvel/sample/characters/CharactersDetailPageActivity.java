package com.marvel.sample.characters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.marvel.sample.R;
import com.marvel.sample.adapters.CharactersAdapter;
import com.marvel.sample.fragments.models.CharactersResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersDetailPageActivity extends AppCompatActivity implements ICharactersDetailView {
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ICharactersDetailPresenter iCharactersDetailPresenter;
    private static final String TAG = "CharactersDetailActivity";
    public static final String LIST_OBJECT = "LIST_OBJECT";
    @BindView(R.id.image)
    AppCompatImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_detail_page);
        ButterKnife.bind(CharactersDetailPageActivity.this);
        onInitActivity();
    }

    private void onInitActivity(){
        setSupportActionBar(toolbar);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        //iCharactersDetailPresenter = new CharactersDetailPresenter(this);
        //iCharactersDetailPresenter.getCharacterDetail(getIntent().getIntExtra("characterId", 0));

        String result = getIntent().getStringExtra(LIST_OBJECT);
        displayPic(result);

    }

    private void displayPic(String uriPath) {
        Glide.with(image.getContext()).load(uriPath)
                .placeholder(R.drawable.placeholder).into(image);

    }

    private void colorize(Bitmap resource) {
        Palette.from(resource).generate((Palette palette)-> applyPalette(palette));
    }

    private void applyPalette(final Palette mPalette) {
        final int darkMutedColor = mPalette.getDarkMutedColor(getColor());
        getWindow().setBackgroundDrawable(new ColorDrawable(darkMutedColor));
    }

    public int getColor() {
        TypedValue a = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.windowBackground, a, true);
        int color = ContextCompat.getColor(this, R.color.colorPrimary);
        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            color = a.data;
        }return color;
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void start(Context context, View view, String data) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context
                , view.findViewById(R.id.image), context.getString(R.string.banner_transition));
        Intent intent = new Intent(context, CharactersDetailPageActivity.class);
        intent.putExtra(LIST_OBJECT, data);
        ActivityCompat.startActivity(context, intent, optionsCompat.toBundle());
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
