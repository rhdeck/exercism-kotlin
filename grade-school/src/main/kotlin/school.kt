class School() {
    var grades: MutableMap<Int, List<String>> = mutableMapOf()
    fun db() = grades
    fun sort() = grades.toSortedMap<Int, List<String>>()
    fun add(student:String, toGrade: Int) {
        grades.put(toGrade, (grades.get(toGrade) ?: listOf<String>()).plus(student))
    }
    fun grade(gradeLevel: Int) = grades.get(gradeLevel) ?: listOf<String>()

}