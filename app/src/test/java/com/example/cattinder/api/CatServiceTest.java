package com.example.cattinder.api;

import junit.framework.Assert;

import org.junit.Test;
/**
 * Created by doddy on 2/12/16.
 */
public class CatServiceTest{

    @Test
    private void testCanCreateService() {

        CatService catService = CatService.RestClient.createService().getService();
        Assert.assertNotNull("Cat service wasn't created", catService);
    }

    @Test
    private void test() {

        CatService catService = CatService.RestClient.createService().getService();
        Assert.assertNotNull("Cat service wasn't created", catService);
    }

}
