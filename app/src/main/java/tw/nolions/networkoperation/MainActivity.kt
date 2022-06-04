package tw.nolions.networkoperation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Repository.baseAPI("https://httpbin.org", this)

        setUI()
    }

    private fun setUI() {
        getBtn.setOnClickListener(this)
        postBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        putBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = when (view?.id) {
                R.id.getBtn -> {
                    Repository.get("aaa")
                }
                R.id.postBtn -> {
//                    Repository.post()
                    Repository.postJson(Message(title = "123", msg = "hello"))

                }
                R.id.putBtn -> {
                    Repository.put("aa")
                }
                R.id.deleteBtn -> {
                    Repository.delete("aa")
                }
                else -> {
                }
            }

            requestWithContext() {
                Log.d("networkoperation", "result: ${result.toString()}")
            }
        }
    }


    private suspend fun requestWithContext(f: () -> Unit) {
        f.invoke()
    }
}