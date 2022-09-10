class Intern(val weeklyWorkload: Int) {
    val baseWorkload = 20

    class Salary {
        val basePay = 50
        val extraHoursPay = 2.8
    }

    val weeklySalary = if (weeklyWorkload - baseWorkload == 0) Salary().basePay.toDouble() else Salary().basePay + ((weeklyWorkload - baseWorkload) * Salary().extraHoursPay)
}
