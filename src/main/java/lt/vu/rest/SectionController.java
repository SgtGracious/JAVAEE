package lt.vu.rest;

import lombok.*;

import lt.vu.entities.Section;
import lt.vu.persistence.jpa.BarsDAO;
import lt.vu.persistence.jpa.SectionsDAO;
import lt.vu.rest.SectionDto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/sections")
public class SectionController {

    @Inject
    @Setter @Getter
    private SectionsDAO sectionsDAO;

    @Inject
    @Setter @Getter
    private BarsDAO barsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Section section = sectionsDAO.findOne(id);
        if (section == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        SectionDto sectionDto = new SectionDto();
        sectionDto.setName(section.getName());
        sectionDto.setMaxWorkers(section.getMaxWorkers());
        sectionDto.setBarId(section.getBar().getId());

        return Response.ok(sectionDto).build();
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, SectionDto sectionDto) {
        try {
            Section section = sectionsDAO.findOne(id);
            if (section == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            section.setName(sectionDto.getName());
            section.setMaxWorkers(sectionDto.getMaxWorkers());
            section.setBar(barsDAO.findOne(sectionDto.getBarId()));

            sectionsDAO.update(section);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(SectionDto sectionDto) {
        try {
            Section section = new Section();
            section.setName(sectionDto.getName());
            section.setMaxWorkers(sectionDto.getMaxWorkers());
            section.setBar(barsDAO.findOne(sectionDto.getBarId()));

            sectionsDAO.persist(section);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}