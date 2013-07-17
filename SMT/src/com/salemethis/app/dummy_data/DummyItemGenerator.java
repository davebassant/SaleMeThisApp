package com.salemethis.app.dummy_data;

import java.util.ArrayList;
import java.util.UUID;

import com.salemethis.app.R;

import android.content.Context;

public class DummyItemGenerator {
	
	private ArrayList<DummyItem> lstDummyItems;
	
	private static DummyItemGenerator sDummyItemGenerator;
	private Context mAppContext;
	
	private DummyItemGenerator(Context appContext) {
		mAppContext = appContext;
		lstDummyItems = new ArrayList<DummyItem>();
		
		DummyItem d1 = new DummyItem();
		d1.setName("K-Swiss Arvee 1-5");
		d1.setCurrentPrice("�34.99");
		d1.setSaving("�25.01 (42%)");
		d1.setThumbId(R.drawable.thumb1);
		d1.setFullId(R.drawable.full1);
		lstDummyItems.add(d1);
		
		DummyItem d2 = new DummyItem();
		d2.setName("SAMSUNG GT-P3110ZWABTU GALAXY TAB 2 7 INCH WIFI 8GB WHITE");
		d2.setCurrentPrice("�50.00");
		d2.setSaving("�25.00 (33%)");
		d2.setThumbId(R.drawable.thumb2);
		d2.setFullId(R.drawable.full2);
		lstDummyItems.add(d2);
		
		DummyItem d3 = new DummyItem();
		d3.setName("Olympus VG-170 Compact Digital Camera - Red, Red");
		d3.setCurrentPrice("�49.99");
		d3.setSaving("�49.99 (50%)");
		d3.setThumbId(R.drawable.thumb3);
		d3.setFullId(R.drawable.full3);
		lstDummyItems.add(d3);
		
		DummyItem d4 = new DummyItem();
		d4.setName("Sony ICF-DS15iPN Docking System - with Lightning Connector");
		d4.setCurrentPrice("�69.99");
		d4.setSaving("�30.00 (30%)");
		d4.setThumbId(R.drawable.thumb4);
		d4.setFullId(R.drawable.full4);
		lstDummyItems.add(d4);
		
		DummyItem d5 = new DummyItem();
		d5.setName("HAIER Intelius 500 HW80-BD1626 Washing Machine - White, White");
		d5.setCurrentPrice("�799.00");
		d5.setSaving("�200.00 (20%)");
		d5.setThumbId(R.drawable.thumb5);
		d5.setFullId(R.drawable.full5);
		lstDummyItems.add(d5);
	}
	
	/**
	 * Notice in get(Context) that you do not directly pass in the Context parameter to the constructor. This Context could be an Activity or 
	 * another Context object, like Service. You cannot be sure that just any Context will exist as long as CrimeLab needs it, which is for 
	 * the life of the application.
	 * 
	 * To ensure that your singleton has a long-term Context to work with, you call getApplicationContext() and trade the passed-in Context 
	 * for the application context. The application context is a Context that is global to your application. Whenever you have an application-wide 
	 * singleton, it should always use the application context.
	 */
	
	public static DummyItemGenerator get(Context c) {
		if (sDummyItemGenerator == null) {
			sDummyItemGenerator = new DummyItemGenerator(c.getApplicationContext());
		}
		
		return sDummyItemGenerator;
	}
	
	public ArrayList<DummyItem> getDummyItems() {
		return lstDummyItems;
	}
	
	public DummyItem getDummyItem(UUID id) {
		for (DummyItem dummy : lstDummyItems) {
			if (dummy.getId().equals(id)) {
				return dummy;
			}
		}
		
		return null;
	}
}
