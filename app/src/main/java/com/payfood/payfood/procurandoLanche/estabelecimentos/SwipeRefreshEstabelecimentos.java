package com.payfood.payfood.procurandoLanche.estabelecimentos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.payfood.payfood.R;


public class SwipeRefreshEstabelecimentos implements SwipeRefreshLayout.OnRefreshListener{

    SwipeRefreshLayout swipeRefreshLayout;
    Listener listener;

    public SwipeRefreshEstabelecimentos(View view, Listener listener) {
        this.listener = listener;
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_estabelecimentos);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        listener.onSwipeRefresh();
    }

    public void stopRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    public interface Listener {
        void onSwipeRefresh();
    }
}
