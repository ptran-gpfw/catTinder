package com.example.cattinder.api;

import com.example.cattinder.data.CatServiceResponse;

import org.jetbrains.annotations.NotNull;
/**
 * Created by doddy on 2/12/16.
 */
public interface ICatAdapter{

    CatServiceResponse getCats(@NotNull int startIndex);

}
