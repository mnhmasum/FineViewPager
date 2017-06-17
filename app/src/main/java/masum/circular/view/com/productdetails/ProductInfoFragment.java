package masum.circular.view.com.productdetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import customview.masum.com.carouselviewpagerandroid.R;
import masum.circular.view.com.views.MasumCircularSlideLayout;

public class ProductInfoFragment extends Fragment {

    private static final String POSITON = "position";
    private static final String SCALE = "scale";
    private static final String DRAWABLE_RESOURE = "resource";
    private int drawables[] = {R.drawable.bd1, R.drawable.bandarban, R.drawable.khulna, R.drawable.nijhum, R.drawable.kuakata};
    private String titles[] = {"Bangladesh nature 1", "Bangladesh nature 2", "Bangladesh nature 3", "Bangladesh nature 4", "Bangladesh nature 5"};
    private String place[] = {"Gazipur", "Bandarban", "Khulna", "Nijhum Dwip", "kuakata"};

    private int screenWidth;
    private int screenHeight;

    public static Fragment newInstance(Context context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt(POSITON, pos);
        b.putFloat(SCALE, scale);

        return Fragment.instantiate(context, ProductInfoFragment.class.getName(), b);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getScreenSize();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        final int postion = this.getArguments().getInt(POSITON);
        float scale = this.getArguments().getFloat(SCALE);

        int pageMargin = ((Resources.getSystem().getDisplayMetrics().widthPixels / 10) * 2);
        int pageMargin1 = ((Resources.getSystem().getDisplayMetrics().heightPixels / 8) * 2);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth - pageMargin, screenHeight - pageMargin1);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_product_info, container, false);

        MasumCircularSlideLayout root = (MasumCircularSlideLayout) linearLayout.findViewById(R.id.root_container1);
        LinearLayout linear = (LinearLayout) linearLayout.findViewById(R.id.wrapper_main);
        linear.setLayoutParams(layoutParams);

        TextView textFareCost = (TextView) linearLayout.findViewById(R.id.text);
        TextView textPerKiloCost = (TextView) linearLayout.findViewById(R.id.textViewNote);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageProduct);
        textFareCost.setText(titles[postion]);
        textPerKiloCost.setText(place[postion]);
        imageView.setImageResource(drawables[postion]);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        root.setScale(scale);

        return linearLayout;
    }

    private void getScreenSize() {
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
