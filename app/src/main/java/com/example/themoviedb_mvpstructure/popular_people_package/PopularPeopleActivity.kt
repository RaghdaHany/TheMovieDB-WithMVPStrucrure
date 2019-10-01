package com.example.themoviedb_mvpstructure.popular_people_package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb_mvpstructure.EndlessRecyclerViewScrollListener
import com.example.themoviedb_mvpstructure.R
import com.example.themoviedb_mvpstructure.base.BaseActivity
import com.example.themoviedb_mvpstructure.model.PopularPeople

import kotlinx.android.synthetic.main.activity_popular_people.*

class PopularPeopleActivity : BaseActivity<PopularPeoplePresenter>(),
    PopularPeopleScreenContract.PopularPeopleViewInterface {

    private lateinit var adapter: PopularPeopleAdapter

    override val presenter = PopularPeoplePresenter(this, PopularPeopleRepository())

    override fun getLayoutResourceId() = R.layout.activity_popular_people

    override fun onViewReady(bundle: Bundle?) {
        val linearLayoutManager = LinearLayoutManager(this)

        adapter = PopularPeopleAdapter({ url: String, id: Int ->
            //            controller.loadImage(url, id)
        }, {
            // todo open details activity
            // fixme test
            // hgjgjgjhgj
        })
        recyclerViewId.layoutManager = linearLayoutManager
        recyclerViewId.adapter = adapter

        recyclerViewId.addOnScrollListener(object :
            EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                presenter.loadNextPage()
            }
        })
    }

    override fun addData(results: List<PopularPeople>) {
        adapter.add(results)
    }
}
