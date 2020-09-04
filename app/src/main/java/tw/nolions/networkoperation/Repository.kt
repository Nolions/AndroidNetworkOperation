package tw.nolions.networkoperation

import retrofit2.Response

object Repository {

    private var apiService: Service? = null

    fun baseAPI(baseApi: String) {
        apiService = Provider(baseApi).createService(Service::class.java)
    }

    suspend fun get(foo: String? = null): Resp<GetResp> {
        val result = apiService?.get(foo)

        return Resp(
            isSuccess = result?.isSuccessful,
            code = result?.code(),
            message = result?.message(),
            data = result?.body() as GetResp
        )
    }

    suspend fun delete(foo: String? = null): Resp<GetResp> {
        val result = apiService?.delete(foo)

        return response(result)
    }

    private fun <T>response(result: Response<T>?):Resp<GetResp> {
        return Resp(
            isSuccess = result?.isSuccessful,
            code = result?.code(),
            message = result?.message(),
            data = result?.body() as GetResp
        )
    }
}