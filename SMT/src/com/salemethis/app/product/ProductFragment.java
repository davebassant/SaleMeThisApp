package com.salemethis.app.product;

import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.salemethis.app.R;
import com.salemethis.app.dummy_data.DummyItem;
import com.salemethis.app.dummy_data.DummyItemGenerator;

public class ProductFragment extends Fragment {

	public static final String EXTRA_ITEM_ID = "com.salemethis.app.product.item_id";
	
	private DummyItem mItem;
	private ImageView mProductImage, mRatingImage;
	private TextView mProductName, mProductMerchant, mProductDescription, mCurrentPrice, mSavingTotal;
	private Button mBuyNowButton, mWishlistRmvButton;
	
	public static ProductFragment newInstance(UUID itemId) { 
		Bundle args = new Bundle(); 
		args.putSerializable(EXTRA_ITEM_ID, itemId);
		
		ProductFragment fragment = new ProductFragment(); 
		fragment.setArguments(args); 
		
		return fragment; 
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState);
		
		//This is part of how to pass in Fragment Arguments properly
		UUID itemId = (UUID)getArguments().getSerializable(EXTRA_ITEM_ID);
		
		mItem = DummyItemGenerator.get(getActivity()).getDummyItem(itemId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_product, parent, false);
		
		mProductImage 	= (ImageView)v.findViewById(R.id.image_item_full);
		mRatingImage 	= (ImageView)v.findViewById(R.id.item_star_rating);
		
		mProductName 		= (TextView)v.findViewById(R.id.item_name);
		mProductMerchant 	= (TextView)v.findViewById(R.id.item_merchant);
		mProductDescription = (TextView)v.findViewById(R.id.item_description);
		
		mCurrentPrice 	= (TextView)v.findViewById(R.id.item_current_price);
		mSavingTotal 	= (TextView)v.findViewById(R.id.item_saving);
		
		mBuyNowButton 		= (Button)v.findViewById(R.id.btn_buy_now);
		mWishlistRmvButton 	= (Button)v.findViewById(R.id.btn_remove_item);
		
		mProductImage.setImageResource(mItem.getFullId());
		mRatingImage.setImageResource(mItem.getRatingId());
		
		mProductName.setText(mItem.getName());
		mProductMerchant.setText(mItem.getMerchant());
		mProductDescription.setText(mItem.getDescription());
		
		mCurrentPrice.setText("Current Price: " + mItem.getCurrentPrice());
		mSavingTotal.setText("Saving Total: " + mItem.getSaving());
		
		mBuyNowButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mWishlistRmvButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return v;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		//will be required if you start firing off activities i.e. dialogs.
		//see CrimeFragment for details.
	}
}
