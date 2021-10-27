package com.demo.hotelbackend.Model.Collections;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "room")
public class Room {

    @Id
    private String idroomm;

    private String name;
    private String description;
    private Double price;
    private String idtype;
    private String photo;
    private Boolean state;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime datecreated = LocalDateTime.now(ZoneId.of("America/Lima"));

    public Room(String idroomm, String name, String description, String idtype, Double price, String photo) {
        this.idroomm = idroomm;
        this.name = name;
        this.description = description;
        this.idtype = idtype;
        this.price = price;
        this.photo = photo;
        this.state = true;
    }

    public Room(String name, String description, String idtype, Double price, String photo) {
        this.name = name;
        this.description = description;
        this.idtype = idtype;
        this.price = price;
        this.photo = photo;
        this.state = true;
    }
}
