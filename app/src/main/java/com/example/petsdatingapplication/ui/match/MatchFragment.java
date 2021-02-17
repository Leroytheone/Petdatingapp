package com.example.petsdatingapplication.ui.match;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.petsdatingapplication.MainActivity;
import com.example.petsdatingapplication.R;
import com.example.petsdatingapplication.ui.community.PagerAdapter;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MatchFragment extends Fragment {

    private MatchViewModel dashboardViewModel;
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(MatchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_match, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    super.onViewCreated(view, savedInstanceState);
    setContentView(R.layout.fragment_match);
    SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);

    al = new ArrayList<>();
    al.add("php");
    al.add("c");
    al.add("python");
    al.add("java");
    al.add("html");
    al.add("c++");
    al.add("css");
    al.add("javascript");

    arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );
    flingContainer.setAdapter(arrayAdapter);

    flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
        @Override
        public void removeFirstObjectInAdapter() {
            // this is the simplest way to delete an object from the Adapter (/AdapterView)
            Log.d("LIST", "removed object!");
            al.remove(0);
            arrayAdapter.notifyDataSetChanged();
        }

        @Override
        public void onLeftCardExit(Object dataObject) {
            //Do something on the left!
            //You also have access to the original object.
            //If you want to use it just cast it (String) dataObject
            Toast.makeText("left!", );
        }

        @Override
        public void onRightCardExit(Object dataObject) {

            Toast.makeText("right!", );
        }

        @Override
        public void onAdapterAboutToEmpty(int itemsInAdapter) {
            // Ask for more data here
            al.add("XML ".concat(String.valueOf(i)));
            arrayAdapter.notifyDataSetChanged();
            Log.d("LIST", "notified");
            i++;
        }

        @Override
        public void onScroll(float scrollProgressPercent) {
           
        }
    });


            // Optionally add an OnItemClickListener
            flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
                @Override
                public void onItemClicked(int itemPosition, Object dataObject) {
                    //
                }
            });

        }



        }