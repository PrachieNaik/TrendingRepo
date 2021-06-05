package com.example.trendingrepo.network

import android.app.Application
import android.content.Context
import com.example.trendingrepo.utils.ConnectivityUtil
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class ForceCacheInterceptor(val application: Application) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        if (!ConnectivityUtil.isNetworkAvailable(context = application.applicationContext)) {
            builder.cacheControl(CacheControl.FORCE_CACHE)
        }
        return chain.proceed(builder.build());
    }
}