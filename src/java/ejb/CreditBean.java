/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Credit;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sukanya
 */
@Stateless
public class CreditBean extends AbstractBean<Credit> {

    public CreditBean() {
        super(Credit.class);
    }

    @Override
    public List<Credit> findAll() {
        return getEntityManager().createNamedQuery("Credit.findAll", Credit.class).getResultList();
    }
}
