package framework.niceUiComponents;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.payfood.payfood.R;

import framework.Tela;

public class SwipeBalls {

    LinearLayout layoutSwipeBalls;

    public SwipeBalls(Tela tela, ViewPager pager) {
        this.layoutSwipeBalls = (LinearLayout) tela.findViewById(R.id.layout_swipe_balls);
        pager.addOnPageChangeListener(makeListener());
    }

    public void setItens(int itens) {
        layoutSwipeBalls.removeAllViews();
        int i = 0;
        while (i < itens) {
            View ball = LayoutInflater.from(layoutSwipeBalls.getContext()).inflate(R.layout.swipe_ball, layoutSwipeBalls, false);
            ball.setTag(i);
            layoutSwipeBalls.addView(ball);
            i++;
        }
    }

    @NonNull
    private ViewPager.OnPageChangeListener makeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                activePosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    public void activePosition(int position) {
        inativeAll();
        View ballToActive = layoutSwipeBalls.findViewWithTag(position);
        ballToActive.setEnabled(true);
    }

    private void inativeAll() {
        int count = layoutSwipeBalls.getChildCount();
        int i = 0;
        while (i < count) {
            layoutSwipeBalls.getChildAt(i).setEnabled(false);
            i++;
        }
    }
}