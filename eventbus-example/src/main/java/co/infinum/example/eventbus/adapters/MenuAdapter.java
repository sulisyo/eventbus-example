package co.infinum.example.eventbus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.infinum.example.eventbus.R;

/**
 * Created by dino on 23/12/13.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;

    private List<Integer> items;

    private MenuAdapter() {
        // not allowed
    }

    public MenuAdapter(Context context, List<Integer> items) {
        this.items = items;
        this.context = context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Integer getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.list_item_menu, null);
        }

        TextView itemText = (TextView) convertView.findViewById(R.id.item_text);
        itemText.setText(context.getString(getItem(position)));

        if (!isEnabled(position)) {
            convertView.setEnabled(false);
            convertView.setClickable(false);
        }

        return convertView;
    }
}
