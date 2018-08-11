package inc.ahmedmourad.meetegypt.utils;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import inc.ahmedmourad.meetegypt.R;
import inc.ahmedmourad.meetegypt.pojo.Location;

public final class LocationUtils {

	private static final int HISTORICAL_COUNT = 5;
	private static final List<Location> historicalLocations = new ArrayList<>(HISTORICAL_COUNT);

	private static final int NATURAL_COUNT = 7;
	private static final List<Location> naturalLocations = new ArrayList<>(NATURAL_COUNT);

	private static final int HOTELS_COUNT = 5;
	private static final List<Location> hotels = new ArrayList<>(HOTELS_COUNT);

	private static final int RESTAURANTS_COUNT = 5;
	private static final List<Location> restaurants = new ArrayList<>(RESTAURANTS_COUNT);

	public static void prepare(@NonNull final Context context) {
		prepareHistoricalLocations(context);
		prepareNaturalLocations(context);
		prepareHotels(context);
		prepareRestaurants(context);
	}

	@NonNull
	public static List<Location> getHistoricalLocations() {

		if (historicalLocations.size() == 0)
			throw new IllegalStateException("You must call prepare first!");

		return historicalLocations;
	}

	@NonNull
	public static List<Location> getNaturalLocations() {

		if (naturalLocations.size() == 0)
			throw new IllegalStateException("You must call prepare first!");

		return naturalLocations;
	}

	@NonNull
	public static List<Location> getHotels() {

		if (hotels.size() == 0)
			throw new IllegalStateException("You must call prepare first!");

		return hotels;
	}

	@NonNull
	public static List<Location> getRestaurants() {

		if (restaurants.size() == 0)
			throw new IllegalStateException("You must call prepare first!");

		return restaurants;
	}

	private static void prepareHistoricalLocations(@NonNull final Context context) {

		if (historicalLocations.size() < HISTORICAL_COUNT) {

			final String[] names = getStringArray(context, R.array.historical_names);
			final String[] summaries = getStringArray(context, R.array.historical_summaries);

			if (!validateData(names, summaries))
				return;

			historicalLocations.clear();

			for (int i = 0; i < names.length; ++i)
				historicalLocations.add(Location.create(names[i],
						summaries[i],
						getHistoricalLocationImage(i)
				));
		}
	}

	private static void prepareNaturalLocations(@NonNull final Context context) {

		if (naturalLocations.size() < NATURAL_COUNT) {

			final String[] names = getStringArray(context, R.array.natural_names);
			final String[] summaries = getStringArray(context, R.array.natural_summaries);

			if (!validateData(names, summaries))
				return;

			naturalLocations.clear();

			for (int i = 0; i < names.length; ++i)
				naturalLocations.add(Location.create(names[i],
						summaries[i],
						getNaturalLocationImage(i)
				));
		}
	}

	private static void prepareHotels(@NonNull final Context context) {

		if (hotels.size() < HOTELS_COUNT) {

			final String[] names = getStringArray(context, R.array.hotels_names);
			final String[] summaries = getStringArray(context, R.array.hotels_summaries);

			if (!validateData(names, summaries))
				return;

			hotels.clear();

			for (int i = 0; i < names.length; ++i)
				hotels.add(Location.create(names[i],
						summaries[i],
						getHotelImage(i)
				));
		}
	}

	private static void prepareRestaurants(@NonNull final Context context) {

		if (restaurants.size() < RESTAURANTS_COUNT) {

			final String[] names = getStringArray(context, R.array.restaurants_names);
			final String[] summaries = getStringArray(context, R.array.restaurants_summaries);

			if (!validateData(names, summaries))
				return;

			restaurants.clear();

			for (int i = 0; i < names.length; ++i)
				restaurants.add(Location.create(names[i],
						summaries[i],
						getRestaurantImage(i)
				));
		}
	}

	@DrawableRes
	private static int getHistoricalLocationImage(@IntRange(from = 0, to = HISTORICAL_COUNT - 1) final int index) {

		switch (index) {

			case 0:
				return R.drawable.pyramids;

			case 1:
				return R.drawable.karnak;

			case 2:
				return R.drawable.abu_simbel;

			case 3:
				return R.drawable.abydos;

			case 4:
				return R.drawable.valley;

			default:
				return R.drawable.placeholder;
		}
	}

	@DrawableRes
	private static int getNaturalLocationImage(@IntRange(from = 0, to = NATURAL_COUNT - 1) final int index) {

		switch (index) {

			case 0:
				return R.drawable.white_desert;

			case 1:
				return R.drawable.siwa_oasis;

			case 2:
				return R.drawable.alexandria;

			case 3:
				return R.drawable.red_sea;

			case 4:
				return R.drawable.hurghada;

			case 5:
				return R.drawable.aswan;

			case 6:
				return R.drawable.berenice;

			default:
				return R.drawable.placeholder;
		}
	}

	@DrawableRes
	private static int getHotelImage(@IntRange(from = 0, to = HOTELS_COUNT - 1) final int index) {

		switch (index) {

			case 0:
				return R.drawable.nile_ritz_carlton;

			case 1:
				return R.drawable.royal_maxim_palace_kempinski;

			case 2:
				return R.drawable.marriott_mena_house;

			case 3:
				return R.drawable.four_seasons;

			case 4:
				return R.drawable.kempinski_nile_hotel;

			default:
				return R.drawable.placeholder;
		}
	}

	@DrawableRes
	private static int getRestaurantImage(@IntRange(from = 0, to = RESTAURANTS_COUNT - 1) final int index) {

		switch (index) {

			case 0:
				return R.drawable.sequoia;

			case 1:
				return R.drawable.il_piccolo_mondo;

			case 2:
				return R.drawable.abou_el_sid;

			case 3:
				return R.drawable.oak_grill;

			case 4:
				return R.drawable.l_asiatique;

			default:
				return R.drawable.placeholder;
		}
	}

	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	private static boolean validateData(@Nullable final String[] names, @Nullable final String[] summaries) {
		return names != null && summaries != null && names.length == summaries.length;
	}

	@NonNull
	private static String[] getStringArray(final Context context, @ArrayRes final int arrayId) {
		return context.getResources().getStringArray(arrayId);
	}

	private LocationUtils() {

	}
}
