package com.designreactor.sb;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

        int counter = 0;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);

//                getData();
//                View view = new View(MainActivity.this);
//                view.setBackgroundColor(Color.RED);
//                view.setId(1);




//                ViewGroup.LayoutParams vlp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 1400 ,1);
                params.setMargins(20,20, 0, 0);


                ShowData(layout);


            }
        });

        Button clr = findViewById(R.id.refresh);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeAllViews();
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
        Toast.makeText(this, "Please enter symbol and Days.", Toast.LENGTH_LONG).show();
        Log.e("TAG", "go");
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

    int t_id = 2;

    private void ShowData( LinearLayout Layout) {


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 1400 ,1);
        params.setMargins(20,20, 0, 0);

        String symbol = "string";
        String rows = "string";

        EditText editText_symbol = findViewById(R.id.symbol);
        symbol = editText_symbol.getText().toString();

        EditText editText_row = findViewById(R.id.rows);
        rows =  editText_row.getText().toString();

        if ((symbol.isEmpty()) || (rows.isEmpty())) getData();
        else {

            LinearLayout Layout2 = new LinearLayout(this);
            Layout2.setOrientation(LinearLayout.VERTICAL);
            Layout2.setLayoutParams(params);
            for (int x = 0; x < Integer.parseInt(rows); x += 1) {
                TextView textView = new TextView(this);
                textView.setId(t_id);
                textView.setGravity(Gravity.CENTER);

                textView.setBackgroundColor(Color.CYAN);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(200, 30);
                params2.setMargins(5, 5, 0, 0);

//            Layout.setLayoutParams(params2);
//            Layout.setOrientation(LinearLayout.VERTICAL);

                t_id += 1;

//            EditText editText = findViewById(R.id.symbol);
//            String text = editText.getText().toString();

                textView.setText(symbol);
                Layout2.addView(textView, params);

//                Log.e("TAG", symbol);
            }
            Layout.addView(Layout2);

            editText_symbol.setText("");
            editText_row.setText("");
        }

    }

}
