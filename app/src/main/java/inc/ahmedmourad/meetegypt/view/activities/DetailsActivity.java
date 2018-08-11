package inc.ahmedmourad.meetegypt.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import inc.ahmedmourad.meetegypt.R;
import inc.ahmedmourad.meetegypt.pojo.Location;

public class DetailsActivity extends AppCompatActivity {

	public static final String EXTRA_LOCATION = "d_location";

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.details_toolbar)
	Toolbar toolbar;

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.details_image)
	ImageView imageView;

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.details_summary)
	TextView summaryTextView;

	private Unbinder unbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		unbinder = ButterKnife.bind(this);

		setSupportActionBar(toolbar);

		if (getIntent() == null || !getIntent().hasExtra(EXTRA_LOCATION)) {
			finish();
			return;
		}

		final Location location = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_LOCATION));

		setTitle(location.getName());
		imageView.setImageResource(location.getImage());
		summaryTextView.setText(location.getSummary());
	}

	@Override
	protected void onDestroy() {
		unbinder.unbind();
		super.onDestroy();
	}
}
