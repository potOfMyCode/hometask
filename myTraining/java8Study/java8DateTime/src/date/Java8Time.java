package date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;

public class Java8Time {
    public static void main(String[] args) {
        // Получае текущую дату
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //Создадим LocalDate и в качестве аргументов
        //укажем год месяц и день
        LocalDate dateCreate = LocalDate.of(1963,11,22);
        System.out.println(dateCreate);

        //А теперь попробуем хитрость. Укажем дату с ошибкой
        //LocalDate invDate = LocalDate.of(2000, Month.FEBRUARY , 30);
        //Но получим исключение java.time.DateTimeException:
        //Invalid value for DayOfMonth (valid values 1 - 28/31): 33

        //Получаем дату, например с 01.01.1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println(dateFromBase);

        LocalDate day200_2018 = LocalDate.ofYearDay(2018 , 200);
        System.out.println(day200_2018);

        System.out.println();

        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime timeRandom = LocalTime.of(11,45,23,0);
        System.out.println(timeRandom);

        System.out.println();

        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        today = LocalDateTime.of(LocalDate.now() , LocalTime.now());
        System.out.println(today);

        LocalDateTime dateTimeFrom = LocalDateTime.ofEpochSecond(2000 , 0 , ZoneOffset.UTC);
        System.out.println(dateTimeFrom);

        System.out.println();

        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::yyyy")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("d::MMM::yyyy HH:mm:ss")));
    }
}
