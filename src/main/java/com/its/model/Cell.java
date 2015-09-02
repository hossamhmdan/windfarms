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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ITS
 */
@Entity
@Table(name = "cell", catalog = "windfarms", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Cell.findAll", query = "SELECT c FROM Cell c"),
    @NamedQuery(name = "Cell.findByCelid", query = "SELECT c FROM Cell c WHERE c.celid = :celid"),
    @NamedQuery(name = "Cell.findByMinlat", query = "SELECT c FROM Cell c WHERE c.minlat = :minlat"),
    @NamedQuery(name = "Cell.findByMinlong", query = "SELECT c FROM Cell c WHERE c.minlong = :minlong"),
    @NamedQuery(name = "Cell.findByMaxlat", query = "SELECT c FROM Cell c WHERE c.maxlat = :maxlat"),
    @NamedQuery(name = "Cell.findByMaxlong", query = "SELECT c FROM Cell c WHERE c.maxlong = :maxlong")
})
public class Cell implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "celid", nullable = false)
    private Integer celid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minlat", precision = 22)
    private Double minlat;
    @Column(name = "minlong", precision = 22)
    private Double minlong;
    @Column(name = "maxlat", precision = 22)
    private Double maxlat;
    @Column(name = "maxlong", precision = 22)
    private Double maxlong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cellCelid", fetch = FetchType.LAZY)
    private List<Cellfactor> cellfactorList;

    public Cell()
    {
    }

    public Cell(Integer celid)
    {
        this.celid = celid;
    }

    public Integer getCelid()
    {
        return celid;
    }

    public void setCelid(Integer celid)
    {
        this.celid = celid;
    }

    public Double getMinlat()
    {
        return minlat;
    }

    public void setMinlat(Double minlat)
    {
        this.minlat = minlat;
    }

    public Double getMinlong()
    {
        return minlong;
    }

    public void setMinlong(Double minlong)
    {
        this.minlong = minlong;
    }

    public Double getMaxlat()
    {
        return maxlat;
    }

    public void setMaxlat(Double maxlat)
    {
        this.maxlat = maxlat;
    }

    public Double getMaxlong()
    {
        return maxlong;
    }

    public void setMaxlong(Double maxlong)
    {
        this.maxlong = maxlong;
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
        hash += (celid != null ? celid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cell))
        {
            return false;
        }
        Cell other = (Cell) object;
        if ((this.celid == null && other.celid != null) || (this.celid != null && !this.celid.equals(other.celid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.its.model.Cell[ celid=" + celid + " ]";
    }

}
