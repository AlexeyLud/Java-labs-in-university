public class BankImpl implements Bank {
    private String bankName;           // название банка
    private double startDeposit;      // начальный вклад
    private double targetDeposit;    // целевой вклад
    private String durationDeposit; // продолжительность
    private int persentRate;       // процентная ставка
    private String depositType;   // тип(вид) вклада
    private String currency;     // валюта

    public BankImpl(String bankName, double startDep, double tarDep, String durat, int persRate, String currency){
        this.bankName = bankName;
        this.startDeposit = startDep;
        this.targetDeposit = tarDep;
        this.durationDeposit = durat;
        this.persentRate = persRate;
        this.currency = currency;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public void changeDurationDeposit(int year){
        System.out.println("Зададим срок нашего вклада. Например " + year + "год(a)/лет");
        if (year == 0) {
            durationDeposit = "Бессрочный";
            persentRate = 1;
        }
        else if(year > 1 && year <= 30){
            durationDeposit = "Долгосрочный";
            persentRate = 13;
        }
        else if(year > 0 && year <= 1){
            durationDeposit = "Краткосрочный";
            persentRate = 9;
        }
        System.out.println("Продолжительность вклада банка '" + bankName + "' изменена на - '" +
                durationDeposit + "', а процентная ставка теперь равна = " + persentRate + "%");;
    }

    @Override
    public void findOutDeposit(){
        if(persentRate > 0 && persentRate <= 12){
            depositType = "Отзывной";
            System.out.println("У нашего банка '" + bankName + "' тип вклада - '" +
                    depositType + "', потому что его процентаная ставка = " +
                    persentRate + "%" + ", что > 0% и <= 12%");
        }
        else if(persentRate >= 13 && persentRate < 25){
            depositType = "Безотзывной";
            System.out.println("У нашего банка '" + bankName + "' тип вклада - '" +
                    depositType + "', потому что его процентаная ставка = " +
                    persentRate + "%" + ", что >= 13% и < 25%");
        }
    }

    @Override
    public void openDepositInDiffCurrency(){
        System.out.println("Валюта нашего вклада = '" + currency + "'");
        if(currency.equals("byn")){
            currency = "usd";
            startDeposit *= 0.39;
            targetDeposit *= 0.39;
        }
        else{
            currency = "byn";
            startDeposit *= 2.56;
            targetDeposit *= 2.56;
        }
        System.out.println("Закрываем этот вклад и открываем новый в валюте = '" + currency + "'");
    }

    @Override
    public void calculatePercentDeposit(int year){
        System.out.println("Начальный вклад в банк '" + bankName + "' состовляет = " + startDeposit + currency);
        System.out.println("Процентная ставка равна = " + persentRate + "%");
        System.out.println("Теперь рассчиаем доход через " + year + "год(a)/лет = " + year*12 + "мес");
        double formula = 1 + (double)persentRate/1200;
        double dohod = startDeposit * Math.pow(formula,12 * year);
        System.out.println("Полученная сумма составит = " + dohod);
        System.out.println("А сумма начисляемых процентов получится = " + (dohod - startDeposit));
        if(dohod >= targetDeposit){
            System.out.println("Судя по нашим рассчётам, целевого вклада = " + targetDeposit + currency +
                    " мы достигнем через " + year + "год(a)/лет");
        }
    }

    @Override
    public String bankInformation() {
        if(depositType == null){
            depositType = "UNKNOWN";
        }
        return "\tbankName = '" + bankName + "'\n" + "\tstartDeposit = " + startDeposit + currency + "\n" +
                "\ttargetDeposit = " + targetDeposit + currency + "\n" + "\tdurationDeposit = " + durationDeposit + "\n" +
                "\tpersentRate = " + persentRate + "%\n" + "\tdepositType = " + depositType + "\n" + "\tcurrency = " + currency;
    }


}
