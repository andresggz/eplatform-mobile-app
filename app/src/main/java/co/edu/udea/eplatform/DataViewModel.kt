package co.edu.udea.eplatform

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataRepo: DataRepository
): ViewModel() {

    fun getCareers() {
        viewModelScope.launch(Dispatchers.IO) {
            val careers = dataRepo.getCareers()
            Log.d("DataViewModel", careers.size.toString())
        }
    }
}