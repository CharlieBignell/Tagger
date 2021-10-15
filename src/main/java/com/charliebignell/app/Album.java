package com.charliebignell.app;

import java.util.HashSet;
import java.util.Set;

public class Album<T> implements Tracklist<T> {

    protected final String name;
    protected Set<Song> songs = new HashSet<Song>();

    public Album(String name) {
        super();
        this.name = name;
    }

    /**
     * Add a song to an album
     * 
     * @param songRef The song reference. In the case of a playlist, this is a Song
     *                object
     * @throws IllegalArgumentException
     */
    public void populate(T songRef) {
        if (songRef instanceof Song) {
            songs.add((Song) songRef);
        } else {
            throw new IllegalArgumentException("Input must be a song");
        }
    }

    /**
     * Get the number of songs in the album
     * 
     * @return the number of songs in the album
     */
    public int getSize(){
        return this.songs.size();
    }

    /**
     * Play the songs in the playlist, for demonstrative purposes it simply ouputs
     * the songs to the console
     * 
     */
    public void playSongs(Library lib) {
        System.out.println("-- " + this.name + " --");

        for (Song s : songs) {
            System.out.println(s.toString());
        }
    }

    @Override
    public String toString(){
        return this.name + ", contains " + this.getSize() + " song(s)";
    }

}
