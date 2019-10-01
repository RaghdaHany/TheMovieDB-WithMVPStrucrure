package com.example.themoviedb_mvpstructure.base

abstract class BaseRepository : BaseContract.BaseIRepository {
    val remoteDataSource = RemoteDataSource.Instance
    val localDataSource = LocalDataSource.Instance
}

