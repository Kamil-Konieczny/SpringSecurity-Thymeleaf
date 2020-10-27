package com.konieczny.Login.profileEntity;

import com.konieczny.Login.UserEntities.User;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;


@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int profile_id;
    @Column
    private String nickname;
    @Column
    private String aboutMe;
    @Column
    private String birthday;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo;
    @Transient
    private MultipartFile file;

    @OneToOne(mappedBy="profileEntity")
    private User user;

    public ProfileEntity() {
    }

    public ProfileEntity(String nickname, String aboutMe, String birthday, String photo) {
        this.nickname = nickname;
        this.aboutMe = aboutMe;
        this.birthday = birthday;
        this.photo = photo;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPhoto() {
    return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "profile_id=" + profile_id +
                ", nickname='" + nickname + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", birthday='" + birthday + '\'' +
                ", photo='" + photo + '\'' +
                ", file=" + file +
                ", user=" + user +
                '}';
    }
}
