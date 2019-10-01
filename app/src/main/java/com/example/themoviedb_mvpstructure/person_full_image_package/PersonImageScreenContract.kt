package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BaseContract

interface PersonImageScreenContract {

    interface PersonImageViewInterface : BaseContract.BaseIView {
    }

    interface PersonImagePresenterInterface : BaseContract.BaseIPresenter {

    }

    interface PersonImageRepositoryInterface : BaseContract.BaseIRepository {

    }

}