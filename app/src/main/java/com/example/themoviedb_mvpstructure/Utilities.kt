package com.example.themoviedb_mvpstructure

class Utilities {
    companion object{
        var popularPeopleURL = "https://api.themoviedb.org/3/person/popular?api_key=e6f20f39139b1f5a2be132cbaaa9ce43" + "&page="
        var pageURL = "&page="
        var firstPage = "1"
        var popularPeoplePage = 1
        var searchPage = 1
        var search_url = "https://api.themoviedb.org/3/search/person?api_key=e6f20f39139b1f5a2be132cbaaa9ce43&query="
        var photo_first_path = "https://image.tmdb.org/t/p/w500/"
        var PROFILE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
    }

}
