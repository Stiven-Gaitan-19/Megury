package co.com.megury.web.rest.assemblers;

import co.com.megury.domain.UserSystem;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public class UserSystemAssembler implements RepresentationModelAssembler<UserSystem, EntityModel<UserSystem>> {
    @Override
    public EntityModel<UserSystem> toModel(UserSystem entity) {

        return null;
    }
}
