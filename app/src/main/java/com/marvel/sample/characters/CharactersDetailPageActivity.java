package com.marvel.sample.characters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.marvel.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersDetailPageActivity extends AppCompatActivity implements ICharactersDetailView {
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ICharactersDetailPresenter iCharactersDetailPresenter;
    private static final String TAG = "CharactersDetailActivity";

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
        iCharactersDetailPresenter = new CharactersDetailPresenter(this);
        iCharactersDetailPresenter.getCharacterDetail(getIntent().getIntExtra("characterId", 0));
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
}
