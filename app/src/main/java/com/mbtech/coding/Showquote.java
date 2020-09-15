package com.mbtech.coding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Showquote extends AppCompatActivity {
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView quote = (TextView) findViewById(R.id.quoteview);

        Intent intent = getIntent();
         text = intent.getStringExtra("text");
        quote.setText(text);

    }

    public void back_btn(View view) {

                onBackPressed();
    }

    public void send(View view) {
       // Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

        composeMmsMessage(text);
    }


    public  void composeMmsMessage(String message) {


        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT , text);
        //  Intent	chooser	=	Intent.createChooser(intent,"share to");
        //	Resolve	the	intent	before	starting	the	activity
        //
        Intent	chooser	=	Intent.createChooser(intent,	"share to");
        if	(intent.resolveActivity(getPackageManager())	!=	null)	{
            startActivity(chooser); }
    }
}
