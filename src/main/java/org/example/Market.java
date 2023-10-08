package org.example;
import java.util.*;



public class Market implements MarketBehaviour, QueueBehaviour{
    List <Actor> orders = new LinkedList<>();
    Queue <Actor> que = new ArrayDeque<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getActor().getName() + " Покупатель зашел в магазин");
        System.out.println();

        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.que.add(actor);
        System.out.println(actor.getActor().getName() + " Покупатель встал в очередь");
        System.out.println();

    }

    @Override
    public void takeOrder() {
        for (Actor actor : que) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName() + " Покупатель заказал товары");
                System.out.println();

            }
        }
    }

    @Override
    public void giveOrder() {

        for (Actor actor : que) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName() + " Покупатель получил заказ");
                System.out.println();

            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (Actor actor : que) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " Покупатель вышел из очереди");
                System.out.println();
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " Покупатель покинул магазин");
            System.out.println();
            que.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }
}