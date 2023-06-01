/**
 * Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами. Если это возможно,
 * выведите строку YES, иначе выведите строку NO.
 *
 * Треугольник — это три точки, не лежащие на одной прямой.
 *
 * Формат ввода - Вводятся три натуральных числа.
 *
 * Формат вывода - Выведите ответ на задачу.
 *
 * Пример 1
 * Ввод - 3, 4, 5
 * Вывод - YES
 *
 * Пример 2
 * Ввод - 3, 5 ,4
 * Вывод - YES
 *
 * Пример 3
 * Ввод - 4, 5, 3
 * Вывод - YES
 */
class Task02 {
    private val scan = java.util.Scanner(System.`in`)
    private val intputData = scan.nextLine().split(' ').map { it.toInt() }
    private val oneEdge = intputData[0]
    private val twoEdge = intputData[1]
    private val threeEdge = intputData[2]

    init {
        checkAllEdge(oneEdge, twoEdge, threeEdge)
    }

    private fun checkAllEdge(oneEdge: Int, twoEdge: Int, threeEdge: Int) {
        if (oneEdge + twoEdge > threeEdge &&
                oneEdge + threeEdge > twoEdge &&
                twoEdge + threeEdge > oneEdge) {
            println("YES")
        } else {
            println("NO")
        }
    }
}