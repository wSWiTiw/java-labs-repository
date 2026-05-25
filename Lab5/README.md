# Lab5. Регулярные выражения

Поиск чисел, проверка IP и пароля, поиск слов и выделение заглавных букв.

## Состав работы

- `src/CapitalLetterHighlight.java`
- `src/IPValidator.java`
- `src/NumberFinder.java`
- `src/PasswordValidator.java`
- `src/WordFinder.java`

## Компиляция

```bash
javac -encoding UTF-8 -d out src/*.java
```

## Запуск

```bash
java -cp out NumberFinder
java -cp out IPValidator
java -cp out WordFinder
java -cp out PasswordValidator
java -cp out CapitalLetterHighlight
```

> Некоторые программы ожидают ввод с клавиатуры или используют файлы в корне папки лабораторной работы.
