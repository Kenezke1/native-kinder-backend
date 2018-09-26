package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.model.Profile;

public interface ProfileService {

    Profile getProfileByUser(Integer userId) throws ProfileNotFoundException;
}
