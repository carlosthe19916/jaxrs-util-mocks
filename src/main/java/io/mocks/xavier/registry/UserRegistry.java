package io.mocks.xavier.registry;

import io.mocks.xavier.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRegistry {

    private User user;

    @PostConstruct
    void init() {
        user = new User();
        user.setFirstTimeCreatingReports(true);
    }

    public User getUser() {
        return user;
    }

    public User changeUserStatus() {
        User user = getUser();
        user.setFirstTimeCreatingReports(false);
        return user;
    }

}
