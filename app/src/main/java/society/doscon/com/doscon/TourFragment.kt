package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView


class TourFragment : Fragment() {
    var positionl: Int = 0

    companion object {
        fun newInstance(position: Int): TourFragment {
          var tourFragment=  TourFragment()
            tourFragment.positionl = position
            println("positionl "+ tourFragment.positionl)
            println("positionl "+ position)
            return tourFragment
        }
    }

    lateinit var webpagesLinear: WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.first_frgment_view, container, false)
        webpagesLinear = view.findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
//        webpagesLinear.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        var st:String=""
        /*if (positionl == 0)
           st= getString(R.string.tour_1)
        if (positionl == 1)
            st= getString(R.string.tour_2)
        if (positionl == 2)
            st= getString(R.string.tour_3)
        if (positionl == 3)
            st= getString(R.string.tour_4)
        if (positionl == 4)
            st= getString(R.string.tour_5)
        if (positionl == 5)
            st= getString(R.string.tour_6)*/

            webpagesLinear.loadData(st, "text/html; charset=utf-8", "utf-8");
        return view;
    }
}