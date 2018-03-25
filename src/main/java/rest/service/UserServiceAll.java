package rest.service;

import rest.entity.User;
import rest.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/users")
public class UserServiceAll {
    // Define what type of request this method responds to
    @GET

    //Define what type of content is produced
    @Produces("text/plain")
    public Response getUser() {
        GenericDao genericDao = new GenericDao(User.class);
        List<User> allUsers = genericDao.getAllUsersOrProducts();
        Logger logger = LogManager.getLogger(this.getClass());
        logger.debug("Return USERs: " + allUsers.size());

        return Response.status(200).entity(allUsers.get(0).getId()
                + " " + allUsers.get(0).getFirstName()
                + " " + allUsers.get(0).getLastName()).build();
    }
}