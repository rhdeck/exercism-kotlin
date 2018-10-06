package BeerSong
fun verses(start: Int, finish: Int): String = when (start) {
    0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    else -> "${start} bottles of beer on the wall, ${start} bottles of beer.\n" + when(start -1) {
        1 -> "Take one down and pass it around, 1 bottle of beer on the wall.\n"
        else -> "Take one down and pass it around, ${start -1} bottles of beer on the wall.\n"
}} + when (finish) {
    start -> ""
    else -> "\n" + verses(start -1, finish)
}