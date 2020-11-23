package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register parse model
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Wl4aI0FyBc9tAw04iGMyf0KyGloA1RLDVPhoDQxb")
                .clientKey("CEWcUi4q1NH2849RYVNbPgIYK7arj2zEuZeAmP4u")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
