package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.model.PopularPeople
import com.moneam.basemvp.base.BaseContract

interface PopularPeopleScreenContract {

    interface PopularPeopleViewInterface : BaseContract.BaseIView {
        fun getList(): List<PopularPeople>?
        fun getSearchState(): Boolean?

        fun setPerson(person: PopularPeople)
        fun settingAdapterInList()
        fun notifyDataRemoved(size: Int)
    }

    interface PopularPeoplePresenterInterface : BaseContract.BaseIPresenter {


    }

    interface PopularPeopleRepositoryInterface : BaseContract.BaseIRepository {

    }
}