package www.technovimal.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tos.retrofitokhttpcaching.R;
import java.util.List;
import www.technovimal.com.webapi.api.SecondData;

/**
 * Created by vimalcvs on 10/01/2021.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private final List<SecondData> items;
    public SecondAdapter(List<SecondData> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SecondData item = items.get(position);
        holder.english.setText(String.format("English: %s", item.getEnglish()));
        holder.hindi.setText(String.format("Hindi: %s", item.getHindi()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView english,hindi;
        ViewHolder(View itemView) {
            super(itemView);
            english = itemView.findViewById(R.id.english);
            hindi = itemView.findViewById(R.id.hindi);
        }

    }
}
