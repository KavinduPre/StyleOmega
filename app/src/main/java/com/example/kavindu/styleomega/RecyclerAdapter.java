package com.example.kavindu.styleomega;



import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kavindu on 9/9/2017.
 */

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    DB_Con imageLoad;
    String tittle1;
    String tittle2;
    String tittle3;
    String tittle4;
    String tittle5;
    String tittle6;
    String tittle7;
    String tittle8;

    ImageView imageView;

    private String[] titles = {""+tittle1+"",
            ""+tittle2+"",
            ""+tittle3+"",
            ""+tittle4+"",
            ""+tittle5+"",
            ""+tittle6+"",
            ""+tittle7+"",
            ""+tittle8+""};

    private String[] details = {"Frock with black dotts",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};


    private int[] images = {R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5,
            R.drawable.g6,
            R.drawable.g7,
            R.drawable.g8};


    class ViewHolder extends RecyclerView.ViewHolder {


        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;



        public ViewHolder(View itemView) {
            super(itemView);
            itemImage =(ImageView)itemView.findViewById(R.id.item_image);
            itemTitle =(TextView)itemView.findViewById(R.id.item_title);
            itemDetail=(TextView)itemView.findViewById(R.id.item_detail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, ""+details[position]+"" + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }
    public int getItemCount() {
        return titles.length;
    }

  /*  private void loadImageFromUrl(String url) {

        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.field_image_thumb);
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher) //if error
                .into(imageView,new com.squareup.picasso.Callback(){


                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

    }*/



 /*   public void loadimage()
    {

        ImageView img = (ImageView) findViewById(R.id.imageView1);
        try {
            URL url = new URL("Your URL");
            //try this url = "http://0.tqn.com/d/webclipart/1/0/5/l/4/floral-icon-5.jpg"
            HttpGet httpRequest = null;

            httpRequest = new HttpGet(url.toURI());

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = (HttpResponse) httpclient
                    .execute(httpRequest);

            HttpEntity entity = response.getEntity();
            BufferedHttpEntity b_entity = new BufferedHttpEntity(entity);
            InputStream input = b_entity.getContent();

            Bitmap bitmap = BitmapFactory.decodeStream(input);

            img.setImageBitmap(bitmap);

        } catch (Exception ex) {

        }
    }*/

}



