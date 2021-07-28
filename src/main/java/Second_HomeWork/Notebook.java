package Second_HomeWork;

public class Notebook {

    private int price;
    private int RAM;
    private String brand;

    public Notebook(int price, int RAM, String name) {
        this.brand = name;
        this.RAM = RAM;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", RAM=" + RAM +
                ", brand='" + brand + '\'' +
                '}' + '\n';
    }

    public int getPrice() {
        return price;
    }

    public int getRAM() {
        return RAM;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
