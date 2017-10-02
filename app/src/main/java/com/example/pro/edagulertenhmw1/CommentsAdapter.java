package com.example.pro.edagulertenhmw1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.pro.edagulertenhmw1.model.CommentItem;

import java.util.List;

/**
 * Created by Pro on 30/04/17.
 */

public class CommentsAdapter extends ArrayAdapter<CommentItem> {
    public CommentsAdapter(@NonNull Context context, @NonNull List<CommentItem> objects) {
        super(context,android.R.layout.simple_list_item_1 , objects);
    }
    class CommentHolder{
        private View base;
        private TextView txtCommentOwner;
        private TextView txtCommentMessage;

        public CommentHolder(View base) {
            this.base = base;
        }

        public TextView getTxtCommentOwner() {
            if(txtCommentOwner == null){
                txtCommentOwner = (TextView)base.findViewById(R.id.txtNewsTitle);
            }


            return txtCommentOwner;
        }

        public TextView getTxtCommentMessage() {
            if(txtCommentMessage == null){
                txtCommentMessage = (TextView)base.findViewById(R.id.txtNewsDate);
            }
            return txtCommentMessage;
        }

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CommentHolder holder =null;
        View row = convertView;

        if(row == null){

            row = ((Activity)getContext()).getLayoutInflater()
                    .inflate(R.layout.row_layout,
                            parent,false);

            holder = new CommentHolder(row);
            row.setTag(holder);

        }else{

            holder = (CommentHolder) row.getTag();


        }


        holder.getTxtCommentMessage().setText(getItem(position).getMessage());
        holder.getTxtCommentOwner().setText(String.valueOf(getItem(position).getName()));

        return row;



    }
}
