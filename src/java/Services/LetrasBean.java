/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author NovatoPx
 */
@Named(value = "letrasBean")
@SessionScoped
public class LetrasBean implements Serializable {

    public void soloLetras(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        if (((String) arg2).matches("[0-9]*")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Solo Letras", ""));
        }
    }
   
}