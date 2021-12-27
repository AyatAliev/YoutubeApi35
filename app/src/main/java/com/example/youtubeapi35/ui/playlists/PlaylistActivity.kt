package com.example.youtubeapi35.ui.playlists

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi35.base.BaseActivity
import com.example.youtubeapi35.databinding.ActivityPlaylistsBinding
import com.example.youtubeapi35.extension.showToast

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistsBinding>() {

    override fun initView() {
        super.initView()

        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlayList().observe(this) {
            showToast(it.kind.toString())
        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }

    /*
    *     Дз.
 1. Создать свой ApiKey и ознакомиться с документацией
 2. Добавить в класс playlist поле "items", отрисовать первых 2 экрана из фигмы (Проверка на интернет, и список всех PlayList)
 3. Cделать переход на новую активити и передаете туда id и её отображаете тостом

Также прочитайте про корутины желательно

*/
}