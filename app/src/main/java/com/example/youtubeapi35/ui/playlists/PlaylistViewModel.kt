package com.example.youtubeapi35.ui.playlists

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi35.BuildConfig.API_KEY
import com.example.youtubeapi35.`object`.Constant
import com.example.youtubeapi35.base.BaseViewModel
import com.example.youtubeapi35.model.PlayList
import com.example.youtubeapi35.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val youtubeApi = RetrofitClient.create()

    fun getPlayList(): LiveData<PlayList> {
        return createPlayList()
    }

    private fun createPlayList(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()

        youtubeApi.getPlaylists(Constant.PART, Constant.CHANNEL_ID, API_KEY)
            .enqueue(object : Callback<PlayList> {
                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    print(t.stackTrace)
                }
            })
        return data
    }

}