package com.example.sevenwindsstudiotest.core.util.extantion

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(this, Observer {
        it?.let { t -> observer(t) }
    })
}