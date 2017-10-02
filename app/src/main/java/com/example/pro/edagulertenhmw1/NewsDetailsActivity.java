package com.example.pro.edagulertenhmw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);

        Intent intent = getIntent();
        TextView txtNewsTitle = (TextView) findViewById(R.id.txtNewsTitle);
        txtNewsTitle.setText(intent.getStringExtra("NewsTitle"));
        TextView txtNewsDate = (TextView) findViewById(R.id.txtNewsDate);
        txtNewsDate.setText(intent.getStringExtra("NewsDate"));
        ImageView imgNews = (ImageView) findViewById(R.id.imgNews);
        imgNews.setImageResource(intent.getIntExtra("NewsImageId",1));
        TextView txtNewsDetails = (TextView) findViewById(R.id.txtNewsDetails);
        txtNewsDetails.setText(intent.getStringExtra("NewsDetails"));
        Button btnViewComments = (Button) findViewById(R.id.btnViewComments);
        btnViewComments.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(NewsDetailsActivity.this,CommentsActivity.class);
                startActivity(i);
            }
        });

    }
}
