package com.salemethis.app.wishlist;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.salemethis.app.R;
import com.salemethis.app.WishListPagerActivity;
import com.salemethis.app.dummy_data.DummyItem;
import com.salemethis.app.dummy_data.DummyItemGenerator;
import com.salemethis.app.product.ProductFragment;

public class WishListFragment extends ListFragment {

	//only needed if logging
//	private static final String TAG = "WishListFragment";
	
	private ArrayList<DummyItem> mDummyItems;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.wishlist_title);
		mDummyItems = DummyItemGenerator.get(getActivity()).getDummyItems();
		
		DummyItemAdapter adapter = new DummyItemAdapter(mDummyItems);
		
		super.setListAdapter(adapter);
	}
	
	@Override 
	public void onResume() { 
		super.onResume(); 
		((DummyItemAdapter)getListAdapter()).notifyDataSetChanged(); 
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		DummyItem item = ((DummyItemAdapter)getListAdapter()).getItem(position);
		
		Intent i = new Intent(getActivity(), WishListPagerActivity.class);
		i.putExtra(ProductFragment.EXTRA_ITEM_ID, item.getId());
		startActivity(i);
	}
	
	private class DummyItemAdapter extends ArrayAdapter<DummyItem> {
		
		public DummyItemAdapter(ArrayList<DummyItem> dummyItems) {
			super(getActivity(), 0, dummyItems);
		}
		
		//The convertView parameter is an existing list item that the adapter can reconfigure and return instead of creating a brand new object. 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//If we weren't given a view, inflate one 
			if (convertView == null) { 
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_wishlist, null); 
			}
			
			DummyItem d = super.getItem(position);
			
			TextView nameTextView = (TextView)convertView.findViewById(R.id.wishlist_item_name);
			nameTextView.setText(d.getName());
			
			TextView currPriceTextView = (TextView)convertView.findViewById(R.id.wishlist_item_current_price);
			currPriceTextView.setText("Current Price:\n" + d.getCurrentPrice());
			
			TextView savingTextView = (TextView)convertView.findViewById(R.id.wishlist_item_saving);
			savingTextView.setText("Saving Total:\n" + d.getSaving());
			
			ImageView thumbImageView = (ImageView)convertView.findViewById(R.id.wishlist_item_thumb);
			thumbImageView.setImageResource(d.getThumbId());
			
			return convertView;
		}
	}
}
