package society.doscon.com.doscon

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import kotlinx.android.synthetic.main.registration_view.*
import android.view.MotionEvent
import society.doscon.com.doscon.R.id.vScroll
import society.doscon.com.doscon.R.id.hScroll
import society.doscon.com.doscon.R.id.vScroll







class Registration : Fragment(){


    companion object {
        fun newInstance(): Registration {
            return Registration()
        }
    }

    lateinit var webpagesLinear: WebView
    var mx: Float = 0.0f
    var my: Float = 0.0f
    var curX: Float = 0.0f
    var curY: Float = 0.0f

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.registration_view, container, false)
        return view;
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vScroll.setOnTouchListener { v, event ->
            //inner scroll listener
            false
        }

        r1.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
        r2.text = Html.fromHtml(resources.getString(R.string.rupy) + 1200 + "*")
        r3.text = Html.fromHtml(resources.getString(R.string.rupy) + 1400 + "*")
        r4.text = Html.fromHtml(resources.getString(R.string.rupy) + 2000 + "*")

        r21.text = Html.fromHtml(resources.getString(R.string.rupy) + 900 + "*")
        r22.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
        r23.text = Html.fromHtml(resources.getString(R.string.rupy) + 1200 + "*")
        r24.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")

        r31.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
        r32.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r33.text = Html.fromHtml(resources.getString(R.string.rupy) + 2100 + "*")
        r34.text = Html.fromHtml(resources.getString(R.string.rupy) + 2500 + "*")

        r41.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
        r42.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r43.text = Html.fromHtml(resources.getString(R.string.rupy) + 2100 + "*")
        r44.text = Html.fromHtml(resources.getString(R.string.rupy) + 2500 + "*")

        r51.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
        r52.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r53.text = Html.fromHtml(resources.getString(R.string.rupy) + 2100 + "*")
        r54.text = Html.fromHtml(resources.getString(R.string.rupy) + 2500 + "*")


        r61.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
        r62.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r63.text = Html.fromHtml(resources.getString(R.string.rupy) + 2100 + "*")
        r64.text = Html.fromHtml(resources.getString(R.string.rupy) + 2500 + "*")


        r71.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
        r72.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r73.text = Html.fromHtml(resources.getString(R.string.rupy) + 2100 + "*")
        r74.text = Html.fromHtml(resources.getString(R.string.rupy) + 2500 + "*")



        webpagesLinear=view.findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webpagesLinear.loadData(getString(R.string.imp_note), "text/html; charset=utf-8", "utf-8");


    }
}