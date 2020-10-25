package com.bharathkrishna.retrofittest.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bharathkrishna.retrofittest.Pojos.Hero;
import com.bharathkrishna.retrofittest.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Myholder> {
    //this context we will use to inflate the layout
    private Context context;

    //we are storing all the products in a list
    private List<Hero> heroList;

    //getting the context and product list with constructor

    public RecyclerviewAdapter(Context context, List<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_recycler_view_items, null);
        return new RecyclerviewAdapter.Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.Myholder holder, int position) {
        //getting the product of the specified position
        Hero hero = heroList.get(position);

        //binding the data with the Myholder views
        holder.Textview_Heroname.setText(hero.getName());
        holder.Textview_Realname.setText(hero.getRealname());
        holder.Textview_Team.setText(hero.getTeam());
        holder.Textview_FirstApperence.setText(hero.getFirstappearance());
        holder.Textview_Publisher.setText(hero.getPublisher());
        holder.Textview_Bio.setText(hero.getBio());
        Glide.with(context).load(Uri.parse(hero.getImageurl())).into(holder.ImageView_heroImage);



    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView Textview_Heroname, Textview_Realname, Textview_Team, Textview_FirstApperence, Textview_Publisher, Textview_Bio;
        ImageView ImageView_heroImage;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            Textview_Heroname = itemView.findViewById(R.id.Textview_Heroname);
            Textview_Realname = itemView.findViewById(R.id.Textview_Realname);
            Textview_Team = itemView.findViewById(R.id.Textview_Team);
            Textview_FirstApperence = itemView.findViewById(R.id.Textview_FirstApperence);
            Textview_Publisher = itemView.findViewById(R.id.Textview_Publisher);
            Textview_Bio = itemView.findViewById(R.id.Textview_Bio);
            ImageView_heroImage = itemView.findViewById(R.id.ImageView_heroImage);
        }
    }
}
