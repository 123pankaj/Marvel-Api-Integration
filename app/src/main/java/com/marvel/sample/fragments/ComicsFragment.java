package com.marvel.sample.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.sample.R;
import com.marvel.sample.fragments.adapters.ComicsAdapter;
import com.marvel.sample.fragments.models.ComicsResponse;
import com.marvel.sample.mvp.ComicsPresenter;
import com.marvel.sample.mvp.IComicsPresenter;
import com.marvel.sample.mvp.IComicsView;
import com.marvel.sample.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicsFragment extends Fragment implements IComicsView, SearchView.OnQueryTextListener{
    private Context ctx;
    private IComicsPresenter iComicsPresenter;
    private LinearLayoutManager linearLayoutManager;
    private static final String TAG = "ComicsFragment==>";
    private ComicsAdapter comicsAdapter;
    private List<ComicsResponse.Data.Result> dataList = new ArrayList<>();

    @BindView(R.id.list)
    RecyclerView list;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    public ComicsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comics, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        iComicsPresenter = new ComicsPresenter(this);
        linearLayoutManager = new LinearLayoutManager(ctx);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(linearLayoutManager);
        list.setHasFixedSize(false);
        comicsAdapter = new ComicsAdapter(dataList);
        list.setAdapter(comicsAdapter);

        dataList.add(null);
        comicsAdapter.notifyItemInserted(dataList.size() - 1);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        comicsAdapter.setFilter(dataList);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }
                });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "In onActivityCreated");
        list.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                Log.i(TAG, "In Scroll Listener");
                iComicsPresenter.getComicsListFromMarvelServers();
            }
        });
    }

    @Override
    public void setData(ComicsResponse response) {
        if (dataList.contains(null)) {
            dataList.remove(null);
        }
        dataList.addAll(response.getData().getResults());
        comicsAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError(Throwable error) {
        Log.e(TAG, error.getMessage());
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<ComicsResponse.Data.Result> filteredModelList = filter(dataList, newText);
        comicsAdapter.setFilter(filteredModelList);
        return true;
    }

    private List<ComicsResponse.Data.Result> filter(List<ComicsResponse.Data.Result> models, String query) {
        query = query.toLowerCase();

        final List<ComicsResponse.Data.Result> filteredModelList = new ArrayList<>();
        for (ComicsResponse.Data.Result model : models) {
            if (model!=null) {
                final String text = model.getTitle().toLowerCase();
                if (text.contains(query)) {
                    filteredModelList.add(model);
                }
            }
        }
        return filteredModelList;
    }
}
