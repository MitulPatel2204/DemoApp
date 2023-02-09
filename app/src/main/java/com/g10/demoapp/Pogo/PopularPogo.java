package com.g10.demoapp.Pogo;

public class PopularPogo {

    Integer pid;
    String pname,pauthor,pdescription,pimage;

    public PopularPogo(Integer pid, String pname, String pauthor, String pdescription, String pimage) {
        this.pid = pid;
        this.pname = pname;
        this.pauthor = pauthor;
        this.pdescription = pdescription;
        this.pimage = pimage;
    }

    public PopularPogo() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPauthor() {
        return pauthor;
    }

    public void setPauthor(String pauthor) {
        this.pauthor = pauthor;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}
