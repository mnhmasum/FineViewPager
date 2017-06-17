package masum.circular.view.com.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by masum on 3/14/17.
 */

public class MasumCircularSlideLayout extends LinearLayout {

    private float scale = 1f;

    public MasumCircularSlideLayout(Context context) {
        super(context);
    }

    public MasumCircularSlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MasumCircularSlideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScale(float scale) {
        this.scale = scale;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale, scale, w/2, h/2);
        //canvas.translate(x, y);

    }
}
