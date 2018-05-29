package diellza.touristguide.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class MonumentRecyclerViewAdapter extends RecyclerView.Adapter<MonumentRecyclerViewAdapter.ViewHolder> {

    List<Monument> monuments;
    Context context;

    public MonumentRecyclerViewAdapter(List<Monument> monuments, Context context) {
        this.monuments = monuments;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monument,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Monument monument=monuments.get(position);
        holder.itemMonumentTitle.setText(monument.getTitle());
        holder.itemMonumentOverview.setText(monument.getOverview());


        Picasso.with(context).load(Uri.parse(monument.getOverviewImg()))
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.itemMonumentImg, new Callback() {
                    @Override

                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                        // Try again online if cache failed
                        Picasso.with(context)
                                .load(Uri.parse(monument.getOverviewImg()))
                                .error(R.drawable.nowifi)
                                .into(holder.itemMonumentImg);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return monuments.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView itemMonumentImg;
        TextView  itemMonumentTitle;
        TextView itemMonumentOverview;

        public ViewHolder(View itemView) {
            super(itemView);


            itemMonumentImg=itemView.findViewById(R.id.itemMonumentImg);
            itemMonumentTitle=itemView.findViewById(R.id.itemMonumentTitle);
            itemMonumentOverview=itemView.findViewById(R.id.itemMonumentOverview);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (context instanceof OnItemClickListener) {
                ((MainActivity) context).onItemClick(getAdapterPosition());
            }
        }
    }
    public void setFilter(List<Monument> monumentsList) {
        monuments = new ArrayList<>();
        monuments.addAll(monumentsList);
        notifyDataSetChanged();
    }
}