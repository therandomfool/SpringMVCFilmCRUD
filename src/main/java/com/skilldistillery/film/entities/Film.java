package com.skilldistillery.film.entities;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.skilldistillery.film.data.MVCFilmSiteDAOImpl;

public class Film {
	
	private int id;
	private String title;
	private String description;
	@Min(1990) @Max(2029)
	private Integer releaseYear;
	private int languageId;
	
	private int rentalDuration;
	
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	
	private FilmCategory category;
	private List<Actor> actors;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getLanguageId() {
		return languageId;
	}
	
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getReplacementCost() {
		return replacementCost;
	}
	
	public String getLanguage() {
		return new MVCFilmSiteDAOImpl().getLanguage(this.languageId).getLanguage();

	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public FilmCategory getCategory() {
		return this.category;
	}

	public void setCategory(FilmCategory category) {
		this.category = category;
	}

	public Film(int id, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			int length, double replacementCost, String rating, String specialFeatures, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	public Film() {
		super();
	}

	public Film(int id, String title, String description, Integer releaseYear, int languageId, int rentalDuration, int length,
			double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		
	}
	
	public Film(int id, String title, String description, Integer releaseYear, int languageId, int rentalDuration, int length,
			double replacementCost, String rating, String specialFeatures, FilmCategory category, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.category = category;
		this.actors = actors;
		
	}

	public Film(String title, String description, Integer releaseYear, int languageId, int length, String rating) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.length = length;
		this.rating = rating;
	}
	
	public String displayFilm() {
		MVCFilmSiteDAOImpl db = new MVCFilmSiteDAOImpl();
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append(title);
		builder.append("\nFilm ID: ");
		builder.append(id);
		builder.append(", Released in ");
		builder.append(releaseYear);
		builder.append(", with a rating of ");
		builder.append(rating);
		builder.append("\nFilm description: ");
		builder.append(description);
		builder.append("\nFilm language: ");
		builder.append(db.getLanguage(languageId).toString());
		builder.append("\nFilm category: ");
		builder.append(db.getCategory(id));
		builder.append("\nFilm cast: ");
		for (int i = 0; i < actors.size(); i++) {
			builder.append(actors.get(i));
			if (i < actors.size() - 1) {
				builder.append(", ");
			}
		}
		return builder.toString();
		
	}

	
		
	@Override
	public String toString() {
		return "Film Id: " + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

	
	
	
	
}
