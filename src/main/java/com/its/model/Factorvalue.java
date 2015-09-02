/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ITS
 */
@Entity
@Table(name = "factorvalue", catalog = "windfarms", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Factorvalue.findAll", query = "SELECT f FROM Factorvalue f"),
    @NamedQuery(name = "Factorvalue.findByFactorid", query = "SELECT f FROM Factorvalue f WHERE f.factorid = :factorid"),
    @NamedQuery(name = "Factorvalue.findByWindspeed", query = "SELECT f FROM Factorvalue f WHERE f.windspeed = :windspeed"),
    @NamedQuery(name = "Factorvalue.findBySlope", query = "SELECT f FROM Factorvalue f WHERE f.slope = :slope"),
    @NamedQuery(name = "Factorvalue.findByWinddirection", query = "SELECT f FROM Factorvalue f WHERE f.winddirection = :winddirection")
})
public class Factorvalue implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factorid", nullable = false)
    private Integer factorid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "windspeed", precision = 22)
    private Double windspeed;
    @Column(name = "slope", precision = 22)
    private Double slope;
    @Size(max = 45)
    @Column(name = "winddirection", length = 45)
    private String winddirection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factorvalueFactorid", fetch = FetchType.LAZY)
    private List<Cellfactor> cellfactorList;

    public Factorvalue()
    {
    }

    public Factorvalue(Integer factorid)
    {
        this.factorid = factorid;
    }

    public Integer getFactorid()
    {
        return factorid;
    }

    public void setFactorid(Integer factorid)
    {
        this.factorid = factorid;
    }

    public Double getWindspeed()
    {
        return windspeed;
    }

    public void setWindspeed(Double windspeed)
    {
        this.windspeed = windspeed;
    }

    public Double getSlope()
    {
        return slope;
    }

    public void setSlope(Double slope)
    {
        this.slope = slope;
    }

    public String getWinddirection()
    {
        return winddirection;
    }

    public void setWinddirection(String winddirection)
    {
        this.winddirection = winddirection;
    }

    @XmlTransient
    public List<Cellfactor> getCellfactorList()
    {
        return cellfactorList;
    }

    public void setCellfactorList(List<Cellfactor> cellfactorList)
    {
        this.cellfactorList = cellfactorList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (factorid != null ? factorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factorvalue))
        {
            return false;
        }
        Factorvalue other = (Factorvalue) object;
        if ((this.factorid == null && other.factorid != null) || (this.factorid != null && !this.factorid.equals(other.factorid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.its.model.Factorvalue[ factorid=" + factorid + " ]";
    }

}
