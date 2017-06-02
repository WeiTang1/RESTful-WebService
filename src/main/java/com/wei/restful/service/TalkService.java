package com.wei.restful.service;
import com.wei.restful.dao.TalkHibernateDao;
import com.wei.restful.model.Talk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Path("/talk")
public class TalkService {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    TalkHibernateDao daoi = (TalkHibernateDao) context.getBean("dao");

    @GET
    @Path("GetTalk/{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Talk getTalk(@PathParam("id") int id) {
        System.out.println("I am here");
        Talk talk = daoi.get(id);
        return talk;
    }
    @GET
    @Path("/GetTalks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTalk() {
        System.out.println("I am here");
        List list = daoi.list();
        GenericEntity<List<Talk>> list1 = new GenericEntity<List<Talk>>(list) {
        };
        return Response.ok(list1).build();
    }

    @POST
    @Path("/Insert")
    @Consumes({"application/x-www-form-urlencoded",MediaType.APPLICATION_JSON})
    public void createTalk(@FormParam("id") int id,
                           @FormParam("name") String name,
                           @FormParam("speaker") String speaker,
                           @FormParam("venue") String venue,
                           @FormParam("duration") double duration
                          ) throws IOException
    {

        Talk talk = new Talk(id,name,speaker,venue,duration);
        daoi.save(talk);

    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        System.out.println(id);
        daoi.delete(id);
    }

    @POST
    @Path("/Update")
    @Consumes({"application/x-www-form-urlencoded",MediaType.APPLICATION_JSON})
    public void updateTalk(@FormParam("id") int id,
                           @FormParam("name") String name,
                           @FormParam("speaker") String speaker,
                           @FormParam("venue") String venue,
                           @FormParam("duration") double duration
    ) throws IOException
    {
        Talk talk = new Talk(id,name,speaker,venue,duration);
        System.out.println(talk.toString());
        daoi.update(talk,id);
    }

}