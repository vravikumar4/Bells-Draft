package com.example.varun.bells;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<DistrictNames> districtNamesList = null;
    private ArrayList<DistrictNames> arraylist;

    public ListViewAdapter(Context context, List<DistrictNames> animalNamesList) {
        mContext = context;
        this.districtNamesList = districtNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<DistrictNames>();
        this.arraylist.addAll(districtNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return districtNamesList.size();
    }

    @Override
    public DistrictNames getItem(int position) {
        return districtNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(districtNamesList.get(position).getDistrictName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        districtNamesList.clear();
        if (charText.length() == 0) {
            districtNamesList.addAll(arraylist);
        } else {
            for (DistrictNames wp : arraylist) {
                if (wp.getDistrictName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    districtNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
