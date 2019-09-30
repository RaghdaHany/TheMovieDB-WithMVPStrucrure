package com.example.themoviedb_mvpstructure.popular_people_package

import com.moneam.basemvp.base.BaseContract

interface PopularPeopleScreenContract {

    interface PopularPeopleViewInterface : BaseContract.BaseIView {
    }

    interface PopularPeoplePresenterInterface : BaseContract.BaseIPresenter {

    }

    interface PopularPeopleRepositoryInterface : BaseContract.BaseIRepository {

    }
}