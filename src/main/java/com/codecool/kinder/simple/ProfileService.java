package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.ProfileNotFound;
import com.codecool.kinder.model.Profile;

public interface ProfileService {

    Profile getProfileByUser(Integer userId) throws ProfileNotFound;
}
