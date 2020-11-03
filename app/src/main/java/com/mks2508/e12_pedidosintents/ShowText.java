package com.mks2508.e12_pedidosintents;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        Intent intent1 = getIntent();
        String totalText = intent1.getStringExtra("totalText");
        String mailText = intent1.getStringExtra("mailText");
        String email = intent1.getStringExtra("email");


        TextView texto =findViewById(id.textView_order_summary);
        texto.setText(totalText+mailText);
    }

    public void goBackMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Context context = getApplicationContext();
        CharSequence text = "Cancelado!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();

    }

    public void sendMail(View view) {
        Intent intent = getIntent();
        String texto = intent.getStringExtra("totalText");
        String[] correo = {intent.getStringExtra("email")};
        Intent sendIntent = new Intent();

        sendIntent.setAction(Intent.ACTION_SENDTO);
        sendIntent.setData(Uri.parse("mailto:"));
        sendIntent.putExtra(Intent.EXTRA_TEXT, texto);
        sendIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, correo);
        startActivity(Intent.createChooser(sendIntent, "Send Email"));
        finish();
    }


}


