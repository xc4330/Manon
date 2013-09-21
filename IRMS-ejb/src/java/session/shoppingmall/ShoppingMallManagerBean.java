/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.shoppingmall;

import entity.shoppingmall.OutletEntity;
import entity.shoppingmall.ShoppingMallEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nirvana
 */
@Stateless
public class ShoppingMallManagerBean implements ShoppingMallManagerBeanLocal {
    @PersistenceContext
    private EntityManager em;
    
    

public void createShoppingMall(String smName){
    ShoppingMallEntity sm = new ShoppingMallEntity();
    sm.setName(smName);
    
    em.persist(sm);
}

public void createOutlet(String outletName, String smName){
    OutletEntity outlet = new OutletEntity();
    outlet.setName(outletName);
}

}
