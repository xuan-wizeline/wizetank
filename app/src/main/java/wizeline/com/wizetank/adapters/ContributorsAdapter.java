package wizeline.com.wizetank.adapters;

import android.content.Intent;
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
import wizeline.com.wizetank.activities.ProfileActivity;
import wizeline.com.wizetank.models.ContributorModel;


/**
 * Created by xuannguyen on 1/20/18.
 */

public class ContributorsAdapter extends
        RecyclerView.Adapter<ContributorsAdapter.ContributorViewholder> {

    private List<ContributorModel> contributorModels = new ArrayList<>();

    @Override
    public ContributorViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contributor_item, null);

        ContributorViewholder contributorViewholder = new ContributorViewholder(view);
        return contributorViewholder;
    }

    @Override
    public void onBindViewHolder(ContributorViewholder holder, int position) {
        ContributorModel contributorModel = contributorModels.get(position);
        holder.bind(contributorModel);
    }

    @Override
    public int getItemCount() {
        return contributorModels.size();
    }

    public void setContributorModels(List<ContributorModel> contributorModels) {
        this.contributorModels = contributorModels;
        notifyDataSetChanged();
    }

    public class ContributorViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.tvIdeas)
        TextView tvIdeas;


        public ContributorViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(ContributorModel contributorModel) {
            tvName.setText(contributorModel.name);
            tvDescription.setText(contributorModel.description);
            tvIdeas.setText(String.format("%d ideas", contributorModel.ideaNumber));
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), ProfileActivity.class);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
