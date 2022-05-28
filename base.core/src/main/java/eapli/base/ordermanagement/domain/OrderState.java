package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;


@Embeddable
public class OrderState {
    private PossibleStates state;

    public OrderState(PossibleStates state){

        this.state=state;
    }
    public OrderState(){}

    @Override
    public String toString() {
        return "OrderState{" +
                "state=" + state +
                '}';
    }

    public PossibleStates value(){
        return this.state;
    }

    public static OrderState valueOf(PossibleStates state){
        return new OrderState(state);
    }


}
