package org.example;

/**
 * Реализовать класс Market и все методы, которые он обязан реализовывать.
 * Методы из интерфейса QueueBehaviour, имитируют работу очереди,
 * MarketBehaviour – помещает и удаляет человека из очереди,
 * метод update – обновляет состояние магазина (принимает и отдаёт заказы)
 */

public class Main {
    public static void main(String[] args) {

        Market market = new Market();

        Actor name1 = new Human("Alex");
        Actor name2 = new Human("Non-Alex");
        Actor name3 = new Human("Chloya");
        Actor name4 = new Human("Maftuha");


        market.acceptToMarket(name1);
        market.acceptToMarket(name2);
        market.acceptToMarket(name3);
        market.acceptToMarket(name4);
        market.update();

//        market.takeInQueue(name1);
//        market.takeOrders("Хлеба кусок");
//        market.update();
//
//        market.takeInQueue(name2);
//        market.takeOrders("Кашица");
//        market.update();
//
//        market.takeInQueue(name3);
//        market.takeOrders("Воды стакан");
//        market.update();
//
//        market.takeInQueue(name4);
//        market.takeOrders("Полба");
//        market.update();
//
//        market.releaseFromMarket(name1);
//        market.releaseFromMarket(name2);
//        market.releaseFromMarket(name3);
//        market.releaseFromMarket(name4);
        market.update();

    }
}