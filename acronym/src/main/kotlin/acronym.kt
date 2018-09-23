package Acronym
fun generate(source: String) = source.split(("[ -]").toRegex()).map() { word -> word.toCharArray()[0] }.joinToString("").toUpperCase()