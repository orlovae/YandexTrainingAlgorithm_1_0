/**
 * Телефонные номера в адресной книге мобильного телефона имеют один из следующих форматов:
 * +7<код><номер>, 8<код><номер>, <номер>, где <номер> — это семь цифр, а <код> — это три цифры или три цифры в
 * круглых скобках. Если код не указан, то считается, что он равен 495. Кроме того, в записи телефонного номера
 * может стоять знак “-” между любыми двумя цифрами (см. пример). На данный момент в адресной книге телефона Васи
 * записано всего три телефонных номера, и он хочет записать туда еще один. Но он не может понять, не записан ли
 * уже такой номер в телефонной книге. Помогите ему! Два телефонных номера совпадают, если у них равны коды и
 * равны номера. Например, +7(916)0123456 и 89160123456 — это один и тот же номер.
 *
 * Формат ввода
 * В первой строке входных данных записан номер телефона, который Вася хочет добавить в адресную книгу своего
 * телефона. В следующих трех строках записаны три номера телефонов, которые уже находятся в адресной книге
 * телефона Васи. Гарантируется, что каждая из записей соответствует одному из трех приведенных в условии форматов.
 *
 * Формат вывода
 * Для каждого телефонного номера в адресной книге выведите YES (заглавными буквами), если он совпадает с тем
 * телефонным номером, который Вася хочет добавить в адресную книгу или NO (заглавными буквами) в противном случае
 *
 * Пример 1
 * Ввод
 * 8(495)430-23-97
 * +7-4-9-5-43-023-97
 * 4-3-0-2-3-9-7
 * 8-495-430
 * Вывод
 * YES
 * YES
 * NO
 *
 * Пример 2
 * Ввод
 * 86406361642
 * 83341994118
 * 86406361642
 * 83341994118
 * Вывод
 * NO
 * YES
 * NO
 *
 * Пример 3
 * Ввод
 * +78047952807
 * +78047952807
 * +76147514928
 * 88047952807
 * Вывод
 * YES
 * NO
 * YES
 */
class Task03 {
    private val scan = java.util.Scanner(System.`in`)
    private val telNumberSample = scan.nextLine().toCharArray()

    private val numberInTelBookList = mutableListOf<CharArray>()

    private val firstNumberInTelBook = scan.nextLine().toCharArray()
    private val secondNumberInTelBook = scan.nextLine().toCharArray()
    private val thirdNumberInTelBook = scan.nextLine().toCharArray()


    init {
        numberInTelBookList.add(firstNumberInTelBook)
        numberInTelBookList.add(secondNumberInTelBook)
        numberInTelBookList.add(thirdNumberInTelBook)

        numberInTelBookList.forEach {
            prepareTelNumber(it)
        }
    }

    private fun prepareTelNumber(telNumber: CharArray) {
        val outTelNumber = CharArray(10)
        var left = 0
        var rightIn = telNumber.size - 1
        var rightOut = outTelNumber.size - 1



        if (telNumber[left] == '+' && telNumber[left + 1] == '7') {
            left += 2
        }
        if (telNumber[left] == '8') {
            left += 1
        }

        while (rightOut >= 0) {
            while (rightIn >= 0 && telNumber[rightIn].isDigit() || telNumber[rightIn] == '+') {
                outTelNumber[rightOut] = telNumber[rightIn]
                rightIn--
            }
            rightOut--
        }
    }
}