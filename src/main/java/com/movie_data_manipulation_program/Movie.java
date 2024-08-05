package com.movie_data_manipulation_program;

public class Movie {
    private String movieId, movieName, year, certificate, runtime, rating, director, star, votes, gross;
    // constructor for new movie data
    public Movie(String movieId, String movieName, String year, String director, String star) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.star = star;
    }
    // constructor for existing movie data
    public Movie(String movieId, String movieName, String year, String certificate, String runtime, String rating, String director, String star, String votes, String gross) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.year = year;
        this.certificate = certificate;
        this.runtime = runtime;
        this.rating = rating;
        this.director = director;
        this.star = star;
        this.votes = votes;
        this.gross = gross;
    }
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getCertificate() {
        return certificate;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
    }
    public String getVotes() {
        return votes;
    }
    public void setVotes(String votes) {
        this.votes = votes;
    }
    public String getGross() {
        return gross;
    }
    public void setGross(String gross) {
        this.gross = gross;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", year='" + year + '\'' +
                ", certificate='" + certificate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", rating='" + rating + '\'' +
                ", director='" + director + '\'' +
                ", star='" + star + '\'' +
                ", votes='" + votes + '\'' +
                ", gross=" + gross +
                '}';
    }
}

