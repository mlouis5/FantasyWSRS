/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.service;

import com.fantasy.fantasydrafttool.pojo.Heartbeat;
import com.fantasy.fantasydrafttool.pojo.LogCheck;
import com.fantasy.fantasydrafttool.pojo.Owner;
import com.fantasy.fantasydrafttool.utilities.JsonConverter;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
import java.time.Instant;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientResponse;

/**
 * REST Web Service
 *
 * @author MacDerson
 */
@Path("/login")
@Stateless
public class LoginFacdeRest extends AbstractFacade<LogCheck> {

    //////////INJECTED BEANS
    @EJB
    private JsonConverter jsonConverter;
    @Context
    private UriInfo context;
    @PersistenceContext(unitName = "com.fantasy_FantasyDrafttool_war_1.0PU")
    private EntityManager em;

    //////////STATIC VALUES
    private static final String BASE_HEARTBEAT = "http://localhost:8080/DraftLogger/heartbeat";
    private static final String HEARTBEAT_PATH = BASE_HEARTBEAT;
    private static final String LAST_HEARTBEAT_PATH = BASE_HEARTBEAT + "/lastbeat";

    /**
     * Creates a new instance of LogginResource
     */
    public LoginFacdeRest() {
        super(LogCheck.class);
    }

    /**
     * Retrieves representation of an instance of
     * com.fantasy.draftlogger.service.LogginResource
     *
     * @param email
     * @param pwd
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{email}/{pwd}")
    @Produces(MediaType.APPLICATION_JSON)
    public LogCheck login(@PathParam("email") String email, @PathParam("pwd") String pwd) {
//        LogCheck res = null;
//        if (Objects.nonNull(email) && Objects.nonNull(pwd)) {
//            res = super.find(email);
//                if (Objects.nonNull(res)) {
//                    Response response = makeGetRequest(LAST_HEARTBEAT_PATH,
//                            MediaType.APPLICATION_JSON_TYPE);
//
//                    if (!(response.getStatus() == Response.Status.OK.getStatusCode())) {
//                        long initHeartbeat = Instant.now().toEpochMilli();
//                        Heartbeat hb = new Heartbeat(initHeartbeat);
////                        String hbString = jsonConverter.jsonEncode(hb);
//                        Entity<Heartbeat> entity = Entity.entity(hb, MediaType.APPLICATION_JSON_TYPE);
//                        makePostRequest(HEARTBEAT_PATH, entity,
//                                MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_JSON_TYPE);
//                    }
//                }
//        }
//        return res;
        return null;
    }

//    private Response makePostRequest(String resourcePath, String jsonEncodedString,
//            MediaType consumeType, MediaType acceptType) {
//        Client client = ClientBuilder.newClient();//Client.create();
//        WebTarget resource = client.target(resourcePath);
//        //WebResource resource = client.resource(resourcePath);
//        
//        Entity<Owner> entity = Entity.en
//        
//        Response response = resource.request(acceptType).post(Entity., null) //resource.type(consumeType)
//                .accept(acceptType)
//                .post(ClientResponse.class, jsonEncodedString);
//
//        return response;
//    }
    
    private Response makePostRequest(String resourcePath, Entity entity,
            MediaType consumeType, MediaType acceptType) {
        Client client = ClientBuilder.newClient();//Client.create();
        WebTarget resource = client.target(resourcePath);
        //WebResource resource = client.resource(resourcePath);
        
        //Entity<Owner> entity = Entity.entity(new Owner(), MediaType.APPLICATION_JSON_TYPE);
        
        Response response = resource.request(acceptType).post(entity);

        return response;
    }

    private Response makeGetRequest(String resourcePath, MediaType acceptType) {
        Client client = ClientBuilder.newClient();//Client.create();
        WebTarget resource = client.target(resourcePath);
        //WebResource resource = client.resource(resourcePath);

        Response response = resource.request(acceptType).get(Response.class);

        return response;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
