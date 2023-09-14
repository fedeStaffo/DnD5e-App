package com.progetto_dd.memory.personaggio.incantesimo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007J\u001e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0019\u001a\u00020\u000eJ\b\u0010\u001a\u001a\u00020\fH\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoViewModel;", "Landroidx/lifecycle/ViewModel;", "dao", "Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoDao;", "(Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoDao;)V", "incantesimi", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;", "getIncantesimi", "()Landroidx/lifecycle/MutableLiveData;", "getIncantesimiByClass", "", "classe", "", "getIncantesimiByLevelAndClass", "livello", "", "classi", "getIncantesimiByNomi", "nomiIncantesimi", "getIncantesimiByParams", "tipo", "getIncantesimiByTypeAndClass", "getIncantesimoByNome", "nomeIncantesimo", "insertIncantesimiPredefiniti", "searchIncantesimiByKeyword", "keyword", "app_debug"})
public final class IncantesimoViewModel extends androidx.lifecycle.ViewModel {
    private final com.progetto_dd.memory.personaggio.incantesimo.IncantesimoDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> incantesimi = null;
    
    public IncantesimoViewModel(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.incantesimo.IncantesimoDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> getIncantesimi() {
        return null;
    }
    
    private final void insertIncantesimiPredefiniti() {
    }
    
    public final void getIncantesimiByParams(int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String classe) {
    }
    
    public final void getIncantesimiByLevelAndClass(int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String classi) {
    }
    
    public final void getIncantesimiByTypeAndClass(@org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String classi) {
    }
    
    public final void getIncantesimiByClass(@org.jetbrains.annotations.NotNull()
    java.lang.String classe) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> getIncantesimiByNomi(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> nomiIncantesimi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> getIncantesimoByNome(@org.jetbrains.annotations.NotNull()
    java.lang.String nomeIncantesimo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> searchIncantesimiByKeyword(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
}