//package com.gradescope.hw2;

import bridges.base.ColorGrid;
import bridges.base.Color;

import java.util.ArrayList;
import java.util.List;


public class Scene {
	private int maxMarks;
	private List<Mark> marks;
	private Color color;

    /* Creates a Scene with a maximum capacity of Marks and
	   with a background color.
	   maxMarks: the maximum capacity of Marks
	   backgroundColor: the background color of this Scene
     */
	public Scene(int maxMarks, Color backgroundColor) {
		this.maxMarks = maxMarks; // input max marks
		this.color = backgroundColor; // color is the instance "background" color for this object
		this.marks = new ArrayList<>(); // array list to hold marks
	}
	// returns true if the Scene has no room for additional Marks
	private boolean isFull() {
		return marks.size() >= maxMarks; // returns boolean of if mark size is bigger or equal to max marks
	}
	/* Adds a Mark to this Scene. When drawn, the Mark
	   will appear on top of the background and previously added Marks
	   m: the Mark to add
	 */
	public void addMark(Mark m) {
		if (isFull()) throw new IllegalStateException("No room to add more Marks");
		marks.add(m); // if it's not full add mark
	}
	/*
	Helper method: deletes the Mark at an index.
	If no Marks have been previously deleted, the method
	deletes the ith Mark that was added (0 based).
	i: the index
	 */
	public void deleteMark(int i) {
		if(i<0 || i>=marks.size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		marks.remove(i); // if inside the index then remove mark at input position
	}
	/*
	Deletes all Marks from this Scene that
	have a given Color
	c: the Color
	 */
	public void deleteMarksByColor(Color c) {
		List<Mark> remove = new ArrayList<>(); // create a new array list to hold marks to remove
		for(Mark mark : marks){ // loop through each mark within marks
			if(mark.color != null && mark.color.equals(c)){ // if mark isnt null and mark is the input color
				remove.add(mark); // add that specific mark to the array in which will be removed
			}
		}
		marks.removeAll(remove); // after setting the remove array and adding all marks to be removed, actually remove the marks
	}
	/* draws the Marks in this Scene over a background color
	   onto a ColorGrid. Marks will appear on top of the
	   background, and Marks will overlap other Marks if
	   they were added by a more recent call to addMark.
	   cg: the ColorGrid to draw on
	 */
	public void draw(ColorGrid cg) {
		for(int i=0;i<cg.getHeight();i++){ // loop through 2d array of color grid
			for(int j=0;j<cg.getWidth();j++){
				cg.set(i,j,color); // set the instance color as the entire "background"
			}
		}
		for(Mark mark : marks){ // loop through marks that need to be a different color
			mark.draw(cg); // draw those marks, they will overwrite the "background" color and set it to the new mark
		}
	}
};
