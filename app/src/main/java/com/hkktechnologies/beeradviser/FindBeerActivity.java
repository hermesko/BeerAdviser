package com.hkktechnologies.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    // called when the Button is pressed
    public void onClickFindBeer(View view) {

        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        //Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Call the BeerExpert getBrands() method, assigning the return value to suggestions
        List<String> suggestions = expert.getBrands(beerType);

        //Convert List<String> suggestions to a single string
        String results = new String();
        for (int i = 0; i < suggestions.size(); i++) {
            results = results + '\n' + suggestions.get(i);
        }

        //Display the beers
        brands.setText(results);

    }
}
