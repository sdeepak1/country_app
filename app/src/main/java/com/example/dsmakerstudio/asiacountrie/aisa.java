package com.example.dsmakerstudio.asiacountrie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class aisa extends AppCompatActivity {
    RecyclerView rv;
    asiaadapter adapter;
    public static List<asiamodel> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisa);
        rv=findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        list.clear();
        adapter=new asiaadapter(list);
        rv.setAdapter(adapter);

        fetchData();


    }

    private void fetchData() {

        String url="https://restcountries.eu/rest/v2/region/Asia";


        StringRequest request=new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                   for(int i=0;i<jsonArray.length();i++){
                       List<String> lan=new ArrayList<>();



                       JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("name");
                        String capital=jsonObject.getString("capital");
                        String flag=jsonObject.getString("flag");
                        String region=jsonObject.getString("region");
                        String subregion=jsonObject.getString("subregion");
                        String population=jsonObject.getString("population");
                        String border=jsonObject.getString("borders");
                        JSONArray jsonArray1=jsonObject.getJSONArray("languages");
                        for(int j=0;j<jsonArray1.length();j++){
                            JSONObject object=jsonArray1.getJSONObject(j);
                            lan.add(object.getString("name"));
                        }





                       list.add(new asiamodel(name,capital,flag,region,subregion,population,border,lan));


                         }
                   adapter.notifyDataSetChanged();





                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(aisa.this,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}