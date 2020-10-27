package com.konieczny.Login.profileDB;


import com.konieczny.Login.UserEntities.User;
import com.konieczny.Login.profileEntity.ProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public void save(ProfileEntity profileEntity,int id) {

        ProfileEntity profile = new ProfileEntity();
        profile = profileRepository.getOne(id);
        String fileName = StringUtils.cleanPath(profileEntity.getFile().getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            profile.setPhoto(Base64.getEncoder().encodeToString(profileEntity.getFile().getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile.setNickname(profileEntity.getNickname());
        profile.setAboutMe(profileEntity.getAboutMe());
        profile.setBirthday(profileEntity.getBirthday());
        profileRepository.save(profile);
    }

    public void create(ProfileEntity profileEntity)
    {
        profileRepository.save(profileEntity);
    }
}
