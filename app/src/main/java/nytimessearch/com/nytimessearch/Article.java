package nytimessearch.com.nytimessearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by snarielwala on 2/11/16.
 */
public class Article implements Serializable {
    String webUrl;
    String headLine;

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    String thumbnail;


    public Article(JSONObject jsonObject){
       try {
           this.webUrl = jsonObject.getString("web_url");
           this.headLine=jsonObject.getJSONObject("headline").getString("main");

           JSONArray multimedia = jsonObject.getJSONArray("multimedia");
           if(multimedia.length()>0){
               JSONObject multimediaJson = multimedia.getJSONObject(0);
               this.thumbnail="http://www.nytimes.com/"+multimediaJson.getString("url");
           }
           else{
               this.thumbnail="";
           }
       }
       catch(JSONException e){

       }

    }

    public static ArrayList<Article> fromJsonArray(JSONArray jsonArray){
        ArrayList<Article> results = new ArrayList<>();

        for(int i=0;i<jsonArray.length();i++){
            try {
                results.add(new Article(jsonArray.getJSONObject(i)));
            }
            catch(JSONException e){
                e.printStackTrace();
            }
        }
        return results;

    }

}
