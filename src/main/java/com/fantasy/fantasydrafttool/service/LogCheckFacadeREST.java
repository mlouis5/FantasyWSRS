/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.service;

import com.fantasy.fantasydrafttool.pojo.League;
import com.fantasy.fantasydrafttool.pojo.LogCheck;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mac
 */
@Stateless
@Path("/logcheck")
public class LogCheckFacadeREST extends AbstractFacade<LogCheck> {
    @PersistenceContext(unitName = "com.fantasy_FantasyDrafttool_war_1.0PU")
    private EntityManager em;

    public LogCheckFacadeREST() {
        super(LogCheck.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(LogCheck entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, LogCheck entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        LogCheck lc = super.find(id);
        if(Objects.nonNull(lc)){
            super.remove(lc);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LogCheck find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LogCheck> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LogCheck> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
