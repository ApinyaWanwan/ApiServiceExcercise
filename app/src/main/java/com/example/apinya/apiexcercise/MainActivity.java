package com.example.apinya.apiexcercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        
        loadData();
    }

    private void loadData() {
        String API_KEY = "AIzaSyCaCDNxPJHbHMnqHiz4t64f2EmlsnqDfCM";
        String URL = "http://www.akexorcist.com";

        Call<Collection> call = HttpManager.getInstance().getService().repos(URL, API_KEY);
        call.enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                if (response.isSuccessful()){
                    Collection dao = response.body();
                    textView.setText(dao.getName());
                }else {
                    textView.setText(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                textView.setText(t.toString());
            }
        });
    }
}
