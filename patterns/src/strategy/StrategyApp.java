package strategy;

public class StrategyApp {
    public static void main(String[] args) {

        /*
            В паттерне Стратегия: стратегию можно установить только из вне,
            а в паттерне Состояние состояние меняется внутри контекста или внуутри другого состояния
            
            +
            Стратегия делает одно и тоже, но разными спосабами,
            а Состояния могут иметь разные назначения
         */

        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new Strategy1());
        strategyClient.doOperation();

        strategyClient.setStrategy(new Strategy2());
        strategyClient.doOperation();
    }
}
interface Strategy{
    void strategy();
}
class Strategy1 implements Strategy{
    public void strategy() {
        System.out.println("strategy 1");
    }
}
class Strategy2 implements Strategy{
    public void strategy() {
        System.out.println("strategy 2");
    }
}
class StrategyClient{
    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void doOperation(){
        strategy.strategy();
    }
}