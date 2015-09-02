/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.backing;

import com.its.facade.FacadeCell;
import com.its.facade.FacadeCellfactor;
import com.its.facade.FacadeFactorvalue;
import com.its.model.Cell;
import com.its.model.Cellfactor;
import com.its.model.Factorvalue;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ITS
 */
@Named
@ViewScoped
public class joinrelation implements Serializable
{

    @EJB
    private FacadeCell facadeCell;
    @EJB
    private FacadeFactorvalue facadeFactorvalue;
    @EJB
    private FacadeCellfactor facadeCellfactor;
    private Cell cell;
    private Factorvalue factorvalue;

    @PostConstruct
    public void init()
    {
        clearme();
    }

    public void clearme()
    {
        cell = new Cell();
        factorvalue = new Factorvalue();
    }

    public List<Factorvalue> findallfactors()
    {
        return facadeFactorvalue.findAll();
    }

    public List<Cell> findallcells()
    {
        return facadeCell.findAll();
    }

    public void link()
    {
        cell = facadeCell.find(cell.getCelid());
        Cellfactor cellfactor = new Cellfactor();
        cellfactor.setFactorvalueFactorid(factorvalue);
        cellfactor.setCellCelid(cell);
        facadeCellfactor.create(cellfactor);
        clearme();

    }

    public Cell getCell()
    {
        return cell;
    }

    public void setCell(Cell cell)
    {
        this.cell = cell;
    }

    public Factorvalue getFactorvalue()
    {
        return factorvalue;
    }

    public void setFactorvalue(Factorvalue factorvalue)
    {
        this.factorvalue = factorvalue;
    }

}
