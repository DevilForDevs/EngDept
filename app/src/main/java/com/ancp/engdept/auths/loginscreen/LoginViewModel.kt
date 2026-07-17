package com.ancp.engdept.auths.loginscreen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ancp.engdept.db.entitydao.user.UserEntity
import com.ancp.engdept.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.withTimeout
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

     val userId = MutableStateFlow(String())
     val password = MutableStateFlow(String())
    fun login(
        actionCompleted: (UserEntity) -> Unit,
        error: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val client = OkHttpClient()

                val json = JSONObject().apply {
                    put("id", userId.value)
                    put("password", password.value)
                }

                val body = json.toString()
                    .toRequestBody("application/json".toMediaType())

                val request = Request.Builder()
                    .url("https://ba2428.dev/api/apiLogin")
                    .post(body)
                    .addHeader("Accept", "application/json")
                    .build()

                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()

                if (response.isSuccessful) {
                    val json = JSONObject(responseBody!!)

                    val accessToken = json.getString("access_token")
                    val userJson = json.getJSONObject("user")

                    val user = UserEntity(
                        id = userJson.getInt("id"),
                        name = userJson.getString("name"),
                        role = userJson.getString("role"),
                        userId = userJson.getInt("id"),
                        bearerToken = accessToken,
                    )

                    repository.insertUser(user)
                    withContext(Dispatchers.Main){
                        actionCompleted(user)
                    }


                } else {
                    val message = try {
                        JSONObject(responseBody ?: "").getString("message")
                    } catch (e: Exception) {
                        "Login failed (${response.code})"
                    }
                    withContext(Dispatchers.Main){
                        error(message)
                    }

                }

            } catch (e: Exception) {
                println(e.printStackTrace())
                withContext(Dispatchers.Main){
                    error(e.message ?: "Unable to connect to the server.")
                }

            }
        }
    }


}