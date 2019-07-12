package com.adityaputra.lsp_olshop.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.10.2.225/APIMobile/")
//                .baseUrl("http://sig.upgris.ac.id/api_iav/sertifikasi_android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service =retrofit.create(ApiService.class);
        return service;
    }
}
