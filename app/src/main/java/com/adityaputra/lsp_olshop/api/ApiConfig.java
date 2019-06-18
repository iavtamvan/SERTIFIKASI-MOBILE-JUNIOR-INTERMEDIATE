package com.adityaputra.lsp_olshop.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static ApiSevice getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://IP KAMU/sertifikasiMobile/")
//                .baseUrl("http://192.168.43.57/local/sertifikasiMobile/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiSevice service =retrofit.create(ApiSevice.class);
        return service;
    }
}
