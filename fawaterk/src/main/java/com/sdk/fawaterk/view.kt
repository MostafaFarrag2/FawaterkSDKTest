package com.sdk.fawaterk

import androidx.appcompat.app.AppCompatActivity
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import com.sdk.fawaterk.R
import com.sdk.fawaterk.MainListener
import com.sdk.fawaterk.FawSDKController
import com.sdk.fawaterk.FawSDKListener
import com.sdk.fawaterk.model.InvoiceModel
import com.sdk.fawaterk.model.InvoiceResponseModel
import com.sdk.fawaterk.utils.Const
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toolbar
import com.sdk.fawaterk.network.ApiFactory
import org.json.JSONObject
import java.lang.Exception
class View : AppCompatActivity() {
    private lateinit var listener:FawSDKListener
    private lateinit var invoiceModel: InvoiceModel
    private lateinit var lang: String
    //    private val TAG = FawSDKMain::class.java.simpleName
    private lateinit var token: String
    private val configError = "Configuration error"
    private val paymentCanceled = "Payment canceled"
    init {
        init()
    }
    private fun init() {
        this.listener = Const.listener

        if (ApiFactory.BASE_URL.isEmpty() || Const.username.isEmpty() || Const.password.isEmpty()) {
            listener.onFailed(Const.CONFIG_ERROR, configError)
            finish()
        }
        else {
            this.lang = Const.apiLang
            this.invoiceModel = Const.invoiceModel!!

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        findViewById<ProgressBar>(R.id.pbLoading).visibility = View.VISIBLE

    }






    private fun showWebView(url: String) {
        val pbLoading = findViewById<ProgressBar>(R.id.pbLoading)
        val webView = findViewById<WebView>(R.id.webView)

        pbLoading.visibility = View.GONE

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.webViewClient = WebViewCallback()  //HERE IS THE MAIN CHANGE
        webView.loadUrl(url)
    }

    private inner class WebViewCallback : WebViewClient() {  //HERE IS THE MAIN CHANGE.



        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
//            Log.i(TAG, "onPageFinished: $url")
            findViewById<ProgressBar>(R.id.pbLoading).visibility = View.GONE
        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//            Log.i(TAG, "shouldOverrideUrlLoading: " + request.toString())
            return super.shouldOverrideUrlLoading(view, request)
        }
    }



    @override  fun onCreateInvoiceSuccess(invoiceResponseModel: InvoiceResponseModel) {


        // If the payment method not exists will open the redirect url
        showWebView(invoiceResponseModel.url)
    }



    @override fun onCreateInvoiceFailed(statusCode: Int, error: String) {
        listener.onFailed(statusCode, parseErrorMessage(error))
        finish()
    }


    private fun parseErrorMessage(error: String): String{
        var message = ""
        val obj = JSONObject(error)

        try {
            when {
                obj.has("FieldsErrors") -> {
                    val jsonArray = obj.getJSONArray("FieldsErrors")
                    for (i in 0 until jsonArray.length()) {
                        val o = jsonArray.getJSONObject(i)
                        message += o.get("Error").toString() + "\n"
                    }
                }
                obj.has("error_description") -> message = obj.getString("error_description")
                obj.has("Message") -> message = obj.getString("Message")
            }

            if(message.isEmpty())
                message = error
        }
        catch (e: Exception){
            e.printStackTrace()
            message = error
        }

        return message
    }
}

annotation class override
