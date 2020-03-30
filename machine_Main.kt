package machine
import java.util.Scanner

fun thecoffemachinehas(water: Int, milk: Int, coffee: Int, cups: Int, money: Int) {
    println()
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$coffee of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
}

fun notenough(missing: String) {
    println("Sorry, not enough $missing!")
}

fun enough() {
    println("I have enough resources, making you a coffee!")
}

fun main() {
    val scanner = Scanner(System.`in`)

    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550

    do {
        println()
        print("Write action (buy, fill, take, remaining, exit): ")
        val firstInput = scanner.next()
        when (firstInput) {
            "buy" -> {
                println()
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                do {
                    val secondInput = scanner.next()
                    when (secondInput) {
                        "1" -> {
                            if (water > 250 && coffee > 16) {
                                water -= 250
                                coffee -= 16
                                cups -= 1
                                money += 4
                                enough()

                            } else if (water < 250) {
                                notenough("water")
                            } else {
                                notenough("coffee")
                            }
                        }
                        "2" -> {
                            if (water > 350 && milk > 75 && coffee > 20) {
                                water -= 350
                                milk -= 75
                                coffee -= 20
                                cups -= 1
                                money += 7
                                enough()

                            } else if (water < 350) {
                                notenough("water")
                            } else if (milk < 20) {
                                notenough("milk")
                            } else {
                                notenough("coffee")
                            }
                        }
                        "3" -> {
                            if (water > 250 && milk > 100 && coffee > 16) {
                                water -= 200
                                milk -= 100
                                coffee -= 12
                                cups -= 1
                                money += 6
                                enough()

                            } else if (water < 250) {
                                notenough("water")
                            } else if (milk < 100) {
                                notenough("milk")
                            } else {
                                notenough("coffee")
                            }
                        }
                    }
                } while (false)
            }
            "fill" -> {
                println()
                print("Write how many ml of water do you want to add: ")
                water += scanner.nextInt()
                print("Write how many ml of milk do you want to add: ")
                milk += scanner.nextInt()
                print("Write how many grams of coffee beans do you want to add: ")
                coffee += scanner.nextInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                cups += scanner.nextInt()
            }
            "take" -> {
                println("I gave you $$money")
                money -= money
            }
            "remaining" -> {
                thecoffemachinehas(water, milk, coffee, cups, money)
            }
            "exit" -> {
            }
            else -> println("Dunno what do you want from me")
        }
    } while (firstInput != "exit" )
}
