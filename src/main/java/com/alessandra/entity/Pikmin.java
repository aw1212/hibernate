package com.alessandra.entity;

import com.alessandra.PikminQuality;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pikmin")
@Getter
@Setter
public class Pikmin implements Serializable {

    private static final long serialVersionUID = 2546206700129465299L;
    @Id
    @Column(name = "id") //column annotation not needed when name is the same?
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quality")
    @Enumerated(EnumType.STRING)
    private PikminQuality quality;
    @Column(name = "color")
    private String color;
    @Column(name = "toss_distance")
    private Integer tossDistance;

    protected Pikmin() {
        // needed for hibernate
    }

    public Pikmin(PikminQuality quality, String color, Integer tossDistance) {
        this.quality = quality;
        this.color = color;
        this.tossDistance = tossDistance;
    }

    @Override
    public String toString() {
        return "Pikmin{" +
                "id=" + id +
                ", quality=" + quality +
                ", color='" + color + '\'' +
                ", tossDistance=" + tossDistance +
                '}';
    }
}
