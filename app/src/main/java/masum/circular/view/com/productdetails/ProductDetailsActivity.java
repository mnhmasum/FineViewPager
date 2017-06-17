package masum.circular.view.com.productdetails;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import customview.masum.com.carouselviewpagerandroid.R;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int pageMargin = ((Resources.getSystem().getDisplayMetrics().widthPixels / 10) * 2);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageMargin(-pageMargin);

        CircularPagerAdapter adapter = new CircularPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        viewPager.addOnPageChangeListener(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(10);
    }

}
