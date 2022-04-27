package eapli.base.customermanagement.domain;
import javax.persistence.*;
import java.util.Objects;


@Entity
    public class Customer {

        @Id
        @GeneratedValue
        private int id;

        @Embedded
        private CustomerName name;

        @Embedded
        private CustomerAddress address;

        @Embedded
        private CustomerPhone phone;

        @Embedded
        private CustomerVAT vat;

        @Embedded
        private CustomerBirth birth;


        protected Customer() {
            // for ORM
        }


    public Customer(int id,
            CustomerName name,
                    CustomerAddress address,
                            CustomerPhone phone,
            CustomerVAT vat,
                    CustomerBirth birth){

        this.id = id;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.birth = birth;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", vat=" + vat +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
        }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, vat, birth);
    }

}
