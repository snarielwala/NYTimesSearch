package nytimessearch.com.nytimessearch;

import android.content.Context;
import android.media.Image;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by snarielwala on 2/11/16.
 */
public class ArticleArrayAdapter extends ArrayAdapter<Article> {

    public ArticleArrayAdapter(Context context, List<Article> articles){
        super(context,android.R.layout.simple_list_item_1,articles);


}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //check to see if the view is being recycled
        Article article = getItem(position);
        //if not, inflate the layout

        //find the image view
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_article_result,parent,false);
        }


        ImageView imageView = (ImageView)convertView.findViewById(R.id.ivImage);
        imageView.setImageResource(0);


        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        tvTitle.setText(article.getHeadLine());
        String thumbnail = article.getThumbnail();
        if(!TextUtils.isEmpty(thumbnail)){
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        }

    return convertView;
        //clear out the recycled image


    }

    }
