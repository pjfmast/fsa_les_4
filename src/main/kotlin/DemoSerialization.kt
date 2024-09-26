package avans.avd

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Student(
    val name: String,
    val yearOfBirth: Int,
    val isEnrolled: Boolean = false,
    val dateEenrolled: LocalDate? = null,
)


fun main() {
    val json = Json {
        prettyPrint = true
        encodeDefaults = true // adds default values of properties when using json.encode
        ignoreUnknownKeys = true // ignores additional json keys in json.decodeFromString()
        // a lot more options... case-sensitive? allow trailing comma's?

    }

    val students = listOf<Student>(
        Student("Henk", 1984, false),
        Student("Sophie", 2005, true, Clock.System.todayIn(TimeZone.currentSystemDefault())),
        Student("Anne", 2002, true, LocalDate(2024, 9, 26)),
    )

    val encodedJson:String = json.encodeToString(students)
    println(encodedJson)

    val studentsJson = """
        [
            {
                "name": "Henk",
                "yearOfBirth": 1984,
                "isEnrolled": false
            },
            {
                "name": "Sophie",
                "yearOfBirth": 2005,
                "isEnrolled": true
            },
            {
                "name": "Anne",
                "yearOfBirth": 2002,
                "isPartimeStudent": true
            }
        ]
    """.trimIndent()

    val decodedStudents = json.decodeFromString<List<Student>>(studentsJson)
    println(decodedStudents)
}

