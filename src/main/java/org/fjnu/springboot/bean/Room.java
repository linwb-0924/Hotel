package org.fjnu.springboot.bean;

import java.io.Serializable;

/**
 * @author wb_Lin
 * @create 2020-06-13 10:02
 */
public class Room implements Serializable {
    private  String rno;
    private  String rname;
    private  String rstatus;
    private  double rprice;

    public Room() {
    }

    public Room(String rno, String rname, String rstatus, double rprice) {
        this.rno = rno;
        this.rname = rname;
        this.rstatus = rstatus;
        this.rprice = rprice;
    }

    public Room(String rno, String rname, double rprice) {
        this.rno = rno;
        this.rname = rname;
        this.rprice = rprice;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }
}
