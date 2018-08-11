package inc.ahmedmourad.meetegypt.adapters.pager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	private final List<Fragment> fragmentList = new ArrayList<>(4);
	private final List<String> titlesList = new ArrayList<>(4);

	public ViewPagerAdapter(@NonNull final FragmentManager manager) {
		super(manager);
	}

	@Override
	public Fragment getItem(final int position) {
		return fragmentList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

	public void addFragment(@NonNull final String title, @NonNull final Fragment fragment) {
		fragmentList.add(fragment);
		titlesList.add(title);
	}

	@Override
	public CharSequence getPageTitle(final int position) {
		return titlesList.get(position);
	}
}
