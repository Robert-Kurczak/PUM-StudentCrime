package pl.edu.uwr.studentcrime

import kotlin.random.Random

data class Crime(
    val ID: Int,
    val title: String,
    val description: String,
    val studentIndex: Int,
    var resolved: Boolean
){}

object DataProvider{
    val crimeList = List(20) {
        Crime(
            it,
            "Crime #$it",
            "Crime #$it description",
            Random.nextInt(100000, 999999),
            it % 3 == 0
        )
    }
}