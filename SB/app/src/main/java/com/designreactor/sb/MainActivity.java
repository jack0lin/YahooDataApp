package com.designreactor.sb;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout = findViewById(R.id.continer);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

//                getData();
//                View view = new View(MainActivity.this);
//                view.setBackgroundColor(Color.RED);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
//
//                layout.addView(view, params);
//                EditText editText = findViewById(R.id.et);
//
//                String text = editText.getText().toString();
//
//                Log.e("TAG", text);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void getData() {
        Toast.makeText(this, "get Data", Toast.LENGTH_LONG).show();
        Log.e("TAG", "get Data");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://www.baidu.com";
                Request request = new Request.Builder()
                        .url(url)
                        .header("cookie", "abc")
                        .build();
                OkHttpClient client = new OkHttpClient();
                try {

                    Response response = client.newCall(request).execute();
                    Log.e("TAG", "response " + response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
