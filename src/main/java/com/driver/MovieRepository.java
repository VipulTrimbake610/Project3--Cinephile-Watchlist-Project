package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        movieMap.put(movie.getName(),movie);
    }

    public void saveDirector(Director director){
        // your code here
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here
            List<String> list;
            if(directorMovieMapping.get(director) == null){
                list = new ArrayList<>();
                list.add(movie);
            }else{
                list = directorMovieMapping.get(director);
                list.add(movie);
            }
            directorMovieMapping.put(director,list);

        }
    }

    public Movie findMovie(String movie){
        // your code here
        if(movieMap.containsKey(movie)){
            return movieMap.get(movie);
        }
        return null;
    }

    public Director findDirector(String director){
        // your code here
        if(directorMap.containsKey(director)){
            return directorMap.get(director);
        }
        return null;
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here
        if(directorMovieMapping.containsKey(director)){
            return directorMovieMapping.get(director);
        }
        return null;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        // your code here
        if(directorMap.containsKey(director) ){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        // your code here
        directorMap.clear();

    }
}