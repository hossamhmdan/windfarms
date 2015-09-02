/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.facade;

import com.its.model.Cell;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ITS
 */
@Stateless
public class FacadeCell extends AbstractFacade<Cell>
{

    @PersistenceContext(unitName = "com.its_windfarms_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public FacadeCell()
    {
        super(Cell.class);
    }

    public void delete(Cell cell)
    {
        Query q = em.createQuery("DELETE FROM Cell AS C WHERE c.celid=:cellid ");
        q.setParameter("cellid", cell.getCelid());
        q.executeUpdate();
    }

}
