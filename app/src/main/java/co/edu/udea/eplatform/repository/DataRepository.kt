package co.edu.udea.eplatform.repository

import co.edu.udea.eplatform.datasource.RestDataSource
import co.edu.udea.eplatform.model.*
import javax.inject.Inject

interface DataRepository {

    suspend fun getCareers(): List<MyCareer>

    suspend fun getArticles(): List<MyArticle>

    suspend fun getCareerById(id: Int): MyCareer

    suspend fun getArticleById(id: Int): MyArticle

    suspend fun getRoadmapById(id: Int): MyRoadmap

    suspend fun getCourseById(id: Int): MyCourse

    suspend fun getClassById(id: Int): MyClass
}

class DataRepositoryImpl @Inject constructor(
    private val dataSource: RestDataSource
) : DataRepository {

    override suspend fun getCareers(): List<MyCareer> {
        return dataSource.getCareers()
    }

    override suspend fun getArticles(): List<MyArticle> {
        return dataSource.getArticles()
    }

    override suspend fun getCareerById(id: Int): MyCareer {
        return dataSource.getCareerById(id)
    }

    override suspend fun getArticleById(id: Int): MyArticle {
        return dataSource.getArticleById(id)
    }

    override suspend fun getRoadmapById(id: Int): MyRoadmap {
        return dataSource.getRoadmapById(id)
    }

    override suspend fun getCourseById(id: Int): MyCourse {
        return dataSource.getCourseById(id)
    }

    override suspend fun getClassById(id: Int): MyClass {
        return dataSource.getClassById(id)
    }

}