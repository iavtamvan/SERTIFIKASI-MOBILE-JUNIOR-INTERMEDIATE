package com.adityaputra.lsp_olshop.api;

import com.adityaputra.lsp_olshop.model.ProdukModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiSevice {
    @GET("api_get.php")
    Call<ArrayList<ProdukModel>> ambilData();
    @GET("api_login.php")
    Call<ResponseBody> login(@Query("username") String username,
                             @Query("password") String password);

    @FormUrlEncoded
    @POST("api_hapus_barang.php")
    Call<ResponseBody> deleteData(@Field("id_barang") String id);

    @FormUrlEncoded
    @POST("api_tambah_barang.php")
    Call<ResponseBody> tambahData(
            @Field("nama_barang") String nama_barang,
            @Field("image_barang") String image_barang,
            @Field("deskripsi_barang") String deskripsi_barang,
            @Field("harga_barang") String harga_barang,
            @Field("stok_barang") String stok_barang
    );

    @FormUrlEncoded
    @POST("api_update_barang.php")
    Call<ResponseBody> updateData(
            @Field("id_barang") String id_barang,
            @Field("nama_barang") String nama_barang,
            @Field("image_barang") String image_barang,
            @Field("deskripsi_barang") String deskripsi_barang,
            @Field("harga_barang") String harga_barang,
            @Field("stok_barang") String stok_barang
    );

    @FormUrlEncoded
    @POST("api_beli_barang.php")
    Call<ResponseBody> beliData(
            @Field("id_barang") String id_barang
    );


}
