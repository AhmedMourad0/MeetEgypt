package inc.ahmedmourad.meetegypt.pojo;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import org.parceler.Parcel;

import inc.ahmedmourad.meetegypt.R;

@Parcel(Parcel.Serialization.BEAN)
public class Location {

	private String name = "N/A";
	private String summary = "N/A";

	private int image = R.drawable.placeholder;

	@NonNull
	public static Location create(@NonNull final String name, @NonNull final String summary, @DrawableRes final int image) {
		final Location location = new Location();
		location.setName(name);
		location.setSummary(summary);
		location.setImage(image);
		return location;
	}

	@NonNull
	public String getName() {
		return name;
	}

	@SuppressWarnings("WeakerAccess")
	public void setName(@NonNull final String name) {
		this.name = name;
	}

	@NonNull
	public String getSummary() {
		return summary;
	}

	@SuppressWarnings("WeakerAccess")
	public void setSummary(@NonNull final String summary) {
		this.summary = summary;
	}

	@DrawableRes
	public int getImage() {
		return image;
	}

	@SuppressWarnings("WeakerAccess")
	public void setImage(@DrawableRes final int image) {
		this.image = image;
	}
}
