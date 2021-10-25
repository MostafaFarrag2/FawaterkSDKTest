package com.sdk.fawaterk.utils

import com.sdk.fawaterk.FawSDKController
import com.sdk.fawaterk.model.InvoiceModel
import com.sdk.fawaterk.FawSDKListener
import com.sdk.fawaterk.MainListener
internal object Const {
//    var isTestMode: Boolean = false

    const val LOGIN_GRANT_TYPE = "password"
    const val CALL_BACK_URL = "https://app.fawaterk.com/"
    const val ERROR_URL = "https://app.fawaterk.com/"

    const val TRANSACTION_SUCCESS = 2
    const val TRANSACTION_FAILED = 3

    const val SUCCESS = 200
    const val SERVER_ERROR = 500
    const val CONFIG_ERROR = 100

    var username = ""
    var password = ""
    lateinit var listener: MainListener
    var invoiceModel: InvoiceModel? = null
    lateinit var apiLang: String
    lateinit var paymentMethod: String

    var PAYMENT_SCREEN_TITLE = ""
    var TITLE_TEXT_COLOR = -1
    var TITLE_BACKGROUND_COLOR = -1
    var IS_SHOW_ACTION_BAR = true
}