data class SpaceAge(val ageInSeconds: Long) {
    fun onEarth() = format(ageInSeconds.toDouble() / 31557600.0)
    fun onMercury() = format(onEarth() / 0.2408467)
    fun onVenus() = format(onEarth() / 0.61519726)
    fun onMars() = format(onEarth() / 1.8808158)
    fun onJupiter() = format(onEarth() / 11.862615)
    fun onSaturn() = format(onEarth() / 29.447498)
    fun onUranus() = format(onEarth() / 84.016846)
    fun onNeptune() = format(onEarth() / 164.79132) 
    fun onPluto():Double = throw RuntimeException("Pluto is not a planet: http://www.youtube.com/watch?v=Z_2gbGXzFbs")
    fun format(source: Double) = Math.round(source * 100.0).toDouble() / 100.0
}