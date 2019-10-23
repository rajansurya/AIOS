package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.first_frgment_view.*


class Invitation : Fragment() {
    companion object {
        fun newInstance(): Invitation {
            return Invitation()
        }
    }
lateinit var webpagesLinear:WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.first_frgment_view, container, false)
//        val webview = WebView(activity)
        //webview.isVerticalScrollBarEnabled = true
        webpagesLinear=view.findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //webpagesLinear.addView(webview)
//        webpagesLinear.loadData(getString(R.string.invitation), "text/html; charset=utf-8", "utf-8");
        return view;
    }
}