package com.example.uasAPI.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uasAPI.network.Sea
import com.example.uasAPI.network.Bugs
import com.example.uasAPI.network.Fish
import com.example.uasAPI.network.UasAPIApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatus { LOADING, ERROR, DONE }

class MyViewModel : ViewModel() {
    // status
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    // penampung data untuk API doa
    private val _listfish = MutableLiveData<Fish>()
    val listfish: LiveData<Fish> = _listfish

    private val _fishtunggal = MutableLiveData<Fish.Data>()
    val fishtunggal: LiveData<Fish.Data> = _fishtunggal

    // penampung data untuk API asmaul husna
    private val _listsea = MutableLiveData<Sea>()
    val listsea: LiveData<Sea> = _listsea

    private val _seaTunggal = MutableLiveData<Sea.Data>()
    val seaTunggal: LiveData<Sea.Data> = _seaTunggal

    // penampung data untuk API bugs
    private val _listbugs = MutableLiveData<Bugs>()
    val listbugs: LiveData<Bugs> = _listbugs

    private val _bugsTunggal = MutableLiveData<Bugs.Data>()
    val bugsTunggal: LiveData<Bugs.Data> = _bugsTunggal




    fun getFishList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _listfish.value = UasAPIApi.retrofitServiceApi.getFish()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listfish.value = Fish(listOf())
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getSeaList(){
        viewModelScope.launch {
            try {
                _listsea.value = UasAPIApi.retrofitServiceApi.getSea()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listsea.value = Sea(listOf())
            }
        }
    }

    fun getBugsList(){
        viewModelScope.launch {
            try {
                _listbugs.value = UasAPIApi.retrofitServiceApi.getBugs()
            } catch (e: Exception) {
                Log.d("error", e.printStackTrace().toString())
                _listbugs.value = Bugs(listOf())
            }
        }
    }

    fun onFishCLicked(fish: Fish.Data){
        _fishtunggal.value = fish
    }

    fun onSeaCLicked(sea: Sea.Data){
        _seaTunggal.value = sea
    }

    fun onBugsCLicked(bugs: Bugs.Data){
        _bugsTunggal.value = bugs
    }
}