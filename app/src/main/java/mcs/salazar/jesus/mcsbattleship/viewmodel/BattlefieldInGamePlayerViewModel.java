package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;

import mcs.salazar.jesus.mcsbattleship.adapter.PlayerBattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 2/23/2018
 */
public class BattlefieldInGamePlayerViewModel extends BattlefieldInGameViewModel {

    public BattlefieldInGamePlayerViewModel(Context context, Battlefield battlefield) {
        super(context, battlefield);
    }

    @Override
    public void createAdapter(Context context) {
        mAdapter = new PlayerBattlefieldAdapter(context,
                mBattlefield.getSize(), mBattlefield.getGrid(), mBattlefield.getShots());
    }

    @Override
    public void bind() {
        super.bind();
    }
}
