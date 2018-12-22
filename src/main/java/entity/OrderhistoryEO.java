package entity;

import javax.persistence.*;

@Entity
@Table(name = "orderhistory", schema = "neoflexdb")
public class OrderhistoryEO {
    private int id;
    private String placeOfIssue;
    private String delivery;
    private String deliveryAddress;
    private OrdercustomerEO ordercustomerEO;
    private OrderstatusEO orderstatusEO;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    public OrderstatusEO getOrderstatusEO() {
        return orderstatusEO;
    }

    public void setOrderstatusEO(OrderstatusEO orderstatusEO) {
        this.orderstatusEO = orderstatusEO;
    }

    @ManyToOne
    @JoinColumn(name = "order_customer_id")
    public OrdercustomerEO getOrdercustomerEO() {
        return ordercustomerEO;
    }

    public void setOrdercustomerEO(OrdercustomerEO ordercustomerEO) {
        this.ordercustomerEO = ordercustomerEO;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "place_of_issue", nullable = true, length = 1000)
    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    @Basic
    @Column(name = "delivery", nullable = true, length = 10)
    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Basic
    @Column(name = "delivery_address", nullable = true, length = 10)
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderhistoryEO that = (OrderhistoryEO) o;

        if (id != that.id) return false;
        if (placeOfIssue != null ? !placeOfIssue.equals(that.placeOfIssue) : that.placeOfIssue != null) return false;
        if (delivery != null ? !delivery.equals(that.delivery) : that.delivery != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (placeOfIssue != null ? placeOfIssue.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        return result;
    }
}
