package inc.ahmedmourad.meetegypt.view.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import inc.ahmedmourad.meetegypt.R;
import inc.ahmedmourad.meetegypt.adapters.pager.ViewPagerAdapter;
import inc.ahmedmourad.meetegypt.utils.LocationUtils;
import inc.ahmedmourad.meetegypt.view.fragments.CategoryFragment;

public class MainActivity extends AppCompatActivity {

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.main_toolbar)
	Toolbar toolbar;

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.main_tab_layout)
	TabLayout tabLayout;

	@SuppressWarnings("WeakerAccess")
	@BindView(R.id.main_view_pager)
	ViewPager viewPager;

	private Unbinder unbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		unbinder = ButterKnife.bind(this);

		setSupportActionBar(toolbar);

		LocationUtils.prepare(this);

		setupViewPager();

		tabLayout.setupWithViewPager(viewPager);
	}

	private void setupViewPager() {
		final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(getString(R.string.historical), CategoryFragment.newInstance(LocationUtils.getHistoricalLocations()));
		adapter.addFragment(getString(R.string.natural), CategoryFragment.newInstance(LocationUtils.getNaturalLocations()));
		adapter.addFragment(getString(R.string.hotels), CategoryFragment.newInstance(LocationUtils.getHotels()));
		adapter.addFragment(getString(R.string.restaurants), CategoryFragment.newInstance(LocationUtils.getRestaurants()));
		viewPager.setOffscreenPageLimit(3);
		viewPager.setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		unbinder.unbind();
		super.onDestroy();
	}
}
