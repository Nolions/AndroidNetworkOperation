package tw.nolions.networkoperation

import com.google.gson.annotations.SerializedName

class GetResp(val args: HashMap<String, String>, val headers: Header, val origin: String, val url: String) {
    class Header(
        @SerializedName("Accept") val accept: String,
        @SerializedName("Accept-Encoding") val acceptEncoding: String,
        @SerializedName("Accept-Language") val acceptLanguage: String,
        @SerializedName("Sec-Fetch-Dest") val secFetchDest: String,
        @SerializedName("Sec-Fetch-Mode") val secFetchMode: String,
        @SerializedName("Sec-Fetch-Site") val secFetchSite: String,
        @SerializedName("Sec-Fetch-User") val secFetchUser: String,
        @SerializedName("Upgrade-Insecure-Requests") val upgradeInsecureRequests: String,
        @SerializedName("User-Agent") val userAgent: String,
        @SerializedName("X-Amzn-Trace-Id") val xAmznTraceId: String,
        @SerializedName("Host") val host: String
    )
}

class Resp<T>(
    val isSuccess: Boolean? = false,
    val code: Int? = 0,
    val message: String? = null,
    val data: T? = null
)