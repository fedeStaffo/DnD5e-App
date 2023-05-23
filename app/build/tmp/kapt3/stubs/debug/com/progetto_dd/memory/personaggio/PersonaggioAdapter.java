package com.progetto_dd.memory.personaggio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/progetto_dd/memory/personaggio/PersonaggioAdapter$PersonaggioViewHolder;", "personaggi", "", "Lcom/progetto_dd/memory/personaggio/Personaggio;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PersonaggioViewHolder", "app_debug"})
public final class PersonaggioAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.progetto_dd.memory.personaggio.PersonaggioAdapter.PersonaggioViewHolder> {
    private final java.util.List<com.progetto_dd.memory.personaggio.Personaggio> personaggi = null;
    
    public PersonaggioAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.progetto_dd.memory.personaggio.Personaggio> personaggi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.progetto_dd.memory.personaggio.PersonaggioAdapter.PersonaggioViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.PersonaggioAdapter.PersonaggioViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioAdapter$PersonaggioViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/progetto_dd/memory/personaggio/PersonaggioAdapter;Landroid/view/View;)V", "classTextView", "Landroid/widget/TextView;", "nameTextView", "raceTextView", "bind", "", "personaggio", "Lcom/progetto_dd/memory/personaggio/Personaggio;", "app_debug"})
    public final class PersonaggioViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView nameTextView = null;
        private final android.widget.TextView raceTextView = null;
        private final android.widget.TextView classTextView = null;
        
        public PersonaggioViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.progetto_dd.memory.personaggio.Personaggio personaggio) {
        }
    }
}