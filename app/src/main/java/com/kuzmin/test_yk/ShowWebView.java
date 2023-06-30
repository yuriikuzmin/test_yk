package com.kuzmin.test_yk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowWebView extends AppCompatActivity {
    Button btn_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_web);
        btn_back=(Button) findViewById(R.id.btn_back);
        
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowWebView.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
    //Disable button back
    public void onBackPressed(){
    }
}
