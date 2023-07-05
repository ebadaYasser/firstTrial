package com.features.home.presentaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.data.UseCaseResponse
import com.core.network.models.CountryItem
import com.features.home.domain.usecases.AddCountyToFavUseCase
import com.features.home.domain.usecases.GetAllCountriesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    private val addCountyToFavUseCase: AddCountyToFavUseCase
) : ViewModel() {

    private val showLoadingIndicator = MutableLiveData<Boolean>()
    fun showLoadingIndicator(): LiveData<Boolean> = showLoadingIndicator

    private val setupAdapter = MutableLiveData<SetupAdapter>()
    fun setupAdapter(): LiveData<SetupAdapter> = setupAdapter

    private val showError = MutableLiveData<ShowError>()
    fun showError(): LiveData<ShowError> = showError

    init {
        fetchAllCountries()
    }

    fun addCountryToFav(capital: String) {
        viewModelScope.launch {
//            addCountyToFavUseCase(capital)
        }
    }

    private fun fetchAllCountries() {
        viewModelScope.launch {
            showLoadingIndicator.value = true
            when (val result = getAllCountriesUseCase()) {
                is UseCaseResponse.Success -> {
                    showLoadingIndicator.value = false
                    setupAdapter.value = SetupAdapter(result.body)
                }

                is UseCaseResponse.Failure -> {
                    showLoadingIndicator.value = false
                    showError.value = ShowError(result.error)
                }
            }

        }
    }

    data class SetupAdapter(val list: List<CountryItem>)
    data class ShowError(val errorMessage: String)

}