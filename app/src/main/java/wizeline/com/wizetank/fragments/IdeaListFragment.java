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
import wizeline.com.wizetank.activities.CreateIdeaActivity;
import wizeline.com.wizetank.adapters.IdeasAdapter;
import wizeline.com.wizetank.models.IdeaModel;

/**
 * Created by xuannguyen on 1/19/18.
 */

public class IdeaListFragment extends Fragment {

    @BindView(R.id.txtSearch)
    EditText txtSearch;

    @BindView(R.id.ideaList)
    RecyclerView ideaList;
    private IdeasAdapter adapter;

    private List<IdeaModel> models;
    private boolean searchable;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_idea_list, container, false);
        ButterKnife.bind(this, result);

        ideaList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new IdeasAdapter();
        ideaList.setAdapter(adapter);


        ideaList.addItemDecoration(
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        if (searchable) {
            txtSearch.setVisibility(View.VISIBLE);
            setSearchActions();
        } else {
            txtSearch.setVisibility(View.GONE);
        }

        return result;
    }

    @Override
    public void onResume() {
        super.onResume();

        models = createSampleIdeaModels();
        models.addAll(CreateIdeaActivity.ideaModels);
        adapter.setIdeaModels(models);
    }

    private void setSearchActions() {
        txtSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<IdeaModel> filteredList = new ArrayList<>();

                for (int i = 0; i < models.size(); i++) {

                    final String text = models.get(i).getAllInformation().toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(models.get(i));
                    }
                }

                adapter.setIdeaModels(filteredList);
            }

        });
    }

    private List<IdeaModel> createSampleIdeaModels() {
        List<IdeaModel> result = new ArrayList<>();

        IdeaModel model;

        model = new IdeaModel();
        model.creators = "Xuan Nguyen, Hung Vo";
        model.title = "Wize Tank";
        model.description = "You raise, we make it work";
        model.followingNumbers = 2;
        model.rating = 4;
        result.add(model);

        model = new IdeaModel();
        model.creators = "Adam Fisher, Alex Pliutau";
        model.title = "Wizeline Culture Bot";
        model.description = "AI bot for Wizeline";
        model.followingNumbers = 2;
        model.rating = 5;
        result.add(model);

        model = new IdeaModel();
        model.creators = "Thien Liu, Duc Nguyen";
        model.title = "Wizeline mentor";
        model.description = "Pair programming";
        model.followingNumbers = 2;
        model.rating = 5;
        result.add(model);

        return result;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }
}
