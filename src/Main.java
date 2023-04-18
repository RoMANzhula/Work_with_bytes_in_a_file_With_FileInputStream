import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "pathToFile"; //создаем строковую переменную и инициализируем
        // ее адресом(путем к) нашего файла
        sumOfAllBytesInFile(fileName);
        searchMaximumByte(fileName);
        searchMinimumByte(fileName);
        sortBytesAscending(fileName);
    }

    public static void sumOfAllBytesInFile(String pathToFile) { //метод для подсчета всех байтов в указанном файле

        long containerForBytes = 0; //создаем 64-битный контейнер для подсчета байтов
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) {//создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)

            while (fileInputStream.available() > 0) { //будет выполнять цикл, пока в потоке для чтения есть еще байты
                int dataForRead = fileInputStream.read(); //считываем следующий байт
                containerForBytes += dataForRead; //добавляем считанный байт в наш контейнер байтов
            }

        } catch (IOException ioException) { //ловим исключение для входного/выходного потока
            ioException.printStackTrace(); //выводим исключение в стек
        }
        System.out.println("The sum of all bytes in your file: " + containerForBytes); //выводим в консоль данные
    }

    public static void searchMaximumByte(String pathToFile) { //метод для поиска максимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the maximum byte in your file: " + Collections.max(arrayListForReadBytes));//выводим в консоль -
            // функция super-класс Коллекции - вывести максимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchMinimumByte(String pathToFile) { //метод для поиска минимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the minimum byte in your file: " + Collections.min(arrayListForReadBytes));//выводим в консоль -
            // функция super-класс Коллекции - вывести минимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sortBytesAscending(String pathToFile) { //метод для поиска минимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }

            Collections.sort(arrayListForReadBytes); //используем супер-класса Collections метод sort() сортировки указанного
            // списка в порядке возрастания
            Set<Long> sortBytesForSet = new HashSet<>(arrayListForReadBytes); //создаем Сэт, который обеспечит нашему списку байтов
            //уникальность, т.е. избавит нас то повторяющихся экземпляров
            arrayListForReadBytes.clear(); //очищаем наш список всех байтов
            arrayListForReadBytes.addAll(sortBytesForSet); //заполняем наш список всех байтов значениями из Сэта
            System.out.print("For your attention sorted bytes from your file: "); //в консоль выводим литерал
            for (long elementOfArray : arrayListForReadBytes) { //используем or-each для вывода каждого элемента из нашего списка
                //уже отсортированных байтов
                System.out.print(elementOfArray + " "); //каждый элемент выводим их через пробел
            }

        } catch (IOException e) { //ловим исключения входного/выходного потока
            e.printStackTrace(); //выводим стек для пойманного исключения
        }
    }
}