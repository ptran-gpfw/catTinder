package com.example.cattinder.activity.fragment;

import com.example.cattinder.R;
import com.example.cattinder.api.CatService;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{

    private CatService mCatService;
    private SwipeFlingAdapterView mSwipeFlingAdapterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_hotornot, null);
        mSwipeFlingAdapterView = (SwipeFlingAdapterView)view.findViewById(R.id.kittyStack);
        
        return view;
    }



    protected void inject() {
        mCatService = CatService.RestClient.createService().getService();
    }



}
