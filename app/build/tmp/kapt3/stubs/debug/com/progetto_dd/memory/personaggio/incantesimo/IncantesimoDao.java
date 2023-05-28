package com.progetto_dd.memory.personaggio.incantesimo;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/progetto_dd/memory/personaggio/incantesimo/IncantesimoDao;", "", "delete", "", "incantesimo", "Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;", "(Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncantesimiByClass", "", "classi", "", "classiConcatenata", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncantesimiByLevelAndClass", "livello", "", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncantesimiByParams", "tipo", "classe", "classeConcatenata", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncantesimiByTypeAndClass", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncantesimoByNome", "nomeIncantesimo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrReplace", "app_debug"})
public abstract interface IncantesimoDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertOrReplace(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.incantesimo.Incantesimo incantesimo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.progetto_dd.memory.personaggio.incantesimo.Incantesimo incantesimo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> incantesimo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tabella_incantesimi WHERE livello = :livello AND tipo = :tipo AND (classi = :classe OR classi LIKE :classeConcatenata)")
    public abstract java.lang.Object getIncantesimiByParams(int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String classe, @org.jetbrains.annotations.NotNull()
    java.lang.String classeConcatenata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tabella_incantesimi WHERE livello = :livello AND (classi = :classi OR classi LIKE :classiConcatenata)")
    public abstract java.lang.Object getIncantesimiByLevelAndClass(int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String classi, @org.jetbrains.annotations.NotNull()
    java.lang.String classiConcatenata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tabella_incantesimi WHERE tipo = :tipo AND (classi = :classi OR classi LIKE :classiConcatenata)")
    public abstract java.lang.Object getIncantesimiByTypeAndClass(@org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String classi, @org.jetbrains.annotations.NotNull()
    java.lang.String classiConcatenata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tabella_incantesimi WHERE (classi = :classi OR classi LIKE :classiConcatenata)")
    public abstract java.lang.Object getIncantesimiByClass(@org.jetbrains.annotations.NotNull()
    java.lang.String classi, @org.jetbrains.annotations.NotNull()
    java.lang.String classiConcatenata, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.progetto_dd.memory.personaggio.incantesimo.Incantesimo>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM tabella_incantesimi WHERE nome = :nomeIncantesimo")
    public abstract java.lang.Object getIncantesimoByNome(@org.jetbrains.annotations.NotNull()
    java.lang.String nomeIncantesimo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.progetto_dd.memory.personaggio.incantesimo.Incantesimo> continuation);
}