package com.sb.kclustering.interpretor;

import java.awt.Color;

import com.sb.kclustering.DataInterpreter;

public class ColorInterpretor implements DataInterpreter<Color> {

    @Override
    public double getEucledeanDistance(Color col1, Color col2) {
	double r = Math.pow(col2.getRed() - col1.getRed(), 2);
	double g = Math.pow(col2.getGreen() - col1.getGreen(), 2);
	double b = Math.pow(col2.getBlue() - col1.getBlue(), 2);
	return Math.sqrt(r + g + b);
    }

    @Override
    public Color moveCentroid(Color centroid, Color[] cluster) {
	int r = 0;
	int g = 0;
	int b = 0;

	for (Color color : cluster) {
	    r += color.getRed();
	    g += color.getGreen();
	    b += color.getBlue();
	}
	return new Color(r / cluster.length, g / cluster.length, b / cluster.length);
    }

    @Override
    public Color clone(Color obj) {
	return new Color(obj.getRGB());
    }
}
