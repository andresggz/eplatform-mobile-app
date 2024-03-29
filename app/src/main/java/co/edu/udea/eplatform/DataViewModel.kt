package co.edu.udea.eplatform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.eplatform.model.*
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

    private val _articles = MutableStateFlow(emptyList<MyArticle>())
    val articles: StateFlow<List<MyArticle>> = _articles

    private val _career = MutableStateFlow(MyCareer())
    val career: StateFlow<MyCareer> = _career

    private val _article = MutableStateFlow(MyArticle())
    val article: StateFlow<MyArticle> = _article

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

    fun getArticles() {
        viewModelScope.launch {
            val response = dataRepo.getArticles()
            _articles.value = response
        }
    }

    fun getCareerById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getCareerById(id);
            _career.value = response
        }
    }

    fun getArticleById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getArticleById(id);
            _article.value = response
        }
    }

    fun getRoadmapById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getRoadmapById(id);
            _roadmap.value = response
        }
    }

    fun getCourseById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getCourseById(id);
            _course.value = response
        }
    }

    fun getClassById(id: Int) {
        viewModelScope.launch {
            val response = dataRepo.getClassById(id);
            _myClass.value = response
        }
    }

}