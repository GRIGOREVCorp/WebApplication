package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderstatus", schema = "neoflexdb", catalog = "")
public class OrderstatusEO {
    private int id;
    private String created;
    private String processing;
    private String finished;
    private List<OrdercustomerEO> orders;
    private List<OrderhistoryEO> history;

    @OneToMany(mappedBy = "orderstatusEO", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<OrderhistoryEO> getHistory() {
        return history;
    }

    public void setHistory(List<OrderhistoryEO> history) {
        this.history = history;
    }

    @OneToMany(mappedBy = "orderstatusEO", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<OrdercustomerEO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdercustomerEO> orders) {
        this.orders = orders;
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
    @Column(name = "created", nullable = true, length = 10)
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Basic
    @Column(name = "processing", nullable = true, length = 1000)
    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @Basic
    @Column(name = "finished", nullable = true, length = 10)
    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderstatusEO that = (OrderstatusEO) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (processing != null ? !processing.equals(that.processing) : that.processing != null) return false;
        if (finished != null ? !finished.equals(that.finished) : that.finished != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (processing != null ? processing.hashCode() : 0);
        result = 31 * result + (finished != null ? finished.hashCode() : 0);
        return result;
    }
}
