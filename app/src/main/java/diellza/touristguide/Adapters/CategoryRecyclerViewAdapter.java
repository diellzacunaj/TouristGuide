package diellza.touristguide.Adapters;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import diellza.touristguide.Models.Category;
import diellza.touristguide.R;


/**
 * Created by SINKOPA on 3/20/2018.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    public static final String CATEGORY_TITLE="CATEGORY_TITLE";
    Context  context;
    List<Category> categories;
    RelativeLayout relativeLayout;
    Fragment fragment;

    FragmentActivity fragmentActivity;



    public CategoryRecyclerViewAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }


    @Override
    public CategoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
relativeLayout=view.findViewById(R.id.relativeViewCategory);

        int height = parent.getMeasuredHeight() / 3;
        int width = parent.getMeasuredWidth()/2;

       relativeLayout.setLayoutParams(new RecyclerView.LayoutParams(width, height));



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerViewAdapter.ViewHolder holder, int position) {
final Category category=categories.get(position);


holder.categoryImg.setImageResource(category.getThumbnail());
holder.categoryTitle.setText(category.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImg;
        TextView categoryTitle;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            categoryImg =(ImageView) itemView.findViewById(R.id.itemCategoryImg);
            categoryTitle=itemView.findViewById(R.id.itemCategoryTitle);
            cardView=itemView.findViewById(R.id.itemCategoryCardview);

        }


    }
}
