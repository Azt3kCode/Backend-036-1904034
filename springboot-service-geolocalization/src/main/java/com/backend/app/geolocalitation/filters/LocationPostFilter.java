package com.backend.app.geolocalitation.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class LocationPostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        String latitud = (String) ctx.get("latitud");
        String longitud = (String) ctx.get("longitud");

        // Coordenadas de "UANL Rectoría"
        double uanlRectoriaLatitud = 25.725234510528832;
        double uanlRectoriaLongitud = -100.31051002762526;

        double distancia = calcularDistancia(Double.parseDouble(latitud), Double.parseDouble(longitud), uanlRectoriaLatitud, uanlRectoriaLongitud);

        ctx.addZuulResponseHeader("Distancia", Double.toString(distancia) + " km");

        return null;
    }

 // Fórmula de Haversine
    private double calcularDistancia(double latitudUsuario, double longitudUsuario, double latitudDestino, double longitudDestino) {

        double latitudUsuarioRad = Math.toRadians(latitudUsuario);
        double longitudUsuarioRad = Math.toRadians(longitudUsuario);
        double latitudDestinoRad = Math.toRadians(latitudDestino);
        double longitudDestinoRad = Math.toRadians(longitudDestino);

        double latitudDiferencia = latitudDestinoRad - latitudUsuarioRad;
        double longitudDiferencia = longitudDestinoRad - longitudUsuarioRad;

        double a = Math.pow(Math.sin(latitudDiferencia / 2), 2) + Math.cos(latitudUsuarioRad) * Math.cos(latitudDestinoRad) * Math.pow(Math.sin(longitudDiferencia / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371 * c;
    }

}
