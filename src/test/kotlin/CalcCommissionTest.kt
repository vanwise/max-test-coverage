import org.junit.Assert.*
import org.junit.Test

class CalcCommissionTest {
    @Test
    fun mainShouldReturnUnit() {
        assertEquals(Unit, main())
    }

    @Test
    fun calcCommissionShouldReturnZero() {
        val result = calcCommission(200, "vk-pay", 200)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcCommissionShouldReturnZeroWithZeroString() {
        val result = calcCommission(0, "", 0)
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
    fun calcCommissionShouldReturnCorrectCommissionsWithMastercard() {
        val result = calcCommission(5200, "mastercard", 0)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcCommissionShouldReturnCorrectCommissionsWithMaestro() {
        val result = calcCommission(100, "maestro", 0)
        assertEquals(20.6, result, 0.0001)
    }

    @Test
    fun calcVisaCommissionShouldReturnMinCommission() {
        val result = calcVisaCommission(350)
        assertEquals(35.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldZero() {
        val result = calcMastercardCommission(50_000, 0)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldZeroWithMonthAmount() {
        val result = calcMastercardCommission(200, 300)
        assertEquals(0.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldCommissionFromMiddleAmountAndMonthAmount() {
        val result = calcMastercardCommission(60_000, 20_000)
        assertEquals(380.0, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldReturnCommissionFromLowAmount() {
        val result = calcMastercardCommission(200, 0)
        assertEquals(21.2, result, 0.0001)
    }

    @Test
    fun calcMastercardCommissionShouldReturnCommissionFromHighAmount() {
        val result = calcMastercardCommission(76_000, 0)
        assertEquals(476.0, result, 0.0001)
    }
}