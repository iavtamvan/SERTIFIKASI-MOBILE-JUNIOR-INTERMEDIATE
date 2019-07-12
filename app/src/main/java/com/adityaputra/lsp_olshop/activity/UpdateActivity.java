package com.adityaputra.lsp_olshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private EditText edtNamaBarang;
    private EditText edtImageBarang;
    private EditText edtNDeskripsiBarang;
    private EditText edtHargaBarang;
    private EditText edtStokBarang;
    private Button btnKirim;

    private String idBarang;
    private String namaBarang;
    private String imageBarang;
    private String deskripsiBarang;
    private String hargaBarang;
    private String stokBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        idBarang = getIntent().getStringExtra("ID_BARANG");
        namaBarang = getIntent().getStringExtra("NAMA_BARANG");
        imageBarang = getIntent().getStringExtra("IMAGE_BARANG");
        deskripsiBarang = getIntent().getStringExtra("DESKRIPSI_BARANG");
        hargaBarang = getIntent().getStringExtra("HARGA_BARANG");
        stokBarang = getIntent().getStringExtra("STOK_BARANG");


        edtNamaBarang.setText(namaBarang);
        edtImageBarang.setText(imageBarang);
        edtNDeskripsiBarang.setText(deskripsiBarang);
        edtHargaBarang.setText(hargaBarang);
        edtStokBarang.setText(stokBarang);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBarang();
            }
        });
    }

    private void updateBarang() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.updateData(idBarang,
                edtNamaBarang.getText().toString().trim(),
                edtImageBarang.getText().toString().trim(),
                edtNDeskripsiBarang.getText().toString().trim(),
                edtHargaBarang.getText().toString().trim(),
                edtStokBarang.getText().toString().trim())
                .enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(UpdateActivity.this, "Sukses Diperbarui",
                            Toast.LENGTH_SHORT).show();
                    finishAffinity();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    // TODO bisa mbok kasih ALert Diaolog mas.
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "" + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        edtNamaBarang = findViewById(R.id.edtNamaBarang);
        edtImageBarang = findViewById(R.id.edtImageBarang);
        edtNDeskripsiBarang = findViewById(R.id.edtNDeskripsiBarang);
        edtHargaBarang = findViewById(R.id.edtHargaBarang);
        edtStokBarang = findViewById(R.id.edtStokBarang);
        btnKirim = findViewById(R.id.btnKirim);
    }
}
