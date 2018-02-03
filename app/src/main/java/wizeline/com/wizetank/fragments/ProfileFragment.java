package wizeline.com.wizetank.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import wizeline.com.wizetank.R;

/**
 * Created by xuannguyen on 1/19/18.
 */

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, result);


        return result;
    }

}
