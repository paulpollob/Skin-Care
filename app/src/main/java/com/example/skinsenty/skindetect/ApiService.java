package com.example.skinsenty.skindetect;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @Multipart
    @POST("upload")
    Call<Info> uploadImage(@Part MultipartBody.Part image);
}
