package com.sage.exp.expenseaccount;

import com.google.inject.AbstractModule;
import com.sage.exp.expenseaccount.managers.DatabaseManager;
import com.sage.exp.expenseaccount.services.AuthService;
import com.sage.exp.expenseaccount.utils.ApplicationUtil;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApplicationUtil.class).asEagerSingleton();
        bind(DatabaseManager.class).asEagerSingleton();
        bind(AuthService.class).asEagerSingleton();

    }
}
