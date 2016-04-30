package com.gdgistanbul.studyjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CheckoutActivity extends AppCompatActivity {

  public static final String EXTRA_QUANTITY = "quantitys";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_checkout);

    int quantity = getIntent().getIntExtra(EXTRA_QUANTITY, 0);
    int unitPrice = getIntent().getIntExtra("unitprice", 0);

    Log.d("CheckoutActivity", String.format("Quantity: %s, UnitPrice: %s", quantity, unitPrice));
  }
}
