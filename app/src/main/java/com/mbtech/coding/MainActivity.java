package com.mbtech.coding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Quotes> quotes;

    public String jsonQuote;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.mylist);

        //  ArrayList<Quotes> quotes = new QuoteQuery().extractQuote();


         quotes = extractQuote();


        //   jsonQuote = readJSONFromAsset();


        // Find a reference to the {@link ListView} in the layout


        // Create a new {@link ArrayAdapter} of earthquakes
        CustomArrayAdapter adapter = new CustomArrayAdapter(getApplicationContext(), quotes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the us

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Quotes quote = quotes.get(position);
                String text = quote.getQuoteString();

                Intent intent = new Intent(MainActivity.this,Showquote.class);
                intent.putExtra("text",text);
                startActivity(intent);

            }
        });

    }


    // JSONObject obj = new JSONObject(readJSONFromAsset());

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("pquotes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public ArrayList<Quotes> extractQuote() {
        ArrayList<Quotes> quotes = new ArrayList<Quotes>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset());
            for (int i = 0; i < 1000; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String quoteT = jsonObject.getString("en");
                String auth = jsonObject.getString("author");

                quotes.add(new Quotes(quoteT, auth));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quotes;


    }
}














