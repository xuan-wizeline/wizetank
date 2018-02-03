package wizeline.com.wizetank.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.widget.EditText;
import android.widget.VideoView;

import com.otaliastudios.autocomplete.Autocomplete;
import com.otaliastudios.autocomplete.AutocompleteCallback;
import com.otaliastudios.autocomplete.AutocompletePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wizeline.com.wizetank.R;
import wizeline.com.wizetank.adapters.ContributorsAdapter;
import wizeline.com.wizetank.adapters.RoleAdapter;
import wizeline.com.wizetank.models.ContributorModel;
import wizeline.com.wizetank.models.IdeaModel;
import wizeline.com.wizetank.models.RoleModel;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class CreateIdeaActivity extends AppCompatActivity {

    public static Uri videoUri;
    public static List<IdeaModel> ideaModels = new ArrayList<>();

    @BindView(R.id.videoView)
    VideoView videoView;

    @BindView(R.id.txtCreators)
    EditText txtCreators;

    @BindView(R.id.txtName)
    EditText txtName;

    @BindView(R.id.txtDescription)
    EditText txtDescription;

    @BindView(R.id.txtRoles)
    EditText txtRoles;

    private Autocomplete creatorComplete;
    private Autocomplete rolesComplete;

    @BindView(R.id.contributorList)
    RecyclerView contributorList;

    @BindView(R.id.roleList)
    RecyclerView roleList;
    private ContributorsAdapter adapter;
    private RoleAdapter roleAdapter;

    private List<ContributorModel> models = new ArrayList<>();
    private List<RoleModel> roleModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_idea);
        ButterKnife.bind(this);

        videoView.setVideoURI(videoUri);
        videoView.start();

        contributorList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContributorsAdapter();
        contributorList.setAdapter(adapter);

        roleList.setLayoutManager(new LinearLayoutManager(this));
        roleAdapter = new RoleAdapter();
        roleList.setAdapter(roleAdapter);

        setupUserAutocomplete();
        setupRoleAutocomplete();
    }

    private void setupUserAutocomplete() {
        float elevation = 6f;
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        AutocompletePresenter<ContributorModel> presenter = new UserPresenter(this);
        AutocompleteCallback<ContributorModel> callback = new AutocompleteCallback<ContributorModel>() {
            @Override
            public boolean onPopupItemClicked(Editable editable, ContributorModel item) {
                editable.clear();
                models.add(item);
                adapter.setContributorModels(models);
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {}
        };

        creatorComplete = Autocomplete.<ContributorModel>on(txtCreators)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    private void setupRoleAutocomplete() {
        float elevation = 6f;
        Drawable backgroundDrawable = new ColorDrawable(Color.WHITE);
        AutocompletePresenter<RoleModel> presenter = new RolePresenter(this);
        AutocompleteCallback<RoleModel> callback = new AutocompleteCallback<RoleModel>() {
            @Override
            public boolean onPopupItemClicked(Editable editable, RoleModel item) {
                editable.clear();
                roleModels.add(item);
                roleAdapter.setRoleModels(roleModels);
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {}
        };

        creatorComplete = Autocomplete.<RoleModel>on(txtRoles)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    @OnClick(R.id.btnAddRole)
    public void onAddRole() {
        startActivity(new Intent(this,
                CreateRoleActivity.class));
    }

    @OnClick(R.id.btnSave)
    public void onSaveIdea() {
        IdeaModel item = new IdeaModel();
        item.description = txtDescription.getText().toString();
        item.title = txtName.getText().toString();
        item.rating = 0;
        item.followingNumbers = 0;
        item.creators = getCreators();
        ideaModels.add(item);
        finish();
    }

    private String getCreators() {
        StringBuilder result = new StringBuilder();
        for (ContributorModel model : models) {
            result.append(model.name);
            result.append(",");
        }
        String creators = result.toString();
        return creators.substring(0, creators.length() - 1);
    }
}
