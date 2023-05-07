package com.example.teacherbill.services

import com.example.teacherbill.model.Teacher
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import com.google.gson.annotations.SerializedName

interface Api {
    @GET("get_teacher")
    fun getTeacher(): Call<ResponseBody>

    @POST("create_teacher")
    @FormUrlEncoded
    fun createTeacher(
        @Field("tenGiaoVien") value1: String,
        @Field("maGiaoVien") value2: String,
        @Field("idBangCap") value3: Int
    ): Call<ResponseBody>
}

data class TeacherResponse(
    @SerializedName("data")
    val teachers: List<Teacher>
)