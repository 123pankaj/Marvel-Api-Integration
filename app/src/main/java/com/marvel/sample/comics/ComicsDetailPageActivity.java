package com.marvel.sample.comics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.marvel.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicsDetailPageActivity extends AppCompatActivity implements IComicDetailView{
    @BindView(R.id.toolbar) Toolbar toolbar;
    private IComicsDetailPresenter iComicsDetailPresenter;
    private static final String TAG = "ComicsDetailPageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_detail_page);
        ButterKnife.bind(ComicsDetailPageActivity.this);
        onInitActivity();
    }

    private void onInitActivity(){
        setSupportActionBar(toolbar);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        iComicsDetailPresenter = new ComicsDetailPresenter(this);
        iComicsDetailPresenter.getComicsDetail(getIntent().getIntExtra("comicsId", 0));
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
