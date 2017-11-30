package entity.dao;

import entity.Detventa;
import entity.dao.util.JsfUtil;
import entity.dao.util.JsfUtil.PersistAction;
import entity.controlador.DetventaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("detventaController")
@SessionScoped
public class DetventaController implements Serializable {

    @EJB
    private entity.controlador.DetventaFacade ejbFacade;
    private List<Detventa> items = null;
    private Detventa selected;

    public DetventaController() {
    }

    public Detventa getSelected() {
        return selected;
    }

    public void setSelected(Detventa selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setDetventaPK(new entity.DetventaPK());
    }

    private DetventaFacade getFacade() {
        return ejbFacade;
    }

    public Detventa prepareCreate() {
        selected = new Detventa();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Vistas").getString("DetventaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Vistas").getString("DetventaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Vistas").getString("DetventaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Detventa> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vistas").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vistas").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Detventa getDetventa(entity.DetventaPK id) {
        return getFacade().find(id);
    }

    public List<Detventa> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Detventa> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Detventa.class)
    public static class DetventaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetventaController controller = (DetventaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detventaController");
            return controller.getDetventa(getKey(value));
        }

        entity.DetventaPK getKey(String value) {
            entity.DetventaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entity.DetventaPK();
            key.setNummed(Integer.parseInt(values[0]));
            key.setNcodDoc(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entity.DetventaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNummed());
            sb.append(SEPARATOR);
            sb.append(value.getNcodDoc());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detventa) {
                Detventa o = (Detventa) object;
                return getStringKey(o.getDetventaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detventa.class.getName()});
                return null;
            }
        }

    }

}
