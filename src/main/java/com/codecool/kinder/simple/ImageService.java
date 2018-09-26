package com.codecool.kinder.simple;

import com.codecool.kinder.exceptions.NoImageFoundException;
import com.codecool.kinder.exceptions.ProfileNotFoundException;
import com.codecool.kinder.model.Image;
import java.util.List;

public interface ImageService {

    List<Image> getImagesByProfileId(Integer profileId) throws ProfileNotFoundException, NoImageFoundException;
}
