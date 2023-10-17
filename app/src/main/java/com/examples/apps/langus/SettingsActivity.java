package com.examples.apps.langus;

import static android.content.pm.PackageManager.GET_META_DATA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button english, hindi, german;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        TitleChange(this);

        english = findViewById(R.id.englishs);
        hindi = findViewById(R.id.hindis);
        german = findViewById(R.id.germans);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale("en", false);
            }
        });

        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale("hi", false);
            }
        });

        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale("de", false);
            }
        });

    }

    public void TitleChange(Activity acts) {
        try {
            ActivityInfo actinf = acts.getPackageManager().getActivityInfo(acts.getComponentName(), GET_META_DATA);
            if (actinf.labelRes != 0) {
                acts.setTitle(actinf.labelRes);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void attachBaseContext(Context ctx) {
        super.attachBaseContext(MainApplication.applangmng.setLocale(ctx));
    }

    private boolean setNewLocale(String langs, boolean boolprc) {

        MainApplication.applangmng.setNewLocale(this, langs);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        return true;
    }

}