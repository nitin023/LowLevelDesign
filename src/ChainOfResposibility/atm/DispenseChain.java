package ChainOfResposibility.atm;

public interface DispenseChain {

    void dispense(Currency currency);

    void setNextChain(DispenseChain dispenseChain);
}
