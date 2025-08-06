package com.benjamin.horoscopoapp.data.providers.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Autorization", "jhasfgdiksdfg")
            .build()
        return chain.proceed(request)
    }
}

class TokenManager @Inject constructor(){
    fun getToken(): String = "BENJAMIN"
}