package de.ait.taskslist.security.details;

import de.ait.taskslist.models.User;
import de.ait.taskslist.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 8/15/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class AuthenticatedUsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AuthenticatedUser(
                usersRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new UsernameNotFoundException("User with email <" + email + "> not found ")));
    }
}
