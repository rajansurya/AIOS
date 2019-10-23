package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.header_other.*

/**
 * Created by RDX on 02-10-2018.
 */
class Contact:Activity(){
    lateinit var webpagesLinear: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_content)
        title_name.text="CONTACT"
        back.setOnClickListener { this@Contact.finish() }
        webpagesLinear=findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //webpagesLinear.loadData(getString(R.string.contact), "text/html; charset=utf-8", "utf-8");

    }
}