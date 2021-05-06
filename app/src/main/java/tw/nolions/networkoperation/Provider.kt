package tw.nolions.networkoperation

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Provider(api: String) {
    private val retrofit = Retrofit.Builder()
        .baseUrl(api)
        .client(createHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun createHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .followRedirects(false)
            .followSslRedirects(false)
            .retryOnConnectionFailure(false)
            .cache(null)
        return httpClient.build()
    }

    fun <S> createService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }
}