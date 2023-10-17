package com.examples.apps.langus;

import static android.content.pm.PackageManager.GET_META_DATA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        TitleChange(this);

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            }
        });

    }

    public void TitleChange(Activity acts) {
        try {
            ActivityInfo actinfo = acts.getPackageManager().getActivityInfo(acts.getComponentName(), GET_META_DATA);
            if (actinfo.labelRes != 0) {
                acts.setTitle(actinfo.labelRes);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void attachBaseContext(Context conn) {
        super.attachBaseContext(MainApplication.applangmng.setLocale(conn));
    }

}