package com.sb.kclustering;

import java.util.LinkedList;
import java.util.Random;

public class KMeansClustering<E> {

    protected int nClusters;
    protected int maxIterations;
    protected double acceptableDistance;
    protected DataInterpreter<E> interpreter;

    public KMeansClustering(int nClusters, int maxIterations, double acceptableDistance,
	    DataInterpreter<E> interpreter) {
	this.nClusters = nClusters;
	this.maxIterations = maxIterations;
	this.acceptableDistance = acceptableDistance;
	this.interpreter = interpreter;
    }

    public KMeansClusteringReport examine(E[] data) {
	Cluster[] clusters = new Cluster[nClusters];
	Random rng = new Random();
	int i = nClusters;
	while (i-- > 0)
	    clusters[nClusters] =
	    	new Cluster(interpreter.clone(data[rng.nextInt(data.length)]), interpreter);

	double averageDistance = Double.MAX_VALUE;
	int nPicks;
	Cluster closestCluster = null;
	double closestDistance = Double.MAX_VALUE;
	double distance = 0;
	for (i = 0; i < maxIterations && averageDistance > acceptableDistance; i++) {
	    averageDistance = 0;
	    for (nPicks = 0; nPicks < nClusters; nPicks++) {
		E point = data[rng.nextInt(data.length)];
		for (Cluster cluster : clusters) {
		    distance = interpreter.getEucledeanDistance((E) cluster.getCentroid(), point);
		    if (distance < closestDistance) {
			closestCluster = cluster;
			closestDistance = distance;
		    }
		}
		averageDistance += closestCluster.add(point);
	    }
	    averageDistance /= clusters.length;
	}
	return new KMeansClusteringReport(clusters);
    }

    public KMeansClusteringReport deepExamine(E[] data) {
	LinkedList<E> points = new LinkedList<E>();
	for (E point : data)
	    points.add(point);
	
	// Find the most distant points from each other
	Object[] centroids = findDistants(data);
	
	return null;
    }

    /**
     * Returns the most distant set of data.
     * 
     * @param data
     * @return
     */
    private Object[] findDistants(E[] data) {
	Object[] centroids = new Object[nClusters];
	double[][] distances = new double[nClusters][nClusters];
	
	for (int i = 0; i < nClusters; i++)
	    centroids[i] = data[i];
	
	for (int i = 0; i < nClusters; i++)
	    for (int j = 0; j < nClusters; j++) {
		distances[i][j] = interpreter.getEucledeanDistance((E) centroids[i], (E)centroids[j]);
	    }
	
	double[] currentDistances = new double[nClusters];
	for (int i = nClusters; i < data.length; i++) {
	    
	}
	
	return null;
    }

    public static void main(String[] args) {

    }
}
