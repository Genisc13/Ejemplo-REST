package edu.upc.dsa.services;


import edu.upc.dsa.mapsManager;
import edu.upc.dsa.mapsManagerImpl;
import edu.upc.dsa.models.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/maps", description = "Endpoint to Map Service")
@Path("/maps")
public class MapsService {

    private mapsManager mm;

    public MapsService() {
        this.mm = mapsManagerImpl.getInstance();
        if (mm.size()==0) {
            this.mm.addMap("Mordor","Vacío","Grande");
            this.mm.addMap("Cueva de lava", "Fuego","Pequeño");
            this.mm.addMap("Lucha en el cielo", "Aereo","Medio");
        }


    }

    @GET
    @ApiOperation(value = "get all Maps", notes = "todos y cada uno de ellos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Map.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaps() {

        List<Map> maps = this.mm.findAll();

        GenericEntity<List<Map>> entity = new GenericEntity<List<Map>>(maps) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Map", notes = "De locos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Map.class),
            @ApiResponse(code = 404, message = "Map not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("id") String id) {
        Map t = this.mm.getMap(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Map", notes = "Elimina un mapa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Map not found")
    })
    @Path("/{id}")
    public Response deleteMap(@PathParam("id") String id) {
        Map t = this.mm.getMap(id);
        if (t == null) return Response.status(404).build();
        else this.mm.deleteMap(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Map", notes = "Actualiza datos del mapa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Map not found")
    })
    @Path("/")
    public Response updateMap(Map map) {

        Map t = this.mm.updateMap(map);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Map", notes = "crea un mapa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Map.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMap(Map map) {

        if (map.getType()==null || map.getName()==null)  return Response.status(500).entity(map).build();
        this.mm.addMap(map);
        return Response.status(201).entity(map).build();
    }

}