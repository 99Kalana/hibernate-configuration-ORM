package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teachers {

    @Id
    private int tid;

    private String tname;

    private String lecmodule;

    public Teachers() {
    }

    public Teachers(int tid, String tname, String lecmodule) {
        this.tid = tid;
        this.tname = tname;
        this.lecmodule = lecmodule;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLecmodule() {
        return lecmodule;
    }

    public void setLecmodule(String lecmodule) {
        this.lecmodule = lecmodule;
    }
}
