package inc.ahmedmourad.meetegypt.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import inc.ahmedmourad.meetegypt.R;
import inc.ahmedmourad.meetegypt.adapters.recycler.LocationsRecyclerAdapter;
import inc.ahmedmourad.meetegypt.pojo.Location;
import inc.ahmedmourad.meetegypt.utils.ListUtils;

public class CategoryFragment extends Fragment {

	private static final String ARG_LOCATIONS = "c_locations";

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.category_recycler)
	RecyclerView recyclerView;

	private Context context;

	private List<Location> locations;

	private Unbinder unbinder;

	@NonNull
	public static CategoryFragment newInstance(@NonNull final List<Location> locations) {
		final CategoryFragment fragment = new CategoryFragment();
		final Bundle args = new Bundle();
		args.putParcelableArrayList(ARG_LOCATIONS, ListUtils.parcel(locations));
		fragment.setArguments(args);
		return fragment;
	}

	public CategoryFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(@Nullable final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			locations = ListUtils.unparcel(getArguments().getParcelableArrayList(ARG_LOCATIONS));
		}
	}

	@Override
	public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.fragment_category, container, false);

		unbinder = ButterKnife.bind(this, view);

		context = view.getContext();

		initializeRecyclerView();

		return view;
	}

	private void initializeRecyclerView() {
		final LocationsRecyclerAdapter adapter = new LocationsRecyclerAdapter(locations);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
		recyclerView.setVerticalScrollBarEnabled(true);
	}

	@Override
	public void onDestroyView() {
		unbinder.unbind();
		super.onDestroyView();
	}
}
