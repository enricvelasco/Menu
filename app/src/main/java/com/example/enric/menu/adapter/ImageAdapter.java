package com.example.enric.menu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enric.menu.MenuPrincipalItem;
import com.example.enric.menu.R;

import java.util.ArrayList;


public class ImageAdapter extends BaseAdapter {

	private final Context mContext;
	private final ArrayList books;

	// 1
	public ImageAdapter(Context context, ArrayList<MenuPrincipalItem> books) {
		this.mContext = context;
		this.books = books;
	}

	// 2

	@Override
	public int getCount() {
		return books.size();
	}

	/*@Override
	public int getCount() {
		return books.length;
	}*/

	// 3
	@Override
	public long getItemId(int position) {
		return 0;
	}

	// 4
	@Override
	public Object getItem(int position) {
		return null;
	}

	// 5
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1
		final MenuPrincipalItem book = (MenuPrincipalItem) books.get(position);

		// 2
		if (convertView == null) {
			final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
			convertView = layoutInflater.inflate(R.layout.mobile, null);
		}

		// 3
		FrameLayout frame = convertView.findViewById(R.id.frameContenidoIconoMenu);
		final ImageView imageView = convertView.findViewById(R.id.grid_item_image);
		//final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
		//final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
		//final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

		// 4
		//Bitmap myBitmap = BitmapFactory.decodeFile(book.getPathImage());
		//ImageView imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
		//imageView.setImageBitmap(myBitmap);
		//imageView.setImageBitmap(BitmapFactory.decodeFile(book.getPathImage()));
		imageView.setImageResource(book.getImagen());
		//nameTextView.setText(mContext.getString(book.getName()));
		//authorTextView.setText(mContext.getString(book.getAuthor()));

		frame.setBackgroundColor(Color.parseColor(book.getColor()));

		ViewGroup.LayoutParams params = frame.getLayoutParams();
		params.height = book.getTamanoHorizontal();
		params.width = book.getTamanoHorizontal();
		frame.setLayoutParams(params);

		return convertView;
	}

}
