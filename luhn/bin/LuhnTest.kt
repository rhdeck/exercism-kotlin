import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {

    @Test
    fun singleDigitStringsCannotBeValid() {
        assertFalse(Luhn.isValid("1"))
    }

    //@ignore
    @Test
    fun singleZeroIsInvalid() {
        assertFalse(Luhn.isValid("0"))
    }

    //@ignore
    @Test
    fun simpleValidSINThatRemainsValidIfReversed() {
        assertTrue(Luhn.isValid("059"))
    }

    //@ignore
    @Test
    fun simpleValidSINThatBecomesInvalidIfReversed() {
        assertTrue(Luhn.isValid("59"))
    }

    //@ignore
    @Test
    fun validCanadianSIN() {
        assertTrue(Luhn.isValid("055 444 285"))
    }

    //@ignore
    @Test
    fun invalidCanadianSIN() {
        assertFalse(Luhn.isValid("055 444 286"))
    }

    //@ignore
    @Test
    fun invalidCreditCard() {
        assertFalse(Luhn.isValid("8273 1232 7352 0569"))
    }

    //@ignore
    @Test
    fun validStringsWithNonDigitIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055a 444 285"))
    }

    //@ignore
    @Test
    fun validStringsWithPunctuationIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055-444-285"))
    }

    //@ignore
    @Test
    fun validStringsWithSymbolsIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055£ 444$ 285"))
    }

    //@ignore
    @Test
    fun singleZeroWithSpaceIsInvalid() {
        assertFalse(Luhn.isValid(" 0"))
    }

    //@ignore
    @Test
    fun moreThanSingleZeroIsValid() {
        assertTrue(Luhn.isValid("0000 0"))
    }

    //@ignore
    @Test
    fun inputDigit9IsCorrectlyConvertedToOutputDigit9() {
        assertTrue(Luhn.isValid("091"))
    }

}
