package com.example.recyclerviewsticky;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewsticky.databinding.FragmentBlankBinding;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {
    private List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBlankBinding binding=FragmentBlankBinding.inflate(inflater, container,false);
        View view=binding.getRoot();

        list=new ArrayList<>();
        list.add("john");
        list.add("jack");
        list.add("bob");
        list.add("ancle");
        list.add("chris");
        list.add("eddye");
        list.add("bill");
        list.add("man");
        list.add("jocker ");
        list.add("bat");
        list.add("alex");
        list.add("bin");
        list.add("billy");
        list.add("john");
        list.add("jack");
        list.add("bob");
        list.add("ancle");
        list.add("chris");
        list.add("eddye");
        list.add("bill");
        list.add("man");
        list.add("jocker ");
        list.add("bat");
        list.add("alex");
        list.add("bin");
        list.add("billy");

        RecyclerView recyclerView=binding.recyclerView;
        RecyclerView.Adapter adapter=new RecyclerAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Decor------------------------------------
        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_section_header_height),
                        true, // true for sticky, false for not
                        new RecyclerSectionItemDecoration.SectionCallback() {
                            @Override
                            public boolean isSection(int position) {
                                return position == 0
                                        || list.get(position)
                                        //.getLastName()
                                        .charAt(0) != list.get(position - 1)
                                        //.getLastName()
                                        .charAt(0);
                            }

                            @Override
                            public CharSequence getSectionHeader(int position) {
                                return list.get(position)
                                        //.getLastName()
                                        .subSequence(0, 3); //.subSequence(0, 1);   //•установление заголовка
                            }
                        });
        recyclerView.addItemDecoration(sectionItemDecoration);

        // Inflate the layout for this fragment
        return view;
    }
}