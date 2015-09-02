/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.backing;

import com.its.facade.FacadeCell;
import com.its.model.Cell;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ITS
 */
@Named
@ViewScoped
public class Cellmodel implements Serializable
{

    @EJB
    private FacadeCell facadeCell;
    private Cell cell;

    @PostConstruct
    public void init()
    {
        clearme();
    }

    public void clearme()
    {
        cell = new Cell();
    }

    public List<Cell> findall()
    {
        return facadeCell.findAll();
    }

    public FacadeCell getFacadeCell()
    {
        return facadeCell;
    }

    public void addcell()
    {
        if (cell.getCelid() == null)
        {
            facadeCell.create(cell);
            clearme();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Info", new FacesMessage("Movie added successfully"));
        } else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Info", new FacesMessage("Error"));
        }
    }

    public void update()
    {
        facadeCell.edit(cell);
    }

    public void delete()
    {
        if (cell.getCellfactorList().isEmpty())
        {
            facadeCell.delete(cell);
        } else
        {
            FacesContext con = FacesContext.getCurrentInstance();
            con.addMessage("error", new FacesMessage("you can not delete this row"));
        }
    }

    public void setFacadeCell(FacadeCell facadeCell)
    {
        this.facadeCell = facadeCell;
    }

    public Cell getCell()
    {
        return cell;
    }

    public void setCell(Cell cell)
    {
        this.cell = cell;
    }

}
