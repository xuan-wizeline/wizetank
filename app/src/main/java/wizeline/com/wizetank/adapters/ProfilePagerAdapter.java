package wizeline.com.wizetank.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import wizeline.com.wizetank.fragments.IdeaListFragment;
import wizeline.com.wizetank.fragments.ProfileFragment;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class ProfilePagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public ProfilePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ProfileFragment tab1 = new ProfileFragment();
                return tab1;
            case 1:
                IdeaListFragment tab2 = new IdeaListFragment();
                tab2.setSearchable(false);
                return tab2;
            case 2:
                IdeaListFragment tab3 = new IdeaListFragment();
                tab3.setSearchable(false);
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
