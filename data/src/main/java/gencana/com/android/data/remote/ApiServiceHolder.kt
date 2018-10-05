package gencana.com.android.data.remote

import gencana.com.android.data.remote.ApiService

/**
 * Created by Gen Cana on 05/10/2018
 */
class ApiServiceHolder {

    private var apiService: ApiService? = null

    internal fun getApiService(): ApiService? {
        return apiService
    }

    internal fun setAPIService(apiService: ApiService) {
        this.apiService = apiService
    }
}