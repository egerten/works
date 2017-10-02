package com.example.pro.edagulertenhmw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pro.edagulertenhmw1.model.NewsItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

        final ListView lstView = (ListView)findViewById(R.id.listNews);
        final Spinner spinnerNews = (Spinner)findViewById(R.id.spinnerNews);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.news_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNews.setAdapter(adapter);

        NewsAdapter adpNews = new NewsAdapter(this, NewsItem.getAllNews());
        lstView.setAdapter(adpNews);


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,NewsDetailsActivity.class);
                i.putExtra("NewsTitle",NewsItem.getAllNews().get(position).getTitle().toString());
                i.putExtra("NewsDate",NewsItem.getAllNews().get(position).getNewsDate().toString());
                i.putExtra("NewsImageId",NewsItem.getAllNews().get(position).getImageId());
                i.putExtra("NewsDetails",NewsItem.getAllNews().get(position).getText());

                startActivity(i);
            }
        });


    }
}
