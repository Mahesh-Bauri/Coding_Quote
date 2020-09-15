/* package com.mbtech.quote;

import java.util.ArrayList;
import com.mbtech.quote.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuoteQuery {

    MainActivity mainActivity = new MainActivity();

    String jsonRes = mainActivity.readJSONFromAsset();


    public QuoteQuery(){}

/*
 public  ArrayList<Quotes> extractQuote() {
     ArrayList<Quotes> quotes = new ArrayList<Quotes>();
     try {
         JSONArray jsonArray = new JSONArray(jsonRes);
         for(int i =0 ; i< 10;i++) {
             JSONObject jsonObject = jsonArray.getJSONObject(i);
             String quoteT = jsonObject.getString("quoteText");
             String auth = jsonObject.getString("quoteAuthor");

             quotes.add(new Quotes(quoteT,auth));
         }
     } catch (JSONException e) {
         e.printStackTrace();
     }
     return  quotes;
 }
}
*/
