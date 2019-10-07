package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BaseRepository
import com.example.themoviedb_mvpstructure.model.ActorsResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class PopularPeopleRepository : BaseRepository(), PopularPeopleScreenContract.PopularPeopleRepositoryInterface {

    override fun getPopularPeople(
        page: Int,
        success: (response: ActorsResponse) -> Unit,
        failure: (t: Throwable) -> Unit
    ) {
        remoteDataSource.api.getPopularPeople(page)
            .enqueue(object : Callback<ActorsResponse> {
                override fun onFailure(
                    call: Call<ActorsResponse>,
                    t: Throwable
                ) {
                    if (t is IOException) {
                        failure(RuntimeException("No internet connection"))
                    } else {
                        failure(t)
                    }
                }

                override fun onResponse(
                    call: Call<ActorsResponse>,
                    response: Response<ActorsResponse>
                ) {
                    if (response.code() != 200) {
                        failure(RuntimeException("Not 200"))
                    } else {
                        success(response.body()!!)
                    }
                }

            })
    }


    override fun getPopularPeople(page: Int): Single<ActorsResponse> {
        return remoteDataSource.api.getPopularPeopleObservable(page)
    }
}