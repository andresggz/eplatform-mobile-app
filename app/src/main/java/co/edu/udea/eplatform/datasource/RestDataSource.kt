package co.edu.udea.eplatform.datasource

import co.edu.udea.eplatform.model.*
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET("careers")
    suspend fun getCareers(): List<MyCareer>

    @GET("articles")
    suspend fun getArticles(): List<MyArticle>

    @GET("careers/{id}")
    suspend fun getCareerById(@Path("id") id: Int): MyCareer

    @GET("articles/{id}")
    suspend fun getArticleById(@Path("id") id: Int): MyArticle

    @GET("roadmaps/{id}")
    suspend fun getRoadmapById(@Path("id") id: Int): MyRoadmap

    @GET("courses/{id}")
    suspend fun getCourseById(@Path("id") id: Int): MyCourse

    @GET("classes/{id}")
    suspend fun getClassById(@Path("id") id: Int): MyClass
}