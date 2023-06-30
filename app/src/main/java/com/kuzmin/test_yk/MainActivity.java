package com.kuzmin.test_yk;


import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPef;
    String SAVED_LINK="saved_link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создаем объект RemoteConfig
        FirebaseRemoteConfig firebaseRemoteConfig=FirebaseRemoteConfig.getInstance();
        /*FirebaseRemoteConfigSettings configSettings=new FirebaseRemoteConfigSettings.Builder()
               .setMinimumFetchIntervalInSeconds(3600)
                .build();

        firebaseRemoteConfig.setConfigSettingsAsync(configSettings);*/
        String link=firebaseRemoteConfig.fetch().toString();
        if(link==null){

        }else {
            load_view(link);
        }


    }
    public void load_view(String link){
        sPef=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=sPef.edit();
        editor.putString(SAVED_LINK, link);
        editor.commit();
        Toast.makeText(this, "Link saved", Toast.LENGTH_SHORT).show();
        Log.d("LOG", "Link= "+link );

        Intent intent=new Intent(MainActivity.this, ShowWebView.class);
        startActivity(intent);

    }
}