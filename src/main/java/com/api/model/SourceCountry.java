package com.api.model;

import javax.persistence.*;

@Entity
@Table(name = "SourceCountry")
public class SourceCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "squadName")
    String squadName;
    @Column(name = "smName")
    String smName;
    @Column(name = "sourceCountry")
    String sourceCountry;

    public String getSquadName() {
        return squadName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }
}
