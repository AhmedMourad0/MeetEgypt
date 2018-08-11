package inc.ahmedmourad.meetegypt.adapters.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import inc.ahmedmourad.meetegypt.R;
import inc.ahmedmourad.meetegypt.pojo.Location;
import inc.ahmedmourad.meetegypt.view.activities.DetailsActivity;

public class LocationsRecyclerAdapter extends RecyclerView.Adapter<LocationsRecyclerAdapter.ViewHolder> {

	private final List<Location> locations;

	public LocationsRecyclerAdapter(@NonNull final List<Location> locations) {
		this.locations = locations;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull final ViewGroup container, final int viewType) {
		return new ViewHolder(LayoutInflater.from(container.getContext()).inflate(R.layout.item_location, container, false));
	}

	@Override
	public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
		holder.bind(locations.get(position));
	}

	@Override
	public int getItemCount() {
		return locations.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.location_name)
		TextView nameTextView;

		@BindView(R.id.location_summary)
		TextView summaryTextView;

		@BindView(R.id.location_image)
		ImageView imageView;

		ViewHolder(final View view) {
			super(view);
			ButterKnife.bind(this, view);
		}

		private void bind(@NonNull final Location location) {

			final Context context = itemView.getContext();

			nameTextView.setText(location.getName());
			summaryTextView.setText(location.getSummary());
			imageView.setImageResource(location.getImage());

			itemView.setOnClickListener(v -> {
				final Intent intent = new Intent(context, DetailsActivity.class);
				intent.putExtra(DetailsActivity.EXTRA_LOCATION, Parcels.wrap(location));
				context.startActivity(intent);
			});
		}
	}
}
