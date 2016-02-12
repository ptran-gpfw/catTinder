package com.example.cattinder.api;

import com.example.cattinder.data.CatServiceResponse;

import junit.framework.Assert;

import org.junit.Test;

import retrofit.http.Query;
/**
 * Created by doddy on 2/12/16.
 */
public class CatServiceTest{

    @Test
    public void testGetCats() {

        // Given
        ICatAdapter catAdapter = new CatAdapter(new MockCatService());


        // When
        CatServiceResponse response = catAdapter.getCats(0);


        // Then
        Assert.assertNotNull(response);
    }







    private class MockCatService implements CatService {

        @Override
        public CatServiceResponse getCats(@Query("start") int startIndex) {
            return new CatServiceResponse();
        }
    }
}
