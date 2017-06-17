package masum.circular.view.com.productdetails;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import customview.masum.com.carouselviewpagerandroid.R;
import masum.circular.view.com.views.MasumCircularSlideLayout;


public class CircularPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    public final static float BIG_SLIDE = 1f;
    public final static float SMALL_SLIDE = 0.90f;
    public final static float DIFF_SLIDE = BIG_SLIDE - SMALL_SLIDE;
    private Context context;
    private SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    private float scale;

    public CircularPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        scale = SMALL_SLIDE;
        return ProductInfoFragment.newInstance(context, position, scale);
    }

    @Override
    public int getCount() {
        return 5; // This is the array size
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        Log.e("position: ", "" + positionOffset);
        Log.e("position no: ", "" + position);

        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                MasumCircularSlideLayout cur = (MasumCircularSlideLayout) getRegisteredFragment(position)
                        .getView().findViewById(R.id.root_container1);
                MasumCircularSlideLayout next = (MasumCircularSlideLayout) getRegisteredFragment(position + 1)
                        .getView().findViewById(R.id.root_container1);

                cur.setScale(BIG_SLIDE - DIFF_SLIDE * positionOffset);
                next.setScale(SMALL_SLIDE + DIFF_SLIDE * positionOffset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}