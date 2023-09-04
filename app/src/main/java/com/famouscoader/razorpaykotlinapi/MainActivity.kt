package com.famouscoader.razorpaykotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authBase64 =getBaseAuthByUserNamePassword("rzp_test_rIZjdOY49anWzb","7n7wZVvhcr32Fxb3FUy93oWc")

        addUser(authBase64)
    }

    private fun addUser(auth:String){

        val requestAddBike = AddCustomerResponseModel("Sudhir","sudhirkumar.edugaon@gmail.com", "8292448021","1","12ABCDE2356F7GH", Notes("Tea, Earl Grey, Hot","Tea, Earl Grey… decaf."))
        RazorPayUsers.create().addCustomer(getHeaderMap(auth) ,requestAddBike)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                hieLoaderActivity()
                Toast.makeText(this,"Your bike is added", Toast.LENGTH_SHORT).show()
                this.finish()
            },{
//                hieLoaderActivity()
                Toast.makeText(this,"Not able to add, please try after sometimes", Toast.LENGTH_SHORT).show()
            })
    }

    fun getBaseAuthByUserNamePassword (userName:String, password:String): String {
        val credentials: String = userName + ":" + password
        return "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
    }

    fun getHeaderMap(authKey: String): Map<String, String?> {
        val headerMap = mutableMapOf<String, String?>()

        headerMap["Authorization"] = authKey
        return headerMap
    }

}