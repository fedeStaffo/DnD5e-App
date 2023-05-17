package com.progetto_dd.memory.personaggio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\fH\u0002R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/progetto_dd/memory/personaggio/CompetenzaViewModel;", "Landroidx/lifecycle/ViewModel;", "dao", "Lcom/progetto_dd/memory/personaggio/CompetenzaDao;", "(Lcom/progetto_dd/memory/personaggio/CompetenzaDao;)V", "competenzeNomiLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getCompetenzeNomiLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getCompetenzeNomiByClasse", "", "classe", "insertCompetenzePredefinite", "app_debug"})
public final class CompetenzaViewModel extends androidx.lifecycle.ViewModel {
    private final com.progetto_dd.memory.personaggio.CompetenzaDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> competenzeNomiLiveData = null;
    
    public CompetenzaViewModel(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.CompetenzaDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> getCompetenzeNomiLiveData() {
        return null;
    }
    
    public final void getCompetenzeNomiByClasse(@org.jetbrains.annotations.NotNull()
    java.lang.String classe) {
    }
    
    private final void insertCompetenzePredefinite() {
    }
}