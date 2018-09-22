data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    operator fun plus(c: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real = this.real + c.real, imag = this.imag + c.imag)
    }
    operator fun minus(c: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real = this.real - c.real, imag = this.imag - c.imag)
    }
    fun equals(c: ComplexNumber) : Boolean {
        return this.real == c.real && this.imag == c.imag
    }
    operator fun times(c: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real = this.real * c.real + this.imag * c.imag * -1, imag = this.real * c.imag + this.imag * c.real)
    }
    operator fun div(c: ComplexNumber) : ComplexNumber {
        val numerator = this * c.conjugate()
        val denominator = c * c.conjugate()
        return ComplexNumber(real = numerator.real / denominator.real, imag = numerator.imag / denominator.real)
    }
    val abs:Double 
    get() { 
        return  Math.pow(Math.pow(this.real,2.0) + Math.pow(this.imag,2.0),0.5)
    }
    fun conjugate(): ComplexNumber {
        return ComplexNumber(real=this.real, imag=this.imag * -1)
    }
}
fun exponential(c: ComplexNumber) : ComplexNumber {
    //Natural log to the exponent we have designated
    val r = ComplexNumber(real = Math.exp(c.real))
    val i = ComplexNumber(real = Math.cos(c.imag), imag = Math.sin(c.imag))
    return r * i
}