import org.junit.Assert.*
import org.junit.Test

class CalcCommissionTest {
    @Test
    fun calcCommissionShouldReturnZero() {
        val result = calcCommission(200, "vk-pay", 300)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcVisaCommissionShouldReturnMinCommission() {
        val result = calcVisaCommission(350)
        assertEquals(35.0, result, 0.0001)
    }

    @Test
    fun calcVisaCommissionShouldReturnCorrectCommission() {
        val result = calcVisaCommission(5200)
        assertEquals(39.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommission() {
    }
}