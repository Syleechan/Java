package Order;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 19:39
 * @description：
 */

class Order<T> {

    private String name;
    private int id;


    private T Order;

    public Order(String name, int id, T order) {
        this.name = name;
        this.id = id;
        Order = order;
    }

    public Order() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getOrder() {
        return Order;
    }

    public void setOrder(T order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", Order=" + Order +
                '}';
    }
}
