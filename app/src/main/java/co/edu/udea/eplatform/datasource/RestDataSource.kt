package co.edu.udea.eplatform.datasource

import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.model.MyClass
import co.edu.udea.eplatform.model.MyCourse
import co.edu.udea.eplatform.model.MyRoadmap
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET("careers")
    suspend fun getCareers(): List<MyCareer>

    @GET("careers/{id}")
    suspend fun getCareerById(@Path("id") id: Int): MyCareer

    @GET("roadmaps/{id}")
    suspend fun getRoadmapById(@Path("id") id: Int): MyRoadmap

    @GET("courses/{id}")
    suspend fun getCourseById(@Path("id") id: Int): MyCourse

    @GET("classes/{id}")
    suspend fun getClassById(@Path("id") id: Int): MyClass
}