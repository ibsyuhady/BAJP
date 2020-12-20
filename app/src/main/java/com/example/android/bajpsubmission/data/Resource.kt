package com.example.android.bajpsubmission.data

data class Resource<T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
        fun <T> done(data: T?): Resource<T> = Resource(Status.DONE, data, null)
        fun <T> error(msg: String?, data: T?): Resource<T> = Resource(Status.ERROR, data, msg)
    }

    enum class Status {
        LOADING,
        DONE,
        ERROR
    }
}
