package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ordercustomer", schema = "neoflexdb")
public class OrdercustomerEO {
    private int id;
    private Date date;
    private List<OrderhistoryEO> history;
    private OrderstatusEO orderstatusEO;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    public OrderstatusEO getOrderstatusEO() {
        return orderstatusEO;
    }

    public void setOrderstatusEO(OrderstatusEO orderstatusEO) {
        this.orderstatusEO = orderstatusEO;
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
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "ordercustomerEO", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<OrderhistoryEO> getHistory() {
        return history;
    }

    public void setHistory(List<OrderhistoryEO> history) {
        this.history=history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdercustomerEO that = (OrdercustomerEO) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
