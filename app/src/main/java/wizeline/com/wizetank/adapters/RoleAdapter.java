package wizeline.com.wizetank.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wizeline.com.wizetank.R;
import wizeline.com.wizetank.models.RoleModel;


/**
 * Created by xuannguyen on 1/20/18.
 */

public class RoleAdapter extends
        RecyclerView.Adapter<RoleAdapter.RoleViewholder> {

    private List<RoleModel> roleModels = new ArrayList<>();

    @Override
    public RoleViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.role_item, null);

        RoleViewholder contributorViewholder = new RoleViewholder(view);
        return contributorViewholder;
    }

    @Override
    public void onBindViewHolder(RoleViewholder holder, int position) {
        RoleModel roleModel = roleModels.get(position);
        holder.bind(roleModel);
    }

    @Override
    public int getItemCount() {
        return roleModels.size();
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
        notifyDataSetChanged();
    }

    public class RoleViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDescription)
        TextView tvDescription;


        public RoleViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(RoleModel roleModel) {
            tvName.setText(roleModel.roleName);
            tvDescription.setText(roleModel.expected);
        }
    }
}
