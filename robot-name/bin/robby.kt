import java.util.Random
val oldNames = mutableListOf<String>()
class Robot() {
    var name:String = ""
    init {
        reset()
    }  
    fun reset() { 
        name = (0..1).map(){
            'A' + Random().nextInt(25)
        }.joinToString("") + (0..2).map(){
            '0' + Random().nextInt(9)
        }.joinToString("")
        when {
            oldNames.contains(name) -> reset()
            else -> oldNames.add(name)
        }
    }
}