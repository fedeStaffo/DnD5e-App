package com.progetto_dd.memory.personaggio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u001d\u001a\u00020\u0005J\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u000bJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u0005J\u0014\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010\'\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_classePersonaggio", "Landroidx/lifecycle/MutableLiveData;", "", "_competenzePersonaggio", "", "_nomePersonaggio", "_razzaPersonaggio", "classePersonaggio", "Landroidx/lifecycle/LiveData;", "getClassePersonaggio", "()Landroidx/lifecycle/LiveData;", "classiRef", "Lcom/google/firebase/firestore/CollectionReference;", "competenzePersonaggio", "getCompetenzePersonaggio", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "nomePersonaggio", "getNomePersonaggio", "personaggiRef", "razzaPersonaggio", "getRazzaPersonaggio", "razzeRef", "getInfoClasse", "classe", "getInfoRazza", "razza", "getPersonaggi", "", "Lcom/progetto_dd/memory/personaggio/Personaggio;", "setClassePersonaggio", "", "setCompetenzePersonaggio", "competenze", "setNomePersonaggio", "nome", "setRazzaPersonaggio", "Companion", "app_debug"})
public final class PersonaggioViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.firestore.CollectionReference personaggiRef = null;
    private final com.google.firebase.firestore.CollectionReference razzeRef = null;
    private final com.google.firebase.firestore.CollectionReference classiRef = null;
    private final com.google.firebase.auth.FirebaseUser currentUser = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _nomePersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _razzaPersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _classePersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.String>> _competenzePersonaggio = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.progetto_dd.memory.personaggio.PersonaggioViewModel.Companion Companion = null;
    private static final java.lang.String TAG = "com.progetto_dd.view.characters.HomeCharacterFragment";
    private static final java.lang.String TAG_RACE = "com.progetto_dd.view.characters.RaceFragment";
    private static final java.lang.String TAG_CLASS = "com.progetto_dd.view.characters.ClassFragment";
    
    public PersonaggioViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getNomePersonaggio() {
        return null;
    }
    
    public final void setNomePersonaggio(@org.jetbrains.annotations.NotNull()
    java.lang.String nome) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getRazzaPersonaggio() {
        return null;
    }
    
    public final void setRazzaPersonaggio(@org.jetbrains.annotations.NotNull()
    java.lang.String razza) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getClassePersonaggio() {
        return null;
    }
    
    public final void setClassePersonaggio(@org.jetbrains.annotations.NotNull()
    java.lang.String classe) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> getCompetenzePersonaggio() {
        return null;
    }
    
    public final void setCompetenzePersonaggio(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> competenze) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.progetto_dd.memory.personaggio.Personaggio>> getPersonaggi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getInfoRazza(@org.jetbrains.annotations.NotNull()
    java.lang.String razza) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getInfoClasse(@org.jetbrains.annotations.NotNull()
    java.lang.String classe) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioViewModel$Companion;", "", "()V", "TAG", "", "TAG_CLASS", "TAG_RACE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}