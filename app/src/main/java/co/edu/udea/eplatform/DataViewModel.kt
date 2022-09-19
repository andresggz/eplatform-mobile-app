package co.edu.udea.eplatform

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataRepo: DataRepository
): ViewModel() {

    private val _careers = MutableStateFlow(emptyList<MyCareer>())
    val careers: StateFlow<List<MyCareer>> = _careers

    private val _career = MutableStateFlow(MyCareer())
    val career: StateFlow<MyCareer> = _career

    fun getCareers() {
        viewModelScope.launch {
            val response = dataRepo.getCareers()
            _careers.value = response
        }
    }

    fun getCareerById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getCareerById(id);
            Log.d("DataViewModelCareer", response.name)
            _career.value = response
        }
    }

}