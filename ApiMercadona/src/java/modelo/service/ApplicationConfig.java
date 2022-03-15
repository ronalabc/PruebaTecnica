package modelo.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author roalbaci
 */
@javax.ws.rs.ApplicationPath("ApiMCDN")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(modelo.service.ProductosFacadeREST.class);
    }
    
}
