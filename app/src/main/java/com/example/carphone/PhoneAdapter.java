package com.example.carphone;
import android.view.*; import android.widget.*; import androidx.annotation.*; import androidx.recyclerview.widget.RecyclerView; import java.util.*;
public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.VH>{
    private final List<Phone> data; public PhoneAdapter(List<Phone> d){data=d;}
    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p,int v){
        View view=LayoutInflater.from(p.getContext()).inflate(R.layout.item_phone,p,false); return new VH(view);
    }
    @Override public void onBindViewHolder(@NonNull VH h,int i){ Phone x=data.get(i); h.b.setText(x.brand); h.m.setText(x.model); h.pr.setText(String.format("%,.0f บาท", x.price)); }
    @Override public int getItemCount(){ return data.size(); }
    static class VH extends RecyclerView.ViewHolder{ TextView b,m,pr; VH(@NonNull View v){ super(v); b=v.findViewById(R.id.tvBrand); m=v.findViewById(R.id.tvModel); pr=v.findViewById(R.id.tvPrice);}}
}
