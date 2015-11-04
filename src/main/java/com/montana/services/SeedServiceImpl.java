package com.montana.services;

import com.montana.models.Gender;
import com.montana.models.nodes.Photo;
import com.montana.models.nodes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * Created by alex_to on 29/10/2015.
 */

@Service
@Transactional
public class SeedServiceImpl implements SeedService {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public void seed(String source, String dest) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new FileReader(source + "ADUsers.csv"));
        br.readLine();
        for (String line; (line = br.readLine()) != null; ) {
            String[] data = line.split(",");
            String firstName = data[3];
            String lastName = data[13];
            String userName = data[data.length - 9];
            String email = data[4];
            Date dob = simpleDateFormat.parse(data[data.length - 3]);
            String gender = data[data.length - 1];
            File file = new File(source + "UserImages/" + firstName + " " + lastName + ".jpg");
            if (file.exists()) {
                User user = new User();
                user.setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setDateOfBirth(dob)
                        .setGender(Gender.valueOf(gender.toUpperCase()))
                        .setUserName(userName)
                        .setPassword(passwordEncoder.encode("P@ssw0rd"));
                File dir = new File(dest + "/" + userName + "/images/");
                if (!dir.exists())
                    dir.mkdirs();
                String fileName = UUID.randomUUID().toString() + ".jpg";
                File destFile = new File(dest + "/" + userName + "/images/" + fileName);
                Files.copy(file.toPath(), destFile.toPath());

                Photo photo = (new Photo())
                        .setUrl("uploads/" + userName + "/images/" + fileName)
                        .setUser(user);

                ProfilePicture profilePicture = (new ProfilePicture())
                        .setPhoto(photo)
                        .setUser(user)
                        .setCurrent(true);

                user.setProfilePicture(profilePicture);
                userService.save(user);
            }
        }

        br.close();
    }


    public void testTx() throws Exception {

        User user1 = (new User()).setUserName("user1");
        userService.save(user1);

        throw new Exception();
    }
}
