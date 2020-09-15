package com.mbtech.coding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomArrayAdapter extends ArrayAdapter<Quotes> {

    ArrayList<Quotes>  quotesArrayList;
    public CustomArrayAdapter( Context context, ArrayList<Quotes> resource) {
        super(context,0, resource);
        this.quotesArrayList = resource;
    }



        public int getCount () {
       return quotesArrayList.size();
    }



        @Override
        public View getView ( int position, View convertView, ViewGroup parent) {



                View view = convertView;
                if (view == null) {

                    view = LayoutInflater.from(getContext()).inflate(
                            R.layout.myitem, parent, false);

                }

                Quotes quotes = getItem(position);
                TextView textQuote = view.findViewById(R.id.quoteText);
                textQuote.setText(quotes.getQuoteString());

            TextView textAut = view.findViewById(R.id.textAuth);

            if(quotes.getAuthor().equals("")){
                textAut.setText("NA");

            }
            else {
                textAut.setText("by "+quotes.getAuthor());
            }





                return view;
        }





}
