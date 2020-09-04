package tw.nolions.networkoperation

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("/get")
    suspend fun get(@Query("foo") foo: String? = null): Response<GetResp>

    @DELETE("/delete")
    suspend fun delete(@Query("foo") foo: String? = null): Response<GetResp>
}