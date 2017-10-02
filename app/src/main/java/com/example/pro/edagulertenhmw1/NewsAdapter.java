package com.example.pro.edagulertenhmw1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pro.edagulertenhmw1.model.NewsItem;

import java.util.List;

/**
 * Created by Pro on 30/04/17.
 */

public class NewsAdapter extends ArrayAdapter<NewsItem> {
    public NewsAdapter(@NonNull Context context, @NonNull List<NewsItem> objects) {
        super(context,android.R.layout.simple_list_item_1 , objects);
    }
    class MyHolder{
        private View base;
        private TextView txtNewsTitle;
        private TextView txtNewsDate;
        private ImageView imgView;


        public MyHolder(View base) {
            this.base = base;
        }

        public TextView getTxtNewsTitle() {
            if(txtNewsTitle == null){
                txtNewsTitle = (TextView)base.findViewById(R.id.txtNewsTitle);
            }


            return txtNewsTitle;
        }

        public TextView getTxtNewsDate() {
            if(txtNewsDate == null){
                txtNewsDate = (TextView)base.findViewById(R.id.txtNewsDate);
            }
            return txtNewsDate;
        }

        public ImageView getImgView() {

            if(imgView == null){
                imgView = (ImageView)base.findViewById(R.id.imgNews);
            }
            return imgView;
        }
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MyHolder holder =null;
        View row = convertView;

        if(row == null){

            row = ((Activity)getContext()).getLayoutInflater()
                    .inflate(R.layout.row_layout,
                            parent,false);

            holder = new MyHolder(row);
            row.setTag(holder);

        }else{

            holder = (MyHolder) row.getTag();


        }


        holder.getImgView().setImageResource(getItem(position).getImageId());
        holder.getTxtNewsTitle().setText(getItem(position).getTitle());
        holder.getTxtNewsDate().setText(String.valueOf(getItem(position).getNewsDate()));

        return row;



    }
}
