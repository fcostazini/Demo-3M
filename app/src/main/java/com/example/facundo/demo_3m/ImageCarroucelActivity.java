package com.example.facundo.demo_3m;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class ImageCarroucelActivity extends Activity{

    public static final String TO_SHOW = "toShow";
    private int[] imagesIdToShow = {R.drawable.notification_template_icon_bg};
    private float lastX;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carroucel);


        if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey(TO_SHOW)) {
            this.imagesIdToShow = this.getIntent().getExtras().getIntArray(TO_SHOW);
        } else if (savedInstanceState != null && savedInstanceState.containsKey(TO_SHOW)) {
            this.imagesIdToShow = savedInstanceState.getIntArray(TO_SHOW);
        }

        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);

        for (int anImagesIdToShow : imagesIdToShow) {
            ImageView image = new ImageView(getApplicationContext());
            image.setBackgroundResource(anImagesIdToShow);
            viewFlipper.addView(image);
        }


    }

    // Using the following method, we will handle all screen swaps.

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                // Handling left to right screen swap.
                if (lastX < currentX) {

                    // If there aren't any other children, just break.
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    // Next screen comes in from left.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                    // Current screen goes out from right.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                    // Display next screen.
                    viewFlipper.showNext();
                }

                // Handling right to left screen swap.
                if (lastX > currentX) {

                    // If there is a child (to the left), kust break.
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;

                    // Next screen comes in from right.
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);

                    // Display previous screen.
                    viewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }

}
