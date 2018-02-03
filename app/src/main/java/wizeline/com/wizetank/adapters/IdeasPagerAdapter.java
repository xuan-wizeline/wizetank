package wizeline.com.wizetank.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import wizeline.com.wizetank.fragments.ContributorListFragment;
import wizeline.com.wizetank.fragments.IdeaListFragment;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class IdeasPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public IdeasPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                IdeaListFragment tab1 = new IdeaListFragment();
                tab1.setSearchable(true);
                return tab1;
            case 1:
                IdeaListFragment tab2 = new IdeaListFragment();
                tab2.setSearchable(false);
                return tab2;
            case 2:
                ContributorListFragment tab3 = new ContributorListFragment();
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
