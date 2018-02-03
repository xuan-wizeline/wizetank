package wizeline.com.wizetank.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wizeline.com.wizetank.R;
import wizeline.com.wizetank.models.RoleModel;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class CreateRoleActivity extends AppCompatActivity {

    public static List<RoleModel> roleModels = new ArrayList<>();

    @BindView(R.id.txtRoleName)
    EditText txtRoleName;

    @BindView(R.id.txtDescription)
    EditText txtDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_role);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSave)
    public void onSaveRole() {
        RoleModel roleModel = new RoleModel();
        roleModel.expected = txtDescription.getText().toString();
        roleModel.roleName = txtRoleName.getText().toString();
        roleModels.add(roleModel);
        finish();
    }
}
