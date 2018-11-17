package org.hexworks.kotlincode.stdlibexplore.wellknown

fun main(args: Array<String>) {

    class UserBuilder() {
        private var name: String = "unknown"
        private var age: Int = 0

        fun name(name: String) = also {
            this.name = name
        }

        fun age(age: Int) = also {
            this.age = age
        }
    }

    UserBuilder().name("John").age(32)

}
