package com.famouscoader.razorpaykotlinapi

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface RazorPayUsers {

    @POST("customers")
    fun addCustomer(@HeaderMap header: Map<String,String?>, @Body addBikes:AddCustomerResponseModel): Observable<CustomerResponseModel>

    companion object Factory{
        fun create():RazorPayUsers{
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.razorpay.com/v1/")
                .build()

            return (retrofit.create(RazorPayUsers::class.java))
        }
    }
}