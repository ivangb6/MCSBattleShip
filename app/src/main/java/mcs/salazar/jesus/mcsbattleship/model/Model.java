package mcs.salazar.jesus.mcsbattleship.model;

import android.os.Parcelable;

/**
 * Created by Ivan on 2/5/2018
 */
public interface Model extends Parcelable {
    void toJson();
    void fromJson();
}
