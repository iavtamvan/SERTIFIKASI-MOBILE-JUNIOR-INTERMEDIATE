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
import com.adityaputra.lsp_olshop.api.ApiSevice;

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

    private String id_barang;
    private String nama_barang;
    private String image_barang;
    private String deskripsi_barang;
    private String harga_barang;
    private String stok_barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        id_barang = getIntent().getStringExtra("ID_BARANG");
        nama_barang = getIntent().getStringExtra("NAMA_BARANG");
        image_barang = getIntent().getStringExtra("IMAGE_BARANG");
        deskripsi_barang = getIntent().getStringExtra("DESKRIPSI_BARANG");
        harga_barang = getIntent().getStringExtra("HARGA_BARANG");
        stok_barang = getIntent().getStringExtra("STOK_BARANG");

        edtNamaBarang.setText(nama_barang);
        edtImageBarang.setText(image_barang);
        edtNDeskripsiBarang.setText(deskripsi_barang);
        edtHargaBarang.setText(harga_barang);
        edtStokBarang.setText(stok_barang);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBarang();
            }
        });
    }

    private void updateBarang() {
        ApiSevice apiSevice = ApiConfig.getApiService();
        apiSevice.updateData(id_barang, edtNamaBarang.getText().toString().trim(), edtImageBarang.getText().toString().trim(),
                edtNDeskripsiBarang.getText().toString().trim(), edtHargaBarang.getText().toString().trim(),
                edtStokBarang.getText().toString().trim()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(UpdateActivity.this, "Sukses Diperbarui", Toast.LENGTH_SHORT).show();
                    finishAffinity();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    // TODO bisa mbok kasih ALert Diaolog mas.
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
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
