package com.progetto_dd.view.campaigns.drawer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/progetto_dd/view/campaigns/drawer/NpcDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/progetto_dd/databinding/FragmentNpcDetailsBinding;", "isEditingDescrizione", "", "isEditingLegame", "npcViewModel", "Lcom/progetto_dd/memory/npc/NpcViewModel;", "viewModelCampagna", "Lcom/progetto_dd/memory/campagna/CampagnaViewModel;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showConfirmationDialog", "npcNome", "", "npcMaster", "campagna", "showSuccessDialog", "message", "updateUI", "app_debug"})
public final class NpcDetailsFragment extends androidx.fragment.app.Fragment {
    private com.progetto_dd.databinding.FragmentNpcDetailsBinding binding;
    private com.progetto_dd.memory.campagna.CampagnaViewModel viewModelCampagna;
    private com.progetto_dd.memory.npc.NpcViewModel npcViewModel;
    private boolean isEditingLegame = false;
    private boolean isEditingDescrizione = false;
    
    public NpcDetailsFragment() {
        super();
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showConfirmationDialog(java.lang.String npcNome, java.lang.String npcMaster, java.lang.String campagna) {
    }
    
    private final void showSuccessDialog(java.lang.String message) {
    }
    
    private final void updateUI() {
    }
}