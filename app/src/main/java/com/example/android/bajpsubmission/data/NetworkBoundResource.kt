package com.example.android.bajpsubmission.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.android.bajpsubmission.data.source.remote.response.ApiResponse
import com.example.android.bajpsubmission.data.source.remote.response.ApiResponse.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Resource.done(newData)
                }
            }
        }
    }

    private fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    CoroutineScope(IO).launch {
                        response.body?.let { saveCallResult(it) }
                        // Log.d("Success : ", response.status.name)

                        withContext(Main) {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = Resource.done(newData)
                            }
                        }
                    }

                StatusResponse.EMPTY -> {
                    CoroutineScope(IO).launch {
                        result.addSource(loadFromDB()) { newData ->
                            result.value = Resource.done(newData)
                        }
                    }
                }

                StatusResponse.ERROR -> {
                    onFetchFailed()
                    // Log.d("Error : ", response.status.name)
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}