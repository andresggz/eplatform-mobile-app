package co.edu.udea.eplatform

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.model.MyClass
import co.edu.udea.eplatform.model.MyCourse
import co.edu.udea.eplatform.model.MyRoadmap
import co.edu.udea.eplatform.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataRepo: DataRepository
) : ViewModel() {

    private val _careers = MutableStateFlow(emptyList<MyCareer>())
    val careers: StateFlow<List<MyCareer>> = _careers

    private val _career = MutableStateFlow(MyCareer())
    val career: StateFlow<MyCareer> = _career

    private val _roadmap = MutableStateFlow(MyRoadmap())
    val roadmap: StateFlow<MyRoadmap> = _roadmap

    private val _course = MutableStateFlow(MyCourse())
    val course: StateFlow<MyCourse> = _course

    private val _myClass = MutableStateFlow(MyClass())
    val myClass: StateFlow<MyClass> = _myClass


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

    fun getRoadmapById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getRoadmapById(id);
            Log.d("DataViewModelRoadmap", response.name)
            _roadmap.value = response
        }
    }

    fun getCourseById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getCourseById(id);
            Log.d("DataViewModelCourse", response.name)
            _course.value = response
        }
    }

    fun getClassById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getClassById(id);
            Log.d("DataViewModelCourse", response.name)
            _myClass.value = response
        }
    }

}