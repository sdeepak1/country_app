package com.example.dsmakerstudio.asiacountrie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class details extends AppCompatActivity {
    TextView cname,region,subRegion,population,border,capitsl,languages;
    ImageView dtImg;
    int position;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        cname=findViewById(R.id.countryName);
        region=findViewById(R.id.region);
        subRegion=findViewById(R.id.subregion);
        population=findViewById(R.id.population);
        languages=findViewById(R.id.languages);
        border=findViewById(R.id.border);
        capitsl=findViewById(R.id.capital);
        position=getIntent().getIntExtra("position",0);
        dtImg=findViewById(R.id.cimg);
        url=aisa.list.get(position).getFlag();
        Glide.with(details.this).load(url).into(dtImg);
        init();


    }
    public void init(){
        cname.setText(aisa.list.get(position).getName());
        region.setText(aisa.list.get(position).getRegion());
        subRegion.setText(aisa.list.get(position).getSubRegion());
        capitsl.setText(aisa.list.get(position).getCapital());
        border.setText(aisa.list.get(position).getBorders());
        population.setText(aisa.list.get(position).getPopulation());
        languages.setText(aisa.list.get(position).getLs().toString());


    }
    public void back(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(details.this,aisa.class);
        startActivity(intent);
        super.onBackPressed();
    }

}