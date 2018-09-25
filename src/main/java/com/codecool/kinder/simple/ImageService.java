package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.ProfileNotFound;
import com.codecool.kinder.model.Image;
import java.util.List;

public interface ImageService {

    List<Image> getImageByProfileId(Integer profileId) throws ProfileNotFound;
}
