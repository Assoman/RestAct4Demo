package rest.service;

import rest.entity.User;
import rest.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Path("/users")
public class UserService {
    // Define what type of request this method responds to
    @GET

    //Define what type of content is produced
    @Produces("text/plain")
    @Path("/{id}")
    public Response getUser(@PathParam("id") String id) {

        GenericDao genericDao = new GenericDao(User.class);
        User user = null;
        Logger logger = LogManager.getLogger(this.getClass());

        if (!id.isEmpty()) {
            user = (User) genericDao.getById(Integer.parseInt(id));
            if (user != null) {
                logger.debug("Return USER ID: " + id);
                return Response.status(200).entity(user.getId()
                        + " " + user.getFirstName()
                        + " " + user.getLastName()).build();
            }
        }
        return Response.status(200).entity("Please, check the USER ID").build();
    }

    @GET

    //Define what type of content is produced
    @Produces("text/plain")
    public Response getAllUser() {
        GenericDao genericDao = new GenericDao(User.class);
        List<User> allUsers = genericDao.getAllUsersOrProducts();
        Logger logger = LogManager.getLogger(this.getClass());
        logger.debug("Return USERs: " + allUsers.size());

        String output = "";
        for (int i = 0; i < allUsers.size(); i++) {
            output += allUsers.get(i).getId()
                    + " " + allUsers.get(i).getFirstName()
                    + " " + allUsers.get(i).getLastName()
                    + "\n";
        }
        return Response.status(200).entity(output).build();
    }
}
