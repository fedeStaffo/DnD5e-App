package com.progetto_dd.memory.personaggio.incantesimo;

import java.lang.System;

@androidx.room.Entity(tableName = "tabella_incantesimi")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/progetto_dd/memory/personaggio/incantesimo/Incantesimo;", "", "nome", "", "livello", "", "tipo", "classi", "", "info", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getClassi", "()Ljava/util/List;", "setClassi", "(Ljava/util/List;)V", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "getLivello", "()I", "setLivello", "(I)V", "getNome", "setNome", "getTipo", "setTipo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Incantesimo {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "nome")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private java.lang.String nome;
    @androidx.room.ColumnInfo(name = "livello")
    private int livello;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "tipo")
    private java.lang.String tipo;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "classi")
    private java.util.List<java.lang.String> classi;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "info")
    private java.lang.String info;
    
    @org.jetbrains.annotations.NotNull()
    public final com.progetto_dd.memory.personaggio.incantesimo.Incantesimo copy(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> classi, @org.jetbrains.annotations.NotNull()
    java.lang.String info) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Incantesimo(@org.jetbrains.annotations.NotNull()
    java.lang.String nome, int livello, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> classi, @org.jetbrains.annotations.NotNull()
    java.lang.String info) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getLivello() {
        return 0;
    }
    
    public final void setLivello(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTipo() {
        return null;
    }
    
    public final void setTipo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getClassi() {
        return null;
    }
    
    public final void setClassi(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInfo() {
        return null;
    }
    
    public final void setInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}