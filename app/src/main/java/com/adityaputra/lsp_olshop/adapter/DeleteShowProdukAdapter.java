package com.adityaputra.lsp_olshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.MainActivity;
import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiSevice;
import com.adityaputra.lsp_olshop.model.ProdukModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteShowProdukAdapter extends RecyclerView.Adapter<DeleteShowProdukAdapter.ProdukViewHolder> {

    private Context context;
    private ArrayList<ProdukModel> list;

    private String id;

    public DeleteShowProdukAdapter(Context context, ArrayList<ProdukModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DeleteShowProdukAdapter.ProdukViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item_delete, viewGroup, false);
        return new ProdukViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DeleteShowProdukAdapter.ProdukViewHolder produkViewHolder, final int i) {
        produkViewHolder.nama.setText(list.get(i).getNamaBarang());
        produkViewHolder.harga.setText(list.get(i).getHargaBarang());
        Glide.with(context).load(list.get(i).getImageBarang()).into(produkViewHolder.gambar);
        id = list.get(i).getIdBarang();
        produkViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiSevice apiSevice = ApiConfig.getApiService();
                apiSevice.deleteData(id).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(context, "Sukse Delete", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, MainActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        TextView nama, harga;
        ImageView gambar;
        Button button;

        public ProdukViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.TVNama);
            harga = itemView.findViewById(R.id.TVHarga);
            gambar = itemView.findViewById(R.id.IVProduk);
            button = itemView.findViewById(R.id.btnDelete);
        }
    }
}
