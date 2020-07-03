package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView coordinatesText;
    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
       coordinatesText=findViewById(R.id.coordinatesText);
       searchBtn=findViewById(R.id.searchBtn);

       searchBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String coordinates=coordinatesText.getText().toString();
               openMap(coordinates);
           }
       });
    }

    private void openMap(String coordinates) {
        Uri uri;
        if(Character.isLetter(coordinates.charAt(0)))
        {
             uri= Uri.parse("geo:?q="+coordinates);
        }
        else
        {
            uri = Uri.parse("geo:"+coordinates);
        }
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
