package com.example.picup;

import android.content.Context;
<<<<<<< HEAD
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class ImageAdapter extends ArrayAdapter {
    private  Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;


    public ImageAdapter (Context context,String[] imageUrls) {
        super(context, R.layout.listview_item_image, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);

        }

        Glide
                .with(context)
                .load(imageUrls[position])
                .centerCrop()
                .into((ImageView) convertView);

        return convertView;
    }
}



/*public class ImageAdapter<string> extends BaseAdapter {
    private Context mContext;
    private String imgData;
    private String geoData;
    private ArrayList<string> thumbsDataList;
    private ArrayList<string> thumbsIDList;


    ImageAdapter(Context c) {
        mContext = c;
        thumbsDataList = new ArrayList<string>();
        thumbsIDList = new ArrayList<string>();
        getThumbInfo(thumbsIDList, thumbsDataList);


    }

    public final void callImageViewer(int selectedIndex) {
        Intent i = new Intent(mContext, ImagePopup.class);
        String imgPath = getImageInfo(imgData, geoData, thumbsIDList.get(selectedIndex));
        i.putExtra("filename", imgPath);
        startActivityForResult(i, 1);
    }

    public boolean deleteSelected(int sIndex) {
        return true;
    }


    @Override
    public int getCount() {
        return thumbsIDList.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
=======
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private  Context mContext;
    public ImageAdapter(MypageActivity c){
        mContext=c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
    }

    @Override
    public long getItemId(int position) {
<<<<<<< HEAD
        return position;
=======
        return 0;
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
<<<<<<< HEAD
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else
            imageView = (ImageView) convertView;
        BitmapFactory.Options bo = new BitmapFactory.Options();
        bo.inSampleSize = 8;
        Bitmap bmp = BitmapFactory.decodeFile(thumbsDataList.get(position), bo);
        Bitmap resized = Bitmap.createScaledBitmap(bmp, 95, 95, true);
        imageView.setImageBitmap(resized);

        return imageView;
        GlideApp
                .with()
    }

    private void getThumbInfo(ArrayList<string> thumbsIDs, ArrayList<string> thumbsDatas) {
        String[] proj = {MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.SIZE};

        Cursor imageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                proj, null, null, null);

        if (imageCursor != null && imageCursor.moveToFirst()) {
            String title;
            String thumbsID;
            String thumbsImageID;
            String thumbsData;
            String data;
            String imgSize;

            int thumbsIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);
            int thumbsDataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
            int thumbsImageIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
            int thumbsSizeCol = imageCursor.getColumnIndex(MediaStore.Images.Media.SIZE);
            int num = 0;
            do {
                thumbsID = imageCursor.getString(thumbsIDCol);
                thumbsData = imageCursor.getString(thumbsDataCol);
                thumbsImageID = imageCursor.getString(thumbsImageIDCol);
                imgSize = imageCursor.getString(thumbsSizeCol);
                num++;
                if (thumbsImageID != null) {
                    thumbsIDs.add(thumbsID);
                    thumbsDatas.add(thumbsData);
                }
            } while (imageCursor.moveToNext());
        }
        imageCursor.close();
        return;
    }

    private String getImageInfo(String ImageData, String Location, String thumbID) {
        String imageDataPath = null;
        String[] proj = {MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.SIZE};
        Cursor imageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                proj, "_ID='" + thumbID + "'", null, null);

        if (imageCursor != null && imageCursor.moveToFirst()) {
            if (imageCursor.getCount() > 0) {
                int imgData = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
                imageDataPath = imageCursor.getString(imgData);
            }
        }
        imageCursor.close();
        return imageDataPath;
    }




}









    };*/
=======
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(350, 460));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else
            imageView = (ImageView) convertView;
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    private Integer[] mThumbIds={
            R.drawable.sns,
            R.drawable.sns1,
            R.drawable.sns2,
            R.drawable.sns3,
            R.drawable.sns4,
            R.drawable.sns5,
            R.drawable.sns6,
            R.drawable.sns7,
            R.drawable.sns8,
            R.drawable.sns9


    };
}
>>>>>>> 0ca01f0bcb8051481652daf3e19224866d19480f
