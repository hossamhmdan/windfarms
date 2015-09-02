/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ITS
 */
@Entity
@Table(name = "cellfactor", catalog = "windfarms", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Cellfactor.findAll", query = "SELECT c FROM Cellfactor c"),
    @NamedQuery(name = "Cellfactor.findById", query = "SELECT c FROM Cellfactor c WHERE c.id = :id")
})
public class Cellfactor implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "cell_celid", referencedColumnName = "celid", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cell cellCelid;
    @JoinColumn(name = "factorvalue_factorid", referencedColumnName = "factorid", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Factorvalue factorvalueFactorid;

    public Cellfactor()
    {
    }

    public Cellfactor(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Cell getCellCelid()
    {
        return cellCelid;
    }

    public void setCellCelid(Cell cellCelid)
    {
        this.cellCelid = cellCelid;
    }

    public Factorvalue getFactorvalueFactorid()
    {
        return factorvalueFactorid;
    }

    public void setFactorvalueFactorid(Factorvalue factorvalueFactorid)
    {
        this.factorvalueFactorid = factorvalueFactorid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cellfactor))
        {
            return false;
        }
        Cellfactor other = (Cellfactor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.its.model.Cellfactor[ id=" + id + " ]";
    }

}
