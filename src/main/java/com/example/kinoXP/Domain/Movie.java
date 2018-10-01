package com.example.kinoXP.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;
    private String title;
    private String genre;
    private String description;
    @OneToMany(mappedBy = "movie")
    private List<MovieShowing> movieShowings;
    @Lob
    @Column(name="CATEGORY_PHOTO")
    private byte[] CategoryPhoto;

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MovieShowing> getMovieShowing() {
        return movieShowings;
    }

    public void setMovieShowing(List<MovieShowing> movieShowing) {
        this.movieShowings = movieShowing;
    }

    public void addMovieShowing(MovieShowing movieShowing){
        if(movieShowings == null){
            movieShowings = new ArrayList<MovieShowing>();
        }
        movieShowings.add(movieShowing);
        movieShowing.setMovie(this);
    }

    public byte[] getCategoryPhoto() {
        return CategoryPhoto;
    }

    public void setCategoryPhoto(byte[] categoryPhoto) {
        CategoryPhoto = categoryPhoto;
    }
}
