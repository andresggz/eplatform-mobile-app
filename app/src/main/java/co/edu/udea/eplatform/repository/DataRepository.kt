package co.edu.udea.eplatform.repository

import co.edu.udea.eplatform.datasource.RestDataSource
import co.edu.udea.eplatform.model.MyCareer
import co.edu.udea.eplatform.model.MyRoadmap
import javax.inject.Inject

interface DataRepository {

    suspend fun getCareers(): List<MyCareer>

    suspend fun getCareerById(id: Int): MyCareer

    suspend fun getRoadmapById(id: Int): MyRoadmap
}

class DataRepositoryImpl @Inject constructor(
    private val dataSource: RestDataSource
) : DataRepository {

    override suspend fun getCareers(): List<MyCareer> {
        return dataSource.getCareers()
    }

    override suspend fun getCareerById(id: Int): MyCareer {
        return dataSource.getCareerById(id)
    }

    override suspend fun getRoadmapById(id: Int): MyRoadmap {
        return dataSource.getRoadmapById(id)
    }

}