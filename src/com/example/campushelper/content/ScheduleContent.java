package com.example.campushelper.content;

import com.example.campushelper.dao.CampusHelperOpenHelper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ScheduleContent extends ContentProvider{
	public static final int TABLE1_DIR = 0;
	public static final int TABLE1_ITEM = 1;
	private static UriMatcher uriMatcher;
	private CampusHelperOpenHelper campusHelperOpenHelper;
	static {
	uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	uriMatcher.addURI("com.example.CampulsHelper.databases.provider", "Schedule", TABLE1_DIR);
	uriMatcher.addURI("com.example.CampulsHelper.databases.provider", "Schedule/#", TABLE1_ITEM);
	}
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		campusHelperOpenHelper = new CampusHelperOpenHelper(getContext(), ".CampusHelper.db", null, 2);
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = campusHelperOpenHelper.getReadableDatabase();
		Uri uriReturn = null;
		switch (uriMatcher.match(uri)) {
		case TABLE1_DIR:
		break;
		case TABLE1_ITEM:
		// 查询table1表中的单条数据
		break;
		default:
		break;
		}
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
