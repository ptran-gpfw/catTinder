package com.example.cattinder.api;

import com.example.cattinder.data.CatServiceResponse;

import org.jetbrains.annotations.NotNull;
/**
 * Created by doddy on 2/12/16.
 */
public class CatAdapter implements ICatAdapter {

    private CatService mCatService;

    public CatAdapter(CatService catService) {
        this.mCatService = catService;
    }

    @Override
    public CatServiceResponse getCats(@NotNull int startIndex) {
        return this.mCatService.getCats(startIndex);
    }
}
