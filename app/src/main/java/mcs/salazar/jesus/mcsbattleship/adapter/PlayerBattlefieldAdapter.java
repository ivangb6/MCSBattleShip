package mcs.salazar.jesus.mcsbattleship.adapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Random;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;

public class PlayerBattlefieldAdapter extends BaseAdapter {

    private Context mContext;

    public boolean[][] mGrid;

    // Adapter should have access to this number somehow!
    private int mBattlefieldSize;

    public PlayerBattlefieldAdapter(Context context, int size, boolean[][] grid) {
        this.mContext = context;
        this.mBattlefieldSize = size;
        this.mGrid = grid;
    }

    public int getCount() {
        //return BattlefieldView.mThumbImages.length;
        return mGrid.length * mBattlefieldSize;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO: ClickListener / element!
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        // if there is a ship in this position
        if (mGrid[position / mBattlefieldSize][position % mBattlefieldSize]) {
            imageView.setImageResource(R.drawable.sample_1);
        }
        // else, set default/random background image
        else {
            imageView.setImageResource(R.drawable.water_pattern_default);
        }

        return imageView;
    }
}
