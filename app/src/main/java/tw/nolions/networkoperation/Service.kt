package tw.nolions.networkoperation

import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET("/get")
    suspend fun get(@Query("foo") foo: String? = null): Response<GetResp>

    @DELETE("/delete")
    suspend fun delete(@Query("foo") foo: String? = null): Response<GetResp>

    @PUT("/put")
    suspend fun put(@Query("foo") foo: String? = null): Response<GetResp>

    @POST("/post")
    suspend fun post(@Query("foo") foo: String? = null): Response<GetResp>
}