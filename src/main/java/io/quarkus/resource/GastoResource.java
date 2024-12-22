package io.quarkus.resource;

import io.quarkus.model.Gasto;
import io.quarkus.service.GastoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/gastos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GastoResource {

    private GastoService gastoService = new GastoService();

    // Se obtiene los gastos
    @GET
    public List<Gasto> getAllGastos() throws IOException {
        return gastoService.getAllGastos();
    }

    // Esto es un gasto por su ID
    @GET
    @Path("/{id}")
    public Response getGastoById(@PathParam("id") int id) throws IOException {
        Gasto gasto = gastoService.getGastoById(id);
        if (gasto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Gasto no encontrado").build();
        }
        return Response.ok(gasto).build();
    }

    // Se agregar un nuevo gasto
    @POST
    public Response addGasto(Gasto gasto) throws IOException {
        gastoService.addGasto(gasto);
        return Response.status(Response.Status.CREATED).entity("Gasto creado con éxito").build();
    }

    // Se actualizar un gasto existente
    @PUT
    @Path("/{id}")
    public Response updateGasto(@PathParam("id") int id, Gasto updatedGasto) throws IOException {
        Gasto gasto = gastoService.getGastoById(id);
        if (gasto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Gasto no encontrado").build();
        }
        gastoService.updateGasto(id, updatedGasto);
        return Response.ok("Gasto actualizado con éxito").build();
    }

    // Se eliminar un gasto
    @DELETE
    @Path("/{id}")
    public Response deleteGasto(@PathParam("id") int id) throws IOException {
        Gasto gasto = gastoService.getGastoById(id);
        if (gasto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Gasto no encontrado").build();
        }
        gastoService.deleteGasto(id);
        return Response.ok("Gasto eliminado con éxito").build();
    }

    // Se obtiene el promedio de los gastos
    @GET
    @Path("/promedio")
    public double getPromedio() throws IOException {
        return gastoService.getPromedio();
    }

    // Se filtrar gastos por rango de fechas
    @GET
    @Path("/rango")
    public List<Gasto> filterGastosByDateRange(@QueryParam("inicio") long inicio, @QueryParam("fin") long fin) throws IOException {
        return gastoService.filterGastosByDateRange(inicio, fin);
    }
}
