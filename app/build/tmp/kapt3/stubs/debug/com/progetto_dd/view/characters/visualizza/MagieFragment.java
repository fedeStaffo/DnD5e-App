package com.progetto_dd.view.characters.visualizza;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/progetto_dd/view/characters/visualizza/MagieFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/progetto_dd/databinding/FragmentMagieBinding;", "binding", "getBinding", "()Lcom/progetto_dd/databinding/FragmentMagieBinding;", "livello1Adapter", "Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoAdapter;", "livello2Adapter", "livello3Adapter", "livello4Adapter", "livello5Adapter", "livello6Adapter", "livello7Adapter", "livello8Adapter", "livello9Adapter", "trucchettiAdapter", "viewModel", "Lcom/progetto_dd/memory/personaggio/PersonaggioViewModel;", "viewModelInc", "Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "showSlotEditDialog", "livello", "", "app_debug"})
public final class MagieFragment extends androidx.fragment.app.Fragment {
    private com.progetto_dd.databinding.FragmentMagieBinding _binding;
    private com.progetto_dd.memory.personaggio.PersonaggioViewModel viewModel;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModel viewModelInc;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter trucchettiAdapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello1Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello2Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello3Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello4Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello5Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello6Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello7Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello8Adapter;
    private com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter livello9Adapter;
    
    public MagieFragment() {
        super();
    }
    
    private final com.progetto_dd.databinding.FragmentMagieBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    public final void showSlotEditDialog(int livello) {
    }
}