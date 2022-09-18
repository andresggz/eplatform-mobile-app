package co.edu.udea.eplatform.datasource

import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.model.MyRoadmap
import retrofit2.http.GET

interface RestDataSource {

    @GET("careers")
    suspend fun getCareers(): List<MyCareer>

    @GET("careers/id")
    suspend fun getCareerById(): MyCareer

    @GET("roadmaps")
    suspend fun getRoadmapsByCareerId(): List<MyRoadmap>

    @GET("roadmaps/id")
    suspend fun getRoadmapById(): MyRoadmap
}