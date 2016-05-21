package com.example.rk.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class restaurants_list extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView list;

    String[] ListrestaurantNames, ListrestaurantDescription;
    int[] images = {R.drawable.i, R.drawable.im, R.drawable.downloads, R.drawable.menu, R.drawable.ge, R.drawable.xy, R.drawable.im, R.drawable.xy, R.drawable.cake, R.drawable.chicken};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_list);

        Resources resources = getResources();
        ListrestaurantNames = resources.getStringArray(R.array.restaurantNames);
        ListrestaurantDescription = resources.getStringArray(R.array.restaurantDescription);
       // images = resources.getStringArray(R.array.all_images);

        list = (ListView) findViewById(R.id.listView);

        RestaurantsAdapter restaurantsAdapter = new RestaurantsAdapter(this, ListrestaurantNames, images, ListrestaurantDescription);

        list.setAdapter(restaurantsAdapter);

        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(restaurants_list.this, chooseItems.class));


    }
}

class RestaurantsAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] imagesArray;
    String[] titleArray;
    String[] descriptionArray;

    RestaurantsAdapter(Context c, String[] titles, int[] imgs, String[] desc)
    {
        super(c, R.layout.single_row_restaurants_list, R.id.textTitle, titles);
        this.context = c;
        this.imagesArray = imgs;
        this.titleArray =  titles;
        this.descriptionArray = desc;

    }

    class MyViewHolder{
        ImageView myImage;
        TextView myTitle, myDescription;

        MyViewHolder(View view){
            myImage = (ImageView) view.findViewById(R.id.imageView);
            myTitle = (TextView) view.findViewById(R.id.textTitle);
            myDescription = (TextView) view.findViewById(R.id.textDescription);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row= convertView;
        MyViewHolder holder = null;

        if(row == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row_restaurants_list, parent, false);

            holder = new MyViewHolder(row);
            row.setTag(holder);

            Log.d("List", "Creating a new row");
        }

        else{
            holder = (MyViewHolder) row.getTag();
            Log.d("List", "Creating a recycler row");
        }

        holder.myImage.setImageResource(imagesArray[position]);
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(descriptionArray[position]);

        return row;
    }
}
