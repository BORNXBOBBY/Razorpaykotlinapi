package com.famouscoader.razorpaykotlinapi


import com.google.gson.annotations.SerializedName


data class CustomerResponseModel (

    @SerializedName("id"         ) var id        : String? = null,
    @SerializedName("entity"     ) var entity    : String? = null,
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("email"      ) var email     : String? = null,
    @SerializedName("contact"    ) var contact   : String? = null,
    @SerializedName("gstin"      ) var gstin     : String? = null,
    @SerializedName("notes"      ) var notes     : Notes?  = Notes(),
    @SerializedName("created_at" ) var createdAt : Int?    = null

)
data class AddCustomerResponseModel (
    @SerializedName("name"         ) var name        : String? = null,
    @SerializedName("email"     ) var email    : String? = null,
    @SerializedName("contact"       ) var contact      : String? = null,
    @SerializedName("fail_existing"      ) var fail_existing     : String? = null,
    @SerializedName("gstin"    ) var gstin   : String? = null,
    @SerializedName("notes"      ) var notes     : Notes?  = Notes(),

    )
data class Notes (

    @SerializedName("notes_key_1" ) var notesKey1 : String? = null,
    @SerializedName("notes_key_2" ) var notesKey2 : String? = null

)