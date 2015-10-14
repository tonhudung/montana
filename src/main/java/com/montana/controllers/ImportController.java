package com.montana.controllers;

import com.montana.models.Gender;
import com.montana.models.HasProfilePictureRel;
import com.montana.models.Photo;
import com.montana.models.User;
import com.montana.services.HasProfilePictureRelService;
import com.montana.services.PhotoService;
import com.montana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by alexto on 10/10/15.
 */

@Controller
@RequestMapping("/import")
public class ImportController {

    @Autowired UserService userService;

    @Autowired
    HasProfilePictureRelService hasProfilePictureRelService;

    @Autowired PhotoService photoService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Transactional
    @RequestMapping(path = "upload", method = RequestMethod.GET)
    public String upload() throws IOException, ParseException {
        String prefix = "D://Projects//Java//montana//references/";
        String prefix2 = "D:\\Projects\\Java\\montana\\src\\main\\webapp\\uploads\\";
        BufferedReader br = new BufferedReader(new FileReader(prefix + "ADUsers.csv"));
        br.readLine();
        for (String line; (line = br.readLine()) != null; ) {
            String[] data = line.split(",");
            String firstName = data[3];
            String lastName = data[13];
            String userName = data[data.length - 9];
            String email = data[4];
            Date dob = simpleDateFormat.parse(data[data.length - 3]);
            String gender = data[data.length - 1];
            File file = new File(prefix + "UserImages/" + firstName + " " + lastName + ".jpg");
            if (file.exists()) {
                User user = new User();
                user.setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setDateOfBirth(dob)
                        .setGender(Gender.valueOf(gender.toUpperCase()))
                        .setUserName(userName)
                        .setPassword("P@ssw0rd");
                File dir = new File(prefix2 + userName + "images\\");
                if (!dir.exists())
                    dir.mkdir();
                String fileName = UUID.randomUUID().toString() + ".jpg";
                File dest = new File(prefix2 + userName + "\\images\\" + fileName);
                Files.copy(file.toPath(), dest.toPath());

                Photo photo = new Photo();
                photo.setUrl("uploads/" + userName + "/images/" + fileName);

                user.getPhotos().add(photo);
                user.setProfilePicture(photo);

                HasProfilePictureRel hasProfilePictureRel = new HasProfilePictureRel();
                hasProfilePictureRel.setPhoto(photo)
                        .setUser(user)
                        .setCurrent(true);

                userService.save(user);
            }
        }

        br.close();


        return "import/upload";
    }

}
