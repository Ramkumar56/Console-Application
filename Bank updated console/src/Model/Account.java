package Model;

public class Account {

    private int customerid;
    private String accountnumber;
    private long accountbalance;
    private String accountstatus;

    private  String accountType;

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public long getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(long accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
