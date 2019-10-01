package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BaseContract

interface PersonDetailsScreenContract {

    interface PersonDetailsViewInterface : BaseContract.BaseIView {
    }

    interface PersonDetailsPresenterInterface : BaseContract.BaseIPresenter {

    }

    interface PersonDetailsRepositoryInterface : BaseContract.BaseIRepository {

    }

}