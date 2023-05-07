package com.example.teacherbill.model

import com.google.gson.annotations.SerializedName

data class Teacher (
    @SerializedName("id")
    val id: Int,

    @SerializedName("tenGiaoVien")
    val tenGiaoVien: String,

    @SerializedName("maGiaoVien")
    val maGiaoVien: String,

    @SerializedName("idBangCap")
    val idBangCap: Int,

    @SerializedName("bangCap")
    val bangCap: String,

    @SerializedName("heSoGiaoVien")
    val heSoGiaoVien: Float
)