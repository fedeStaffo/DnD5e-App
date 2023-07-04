package com.progetto_dd.view.campaigns.drawer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/progetto_dd/view/campaigns/drawer/NpcDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/progetto_dd/databinding/FragmentNpcDetailsBinding;", "npcViewModel", "Lcom/progetto_dd/memory/npc/NpcViewModel;", "viewModelCampagna", "Lcom/progetto_dd/memory/campagna/CampagnaViewModel;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showConfirmationDialog", "npcNome", "", "npcMaster", "campagna", "app_debug"})
public final class NpcDetailsFragment extends androidx.fragment.app.Fragment {
    private com.progetto_dd.databinding.FragmentNpcDetailsBinding binding;
    private com.progetto_dd.memory.campagna.CampagnaViewModel viewModelCampagna;
    private com.progetto_dd.memory.npc.NpcViewModel npcViewModel;
    
    public NpcDetailsFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showConfirmationDialog(java.lang.String npcNome, java.lang.String npcMaster, java.lang.String campagna) {
    }
}