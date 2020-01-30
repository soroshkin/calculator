**Описание требований к программе**

Необходимо написать приложение реализующее вычисление математических выражений.

**Требования к программе**

На вход будет подаваться строка, содержащая цифры и знаки сложения/вычитания/деления/умножения, например, 4.2 + 2 * 3 / 3 - 6.1.
Необходимо разобрать строку и вычислить результат математического выражения или сообщить об ошибке.

Выражение должно вводиться с клавиатуры через консоль.
Допускается хранение исходной строки в переменной типа String.

**Кейсы, которые необходимо учесть:**

В введенной строке с выражением не должно встречаться ничего, кроме цифр и знаков математических операций, в противном случае вы должны выбрасывать исключение и выводить понятное пользователю сообщение об ошибке.
Числа в выражении могут быть дробными. Используйте разделитель ..
При недопустимой операции, например деленние на 0, вы должны выбрасывать исключение и выводить сообщение об ошибке.
Не допускается введение некорректного выражения вида 4++2. Т.е. не может быть дублирующихся символов операций.
В выражении нельзя использовать скобки и соответственно, нельзя использовать отрицательные числа. Выражение вида -2+4 также считаем недопустимым.
Рекомендации к проектированию программы

Ожидается, что программа будет хорошо структурирована:
Будет создан отдельный класс для проверки валидации.
Будет создан класс разбора (парсинга) строки в выражение
Будет создан основной класс производящий математические вычисления
Будет создан класс для работы с консолью (чтения, вывода) и т.д.
Перед началом выполнения работы подумайте, как правильнее реализовать парсинг строки из операторов и операндов.
Удостоверьтесь, что вы не будете писать велосипед (посмотрите в сторону алгоритма обратной польской записи - рекомендуется использовать именно его).
Сделайте вашу программу легко расширяемой. Например, если вы захотите добавить новый оператор ^, который возводит число в степень, то в коде необходимо будет произвести минимум изменений.
Также рекомендуем перед началом разработки программы нарисовать архитектуру и дизайн вашего приложения.

**Усложненный вариант задания**

Помимо цифр и знаков сложения/вычитания/деления/умножения могут встречаться скобки и отрицательные числа.
Например выражение вида (-2) - ((-4) * 3.5) будет считаться корректным.