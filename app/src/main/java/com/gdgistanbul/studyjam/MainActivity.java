package com.gdgistanbul.studyjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  public TextView quantityTextView;
  public TextView summaryTextView;
  public Button minusButton;
  public EditText unitPriceEditText;
  public int quantity = 1;
  public int unitPrice = 5;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quantityTextView = (TextView) findViewById(R.id.quantityTextView);
    summaryTextView = (TextView) findViewById(R.id.summaryTextView);
    minusButton = (Button) findViewById(R.id.minusButton);
    unitPriceEditText = (EditText) findViewById(R.id.unitPriceEditText);

    displayQuantity(quantity);

    unitPriceEditText.setText(Integer.toString(unitPrice));
  }

  public void onClickMinus(View view) {
    quantity = quantity - 1;
    displayQuantity(quantity);
  }

  public void onClickPlus(View view) {
    quantity = quantity + 1;
    displayQuantity(quantity);
  }

  public void onClickOrder(View view) {
    String unitPriceText = unitPriceEditText.getText().toString();
    unitPrice = Integer.parseInt(unitPriceText);
    int amount = quantity * unitPrice;
    displaySummary(String.format("Toplam Ücret : %s TL", amount));

    getString(R.string.full_name, "HAsan", "Keklik");


    Intent intent = new Intent(this, CheckoutActivity.class);
    intent.putExtra(CheckoutActivity.EXTRA_QUANTITY, quantity);
    intent.putExtra("unitprice", unitPrice);
    startActivity(intent);
  }

  public void displaySummary(String summary) {
    summaryTextView.setText(summary);
  }

  public void displayQuantity(int quantity) {
    minusButton.setEnabled(quantity > 0);
    quantityTextView.setText(Integer.toString(quantity));
  }

}
