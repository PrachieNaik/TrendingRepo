package com.example.trendingrepo.network

import okhttp3.Interceptor
import okhttp3.Response

object AddHeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("abcd","efgh").build()
        return chain.proceed(request)
    }
}