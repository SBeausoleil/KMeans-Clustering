package com.sb.kclustering;

import java.util.LinkedList;

public class Cluster<E> {

    private DataInterpreter<E> interpreter;
    private LinkedList<E> points;
    private E centroid;

    public Cluster(E centroid, DataInterpreter<E> interpreter) {
	this.interpreter = interpreter;
	this.centroid = centroid;
	points = new LinkedList<E>();
	points.add(centroid);
    }

    /**
     * Returns the points.
     * 
     * @return the points
     */
    public LinkedList<E> getPoints() {
	return points;
    }

    /**
     * Sets the value of points to that of the parameter.
     * 
     * @param points
     *            the points to set
     */
    public void setPoints(LinkedList<E> points) {
	this.points = points;
    }

    /**
     * Returns the centroid.
     * 
     * @return the centroid
     */
    public E getCentroid() {
	return centroid;
    }

    /**
     * Sets the value of centroid to that of the parameter.
     * 
     * @param centroid
     *            the centroid to set
     */
    public void setCentroid(E centroid) {
	this.centroid = centroid;
    }

    /**
     * Adds a point to the cluster.
     * 
     * @param point
     * @return the centroid after having been re-calculated.
     */
    public double add(E point) {
	points.add(point);
	E oldCentroid = interpreter.clone(centroid);
	centroid = interpreter.moveCentroid(centroid, (E[]) points.toArray());
	return interpreter.getEucledeanDistance(oldCentroid, centroid);
    }
}
