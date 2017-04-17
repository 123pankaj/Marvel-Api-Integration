package com.marvel.sample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.marvel.sample.adapters.MarvelPagerAdapter;
import com.marvel.sample.fragments.CharactersFragment;
import com.marvel.sample.fragments.ComicsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.tabs) TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        onInitActivity();
    }

    private void onInitActivity() {
        setSupportActionBar(toolbar);
        setTitle("Marvel Api Integration");
        setupViewPager(pager);
        tabs.setupWithViewPager(pager);
    }

    private void setupViewPager(ViewPager pager) {
        MarvelPagerAdapter adapter = new MarvelPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ComicsFragment(), "Comics");
        adapter.addFragment(new CharactersFragment(), "Characters");
        pager.setAdapter(adapter);
    }

}
