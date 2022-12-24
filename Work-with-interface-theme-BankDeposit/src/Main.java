
public class Main {
    public static void main(String[] args) {
        // Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей.
        //(Реализовать отдельный пpоверочный класс с методом main(), который реализует поставленную задачу.
        // Весь процесс должен детально выводиться пользователю на консоль. НЕ реализовывать консольный пользовательский интерфейс.)
        // Variant 11 - Банковский вклад
        // Возможности:
        // 1)изменить продолжительность вклада(бессрочный/долгосрочный/краткосрочный); 2)узнать, какой вклад (отзывной или безотзывной);
        // 3)закрыть один вклад и открыть новый с такими же условиями, но в другой валюте; 4)рассчитать начисление процентов по вкладу.

        BankImpl bank1 = new BankImpl("Tinkoff",312.5,625,"Бессрочный",1, "usd");

        System.out.println("Добро пожаловать в банк '" + bank1.getBankName() + "'");
        System.out.println("\nНачальная информация о банке");
        System.out.println("-------------------------------");
        System.out.println(bank1.bankInformation());
        System.out.println("-------------------------------\n");


        System.out.println("Наш банк имеет возможность изменить продолжительность вклада. Давайте попробуем");
        bank1.changeDurationDeposit(8);

        System.out.println("\nОбновлённая информация");
        System.out.println("-------------------------------");
        System.out.println(bank1.bankInformation());
        System.out.println("-------------------------------\n");


        System.out.println("Также наш банк имеет возможность узнать тип вклада. Давайте попробуем");
        bank1.findOutDeposit();

        System.out.println("\nОбновлённая информация");
        System.out.println("-------------------------------");
        System.out.println(bank1.bankInformation());
        System.out.println("-------------------------------\n");


        System.out.println("Можно закрыть наш вклад и открыть новый с такими же условиями, но в другой валюте. Давайте попробуем");
        bank1.openDepositInDiffCurrency();

        System.out.println("\nОбновлённая информация");
        System.out.println("-------------------------------");
        System.out.println(bank1.bankInformation());
        System.out.println("-------------------------------\n");


        System.out.println("Имеется возможность рассчитать начисление процентов по вкладу. Давайте попробуем");
        bank1.calculatePercentDeposit(1);

        System.out.println("\nОбновлённая информация");
        System.out.println("-------------------------------");
        System.out.println(bank1.bankInformation());
        System.out.println("-------------------------------\n");

        System.exit(0);
    }




}
