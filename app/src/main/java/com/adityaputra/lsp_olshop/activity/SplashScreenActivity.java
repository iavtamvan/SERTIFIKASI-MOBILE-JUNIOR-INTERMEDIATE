package com.adityaputra.lsp_olshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.adityaputra.lsp_olshop.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            SharedPreferences sp = getSharedPreferences("LSP", MODE_PRIVATE);
            String error = sp.getString("SHARED_LOGIN", "");

            // TODO jika belum masuk ke LoginActivity
            if (error.equalsIgnoreCase("") || TextUtils.isEmpty(error)){
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
            // TODO jika sudah nantinya akan masuk ke Home
            else {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        }, 2000);
    }
}
