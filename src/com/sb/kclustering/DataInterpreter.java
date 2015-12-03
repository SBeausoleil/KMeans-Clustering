package com.sb.kclustering;

public interface DataInterpreter<E> {

    /**
     * Returns the Eucledean distance from a point to another point of data.
     * 
     * @param obj1
     *            the first point
     * @param obj2
     *            the second point
     * @return the Eucledean distance from obj1 to obj2.
     */
    public double getEucledeanDistance(E obj1, E obj2);

    /**
     * Moves the centroid to the average of the cluster
     * 
     * @param centroid
     * @param cluster
     * @return the new centroid
     */
    public E moveCentroid(E centroid, E[] cluster);

    /**
     * Clones the received object. This method is to avoid data alteration due to the
     * KMeansClustering algorithm, notably when calling the moveCentroid() function.
     * 
     * @param obj
     * @return a clone of the received object.
     */
    public E clone(E obj);
}
