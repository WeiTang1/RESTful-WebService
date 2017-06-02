package com.wei.restful.model;

/**
 * Created by danieltang on 5/31/17.
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "talk")
@XmlAccessorType(XmlAccessType.FIELD)
public class Talk {
    private int id;
    private String name;
    private String speaker;
    private String venue;
    private Double duration;

    public Talk() {
    }

    public Talk(int id, String name, String speaker, String venue, Double duration) {
        this.id = id;
        this.name = name;
        this.speaker = speaker;
        this.venue = venue;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk talk = (Talk) o;

        if (id != talk.id) return false;
        if (name != null ? !name.equals(talk.name) : talk.name != null) return false;
        if (speaker != null ? !speaker.equals(talk.speaker) : talk.speaker != null) return false;
        if (venue != null ? !venue.equals(talk.venue) : talk.venue != null) return false;
        if (duration != null ? !duration.equals(talk.duration) : talk.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (speaker != null ? speaker.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speaker='" + speaker + '\'' +
                ", venue='" + venue + '\'' +
                ", duration=" + duration +
                '}';
    }
}
