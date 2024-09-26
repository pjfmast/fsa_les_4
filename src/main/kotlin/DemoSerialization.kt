package avans.avd

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Student(
    val name: String,
    val yearOfBirth: Int,
    val isEnrolled: Boolean = false
)

fun main() {
    val json = Json {
        prettyPrint = true
        encodeDefaults = false // adds default values of properties when using json.encode
        ignoreUnknownKeys = true // ignores additional json keys in json.decodeFromString()
        // a lot more options... case-sensitive? allow trailing comma's?
    }

    val students = listOf<Student>(
        Student("Henk", 1984, false),
        Student("Sophie", 2005, true),
        Student("Anne", 2002),
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

