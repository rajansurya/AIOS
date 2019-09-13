package society.doscon.com.doscon

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.web_content.*


class Abstract : Activity() {
    companion object {
        fun newInstance(): Abstract {
            return Abstract()
        }
    }
lateinit var context: Context
    lateinit var webpagesLinear: WebView
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_content)
        context=this@Abstract
        title_name.text = "PROGRAM"
        back.setOnClickListener { this@Abstract.finish() }
        webpagesLinear = findViewById(R.id.webpagesLinear)
        /*webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.getSettings().setSupportMultipleWindows(true)
        webpagesLinear.webViewClient=WebViewClient()
       *//* webpagesLinear.setWebChromeClient(object : WebChromeClient() {
            override fun onCreateWindow(view: WebView, dialog: Boolean, userGesture: Boolean, resultMsg: android.os.Message): Boolean {
                val result = view.hitTestResult
                val data = result.extra
                val context = view.context
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data))
                context.startActivity(browserIntent)
                return false
            }
        })*//*
        val pdf = "http://isckrs.com/Scientific-Programme.pdf"
        webpagesLinear.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+pdf)
*/

        webpagesLinear.getSettings().setJavaScriptEnabled(true)
        webpagesLinear.getSettings().setPluginState(WebSettings.PluginState.ON)

        //---you need this to prevent the webview from
        // launching another browser when a url
        // redirection occurs---
        webpagesLinear.setWebViewClient(Callback())
        val pdf = "http://isckrs.com/Scientific-Programme.pdf"
        webpagesLinear.loadUrl("https://docs.google.com/viewer?url=http://isckrs.com/Scientific-Programme.pdf")
    }

    private inner class Callback : WebViewClient() {
        override fun shouldOverrideUrlLoading(
                view: WebView, url: String): Boolean {
            return false
        }
    }
    inner class AppWebViewClients(private val progressBar: ProgressBar) : WebViewClient() {

        init {
            progressBar.visibility = View.VISIBLE
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            // TODO Auto-generated method stub
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }

    inner class MyWebChromeclient : WebChromeClient() {


        override fun onCreateWindow(view: WebView, isDialog: Boolean,
                                    isUserGesture: Boolean, resultMsg: Message): Boolean {

            val newWebView = WebView(context)
            view.addView(newWebView)
            val transport = resultMsg.obj as WebView.WebViewTransport
            transport.webView = newWebView
            resultMsg.sendToTarget()

            newWebView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    val browserIntent = Intent(Intent.ACTION_VIEW)
                    browserIntent.data = Uri.parse(url)
                    context.startActivity(browserIntent)
                    return true
                }
            }
            return true
        }
    }
}