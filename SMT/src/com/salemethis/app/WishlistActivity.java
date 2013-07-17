package com.salemethis.app;

import android.support.v4.app.Fragment;

import com.salemethis.app.utilities.SingleFragmentActivity;
import com.salemethis.app.wishlist.WishListFragment;

public class WishlistActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		return new WishListFragment();
	}
}
