package managed.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.DefaultMapModel;


@Named(value = "mbmapa")
@SessionScoped
public class ManagedBeanMapa implements Serializable {

    // Propiedades
    private MapModel simpleModel;
    private Marker marker;
    public ManagedBeanMapa() {
        simpleModel = new DefaultMapModel();

        LatLng coord1 = new LatLng(-13.0817048, -76.3908276);
        LatLng coord2 = new LatLng(-12.9717455, -76.5382816);
        LatLng coord3 = new LatLng(-12.9436721, -76.3777042);

        simpleModel.addOverlay(new Marker(coord1, "Cerro Azul"));
        simpleModel.addOverlay(new Marker(coord2, "Valle Grande"));
        simpleModel.addOverlay(new Marker(coord3, "Parque Chavin"));
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) { //"OverlaySelectEvent"  Cuando se Selecciona un Superposición
        marker = (Marker) event.getOverlay();

        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Marker Selected", marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
