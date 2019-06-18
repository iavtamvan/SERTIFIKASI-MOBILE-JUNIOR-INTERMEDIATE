package com.adityaputra.lsp_olshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adityaputra.lsp_olshop.DetailActivity;
import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.model.ProdukModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShowProdukAdapter extends RecyclerView.Adapter<ShowProdukAdapter.ProdukViewHolder> {

    private Context context;
    private ArrayList<ProdukModel> list = new ArrayList<>();

    public ShowProdukAdapter(Context context, ArrayList<ProdukModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowProdukAdapter.ProdukViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ProdukViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShowProdukAdapter.ProdukViewHolder produkViewHolder, int i) {
        produkViewHolder.nama.setText(list.get(i).getNamaBarang());
        produkViewHolder.harga.setText(list.get(i).getHargaBarang());
        Glide.with(context).load(list.get(i).getImageBarang()).into(produkViewHolder.gambar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        TextView nama, harga;
        ImageView gambar;

        public ProdukViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.TVNama);
            harga = itemView.findViewById(R.id.TVHarga);
            gambar = itemView.findViewById(R.id.IVProduk);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("ID_BARANG", list.get(getAdapterPosition()).getIdBarang());
                    intent.putExtra("NAMA_BARANG", list.get(getAdapterPosition()).getNamaBarang());
                    intent.putExtra("IMAGE_BARANG", list.get(getAdapterPosition()).getImageBarang());
                    intent.putExtra("DESKRIPSI_BARANG", list.get(getAdapterPosition()).getDeskripsiBarang());
                    intent.putExtra("HARGA_BARANG", list.get(getAdapterPosition()).getHargaBarang());
                    intent.putExtra("STOK_BARANG", list.get(getAdapterPosition()).getStokBarang());
                    context.startActivity(intent);
                }
            });
        }
    }
}
