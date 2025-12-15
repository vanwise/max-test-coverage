fun main() {
    calcCommission(200, "visa", 0)
}

fun calcCommission(amount: Int, cardType: String, totalMonthAmount: Int) = when (cardType) {
    "mastercard", "maestro" -> calcMastercardCommission(amount, totalMonthAmount)
    "visa", "mir" -> calcVisaCommission(amount)
    else -> 0.0
}

fun calcVisaCommission(amount: Int): Double {
    val commissionPercent = 0.75
    val minCommission = 35.0

    val commission = amount * commissionPercent / 100
    return if (commission < minCommission) minCommission else commission
}

fun calcMastercardCommission(amount: Int, totalMonthAmount: Int): Double {
    val commissionPercent = 0.6
    val requiredCommission = 20
    val minMonthLimit = 300
    val maxMonthLimit = 75_000

    val totalAmount = totalMonthAmount + amount

    return if (totalAmount < minMonthLimit || totalAmount > maxMonthLimit) {
        amount * commissionPercent / 100 + requiredCommission
    } else 0.0
}
