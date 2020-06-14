package org.fjnu.springboot.bean;

/**
 * @author wb_Lin
 * @create 2020-06-13 15:59
 */
public class Customer {
    private  String cno;
    private  String cname;
    private  String telephone;

    public Customer() {
    }

    public Customer(String cno, String cname, String telephone) {
        this.cno = cno;
        this.cname = cname;
        this.telephone = telephone;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
