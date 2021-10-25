package com.sdk.fawaterk
import com.sdk.fawaterk.model.InvoiceResponseModel
interface FawSDKListener {
    fun onSuccess(InvoiceResponseModel: InvoiceResponseModel)
    fun onFailed(statusCode: Int, error: String)
    fun onCanceled(error: String)
}