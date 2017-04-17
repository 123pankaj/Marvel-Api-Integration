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
import com.marvel.sample.fragments.adapters.CharactersAdapter;
import com.marvel.sample.fragments.models.CharactersResponse;
import com.marvel.sample.mvp.CharactersPresenter;
import com.marvel.sample.mvp.ICharactersPresenter;
import com.marvel.sample.mvp.ICharactersView;
import com.marvel.sample.utils.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersFragment extends Fragment implements ICharactersView, SearchView.OnQueryTextListener{
    private Context ctx;
    private boolean _areResourcesLoaded=false;
    private ICharactersPresenter iCharactersPresenter;
    private LinearLayoutManager linearLayoutManager;
    @BindView(R.id.characterList) RecyclerView characterList;
    private static final String TAG = "CharactersFragment==>";
    private CharactersAdapter charactersAdapter;
    private List<CharactersResponse.Data.Result> dataList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx=context;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !_areResourcesLoaded){
            dataList.add(null);
            charactersAdapter.notifyItemInserted(dataList.size() - 1);

            characterList.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
                @Override
                public void onLoadMore(int page, int totalItemsCount) {
                    Log.i(TAG, "In Scroll Listener");
                    iCharactersPresenter.getCharactersListFromMarvelServers();
                }
            });
            _areResourcesLoaded=true;
        }
    }

    public CharactersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        iCharactersPresenter=new CharactersPresenter(this);
        linearLayoutManager = new LinearLayoutManager(ctx);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        characterList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        charactersAdapter = new CharactersAdapter(dataList);
        characterList.setAdapter(charactersAdapter);
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
                        charactersAdapter.setFilter(dataList);
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }
                });
    }


    @Override
    public void setData(CharactersResponse response) {
        if (dataList.contains(null)) {
            dataList.remove(null);
        }
        dataList.addAll(response.getData().getResults());
        charactersAdapter.notifyDataSetChanged();
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
        final List<CharactersResponse.Data.Result> filteredModelList = filter(dataList, newText);
        charactersAdapter.setFilter(filteredModelList);
        return true;
    }

    private List<CharactersResponse.Data.Result> filter(List<CharactersResponse.Data.Result> models, String query) {
        query = query.toLowerCase();

        final List<CharactersResponse.Data.Result> filteredModelList = new ArrayList<>();
        for (CharactersResponse.Data.Result model : models) {
            if (model!=null) {
                final String text = model.getName().toLowerCase();
                if (text.contains(query)) {
                    filteredModelList.add(model);
                }
            }
        }
        return filteredModelList;
    }
}
