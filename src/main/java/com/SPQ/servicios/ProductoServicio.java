package com.SPQ.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.SPQ.dao.ProductoDao;
import java.util.List;
import com.SPQ.modelo.*;
import com.SPQ.modelo.Producto;



@Path("productos")
public class ProductoServicio {

	private static List<Producto> lista = ProductoDao.getProductos();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductos() 
	{
		return Response.ok(lista).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducto(@PathParam("id") int id) 
	{
		System.out.println(id);
		Producto producto = new Producto();
		producto.setId(id);
		
		if(lista.contains(producto)) 
		{
			for(Producto obj:lista)
				if(obj.getId()==id)
					return Response.ok(obj).build();
			
		}
		return Response.status(Response.Status.NOT_FOUND).build();
		
	}
	
	
}
