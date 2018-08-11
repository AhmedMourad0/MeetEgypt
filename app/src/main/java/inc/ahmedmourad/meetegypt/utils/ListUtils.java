package inc.ahmedmourad.meetegypt.utils;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public final class ListUtils {

	@NonNull
	public static <T> ArrayList<Parcelable> parcel(@NonNull final List<T> list) {

		final ArrayList<Parcelable> parcelableList = new ArrayList<>(list.size());

		for (int i = 0; i < list.size(); ++i)
			parcelableList.add(Parcels.wrap(list.get(i)));

		return parcelableList;
	}

	@NonNull
	public static <T> List<T> unparcel(@Nullable final List<Parcelable> parcelableList) {

		if (parcelableList == null)
			return new ArrayList<>(0);

		final List<T> list = new ArrayList<>(parcelableList.size());

		for (int i = 0; i < parcelableList.size(); ++i)
			list.add(Parcels.unwrap(parcelableList.get(i)));

		return list;
	}

	private ListUtils() {

	}
}
