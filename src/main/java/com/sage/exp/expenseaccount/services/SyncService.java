package com.sage.exp.expenseaccount.services;


import com.sage.exp.expenseaccount.dao.ExpenseDAO;
import com.sage.exp.expenseaccount.models.Expense;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SyncService {
    private static final String API_URL = "https://api.example.com/expenses";
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    public void syncExpenses() {
        List<Expense> unsyncedExpenses = expenseDAO.getUnsyncedExpenses();
        for (Expense expense : unsyncedExpenses) {
            try {
                URL url = new URL(API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

//                String json = new Gson().toJson(expense);
//                try (OutputStream os = conn.getOutputStream()) {
//                    os.write(json.getBytes());
//                }

                if (conn.getResponseCode() == 200) {
                    expenseDAO.markExpenseAsSynced(expense.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}