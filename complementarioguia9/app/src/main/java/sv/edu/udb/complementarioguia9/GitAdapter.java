package sv.edu.udb.complementarioguia9;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GitAdapter extends ArrayAdapter<GitResponses> {

    public GitAdapter(@NonNull Context context, @NonNull List<GitResponses> objects) {
        super(context, 0, objects);
    }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            GitResponses user = getItem(position);


            if (convertView == null) {

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user,parent,false);
            }

            TextView tvName =  convertView.findViewById(R.id.tvRepo);


            tvName.setText(user.getName());
            return convertView;



        }


    }




