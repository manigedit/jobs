package com.example.jobs;

import android.R.layout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobs.api.ApiClient;
import com.example.jobs.api.ApiInterface;
import com.example.jobs.model.locationResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.layout.*;

public class MainActivity extends AppCompatActivity {



    String textMiddle;
    String textBottom;
    TextView tvMiddle;
    LinearLayout middleLayout;
    TextView tvBottom;
    Button searchButton;
    ImageView menuButton;
    Spinner categorySpinner, areaSpinner;
    public List<String> categories = new ArrayList<>();
    public List<String> locations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = (ImageView) findViewById(R.id.menu_button);
        tvMiddle = (TextView) findViewById(R.id.tv_middle);
        tvBottom = (TextView) findViewById(R.id.tv_bottom);
        searchButton = (Button) findViewById(R.id.search_btn);
        middleLayout = (LinearLayout) findViewById(R.id.middle_layout);
        Spinner categorySpinner = (Spinner) findViewById(R.id.category_spinner);
        final Spinner areaSpinner = (Spinner) findViewById(R.id.area_spinner);

        textMiddle = "<font color=#29C9E9>1500+ </font> <font color=#ffffff>Jobs posted last week</font>";
        tvMiddle.setText(Html.fromHtml(textMiddle, 1));

        textBottom = "<font color=#29C9E9>Search by tags: </font> <font color=#ffffff>Technology, Business, Consulting, IT Company, Design, Development</font>";
        tvBottom.setText(Html.fromHtml(textBottom, 0));

        //middleLayout.setBackgroundResource(R.drawable.circular_egde);

        locations.add("All locations");
        categories.add("All categories ");
        categories.add("Part-time");
        categories.add("Full-time");
        categories.add("Intern");



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, simple_spinner_item, categories);

        final ArrayAdapter<String> statesAdapter = new ArrayAdapter<String>(this, simple_spinner_item, locations);



        dataAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
        statesAdapter.setDropDownViewResource(simple_spinner_dropdown_item);





        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<locationResponse>> call= apiService.getLocations();
        call.enqueue(new Callback<List<locationResponse>>() {
                         @Override
                         public void onResponse(Call<List<locationResponse>> call, Response<List<locationResponse>> response) {
                             List<locationResponse> locationslist = response.body();


                             for (locationResponse location : locationslist) {

                                    String mcity = location.getCity();
                             locations.add(mcity);

                                 //
                                 areaSpinner.setAdapter(statesAdapter);
                             }
                             Toast.makeText(getApplicationContext(), "api connects and gets " + locationslist.size() + " locations", Toast.LENGTH_LONG).show();

                         }



                        @Override
                         public void onFailure(Call<List<locationResponse>> call, Throwable t) {
                             Toast.makeText(getApplicationContext(), "Problem in api", Toast.LENGTH_LONG).show();
                             Log.e("           here is the culprit    ", t.toString());
                            // locations.add("Some error");

                         }
                     });

        categorySpinner.setAdapter(dataAdapter);
        areaSpinner.setAdapter(statesAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Searching for your jobs", Toast.LENGTH_LONG).show();
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Open menu", Toast.LENGTH_LONG).show();
            }
        });


    }


}
