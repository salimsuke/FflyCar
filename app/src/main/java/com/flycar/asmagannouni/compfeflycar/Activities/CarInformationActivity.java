package com.flycar.asmagannouni.compfeflycar.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flycar.asmagannouni.compfeflycar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarInformationActivity extends AppCompatActivity {



    @BindView(R.id.button_goto_pictures_select)
    Button button_goto_pictures_select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);

        ButterKnife.bind(this);

        button_goto_pictures_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CarInformationActivity.this,MainGalleryActivity.class));

            }
        });

    }
}
