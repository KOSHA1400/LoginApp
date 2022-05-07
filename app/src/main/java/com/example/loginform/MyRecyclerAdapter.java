package com.example.loginform;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>  {
    ArrayList<User> users;
    Context context;

    public MyRecyclerAdapter(Context context , ArrayList<User> users){
        this.users=users;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


       User user = users.get(position);
        holder.txtName.setText("نام :"+user.name);
        holder.txtEmail.setText("ایمیل :"+ user.email);

        holder.btnEdit.setOnClickListener(v -> {

            Intent intent=new Intent(context,AddEditActivity.class);
            context.startActivity(intent);


        });

        holder.btnDelete.setOnClickListener(v -> {

            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle( "" )
                    .setMessage("آیا برای حذف اطمینان دارید ؟")
     .setNegativeButton("لغو", (dialoginterface, i) -> dialoginterface.cancel())
                    .setPositiveButton("تایید", (dialoginterface, i) -> {

                        users.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, users.size());
                        holder.itemView.setVisibility(View.GONE);


                    }).show();
        });

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return users.size();
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txtEmail;
        TextView txtName;
        MaterialButton btnEdit;
        MaterialButton btnDelete;

        ViewHolder(View itemView) {
            super(itemView);
            txtEmail = itemView.findViewById(R.id.item_recycler_txt_email);
            txtName = itemView.findViewById(R.id.item_recycler_txt_name);
            btnEdit = itemView.findViewById(R.id.item_recycler_btn_edit);
            btnDelete = itemView.findViewById(R.id.item_recycler_btn_delete);

        }

    }


}
