package me.mrtkhkm.pixabaysearch.navigation

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import me.mrtkhkm.model.Hit

class NavigationUtil {
    private val moshi = Moshi.Builder().build()
    private val listType = Types.newParameterizedType(Hit::class.java)
    private val adapter: JsonAdapter<Hit> = moshi.adapter<Hit?>(listType).lenient()

    fun fromJson(string: String): Hit {
        return adapter.fromJson(string)!!
    }

    fun toJson(value: Hit): String {
        return adapter.toJson(value)
    }
}