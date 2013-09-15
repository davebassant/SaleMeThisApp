package com.salemethis.app.dummy_data;

import java.util.UUID;

public class DummyItem {
	
	private UUID mId;
	private String mName, mMerchant, mDescription, mCurrentPrice, mSaving;
	public String getMerchant() {
		return mMerchant;
	}

	public void setMerchant(String merchant) {
		mMerchant = merchant;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	private int mThumbId, mFullId, mRatingId;
	
	public int getRatingId() {
		return mRatingId;
	}

	public void setRatingId(int ratingId) {
		mRatingId = ratingId;
	}

	public DummyItem() {
		mId = UUID.randomUUID();
	}
	
	public UUID getId() {
		return mId;
	}
	
	public String getName() {
		return mName;
	}
	
	public void setName(String name) {
		mName = name;
	}
	
	public String getCurrentPrice() {
		return mCurrentPrice;
	}
	
	public void setCurrentPrice(String currentPrice) {
		mCurrentPrice = currentPrice;
	}
	
	public String getSaving() {
		return mSaving;
	}
	
	public void setSaving(String saving) {
		mSaving = saving;
	}
	
	public int getThumbId() {
		return mThumbId;
	}
	
	public void setThumbId(int thumbId) {
		mThumbId = thumbId;
	}
	
	public int getFullId() {
		return mFullId;
	}
	
	public void setFullId(int fullId) {
		mFullId = fullId;
	}
}
