package tw.nolions.networkoperation

import retrofit2.Response

object Repository {

    private var apiService: Service? = null

    fun baseAPI(baseApi: String) {
        apiService = Provider(baseApi).createService(Service::class.java)
    }

    suspend fun get(foo: String? = null) = response(apiService?.get(foo))

    suspend fun delete(foo: String? = null) = response(apiService?.delete(foo))

    suspend fun put(foo: String? = null) = response(apiService?.put(foo))

    suspend fun post(foo: String? = null) = response(apiService?.post(foo))

    private fun <T> response(result: Response<T>?): Resp<GetResp> {
        return Resp(
            isSuccess = result?.isSuccessful,
            code = result?.code(),
            message = result?.message(),
            data = result?.body() as GetResp
        )
    }
}