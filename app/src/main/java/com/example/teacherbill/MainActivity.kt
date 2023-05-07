package com.example.teacherbill

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherbill.adapters.TeacherAdapter
import com.example.teacherbill.services.TeacherResponse
import com.example.teacherbill.services.service
import com.example.teacherbill.ui.theme.TeacherBillTheme
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.button
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var teacherAdapter: TeacherAdapter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Loading...")

        button.setOnClickListener {
            progressDialog.show()
            service.getTeacher().enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    progressDialog.dismiss()

                    val gson = Gson()
                    val teacherResponse = gson.fromJson(response.body()?.string(), TeacherResponse::class.java)

                    Log.d("ZZZ", teacherResponse.toString())

                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    teacherAdapter = TeacherAdapter(teacherResponse.teachers)
                    recyclerView.adapter = teacherAdapter
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    progressDialog.dismiss()

                    Log.e("ZZZ", "$t")
                }
            })
        }

//        setContent {
//            TeacherBillTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting(name = a)
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeacherBillTheme {
        Greeting("Minh")
    }
}