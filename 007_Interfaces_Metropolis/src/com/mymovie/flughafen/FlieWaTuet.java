package com.mymovie.flughafen;

/**
 * <pre>
 *     An interface can extend more than 1 interfaces
 *     A class can extend only 1 parent class - to avoid ambiguity
 *     An interface cannot extend class
 *     A class implements interface
 * </pre>
 */
public interface FlieWaTuet extends Flieger, Schwimmer, Fahrer{
    void himbeerSaftTanken();
}
