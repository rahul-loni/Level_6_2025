package com.example.otp_auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListPage extends AppCompatActivity {


   String Items[]={
           "Rahul ",
           "Binod sir ",
           "Asmit sir ",
           "Krishna Sir ",
           "Rupak Sir "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_page);

       ListView listView=findViewById(R.id.list);

        ArrayAdapter adapter=new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Items);
        listView.setAdapter(adapter);


      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


              if(i==0){
                  Toast.makeText(ListPage.this, "Click Item1", Toast.LENGTH_SHORT).show();
              }
              if(i==1){
                  Intent intent=new Intent(getApplicationContext(), Second.class);
                  startActivity(intent);
              }
              if (i==2){
                  Intent intent3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://thirdweb.com/"));
                  startActivity(intent3);
              }
          }
      });
    }

}