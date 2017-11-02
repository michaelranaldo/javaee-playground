/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.ranaldo.javaeeplayground.ejb;

import javax.ejb.Local;

/**
 *
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
@Local
public interface FirstContactBeanLocal {

    public String greeting();

    public void updateGreeting();
    
}
