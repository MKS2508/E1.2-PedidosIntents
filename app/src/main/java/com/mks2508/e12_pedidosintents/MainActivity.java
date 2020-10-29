package com.mks2508.e12_pedidosintents;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {

        if (quantity > 0) quantity--;
        display(quantity);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {

        if (quantity < 25) quantity++;
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.textView_count);
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        double unitprice = 1.50;

        EditText nombreEditText = findViewById(R.id.editText_enter);
        EditText mailEditText = findViewById(R.id.editText_enterEmail);


        String name = nombreEditText.getText().toString();
        String email = mailEditText.getText().toString();

        String text_quantity = name + getString(R.string.you_ordered_text) + quantity + getString(R.string.coffees_text);
        String text_mail = "Tu email es: " + email;
        CheckBox whippedcreamcheckbox = findViewById(R.id.check_whipped_cream);
        boolean whippedcreamchecked = whippedcreamcheckbox.isChecked();

        CheckBox chocolatecheckbox = findViewById(R.id.check_chocolate);
        boolean chocolatechecked = chocolatecheckbox.isChecked();

        if (whippedcreamchecked) {
            text_quantity += getString(R.string.with_whipped_cream);
            unitprice += 0.50;
            if (chocolatechecked) text_quantity += getString(R.string.and);
            ;
        }
        if (chocolatechecked) {
            text_quantity += getString(R.string.with_chocolate);
            unitprice += 0.50;
        }

        double totalprice = unitprice * quantity;
        String text_price = getString(R.string.total_price_text) + totalprice + " €";
        String totalText = text_quantity + "\n" + text_price + "\n" + text_mail;
        //email
        Intent intent = new Intent(this, ShowText.class);
        intent.putExtra("texto", totalText);
        startActivity(intent);

    }

}