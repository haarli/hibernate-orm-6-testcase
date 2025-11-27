package org.hibernate.bugs.pojo2;


import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@SuppressWarnings("serial")
@Entity
@Table(name = "user_account")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "user")
//@TypeDef(name = "GrantVOListJsonUserType", typeClass = GrantVOListJsonUserType.class)
public class User extends Basic {


  @ManyToOne(fetch = FetchType.EAGER)
  private Organization organization;


  public User() {}


  public Organization getOrganization() {
    return this.organization;
  }

  public void setOrganization(Organization affiliation) {
    this.organization = affiliation;
  }


}
