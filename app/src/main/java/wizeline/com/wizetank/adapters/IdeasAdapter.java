package wizeline.com.wizetank.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wizeline.com.wizetank.R;
import wizeline.com.wizetank.activities.ProfileActivity;
import wizeline.com.wizetank.models.IdeaModel;


/**
 * Created by xuannguyen on 1/20/18.
 */

public class IdeasAdapter extends RecyclerView.Adapter<IdeasAdapter.IdeaViewholder> {

    private List<IdeaModel> ideaModels = new ArrayList<>();

    @Override
    public IdeaViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.idea_item, null);

        IdeaViewholder ideaViewholder = new IdeaViewholder(view);
        return ideaViewholder;
    }

    @Override
    public void onBindViewHolder(IdeaViewholder holder, int position) {
        IdeaModel ideaModel = ideaModels.get(position);
        holder.bind(ideaModel);
    }

    @Override
    public int getItemCount() {
        return ideaModels.size();
    }

    public void setIdeaModels(List<IdeaModel> ideaModels) {
        this.ideaModels = ideaModels;
        notifyDataSetChanged();
    }

    public class IdeaViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.tvCreators)
        TextView tvCreators;

        @BindView(R.id.ratingBar)
        RatingBar ratingBar;

        @BindView(R.id.tvFollowing)
        TextView tvFollowing;


        public IdeaViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(IdeaModel ideaModel) {
            ratingBar.setRating(ideaModel.rating);
            tvTitle.setText(ideaModel.title);
            tvDescription.setText(ideaModel.description);
            tvCreators.setText(ideaModel.creators);
            tvFollowing.setText(String.format("%d followers", ideaModel.followingNumbers));

            tvCreators.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), ProfileActivity.class);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
