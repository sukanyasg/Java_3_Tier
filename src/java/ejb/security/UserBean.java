/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.security;

import domain.security.User;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sukanya
 */
@Stateless
public class UserBean extends AbstractBean<User>{

    public UserBean() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
       return getEntityManager().createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    
}
