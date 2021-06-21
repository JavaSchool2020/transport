import builder.BusBuilder;
import builder.CarBuilder;
import builder.MotorcycleBuilder;
import builder.TransportBuilder;
import model.Transport;

import java.util.Scanner;

public class TransportLine {

    public static void main(String[] args) {
        boolean isContinue;
        do {
            Scanner sc = new Scanner(System.in);
            TransportBuilder<?> builder = getBuilder(getType(sc));
            builder.vin(readString(sc, "Введите VIN транспорта"));
            builder.maxSpeed(readInt(sc, "Введите максимальную скорость (км)", 500));
            builder.length(readInt(sc, "Введите длину транспорта (см)", 1500));
            builder.width(readInt(sc, "Введите ширину транспорта (см)", 500));
            builder.height(readInt(sc, "Введите высоту транспорта (см)", 500));
            builder.ecoClass(readString(sc, "Введите эко класс"));

            Transport transport = builder.build();
            showInfo(transport);

            isContinue = doContinue(sc);

        } while(isContinue);
    }

    private static int getType(Scanner sc) {
        return readInt(sc,
                "Выберите тип транспорта для производства: 1 - лекговой автомобиль, 2 - автобус, 3 - мотоцикл",
                3);
    }

    private static TransportBuilder<?> getBuilder(int type) throws IllegalArgumentException {
        switch (type) {
            case 1: return new CarBuilder();
            case 2: return new BusBuilder();
            case 3: return new MotorcycleBuilder();
            default: throw new IllegalArgumentException("Transport type is undefine");
        }
    }

    private static String readString(Scanner sc, String text) {
        String vin = "";
        do {
            System.out.println(text);
            vin = sc.nextLine();
        } while (vin.isEmpty());

        return vin;
    }

    private static int readInt(Scanner scanner, String text, int max) {
        int result = 0;
        boolean isContinue = true;
        do {
            System.out.println(text);
            try {
                String value = scanner.nextLine();
                result = Integer.parseInt(value);
            } catch (Exception e) {
                System.out.println("Ожидается вввод цифры");
                continue;
            }
            isContinue = result <=0 || result > max;
            if (isContinue) {
                System.out.println("Не удовлетворяет заданному диапазону: минимум - 1, максимум (исключая) - " + max);
            }
        } while (result <=0 || result > max);

        return result;
    }

    public static void showInfo(Transport transport) {
        System.out.println("\nСобрано транспортное средство:\nТип: " + transport.getType()
                + "\nVIN: " + transport.getVin()
                + "\nДата сборки: " + transport.getCreateDate()
                + "\nДлина: " + transport.getLength()
                + "\nВысота: " + transport.getHeight()
                + "\nШирина: " + transport.getWidth()
                + "\nЭко класс: " + transport.getEcoClass()
                + "\nМаскимальная скорость: " + transport.getMaxSpeed()
        );
    }

    private static boolean doContinue(Scanner sc) {
        int doWork = 0;
        do {
            System.out.println("\nЗакончить работу: 1 - ДА, 2 - НЕТ");
            try {
                String value = sc.nextLine();
                doWork = Integer.parseInt(value);
            } catch (Exception e) {
                System.out.println("Ожидается вввод цифры");
            }
        } while (doWork != 1 && doWork != 2);

        System.out.println("\n");
        return doWork != 1;
    }
}
