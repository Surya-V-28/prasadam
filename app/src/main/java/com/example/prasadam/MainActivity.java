package com.example.prasadam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.prasadam.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn, skipbtn;

    TextView[] dots;
    OnBoardingAdapter viewPagerAdapter;
    // Shared Preference for Checking is this first time user or not
    SharedPreferences sharedPreferences;
    private final static String  shared_preference_name = "mypref";
    private final static String  shared_preference_firstTime = "firstTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Xml page for OnBoarding Slides
        setContentView(R.layout.activity_on_boarding);
      // Code for making the OnBoarding Screen and Passes the main screen as homepage
        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        skipbtn = findViewById(R.id.skipButton);
        Toast.makeText(MainActivity.this,"MainActivity",Toast.LENGTH_LONG).show();
        //sharedPreference implements
        sharedPreferences = getSharedPreferences(shared_preference_name,MODE_PRIVATE);
        if(sharedPreferences.getString(shared_preference_firstTime,"False") =="False") {
            Intent i = new Intent(MainActivity.this,ProcessInddicatorActivity.class);
            startActivity(i);
            finish();
        }
        // For moving back to the previous slides
        backbtn.setOnClickListener(v -> {

            if (getitem(0) > 0){

                mSLideViewPager.setCurrentItem(getitem(-1),true);

            }

        });
        // For Moving  to the next slides from previous one
        nextbtn.setOnClickListener(v -> {

            if (getitem(0) < 3)
                mSLideViewPager.setCurrentItem(getitem(1),true);
            else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(shared_preference_firstTime,"True");
                editor.apply();
                Intent i = new Intent(MainActivity.this,ProcessInddicatorActivity.class);
                startActivity(i);
                finish();

            }
        });
        // Skiping all onboarding Screen
        skipbtn.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,ProcessInddicatorActivity.class);
            startActivity(i);
            finish();

        });
        mSLideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new OnBoardingAdapter(this);

        mSLideViewPager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);

    }


    public void setUpindicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){

            dots[i] = new TextView(this);
            dots[i].setText(HtmlCompat.fromHtml("&#8226",HtmlCompat.FROM_HTML_MODE_LEGACY));
            //dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);
            if (position > 0){
                backbtn.setVisibility(View.VISIBLE);

            }else {
                backbtn.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    //Get current Item id for the slides
    private int getitem(int i){
        return mSLideViewPager.getCurrentItem() + i;
    }


    private ActivityMainBinding binding = null;
}