package com.adityaputra.lsp_olshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adityaputra.lsp_olshop.R;
import com.adityaputra.lsp_olshop.api.ApiConfig;
import com.adityaputra.lsp_olshop.api.ApiService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = ApiConfig.getApiService();
                apiService.login(edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim()).
                        enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.body().string());
                                        String error = jsonObject.optString("error_msg");
                                        if (error.equalsIgnoreCase("Login Sukses")){
                                            Toast.makeText(LoginActivity.this, "" +
                                                    error, Toast.LENGTH_SHORT).show();
                                            finishAffinity();
                                            startActivity(new Intent(getApplicationContext(),
                                                    HomeActivity.class));

                                            SharedPreferences sharedPreferences = getSharedPreferences("LSP",
                                                    MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString("SHARED_LOGIN", error);
                                            editor.apply();
                                        } else {
                                            Toast.makeText(LoginActivity.this, "" +
                                                    error, Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Gagal",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "" + t.getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void initView() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_masuk);
    }
}
