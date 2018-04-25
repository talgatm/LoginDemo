package kg.shtraf.logindemo;

/**
 * Created by User on 25.04.2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kg.shtraf.logindemo.Result;

import java.util.List;


public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.CustomViewHolder> {
    private List<Result> employees;

    public EmployeesAdapter(List<Result> employees) {
        this.employees = employees;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_employee_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Result result= employees.get(position);
        holder.DocumentCode.setText(employees.get(position).getDocumentCode());
        holder.ViolationDate.setText(employees.get(position).getViolationDate());
        holder.ViolationLocation.setText(employees.get(position).getViolationLocation());
        holder.Article.setText(employees.get(position).getArticle());
        holder.ViolationFine.setText(employees.get(position).getViolationFine());
        holder.Payed.setText(employees.get(position).getPayed());
        holder.AmountToPay.setText(employees.get(position).getAmountToPay());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView DocumentCode,ViolationDate,ViolationLocation,Article,ViolationFine,Payed,AmountToPay;

        public CustomViewHolder(View view) {
            super(view);
            DocumentCode = (TextView) itemView.findViewById(R.id.documentCode);
            ViolationDate = (TextView) itemView.findViewById(R.id.violationDate);
            ViolationLocation = (TextView) itemView.findViewById(R.id.violationLocation);
            Article = (TextView) itemView.findViewById(R.id.article);
            ViolationFine = (TextView) itemView.findViewById(R.id.violationFine);
            Payed = (TextView) itemView.findViewById(R.id.payed);
            AmountToPay = (TextView) itemView.findViewById(R.id.amountToPay);
        }
    }
}