package society.doscon.com.doscon;

import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class Drawerlayout extends DrawerLayout.SimpleDrawerListener {
    private static final float END_SCALE = 0.75f;
    View contentView;

    Drawerlayout (View contentView){
        this.contentView=contentView;
    }
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
//        labelView.setVisibility(slideOffset > 0 ? View.VISIBLE : View.GONE);

        // Scale the View based on current slide offset
        final float diffScaledOffset = slideOffset * (1 - END_SCALE);
        final float offsetScale = 1 - diffScaledOffset;
        contentView.setScaleX(offsetScale);
        contentView.setScaleY(offsetScale);

        // Translate the View, accounting for the scaled width
        final float xOffset = drawerView.getWidth() * slideOffset;
        final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
        final float xTranslation = xOffset - xOffsetDiff;
        contentView.setTranslationX(xTranslation);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
//        labelView.setVisibility(View.GONE);
    }

}
