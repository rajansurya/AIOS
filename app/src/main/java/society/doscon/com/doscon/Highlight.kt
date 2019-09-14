package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import kotlinx.android.synthetic.main.header_other.*

class Highlight:FragmentActivity(){
    companion object {
        fun newInstance(): Highlight {
            return Highlight()
        }
    }
    lateinit var webpagesLinear: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_frgment_view)
//        var view = inflater.inflate(R.layout.first_frgment_view, container, false)
        title_name.text="HIGHLIGHTS"
        title_name.setTextColor(resources.getColor(R.color.white));
        back.setOnClickListener { this@Highlight.finish() }
        webpagesLinear=findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webpagesLinear.loadData(getString(R.string.highlight), "text/html; charset=utf-8", "utf-8");


    }

}