package cyberminds.backend.repository.user;

import cyberminds.backend.model.user.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, String> {
//    AppUser findByEmail(String email);

    AppUser findByUsername(String username);

    AppUser findByLastName(String input);

    AppUser findByFirstName(String input);

    AppUser findByEmail(String email);

//    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);

//    AppUser findUserById(String userId);
}

