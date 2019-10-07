package com.example.themoviedb_mvpstructure.popular_people_package

import com.example.themoviedb_mvpstructure.base.BasePresenter
import com.example.themoviedb_mvpstructure.model.PopularPeople
import io.reactivex.functions.Consumer

class PopularPeoplePresenter(
    view: PopularPeopleScreenContract.PopularPeopleViewInterface?,
    repository: PopularPeopleScreenContract.PopularPeopleRepositoryInterface) :

    BasePresenter<PopularPeopleScreenContract.PopularPeopleViewInterface,
            PopularPeopleScreenContract.PopularPeopleRepositoryInterface>(view, repository){

    private var page = 1
    var peopleList: MutableList<PopularPeople>? = null

    override fun onViewReady() {
        loadData()
    }

     fun loadData() {

         subscribe(repository.getPopularPeople(page),
             Consumer {
                 view!!.addData(it.results as MutableList<PopularPeople>)
             }
         )
    }

    fun loadNextPage() {
        page = page + 1
        loadData()
    }


    fun callSwipeFunction() {
        peopleList = view!!.getList() as MutableList<PopularPeople>?
        this.clearList()
        page = 1
        loadData()

    }

    fun clearList() {
        peopleList = view?.getList() as MutableList<PopularPeople>?
        val size = peopleList?.size
        if (size != null) {
            if (size > 0) {
                for (i in 0 until size) {
                    peopleList?.removeAt(0)
                }
                view?.notifyDataRemoved(size)
            }
        }
        view?.deleteAdapterData()
        peopleList?.clear()
    }

    fun callFirstPage() {
        page = 1
        loadData()
    }
}