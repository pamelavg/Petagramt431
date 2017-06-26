package com.krivic.petagramt43.pojo;



public class Mascota {
    private String  id;
    private String  name;
    private String  imageURL;
    private int     totalLikes;
    private String  imagePerURL;

    public Mascota(String name, String imageURL, int totalLikes, String imagePerURL) {
        this.name           = name;
        this.imageURL       = imageURL;
        this.totalLikes     = totalLikes;
        this.imagePerURL    = imagePerURL;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public String getImagePerURL() {
        return imagePerURL;
    }

    public void setImagePerURL(String imagePerURL) {
        this.imagePerURL = imagePerURL;
    }
}
