package project.apps.kapekat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

// the parameterization <type of the RealmObject, ViewHolder type)
public class UserAdapter extends RealmRecyclerViewAdapter<User, UserAdapter.ViewHolder> {

    // IMPORTANT
    // THE CONTAINING ACTIVITY NEEDS TO BE PASSED SO YOU CAN GET THE LayoutInflator(see below)
    Admin activity;

    public UserAdapter(Admin activity, @Nullable RealmResults<User> data, boolean autoUpdate) {
        super(data, autoUpdate);

        // THIS IS TYPICALLY THE ACTIVITY YOUR RECYCLERVIEW IS IN
        this.activity = activity;
    }

    // THIS DEFINES WHAT VIEWS YOU ARE FILLING IN
    public class ViewHolder extends RecyclerView.ViewHolder {

        // have a field for each one
        TextView un, pw;
        ImageButton delete, edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialize them from the itemView using standard style
            un = itemView.findViewById(R.id.tvReview);
            pw = itemView.findViewById(R.id.pass_word);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // create the raw view for this ViewHolder
        View v = activity.getLayoutInflater().inflate(R.layout.row_layout, parent, false);  // VERY IMPORTANT TO USE THIS STYLE

        // assign view to the viewholder
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // gives you the data object at the given position
        User u = getItem(position);
        String uuid = u.getUuid();
        holder.un.setText(u.getUsername());
        holder.pw.setText(u.getPassword());
    }

}