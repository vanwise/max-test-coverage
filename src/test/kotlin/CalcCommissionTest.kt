import org.junit.Assert.*
import org.junit.Test

class CalcCommissionTest {
    @Test
    fun calcCommissionShouldReturnZero() {
        val result = calcCommission(200, "vk-pay", 0)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcCommissionShouldReturnCorrectCommissionsWithVisa() {
        val result = calcCommission(5200, "visa", 0)
        assertEquals(39.0, result, 0.0001)
    }

    @Test
    fun calcCommissionShouldReturnCorrectCommissionsWithMir() {
        val result = calcCommission(5200, "mir", 0)
        assertEquals(39.0, result, 0.0001)
    }

    @Test
    fun calcVisaCommissionShouldReturnMinCommission() {
        val result = calcVisaCommission(350)
        assertEquals(35.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldZero() {
        val result = calcCommission(50_000, "mastercard", 0)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldZeroWithMonthAmount() {
        val result = calcCommission(200, "mastercard", 300)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldCommissionFromMiddleAmountAndMonthAmount() {
        val result = calcCommission(60_000, "maestro", 20_000)
        assertEquals(380.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldReturnCommissionFromLowAmount() {
        val result = calcCommission(200, "mastercard", 0)
        assertEquals(21.2, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldReturnCommissionFromHighAmount() {
        val result = calcCommission(76_000, "maestro", 0)
        assertEquals(476.0, result, 0.0001)
    }
}