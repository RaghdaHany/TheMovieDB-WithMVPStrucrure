package com.example.themoviedb_mvpstructure.base

abstract class BasePresenter<View : BaseContract.BaseIView,
        Repository : BaseContract.BaseIRepository>(

    var view: View?,
    val repository: Repository

    ) : BaseContract.BaseIPresenter {

    abstract override fun onViewReady()

    override fun onViewDestroy() {
        view = null
    }

}