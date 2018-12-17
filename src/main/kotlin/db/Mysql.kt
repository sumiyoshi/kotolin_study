package db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Cities : Table() {
    val id = integer("id").autoIncrement().primaryKey() // Column<Int>
    val name = varchar("name", 50) // Column<String>
}

fun main(args: Array<String>) {
    Database.connect("jdbc:mysql://localhost/demo_db", "com.mysql.jdbc.Driver", "root", "")

    transaction {
//        SchemaUtils.drop(Cities)
//        SchemaUtils.create(Cities)
//        Cities.insert {
//            it[name] = "Prague"
//        }

        println("All cities:")

        for (city in Cities.selectAll()) {
            println("${city[Cities.id]}: ${city[Cities.name]}")
        }


    }
}