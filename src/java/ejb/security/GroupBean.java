/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.security;

import domain.security.Group;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sukanya
 */
@Stateless
public class GroupBean extends AbstractBean<Group>{

    public GroupBean() {
        super(Group.class);
    }

    @Override
    public List<Group> findAll() {
        return getEntityManager().createNamedQuery("Group.findAll", Group.class).getResultList();
    }
    
}
