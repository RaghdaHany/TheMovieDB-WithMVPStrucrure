package com.example.themoviedb_mvpstructure.popular_people_package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.themoviedb_mvpstructure.EndlessRecyclerViewScrollListener
import com.example.themoviedb_mvpstructure.R
import com.example.themoviedb_mvpstructure.base.BaseActivity
import com.example.themoviedb_mvpstructure.model.PopularPeople

import kotlinx.android.synthetic.main.activity_popular_people.*
import java.util.ArrayList

class PopularPeopleActivity : BaseActivity<PopularPeoplePresenter>(),
    PopularPeopleScreenContract.PopularPeopleViewInterface {

    private lateinit var adapter: PopularPeopleAdapter
    internal lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private var popularPeopleList: MutableList<PopularPeople>? = null
    private var linearLayoutManager: LinearLayoutManager? = null

    override val presenter = PopularPeoplePresenter(this, PopularPeopleRepository())

    override fun getLayoutResourceId() = R.layout.activity_popular_people

    override fun onViewReady(bundle: Bundle?) {
        linearLayoutManager = LinearLayoutManager(this)
        popularPeopleList = ArrayList()

        adapter = PopularPeopleAdapter({ url: String, id: Int ->
            //            controller.loadImage(url, id)
        }, {
            // todo open details activity
            // fixme test
            // hgjgjgjhgj
        })
        recyclerViewId.adapter = adapter

//        presenter.loadData()

        recyclerViewId.addOnScrollListener(object :
            EndlessRecyclerViewScrollListener(linearLayoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                presenter.loadNextPage()
            }
        })

        mSwipeRefreshLayout = findViewById<View>(R.id.swipe_container) as SwipeRefreshLayout
        mSwipeRefreshLayout.setColorSchemeResources(
            R.color.colorAccent,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark
        )

        mSwipeRefreshLayout.setOnRefreshListener {
            recyclerViewId.visibility = View.INVISIBLE
            presenter.callSwipeFunction()
            recyclerViewId.visibility = View.VISIBLE
            mSwipeRefreshLayout.isRefreshing = false
        }

        tv_no_internet.setOnClickListener {
            presenter.callFirstPage()
        }
    }

    override fun addData(results: MutableList<PopularPeople>) {
        adapter.add(results)
        this.settingAdapterInList()
        recyclerViewId.visibility = View.VISIBLE
        tv_no_internet.visibility = View.GONE
    }

    override fun getList(): List<PopularPeople>? {
        return popularPeopleList
    }

    override fun notifyDataRemoved(size: Int) {
        adapter!!.notifyItemRangeRemoved(0, size)

    }

    override fun settingAdapterInList() {
        adapter!!.notifyDataSetChanged()
        recyclerViewId!!.layoutManager = linearLayoutManager
    }

    override fun deleteAdapterData() {
      adapter.clearAdapter()
    }

    override fun showNoInternetConnection() {
        recyclerViewId.visibility = View.GONE
        tv_no_internet.visibility = View.VISIBLE
    }
}
