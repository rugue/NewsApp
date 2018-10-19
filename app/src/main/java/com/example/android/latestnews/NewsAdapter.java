package com.example.android.latestnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news item
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * A new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news item, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the news at the given position in the news list
        News currentNews = getItem(position);

        String originalDate = currentNews.getDate();
        String finalDate;
        String finalTime;

        String[] parts = originalDate.split("T");
        finalDate = parts[0];
        finalTime = parts[1];
        String finalTimeLessZ = finalTime.substring(0, finalTime.lastIndexOf("Z"));


        // Find the TextView with view ID section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);
        // Display the section of the current news in that TextView
        sectionTextView.setText(currentNews.getSection());

        // Find the TextView with view ID headline
        TextView headlineTextView = (TextView) listItemView.findViewById(R.id.headline);
        // Display the headline of the current news in that TextView
        headlineTextView.setText(currentNews.getTitle());

        // Find the TextView with view ID author
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
        // Display the author of the current news in that TextView
        authorTextView.setText(currentNews.getAuthor());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(finalDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the time of the current news in that TextView
        timeView.setText(finalTimeLessZ);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}