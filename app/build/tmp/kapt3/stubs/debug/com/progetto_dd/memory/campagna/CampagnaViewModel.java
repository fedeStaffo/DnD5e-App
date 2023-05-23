package com.progetto_dd.memory.campagna;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/progetto_dd/memory/campagna/CampagnaViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "campagneRef", "Lcom/google/firebase/firestore/CollectionReference;", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "aggiungiPersonaggioACampagna", "", "context", "Landroid/content/Context;", "nomeCampagna", "", "passwordCampagna", "nomePersonaggioSelezionato", "creaCampagna", "nome", "password", "master", "getCampagne", "Landroidx/lifecycle/LiveData;", "", "Lcom/progetto_dd/memory/campagna/Campagna;", "getNomiPersonaggiUtente", "Companion", "app_debug"})
public final class CampagnaViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.firestore.CollectionReference campagneRef = null;
    private final com.google.firebase.auth.FirebaseUser currentUser = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.progetto_dd.memory.campagna.CampagnaViewModel.Companion Companion = null;
    private static final java.lang.String TAG = "com.progetto_dd.view.campaigns.HomeCampaignsFragment";
    
    public CampagnaViewModel() {
        super();
    }
    
    public final void creaCampagna(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String master) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.progetto_dd.memory.campagna.Campagna>> getCampagne() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getNomiPersonaggiUtente() {
        return null;
    }
    
    public final void aggiungiPersonaggioACampagna(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String nomeCampagna, @org.jetbrains.annotations.NotNull()
    java.lang.String passwordCampagna, @org.jetbrains.annotations.NotNull()
    java.lang.String nomePersonaggioSelezionato) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/progetto_dd/memory/campagna/CampagnaViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}