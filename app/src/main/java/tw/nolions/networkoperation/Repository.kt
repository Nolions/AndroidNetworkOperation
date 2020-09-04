package tw.nolions.networkoperation

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
}