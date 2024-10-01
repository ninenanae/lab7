import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Калькулятор
    fun calculator() {
        println("Консольный калькулятор")
        println("Введите первое число:")
        val firstNumber = readLine()!!.toDouble()

        println("Введите оператор (+, -, *, /):")
        val operator = readLine()!!

        println("Введите второе число:")
        val secondNumber = readLine()!!.toDouble()

        val result = when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> {
                if (secondNumber != 0.0) {
                    firstNumber / secondNumber
                } else {
                    println("Деление на ноль!")
                    return
                }
            }
            else -> {
                println("Неизвестный оператор!")
                return
            }
        }

        println("Результат: $result")
    }

    // Проверка на палиндром
    fun findPalindrome() {
        println("Введите строку:")
        val input = scanner.next()
        val isPalindrome = input == input.reversed()
        println(if (isPalindrome) "Это палиндром" else "Это не палиндром")
    }

    // Калькулятор очков
    fun scoreCalculator() {
        println("Введите количество побед:")
        val wins = scanner.nextInt()
        println("Введите количество ничьих:")
        val draws = scanner.nextInt()
        println("Введите количество поражений:")
        val losses = scanner.nextInt()
        val points = wins * 3 + draws
        println("Количество очков: $points")
    }

    // Нахождение минимального числа
    fun findMinimum() {
        println("Введите количество чисел:")
        val count = scanner.nextInt()
        val numbers = IntArray(count)
        println("Введите числа:")
        for (i in 0 until count) {
            numbers[i] = scanner.nextInt()
        }
        val minimum = numbers.minOrNull()
        println("Минимальное число: $minimum")
    }

    // Проверка на равенство
    fun checkEquality() {
        println("Введите первое число:")
        val num1 = scanner.nextDouble()
        println("Введите второе число:")
        val num2 = scanner.nextDouble()
        println(if (num1 == num2) "Они равны" else "Они НЕ равны")
    }

    // Игра "21"
    fun cardGame21() {
        val random = Random()
        var playerScore = 0
        var dealerScore = 0

        while (playerScore < 21 && dealerScore < 21) {
            println("Хотите взять карту? (да/нет)")
            if (scanner.next() == "да") {
                val card = random.nextInt(1, 11)
                playerScore += card
                println("Вы взяли карту: $card. Ваш счет: $playerScore")
            } else {
                break
            }

            if (playerScore > 21) {
                println("Вы перебрали! Счет: $playerScore")
                return
            }
        }

        while (dealerScore < 17) {
            dealerScore += random.nextInt(1, 11)
        }

        println("Счет дилера: $dealerScore")

        when {
            playerScore > 21 -> println("Вы проиграли")
            dealerScore > 21 || playerScore > dealerScore -> println("Вы выиграли!")
            dealerScore > playerScore -> println("Вы проиграли")
            else -> println("Ничья")
        }
    }

    calculator()
    findPalindrome()
    scoreCalculator()
    findMinimum()
    checkEquality()
    cardGame21()
}
