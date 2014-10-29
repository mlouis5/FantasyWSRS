/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author MacDerson
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.fantasy.fantasydrafttool.service.HeartbeatFacadeREST.class);
        resources.add(com.fantasy.fantasydrafttool.service.LeagueFacadeREST.class);
        resources.add(com.fantasy.fantasydrafttool.service.LogCheckFacadeREST.class);
        resources.add(com.fantasy.fantasydrafttool.service.LoginFacdeRest.class);
        resources.add(com.fantasy.fantasydrafttool.service.OwnerFacadeREST.class);
        resources.add(com.fantasy.fantasydrafttool.service.PickFacadeREST.class);
        resources.add(com.fantasy.fantasydrafttool.service.PlayerAthleteFacadeREST.class);
    }
    
}
