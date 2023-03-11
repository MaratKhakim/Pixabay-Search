package me.mrtkhkm.pixabaysearch.navigation

object Route {
    const val SEARCH = "search"
    const val DETAILS = "details/{${NavArgument.IMAGE_DETAILS_ARG}}"
}

object NavArgument {
    const val IMAGE_DETAILS_ARG = "image_details_arg"
}