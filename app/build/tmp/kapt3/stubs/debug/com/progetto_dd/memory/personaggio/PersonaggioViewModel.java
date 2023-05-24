package com.progetto_dd.memory.personaggio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b$\u0018\u0000 o2\u00020\u0001:\u0001oB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010F\u001a\u00020\u0005J\u0016\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010H\u001a\u00020\u0005J\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\u000e0\u001aJ\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0005J\u000e\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020\u0005J\u000e\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u00020\u0005J\u000e\u0010[\u001a\u00020L2\u0006\u0010F\u001a\u00020\u0005J\u0014\u0010\\\u001a\u00020L2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0018\u0010^\u001a\u00020L2\u0010\u0010_\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eJ\u000e\u0010`\u001a\u00020L2\u0006\u0010a\u001a\u00020\u0011J\u000e\u0010b\u001a\u00020L2\u0006\u0010c\u001a\u00020\u0011J\u000e\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020\u0011J\u000e\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020\u0011J\u000e\u0010h\u001a\u00020L2\u0006\u0010i\u001a\u00020\u0011J\u000e\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020\u0011J\u000e\u0010l\u001a\u00020L2\u0006\u0010m\u001a\u00020\u0005J\u000e\u0010n\u001a\u00020L2\u0006\u0010H\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\u001a8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u001cR\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000e0\u001a8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u001cR\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u001cR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u001cR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b:\u0010\u001cR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b<\u0010\u001cR\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u001cR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010\u001cR\u000e\u0010A\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8F\u00a2\u0006\u0006\u001a\u0004\bC\u0010\u001cR\u000e\u0010D\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006p"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_backgroundAllineamento", "Landroidx/lifecycle/MutableLiveData;", "", "_backgroundDescrizione", "_backgroundDifetti", "_backgroundIdeali", "_backgroundLegami", "_backgroundStoria", "_backgroundTratti", "_classePersonaggio", "_competenzePersonaggio", "", "_equipaggiamento", "_modCarisma", "", "_modCostituzione", "_modDestrezza", "_modForza", "_modIntelligenza", "_modSaggezza", "_nomePersonaggio", "_razzaPersonaggio", "backgroundAllineamento", "Landroidx/lifecycle/LiveData;", "getBackgroundAllineamento", "()Landroidx/lifecycle/LiveData;", "backgroundDescrizione", "getBackgroundDescrizione", "backgroundDifetti", "getBackgroundDifetti", "backgroundIdeali", "getBackgroundIdeali", "backgroundLegami", "getBackgroundLegami", "backgroundStoria", "getBackgroundStoria", "backgroundTratti", "getBackgroundTratti", "classePersonaggio", "getClassePersonaggio", "classiRef", "Lcom/google/firebase/firestore/CollectionReference;", "competenzePersonaggio", "getCompetenzePersonaggio", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "equipaggiamento", "getEquipaggiamento", "modCarisma", "getModCarisma", "modCostituzione", "getModCostituzione", "modDestrezza", "getModDestrezza", "modForza", "getModForza", "modIntelligenza", "getModIntelligenza", "modSaggezza", "getModSaggezza", "nomePersonaggio", "getNomePersonaggio", "personaggiRef", "razzaPersonaggio", "getRazzaPersonaggio", "razzeRef", "getInfoClasse", "classe", "getInfoRazza", "razza", "getPersonaggi", "Lcom/progetto_dd/memory/personaggio/Personaggio;", "saveCharacterToFirestore", "", "setBackgroundAllineamento", "allineamento", "setBackgroundDescrizione", "descrizione", "setBackgroundDifetti", "difetti", "setBackgroundIdeali", "ideali", "setBackgroundLegami", "legami", "setBackgroundStoria", "storia", "setBackgroundTratti", "tratti", "setClassePersonaggio", "setCompetenzePersonaggio", "competenze", "setEquipaggiamento", "equipaggiamentoList", "setModCarisma", "carisma", "setModCostituzione", "costituzione", "setModDestrezza", "destrezza", "setModForza", "forza", "setModIntelligenza", "intelligenza", "setModSaggezza", "saggezza", "setNomePersonaggio", "nome", "setRazzaPersonaggio", "Companion", "app_debug"})
public final class PersonaggioViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.firestore.CollectionReference personaggiRef = null;
    private final com.google.firebase.firestore.CollectionReference razzeRef = null;
    private final com.google.firebase.firestore.CollectionReference classiRef = null;
    private final com.google.firebase.auth.FirebaseUser currentUser = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _nomePersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _razzaPersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _classePersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _competenzePersonaggio = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundDescrizione = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundStoria = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundTratti = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundDifetti = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundIdeali = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundLegami = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _backgroundAllineamento = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modForza = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modDestrezza = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modCostituzione = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modIntelligenza = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modSaggezza = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _modCarisma = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _equipaggiamento = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.progetto_dd.memory.personaggio.PersonaggioViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "com.progetto_dd.view.characters.HomeCharacterFragment";
    private static final java.lang.String TAG_RACE = "com.progetto_dd.view.characters.crea.RaceFragment";
    private static final java.lang.String TAG_CLASS = "com.progetto_dd.view.characters.crea.ClassFragment";
    private static final java.lang.String TAG_SAVE = "com.progetto_dd.view.characters.crea.SalvaPersonaggioFragment";
    
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
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getCompetenzePersonaggio() {
        return null;
    }
    
    public final void setCompetenzePersonaggio(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> competenze) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundDescrizione() {
        return null;
    }
    
    public final void setBackgroundDescrizione(@org.jetbrains.annotations.NotNull()
    java.lang.String descrizione) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundStoria() {
        return null;
    }
    
    public final void setBackgroundStoria(@org.jetbrains.annotations.NotNull()
    java.lang.String storia) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundTratti() {
        return null;
    }
    
    public final void setBackgroundTratti(@org.jetbrains.annotations.NotNull()
    java.lang.String tratti) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundDifetti() {
        return null;
    }
    
    public final void setBackgroundDifetti(@org.jetbrains.annotations.NotNull()
    java.lang.String difetti) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundIdeali() {
        return null;
    }
    
    public final void setBackgroundIdeali(@org.jetbrains.annotations.NotNull()
    java.lang.String ideali) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundLegami() {
        return null;
    }
    
    public final void setBackgroundLegami(@org.jetbrains.annotations.NotNull()
    java.lang.String legami) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getBackgroundAllineamento() {
        return null;
    }
    
    public final void setBackgroundAllineamento(@org.jetbrains.annotations.NotNull()
    java.lang.String allineamento) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModForza() {
        return null;
    }
    
    public final void setModForza(int forza) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModDestrezza() {
        return null;
    }
    
    public final void setModDestrezza(int destrezza) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModCostituzione() {
        return null;
    }
    
    public final void setModCostituzione(int costituzione) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModIntelligenza() {
        return null;
    }
    
    public final void setModIntelligenza(int intelligenza) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModSaggezza() {
        return null;
    }
    
    public final void setModSaggezza(int saggezza) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getModCarisma() {
        return null;
    }
    
    public final void setModCarisma(int carisma) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getEquipaggiamento() {
        return null;
    }
    
    public final void setEquipaggiamento(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> equipaggiamentoList) {
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
    
    public final void saveCharacterToFirestore() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/progetto_dd/memory/personaggio/PersonaggioViewModel$Companion;", "", "()V", "TAG", "", "TAG_CLASS", "TAG_RACE", "TAG_SAVE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}