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
import wizeline.com.wizetank.fragments.ContributorListFragment;
import wizeline.com.wizetank.models.ContributorModel;

/**
 * Created by xuannguyen on 1/20/18.
 */

class UserPresenter extends RecyclerViewPresenter<ContributorModel> {

    protected Adapter adapter;

    public UserPresenter(Context context) {
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
        List<ContributorModel> all = ContributorListFragment.createSampleContributorsModels();
        if (TextUtils.isEmpty(query)) {
            adapter.setData(all);
        } else {
            query = query.toString().toLowerCase();
            List<ContributorModel> list = new ArrayList<>();
            for (ContributorModel u : all) {
                if (u.getAllInformation().toLowerCase().contains(query)) {
                    list.add(u);
                }
            }
            adapter.setData(list);
        }
        adapter.notifyDataSetChanged();
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<ContributorModel> data = new ArrayList<>();

        public void setData(List<ContributorModel> data) {
            this.data = data;
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(
                    LayoutInflater.from(getContext()).inflate(R.layout.creator_item, parent,
                            false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            final ContributorModel user = data.get(position);
            holder.tvName.setText(user.name);
            holder.root.setOnClickListener(v -> dispatchClick(user));
        }

        public class Holder extends RecyclerView.ViewHolder {
            private View root;
            private TextView tvName;

            public Holder(View itemView) {
                super(itemView);
                root = itemView;
                tvName = itemView.findViewById(R.id.tvName);
            }
        }
    }
}
