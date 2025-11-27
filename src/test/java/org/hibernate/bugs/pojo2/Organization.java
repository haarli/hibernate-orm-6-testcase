package org.hibernate.bugs.pojo2;

import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name = "organization")
public class Organization extends Basic {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentorganization_objectId")
    private Organization parentOrganization;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "organization_predecessor")
    private java.util.List<Organization> predecessorOrganizations = new ArrayList<>();


    public Organization getParentOrganization() {
        return this.parentOrganization;
    }
    public void setParentOrganization(Organization parentAffiliation) {
        this.parentOrganization = parentAffiliation;
    }


    public java.util.List<Organization> getPredecessorOrganizations() {
        return this.predecessorOrganizations;
    }
    public void setPredecessorOrganizations(java.util.List<Organization> predecessorAffiliations) {
        this.predecessorOrganizations = predecessorAffiliations;
    }





}
