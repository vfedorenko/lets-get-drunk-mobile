package by.vfedorenko.letsgetdrunk.presentation;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 03.11.16.
 */
public class BindingAdapters {
    @BindingAdapter("android:recyclerViewAdapter")
    public static void setRecycleAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("android:forceRequestFocus")
    public static void setForceRequestFocus(EditText editText, boolean shouldRequest) {
        if (shouldRequest) {
            editText.requestFocus();
        }
    }
}
