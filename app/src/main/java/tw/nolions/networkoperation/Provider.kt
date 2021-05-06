package tw.nolions.networkoperation

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Provider(private val context: Context, api: String) {
    private val retrofit = Retrofit.Builder()
        .baseUrl(api)
        .client(createHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var cacheSize = 10 * 1024 * 1024 // 10 MB

    val cache: Cache
        get() = Cache(context.cacheDir, cacheSize.toLong())


    private fun createHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .followRedirects(false)  //是否允許重新定向
            .followSslRedirects(false) //是否支援 http -> https or https -> http的重新定向
            .retryOnConnectionFailure(false) // 是否允許錯誤重新嘗試連線
            .cache(cache) // Cache 設置
        return httpClient.build()
    }

    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }
}