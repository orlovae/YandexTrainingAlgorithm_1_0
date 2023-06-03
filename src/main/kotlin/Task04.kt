/**
 * Решите в целых числах квадратное уравнение:
 * a, b, c – данные целые числа: найдите все решения или сообщите, что решений в целых числах нет.
 *
 * Формат ввода
 * Вводятся три числа a, b и c по одному в строке.
 *
 * Формат вывода
 * Программа должна вывести все решения уравнения в порядке возрастания, либо NO SOLUTION (заглавными буквами),
 * если решений нет. Если решений бесконечно много, вывести MANY SOLUTIONS.
 *
 * Пример 1
 * Ввод
 * 1
 * 0
 * 0
 * Вывод
 * 0
 * Пример 2
 * Ввод
 * 1
 * 2
 * 3
 * Вывод
 * 7
 * Пример 3
 * Ввод
 * 1
 * 2
 * -3
 * Вывод
 * NO SOLUTION
 */
class Task04 {
    private val scan = java.util.Scanner(System.`in`)
    private val a = scan.nextInt()
    private val b = scan.nextInt()
    private val c = scan.nextInt()

    private val notSolution = "NO SOLUTION"
    private val infinitySolution = "MANY SOLUTIONS"

    private val aIn = a * a
    private val bIn = 2 * a * b
    private val cIn = b * b - c * c

    init {
        if (aIn != 0 && bIn != 0 && cIn != 0) {
            solutionFullQuadraticEquation(
                a = aIn,
                b = bIn,
                c = cIn
            )
        }
        if (bIn == 0 || cIn == 0) {
            solutionIncompleteQuadraticEquation(
                a = aIn,
                b = bIn,
                c = cIn
            )
        }

        if (aIn == 0) {
            solutionLinearEquation(
                b = bIn,
                c = cIn
            )
        }

        if (aIn == 0 && bIn == 0 && cIn == 0) {
            println(0)
        }

    }

    private fun solutionFullQuadraticEquation(a: Int, b: Int, c: Int) {
        val discriminant = b * b - 4 * a * c
        when {
            discriminant > 0 -> println(solutionIfDiscriminantMoreZero(a, b, discriminant))
            discriminant == 0 -> println(solutionIfDiscriminantZero(a, b))
            discriminant < 0 -> println(notSolution)

        }
    }

    private fun solutionIfDiscriminantMoreZero(a: Int, b: Int, discriminant: Int): String {
        val x1 = (b.unaryMinus() - Math.sqrt(discriminant.toDouble())) / (2 * a)
        val x2 = (b.unaryMinus() + Math.sqrt(discriminant.toDouble())) / (2 * a)
        return "$x1 \n $x2"
    }

    private fun solutionIfDiscriminantZero(a: Int, b: Int): String {
        return (b.unaryMinus() / (2 * a)).toString()
    }

    private fun solutionIncompleteQuadraticEquation(a: Int, b: Int, c: Int) {
        when {
            b == 0 && c == 0 -> println(0)
            b == 0 && c != 0 -> println(solutionBIsZeroCNotZero(a, b, c))
            b != 0 && c == 0 -> println(solutionBNotZeroCIsZero(a, b, c))
        }
    }

    private fun solutionBIsZeroCNotZero(a: Int, b: Int, c: Int): String {
        val x1: Int
        val x2: Int
        return if ((c / a).unaryMinus() < 0) {
            notSolution
        } else {
            x1 = Math.sqrt((c / a).unaryMinus().toDouble()).unaryMinus().toInt()
            x2 = Math.sqrt((c / a).unaryMinus().toDouble()).toInt()

            "$x1 \n $x2"
        }
    }

    private fun solutionBNotZeroCIsZero(a: Int, b: Int, c: Int): String {
        val x1 = (b / a).unaryMinus()
        val x2 = 0
        return "$x1 \n $x2"
    }

    private fun solutionLinearEquation(b: Int, c: Int) {
        try {
            println(
                (c / b).unaryMinus()
            )
        } catch (exception: Exception) {
            println(notSolution)
        }

    }
}