package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BaseContract
import com.example.themoviedb_mvpstructure.model.ActorsResponse
import com.example.themoviedb_mvpstructure.model.PopularPeople

interface PopularPeopleScreenContract {

    interface PopularPeopleViewInterface : BaseContract.BaseIView {
        fun addData(results: List<PopularPeople>)
    }

    interface PopularPeoplePresenterInterface : BaseContract.BaseIPresenter {


    }

    interface PopularPeopleRepositoryInterface : BaseContract.BaseIRepository {
        fun getPopularPeople(
            page: Int,
            success: (response: ActorsResponse) -> Unit,
            failure: (t: Throwable) -> Unit
        )
    }
}