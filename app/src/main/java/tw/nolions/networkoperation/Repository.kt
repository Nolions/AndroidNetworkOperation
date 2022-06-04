package tw.nolions.networkoperation

import android.content.Context
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response

object Repository {

    private var apiService: Service? = null

    fun baseAPI(baseApi: String, context: Context) {
        apiService = Provider(baseApi, context).createService(Service::class.java)
    }

    suspend fun get(foo: String? = null) = response(apiService?.get(foo))

    suspend fun delete(foo: String? = null) = response(apiService?.delete(foo))

    suspend fun put(foo: String? = null) = response(apiService?.put(foo))

    suspend fun post(foo: String? = null) = response(apiService?.post(foo))

    suspend fun postJson(msg: Message) = response(
        apiService?.postJson(
            Gson().toJson(msg).toRequestBody("application/json; charset=utf-8".toMediaType())
        )
    )

    private fun <T> response(result: Response<T>?): Resp<GetResp> {
        return Resp(
            isSuccess = result?.isSuccessful,
            code = result?.code(),
            message = result?.message(),
            data = result?.body() as GetResp
        )
    }
}

data class Message(
    val title: String,
    val msg: String
) {
}