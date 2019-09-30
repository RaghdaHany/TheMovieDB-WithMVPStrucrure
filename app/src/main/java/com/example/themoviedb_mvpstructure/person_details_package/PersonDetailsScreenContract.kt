package com.example.themoviedb_mvpstructure.popular_people_package

import com.moneam.basemvp.base.BaseContract

interface PersonDetailsScreenContract {

    interface PersonDetailsViewInterface : BaseContract.BaseIView {
    }

    interface PersonDetailsPresenterInterface : BaseContract.BaseIPresenter {

    }

    interface PersonDetailsRepositoryInterface : BaseContract.BaseIRepository {

    }

}