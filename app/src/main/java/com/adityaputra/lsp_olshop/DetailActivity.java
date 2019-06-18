package com.adityaputra.lsp_olshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiSevice;
import com.adityaputra.lsp_olshop.model.ProdukModel;
import com.bumptech.glide.Glide;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tcNamaBarang;
    private TextView tcDeskripsiBarang;
    private TextView tcHargaBarang;
    private TextView tcStokBarang;
    private Button btnKirim;

    private String id_barang;
    private String nama_barang;
    private String image_barang;
    private String deskripsi_barang;
    private String harga_barang;
    private String stok_barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        id_barang = getIntent().getStringExtra("ID_BARANG");
        nama_barang = getIntent().getStringExtra("NAMA_BARANG");
        image_barang = getIntent().getStringExtra("IMAGE_BARANG");
        deskripsi_barang = getIntent().getStringExtra("DESKRIPSI_BARANG");
        harga_barang = getIntent().getStringExtra("HARGA_BARANG");
        stok_barang = getIntent().getStringExtra("STOK_BARANG");

        Glide.with(this).load(image_barang).override(512, 512).into(iv);
        tcNamaBarang.setText(nama_barang);
        tcDeskripsiBarang.setText(deskripsi_barang);
        tcHargaBarang.setText(harga_barang);
        tcStokBarang.setText(stok_barang);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSevice apiSevice = ApiConfig.getApiService();
                apiSevice.beliData(id_barang).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(DetailActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finishAffinity();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(DetailActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initView() {
        iv = findViewById(R.id.iv);
        tcNamaBarang = findViewById(R.id.tcNamaBarang);
        tcDeskripsiBarang = findViewById(R.id.tcDeskripsiBarang);
        tcHargaBarang = findViewById(R.id.tcHargaBarang);
        tcStokBarang = findViewById(R.id.tcStokBarang);
        btnKirim = findViewById(R.id.btnKirim);
    }
}
