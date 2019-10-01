package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BasePresenter

class PopularPeoplePresenter(
    view: PopularPeopleScreenContract.PopularPeopleViewInterface?,
    repository: PopularPeopleScreenContract.PopularPeopleRepositoryInterface) :

    BasePresenter<PopularPeopleScreenContract.PopularPeopleViewInterface,
            PopularPeopleScreenContract.PopularPeopleRepositoryInterface>(view, repository){

    private var page = 1
    override fun onViewReady() {
        loadData()
    }

    fun loadNextPage() {
        page++
        loadData()
    }

    private fun loadData() {
        view!!.showLoading()
        repository.getPopularPeople(page,
            success = {
                view!!.hideLoading()
                view!!.addData(it.results)
            },
            failure = {
                view!!.hideLoading()
                view!!.showError(it.message!!)
            })
    }
}