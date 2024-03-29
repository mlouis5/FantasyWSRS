/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.service;

import com.fantasy.fantasydrafttool.pojo.Owner;
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
@Path("/owner")
public class OwnerFacadeREST extends AbstractFacade<Owner> {
    @PersistenceContext(unitName = "com.fantasy_FantasyDrafttool_war_1.0PU")
    private EntityManager em;

    public OwnerFacadeREST() {
        super(Owner.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Owner entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Owner entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        Owner o = super.find(id);
        if(Objects.nonNull(o)){
            super.remove(o);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Owner find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Owner> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Owner> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
