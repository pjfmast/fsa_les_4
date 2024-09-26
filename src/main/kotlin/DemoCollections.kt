package avans.avd

data class Car(
    val brand: String,
    val model: String,
    val year: Int,
    val licensePlate: String
) {
    override fun equals(other: Any?): Boolean =
        other is Car && licensePlate.lowercase() == other.licensePlate.lowercase()

    override fun hashCode(): Int = licensePlate.lowercase().hashCode()
}

fun main() {
    val cars = mutableListOf<Car>(
        Car("Ford", "B max", 2016, licensePlate = "L-768-JT"),
        Car("Ford", "focus", 2019, licensePlate = "T-975-SC"),
        Car("Ford", "focus", 2019, licensePlate = "t-975-sc"),
        Car("Toyota", "Yaris", 2019, licensePlate = "4-ZHK-03"),
        Car("Toyota", "Prius", 2019, licensePlate = "25-RSH-4"),
        Car("Toyota", "Prius", 2019, licensePlate = "25-RSH-4"),
    )
    val uniqueCars = cars.toSet()
    println("The list contains ${cars.size} cars and ${uniqueCars.size} are unique cars.")

    cars.removeAt(0)
    println(cars.containsAll(uniqueCars))
    println(uniqueCars.containsAll(cars))

    println("HashSet of all license plates:")
    val lincesPlates = HashSet<String>(cars.map { car -> car.licensePlate })
    println(lincesPlates)

    println("HashSet is very fast for check on contains:")
    println(lincesPlates.contains("4-ZHK-03"))
    println(lincesPlates.contains("4-ZHK-04"))

    // a LinkedHashSet preserves the order of the original list:
    println("LinkedHashSet of all license plates:")
    println(LinkedHashSet<String>(cars.map { car -> car.licensePlate }))

    println("-".repeat(80))
    println("All cars grouped by brand:")
    val table1 = cars.groupBy { it.brand }
    // println(table1) is ok, but to see all entries in a separate line we use:
    table1.entries.forEach(::println)

    println("-".repeat(80))
    println("All licensplate - car associations:")
    val table2 = cars.groupBy { it.licensePlate }
    table2.entries.forEach(::println)
}
