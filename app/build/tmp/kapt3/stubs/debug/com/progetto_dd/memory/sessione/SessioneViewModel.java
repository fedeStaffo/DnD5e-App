package com.progetto_dd.memory.sessione;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\"\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006J&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/progetto_dd/memory/sessione/SessioneViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "deleteSessionsFromCampaign", "", "campaignName", "", "masterId", "eliminaSessione", "campagnaNome", "numeroSessione", "getSessione", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/progetto_dd/memory/sessione/Sessione;", "campagna", "master", "modificaDescrizioneSessione", "nuovaDescrizione", "modificaGiornoSessione", "nuovoGiorno", "app_debug"})
public final class SessioneViewModel extends androidx.lifecycle.ViewModel {
    
    public SessioneViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.progetto_dd.memory.sessione.Sessione>> getSessione(@org.jetbrains.annotations.NotNull
    java.lang.String campagna, @org.jetbrains.annotations.NotNull
    java.lang.String master) {
        return null;
    }
    
    public final void eliminaSessione(@org.jetbrains.annotations.NotNull
    java.lang.String campagnaNome, @org.jetbrains.annotations.NotNull
    java.lang.String masterId, @org.jetbrains.annotations.NotNull
    java.lang.String numeroSessione) {
    }
    
    public final void deleteSessionsFromCampaign(@org.jetbrains.annotations.NotNull
    java.lang.String campaignName, @org.jetbrains.annotations.NotNull
    java.lang.String masterId) {
    }
    
    public final void modificaDescrizioneSessione(@org.jetbrains.annotations.NotNull
    java.lang.String campagnaNome, @org.jetbrains.annotations.NotNull
    java.lang.String masterId, @org.jetbrains.annotations.NotNull
    java.lang.String numeroSessione, @org.jetbrains.annotations.NotNull
    java.lang.String nuovaDescrizione) {
    }
    
    public final void modificaGiornoSessione(@org.jetbrains.annotations.NotNull
    java.lang.String campagnaNome, @org.jetbrains.annotations.NotNull
    java.lang.String masterId, @org.jetbrains.annotations.NotNull
    java.lang.String numeroSessione, @org.jetbrains.annotations.NotNull
    java.lang.String nuovoGiorno) {
    }
}