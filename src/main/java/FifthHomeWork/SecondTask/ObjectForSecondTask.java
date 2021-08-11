package FifthHomeWork.SecondTask;

public abstract class ObjectForSecondTask {

    private final int weight;

    public int getPrice() {
        return price;
    }

    private final int price;
    private String name;

    public ObjectForSecondTask(int weight, int price, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " {" + "weight: " + weight + " price: " + price + "}";
    }

    public int getWeight() {
        return weight;
    }
}
