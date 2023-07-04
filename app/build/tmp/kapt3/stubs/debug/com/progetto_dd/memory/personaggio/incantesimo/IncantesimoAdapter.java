package com.progetto_dd.memory.personaggio.incantesimo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoAdapter$IncantesimoViewHolder;", "magie", "", "Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;", "currentFragment", "Landroidx/fragment/app/Fragment;", "(Ljava/util/List;Landroidx/fragment/app/Fragment;)V", "getMagie", "()Ljava/util/List;", "setMagie", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateMagie", "incantesimi", "IncantesimoViewHolder", "app_debug"})
public final class IncantesimoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter.IncantesimoViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> magie;
    private final androidx.fragment.app.Fragment currentFragment = null;
    
    public IncantesimoAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> magie, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment currentFragment) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> getMagie() {
        return null;
    }
    
    public final void setMagie(@org.jetbrains.annotations.NotNull()
    java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter.IncantesimoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter.IncantesimoViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateMagie(@org.jetbrains.annotations.NotNull()
    java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> incantesimi) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoAdapter$IncantesimoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoAdapter;Landroid/view/View;)V", "livelloTextView", "Landroid/widget/TextView;", "nameTextView", "tipoTextView", "bind", "", "incantesimo", "Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;", "app_debug"})
    public final class IncantesimoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView nameTextView = null;
        private final android.widget.TextView livelloTextView = null;
        private final android.widget.TextView tipoTextView = null;
        
        public IncantesimoViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.progetto_dd.memory.personaggio.incantesimo.Incantesimo incantesimo) {
        }
    }
}