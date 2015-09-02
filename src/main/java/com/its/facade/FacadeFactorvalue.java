/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.its.facade;

import com.its.model.Factorvalue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ITS
 */
@Stateless
public class FacadeFactorvalue extends AbstractFacade<Factorvalue>
{
    @PersistenceContext(unitName = "com.its_windfarms_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public FacadeFactorvalue()
    {
        super(Factorvalue.class);
    }

}
