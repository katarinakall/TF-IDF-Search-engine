package com.company;

import java.util.ArrayList;
import java.util.List;

public class SearchResult implements Comparable<SearchResult>{
   private String name;
   private double score;

   public SearchResult(String name, double score) {
      this.name = name;
      this.score = score;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getScore() {
      return score;
   }

   public void setScore(double score) {
      this.score = score;
   }

   @Override
   public String toString() {
      return getName() + " " + getScore();
   }


   @Override
   public int compareTo(SearchResult o) {
      return this.getScore() < o.getScore() ? 1 : this.getScore() == o.getScore() ? 0 : -1;
   }

}
