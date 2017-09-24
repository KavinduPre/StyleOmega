package com.example.kavindu.styleomega;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
/**
 * Created by Kavindu on 9/20/2017.
 */


public class ImageLoader extends AppCompatActivity {

    private final String android_version_names[] = {
            "Donutew",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {

            "https://image.ibb.co/d4ZrOk/g1.jpg",
            "https://image.ibb.co/eFnp9Q/g2.jpg",
            "https://image.ibb.co/dV2d3k/g3.jpg",
            "https://image.ibb.co/f5w5ik/g4.jpg",
            "https://image.ibb.co/f5w5ik/g4.jpg",
            "https://image.ibb.co/bEDU9Q/g5.jpg",
            "https://image.ibb.co/hfv99Q/g6.jpg",
            "https://image.ibb.co/dBprOk/g7.jpg",
            "https://image.ibb.co/gBNBOk/g8.jpg",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
