package wizeline.com.wizetank.activities;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.otaliastudios.autocomplete.RecyclerViewPresenter;

import java.util.ArrayList;
import java.util.List;

import wizeline.com.wizetank.R;
import wizeline.com.wizetank.models.RoleModel;

/**
 * Created by xuannguyen on 1/20/18.
 */

class RolePresenter extends RecyclerViewPresenter<RoleModel> {

    protected Adapter adapter;

    public RolePresenter(Context context) {
        super(context);
    }

    @Override
    protected PopupDimensions getPopupDimensions() {
        PopupDimensions dims = new PopupDimensions();
        dims.width = 600;
        dims.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return dims;
    }

    @Override
    protected RecyclerView.Adapter instantiateAdapter() {
        adapter = new Adapter();
        return adapter;
    }

    @Override
    protected void onQuery(@Nullable CharSequence query) {
        List<RoleModel> all = createSampleRolesModels();
        all.addAll(CreateRoleActivity.roleModels);
        if (TextUtils.isEmpty(query)) {
            adapter.setData(all);
        } else {
            query = query.toString().toLowerCase();
            List<RoleModel> list = new ArrayList<>();
            for (RoleModel u : all) {
                if (u.roleName.toLowerCase().contains(query)) {
                    list.add(u);
                }
            }
            adapter.setData(list);
        }
        adapter.notifyDataSetChanged();
    }

    private List<RoleModel> createSampleRolesModels() {
        List<RoleModel> roleModels = new ArrayList<>();

        RoleModel roleModel;

        roleModel = new RoleModel();
        roleModel.roleName = "Project manager";
        roleModel.expected = "Gather team together and keep track for milestones";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "Business Analyst";
        roleModel.expected = "Analyze and extend the ideas";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "Embedded system developer";
        roleModel.expected = "Integrate with hardware device";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "Front-end developer";
        roleModel.expected = "Know how to generate front-end UI";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "Backend developer";
        roleModel.expected = "Know how to deal with db and design system";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "Android developer";
        roleModel.expected = "Know how to build quick android application";
        roleModels.add(roleModel);

        roleModel = new RoleModel();
        roleModel.roleName = "iOS developer";
        roleModel.expected = "Know how to build quick iOS application";
        roleModels.add(roleModel);

        return roleModels;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<RoleModel> data = new ArrayList<>();

        public void setData(List<RoleModel> data) {
            this.data = data;
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(
                    LayoutInflater.from(getContext()).inflate(R.layout.role_item, parent,
                            false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            final RoleModel user = data.get(position);
            holder.tvName.setText(user.roleName);
            holder.tvDescription.setText(user.expected);
            holder.root.setOnClickListener(v -> dispatchClick(user));
        }

        public class Holder extends RecyclerView.ViewHolder {
            private View root;
            private TextView tvName;
            private TextView tvDescription;

            public Holder(View itemView) {
                super(itemView);
                root = itemView;
                tvName = itemView.findViewById(R.id.tvName);
                tvDescription = itemView.findViewById(R.id.tvDescription);
            }
        }
    }
}
