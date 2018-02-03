package wizeline.com.wizetank.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wizeline.com.wizetank.R;
import wizeline.com.wizetank.adapters.ContributorsAdapter;
import wizeline.com.wizetank.models.ContributorModel;

/**
 * Created by xuannguyen on 1/19/18.
 */

public class ContributorListFragment extends Fragment {

    @BindView(R.id.txtSearch)
    EditText txtSearch;

    @BindView(R.id.contributorList)
    RecyclerView contributorList;
    private ContributorsAdapter adapter;

    private List<ContributorModel> models;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_contributor_list, container, false);
        ButterKnife.bind(this, result);

        contributorList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ContributorsAdapter();
        contributorList.setAdapter(adapter);
        models = createSampleContributorsModels();
        adapter.setContributorModels(models);

        contributorList.addItemDecoration(
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        setSearchActions();

        return result;
    }

    private void setSearchActions() {
        txtSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<ContributorModel> filteredList = new ArrayList<>();

                for (int i = 0; i < models.size(); i++) {

                    final String text = models.get(i).getAllInformation().toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(models.get(i));
                    }
                }

                adapter.setContributorModels(filteredList);
            }
        });
    }

    public static List<ContributorModel> createSampleContributorsModels() {
        List<ContributorModel> result = new ArrayList<>();

        ContributorModel model;

        model = new ContributorModel();
        model.name = "Xuan Nguyen";
        model.description = "Android developer";
        model.ideaNumber = 3;
        model.profileUrl =
                "http://2.bp.blogspot.com/-kxn8QsSmeSc/VnBtWZ0gnrI/AAAAAAAAFWo/e1vUMxUgcmo/s1600"
                        + "/HandsomeGuy_inocent.png";
        result.add(model);

        model = new ContributorModel();
        model.name = "Hung Vo";
        model.description = "Fullstack developer";
        model.ideaNumber = 5;
        model.profileUrl =
                "https://static.wixstatic.com/media/017ff4_16ee21bd66f240b0a36c2d1247181d1f"
                        + ".jpg/v1/fill/w_500,h_500,q_85,"
                        + "usm_0.66_1.00_0.01/017ff4_16ee21bd66f240b0a36c2d1247181d1f.jpg";
        result.add(model);

        model = new ContributorModel();
        model.name = "Alex Pliutau";
        model.description = "Fullstack developer";
        model.ideaNumber = 2;
        model.profileUrl =
                "https://cdn0.iconfinder"
                        + ".com/data/icons/avatar-25/64/avatar-guy-boy-handsome-man-metro-short"
                        + "-512.png";
        result.add(model);

        model = new ContributorModel();
        model.name = "Adam Fisher";
        model.description = "Project manager";
        model.ideaNumber = 2;
        model.profileUrl =
                "https://cdn0.iconfinder.com/data/icons/avatars-3/512/avatar_blond_guy-512.png";
        result.add(model);

        model = new ContributorModel();
        model.name = "Thien Liu";
        model.description = "iOS developer";
        model.ideaNumber = 3;
        model.profileUrl =
                "https://cdn0.iconfinder.com/data/icons/avatars-3/512/avatar_nice_guy-512.png";
        result.add(model);

        model = new ContributorModel();
        model.name = "Duc Nguyen";
        model.description = "Fullstack developer";
        model.ideaNumber = 1;
        model.profileUrl =
                "https://cdn0.iconfinder"
                        + ".com/data/icons/avatar-25/64/avatar-guy-boy-handsome-man-metro-short"
                        + "-512.png";
        result.add(model);

        return result;
    }

}
