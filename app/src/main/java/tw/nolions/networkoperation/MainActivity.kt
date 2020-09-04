package tw.nolions.networkoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Repository.baseAPI("https://httpbin.org")

        CoroutineScope(Dispatchers.IO).launch {
            val result = Repository.get()
            withContext(Dispatchers.Main) {
                text.text = Gson().toJson(result.data)
            }
        }
    }
}