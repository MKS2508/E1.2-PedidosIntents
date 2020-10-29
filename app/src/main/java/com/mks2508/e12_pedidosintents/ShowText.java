package com.mks2508.e12_pedidosintents;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.mks2508.e12_pedidosintents.R.*;


public class ShowText extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_show_text);

        Intent intent = getIntent();
        String text = intent.getStringExtra("texto");

        TextView texto =findViewById(id.textView_order_summary);
        texto.setText(text);
    }

    public void goBackMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void sendMail(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


