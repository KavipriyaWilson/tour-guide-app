package com.example.android.tourguideapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedInfoActivity extends AppCompatActivity {

    @BindView(R.id.detailInfoImageView)
    ImageView detailImage;

    @BindView(R.id.detailNameTextView)
    TextView detailplaceName;


    @BindView(R.id.descriptionTextView)
    TextView detailDiscText;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);
        ButterKnife.bind(this);
        extractDataAndSetToViews();
    }
    /************************** it extracts recieved intent data from fragment and populate it ************************/
    public void extractDataAndSetToViews()
    {
        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("index");
        Place infoDataObject = bundle.getParcelable("object");

        int imageResourceID = infoDataObject.getPlaceImageResourceID();
        String name = infoDataObject.getPlaceName();
        String discription = getString(R.string.discription) + infoDataObject.getPalaceDiscription();

        detailImage.setImageResource(imageResourceID);
        detailplaceName.setText(name);
        detailDiscText.setText(discription);
    }
}