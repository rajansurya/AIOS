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
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.header_other.*
import society.doscon.com.doscon.R.id.vScroll
import society.doscon.com.doscon.R.id.hScroll
import society.doscon.com.doscon.R.id.vScroll


class Registration : Fragment() {


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
        title_name.text = "REGISTRATION"
        back.setOnClickListener { activity?.finish() }
       // r1.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
        r2.text = Html.fromHtml(resources.getString(R.string.rupy) + 6500 + "*")
        r3.text = Html.fromHtml(resources.getString(R.string.rupy) + 7500 + "*")
        r4.text = Html.fromHtml(resources.getString(R.string.rupy) + 9000 + "*")

        r21.text = Html.fromHtml(resources.getString(R.string.rupy) + 7500 + "*")
//        r22.text = Html.fromHtml(resources.getString(R.string.rupy) + 500 + "*")
        r23.text = Html.fromHtml(resources.getString(R.string.rupy) + 8500 + "*")
        r24.text = Html.fromHtml(resources.getString(R.string.rupy) + 10000 + "*")

        r31.text = Html.fromHtml(resources.getString(R.string.rupy) + 4500 + "*")
//        r32.text = Html.fromHtml(resources.getString(R.string.rupy) + 500 + "*")
        r33.text = Html.fromHtml(resources.getString(R.string.rupy) + 5500 + "*")
        r34.text = Html.fromHtml(resources.getString(R.string.rupy) + 7000 + "*")

        r41.text = Html.fromHtml(resources.getString(R.string.rupy) + 600 + "*")
//        r42.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500+ "*")
        r43.text = Html.fromHtml(resources.getString(R.string.rupy) + 800 + "*")
        r44.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")

        /*r51.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
//        r52.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
        r53.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
        r54.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")


        r61.text = Html.fromHtml(resources.getString(R.string.rupy) + 1000 + "*")
//        r62.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r63.text = Html.fromHtml(resources.getString(R.string.rupy) + 1200 + "*")
        r64.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")


        r71.text = Html.fromHtml(resources.getString(R.string.rupy) + 1500 + "*")
//        r72.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r73.text = Html.fromHtml(resources.getString(R.string.rupy) + 2000 + "*")
        r74.text = Html.fromHtml(resources.getString(R.string.rupy) + 3000 + "*")

        r81.text = Html.fromHtml(resources.getString(R.string.doller) + 100 + "*")
//        r72.text = Html.fromHtml(resources.getString(R.string.rupy) + 1800 + "*")
        r83.text = Html.fromHtml(resources.getString(R.string.doller) + 125 + "*")
        r84.text = Html.fromHtml(resources.getString(R.string.doller) + 150 + "*")*/

        webpagesLinear = view.findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.webViewClient = WebViewClient()
        webpagesLinear.requestFocus(View.FOCUS_DOWN or View.FOCUS_UP)
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webpagesLinear.loadData(getString(R.string.imp_note), "text/html; charset=utf-8", "utf-8");


    }
}