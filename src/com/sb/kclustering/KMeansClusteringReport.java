package com.sb.kclustering;

public class KMeansClusteringReport {
    private Cluster[] clusters;

    public KMeansClusteringReport(Cluster[] clusters) {
	this.clusters = clusters;
    }

    /**
     * Returns the clusters.
     * 
     * @return the clusters
     */
    public Cluster[] getClusters() {
	return clusters;
    }

    /**
     * Sets the value of clusters to that of the parameter.
     * 
     * @param clusters
     *            the clusters to set
     */
    public void setClusters(Cluster[] clusters) {
	this.clusters = clusters;
    }

    public Cluster getLargestCluster() {
	Cluster largestCluster = clusters[0];
	for (int i = 1; i < clusters.length; i++)
	    if (clusters[i].getPoints().size() > largestCluster.getPoints().size())
		largestCluster = clusters[i];
	return largestCluster;
    }

    public Cluster getSmallestCluster() {
	Cluster smallestCluster = clusters[0];
	for (int i = 1; i < clusters.length; i++)
	    if (clusters[i].getPoints().size() < smallestCluster.getPoints().size())
		smallestCluster = clusters[i];
	return smallestCluster;
    }
}
