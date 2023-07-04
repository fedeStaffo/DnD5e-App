package com.progetto_dd.memory.personaggio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bJ\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00bd\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010?\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010@\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010A\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010B\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010C\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010D\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010E\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u00c6\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u00c6\u0002\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Z\u001a\u00020[H\u00d6\u0001J\t\u0010\\\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b+\u0010#R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b2\u0010#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b5\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010 R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b:\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b;\u0010#\u00a8\u0006]"}, d2 = {"Lcom/progetto_dd/memory/personaggio/Personaggio;", "", "nome", "", "utenteId", "classe", "razza", "campagna", "competenze", "", "equipaggiamento", "stato", "vitaMax", "", "vita", "livello", "classeArmatura", "carisma", "costituzione", "destrezza", "forza", "intelligenza", "saggezza", "allineamento", "descrizione", "ideali", "legami", "storia", "difetti", "tratti", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllineamento", "()Ljava/lang/String;", "getCampagna", "getCarisma", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClasse", "getClasseArmatura", "getCompetenze", "()Ljava/util/List;", "getCostituzione", "getDescrizione", "getDestrezza", "getDifetti", "getEquipaggiamento", "getForza", "getIdeali", "getIntelligenza", "getLegami", "getLivello", "getNome", "getRazza", "getSaggezza", "getStato", "getStoria", "getTratti", "getUtenteId", "getVita", "getVitaMax", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/progetto_dd/memory/personaggio/Personaggio;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Personaggio {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nome = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String utenteId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String classe = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String razza = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String campagna = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> competenze = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> equipaggiamento = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String stato = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long vitaMax = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long vita = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long livello = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long classeArmatura = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long carisma = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long costituzione = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long destrezza = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long forza = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long intelligenza = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long saggezza = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String allineamento = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String descrizione = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String ideali = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String legami = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String storia = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String difetti = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String tratti = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.progetto_dd.memory.personaggio.Personaggio copy(@org.jetbrains.annotations.Nullable()
    java.lang.String nome, @org.jetbrains.annotations.Nullable()
    java.lang.String utenteId, @org.jetbrains.annotations.Nullable()
    java.lang.String classe, @org.jetbrains.annotations.Nullable()
    java.lang.String razza, @org.jetbrains.annotations.Nullable()
    java.lang.String campagna, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> competenze, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> equipaggiamento, @org.jetbrains.annotations.Nullable()
    java.lang.String stato, @org.jetbrains.annotations.Nullable()
    java.lang.Long vitaMax, @org.jetbrains.annotations.Nullable()
    java.lang.Long vita, @org.jetbrains.annotations.Nullable()
    java.lang.Long livello, @org.jetbrains.annotations.Nullable()
    java.lang.Long classeArmatura, @org.jetbrains.annotations.Nullable()
    java.lang.Long carisma, @org.jetbrains.annotations.Nullable()
    java.lang.Long costituzione, @org.jetbrains.annotations.Nullable()
    java.lang.Long destrezza, @org.jetbrains.annotations.Nullable()
    java.lang.Long forza, @org.jetbrains.annotations.Nullable()
    java.lang.Long intelligenza, @org.jetbrains.annotations.Nullable()
    java.lang.Long saggezza, @org.jetbrains.annotations.Nullable()
    java.lang.String allineamento, @org.jetbrains.annotations.Nullable()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.String ideali, @org.jetbrains.annotations.Nullable()
    java.lang.String legami, @org.jetbrains.annotations.Nullable()
    java.lang.String storia, @org.jetbrains.annotations.Nullable()
    java.lang.String difetti, @org.jetbrains.annotations.Nullable()
    java.lang.String tratti) {
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
    
    public Personaggio() {
        super();
    }
    
    public Personaggio(@org.jetbrains.annotations.Nullable()
    java.lang.String nome, @org.jetbrains.annotations.Nullable()
    java.lang.String utenteId, @org.jetbrains.annotations.Nullable()
    java.lang.String classe, @org.jetbrains.annotations.Nullable()
    java.lang.String razza, @org.jetbrains.annotations.Nullable()
    java.lang.String campagna, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> competenze, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> equipaggiamento, @org.jetbrains.annotations.Nullable()
    java.lang.String stato, @org.jetbrains.annotations.Nullable()
    java.lang.Long vitaMax, @org.jetbrains.annotations.Nullable()
    java.lang.Long vita, @org.jetbrains.annotations.Nullable()
    java.lang.Long livello, @org.jetbrains.annotations.Nullable()
    java.lang.Long classeArmatura, @org.jetbrains.annotations.Nullable()
    java.lang.Long carisma, @org.jetbrains.annotations.Nullable()
    java.lang.Long costituzione, @org.jetbrains.annotations.Nullable()
    java.lang.Long destrezza, @org.jetbrains.annotations.Nullable()
    java.lang.Long forza, @org.jetbrains.annotations.Nullable()
    java.lang.Long intelligenza, @org.jetbrains.annotations.Nullable()
    java.lang.Long saggezza, @org.jetbrains.annotations.Nullable()
    java.lang.String allineamento, @org.jetbrains.annotations.Nullable()
    java.lang.String descrizione, @org.jetbrains.annotations.Nullable()
    java.lang.String ideali, @org.jetbrains.annotations.Nullable()
    java.lang.String legami, @org.jetbrains.annotations.Nullable()
    java.lang.String storia, @org.jetbrains.annotations.Nullable()
    java.lang.String difetti, @org.jetbrains.annotations.Nullable()
    java.lang.String tratti) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNome() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUtenteId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClasse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRazza() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCampagna() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCompetenze() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getEquipaggiamento() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStato() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getVitaMax() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getVita() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLivello() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClasseArmatura() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCarisma() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCostituzione() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDestrezza() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getForza() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getIntelligenza() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSaggezza() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAllineamento() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescrizione() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIdeali() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLegami() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStoria() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDifetti() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTratti() {
        return null;
    }
}