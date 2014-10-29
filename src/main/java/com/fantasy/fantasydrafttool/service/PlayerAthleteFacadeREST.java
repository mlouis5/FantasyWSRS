/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.service;

import com.fantasy.fantasydrafttool.pojo.PlayerAthlete;
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
@Path("/playerathlete")
public class PlayerAthleteFacadeREST extends AbstractFacade<PlayerAthlete> {
    @PersistenceContext(unitName = "com.fantasy_FantasyDrafttool_war_1.0PU")
    private EntityManager em;

    public PlayerAthleteFacadeREST() {
        super(PlayerAthlete.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(PlayerAthlete entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, PlayerAthlete entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        PlayerAthlete pa = super.find(id);
        if(Objects.nonNull(pa)){
            super.remove(pa);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public PlayerAthlete find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<PlayerAthlete> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<PlayerAthlete> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
