package com.sdk.fawaterk
import com.sdk.fawaterk.model.InvoiceResponseModel

internal interface MainListener : FawSDKListener {
    fun onCreateInvoiceSuccess(invoiceResponseModel: InvoiceResponseModel)
    fun onCreateInvoiceFailed(statusCode: Int, error: String)
    override fun onSuccess(InvoiceResponseModel: InvoiceResponseModel) {
        TODO("Not yet implemented")
    }

    override fun onFailed(statusCode: Int, error: String) {
        TODO("Not yet implemented")
    }

    override fun onCanceled(error: String) {
        TODO("Not yet implemented")
    }

}