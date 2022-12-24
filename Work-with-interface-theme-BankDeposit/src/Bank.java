public interface Bank {
    void changeDurationDeposit(int year);      //изменить продолжительность вклада(бессрочный/долгосрочный/краткосрочный)
    void findOutDeposit();                    //узнать, какой вклад (отзывной или безотзывной)
    void openDepositInDiffCurrency();        //закрыть один вклад и открыть новый с такими же условиями, но в другой валюте
    void calculatePercentDeposit(int year); //рассчитать начисление процентов по вкладу.
    String bankInformation();              // полная информация о банке
}
