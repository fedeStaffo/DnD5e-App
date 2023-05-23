package com.progetto_dd.databinding;
import com.progetto_dd.R;
import com.progetto_dd.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCompetenzeBindingImpl extends FragmentCompetenzeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.atletica, 2);
        sViewsWithIds.put(R.id.atleticaCheckBox, 3);
        sViewsWithIds.put(R.id.acrobazia, 4);
        sViewsWithIds.put(R.id.acrobaziaCheckBox, 5);
        sViewsWithIds.put(R.id.furtivita, 6);
        sViewsWithIds.put(R.id.furtivitaCheckBox, 7);
        sViewsWithIds.put(R.id.rapiditadimano, 8);
        sViewsWithIds.put(R.id.rapiditamanoCheckBox, 9);
        sViewsWithIds.put(R.id.arcano, 10);
        sViewsWithIds.put(R.id.arcanoCheckBox, 11);
        sViewsWithIds.put(R.id.storia, 12);
        sViewsWithIds.put(R.id.storiaCheckBox, 13);
        sViewsWithIds.put(R.id.indagare, 14);
        sViewsWithIds.put(R.id.indagareCheckBox, 15);
        sViewsWithIds.put(R.id.natura, 16);
        sViewsWithIds.put(R.id.naturaCheckBox, 17);
        sViewsWithIds.put(R.id.religione, 18);
        sViewsWithIds.put(R.id.religioneCheckBox, 19);
        sViewsWithIds.put(R.id.addestrareanimali, 20);
        sViewsWithIds.put(R.id.addanimaliCheckBox, 21);
        sViewsWithIds.put(R.id.intuizione, 22);
        sViewsWithIds.put(R.id.intuizioneCheckBox, 23);
        sViewsWithIds.put(R.id.medicina, 24);
        sViewsWithIds.put(R.id.medicinaCheckBox, 25);
        sViewsWithIds.put(R.id.percezione, 26);
        sViewsWithIds.put(R.id.percezioneCheckBox, 27);
        sViewsWithIds.put(R.id.sopravvivenza, 28);
        sViewsWithIds.put(R.id.sopravvivenzaCheckBox, 29);
        sViewsWithIds.put(R.id.inganno, 30);
        sViewsWithIds.put(R.id.ingannoCheckBox, 31);
        sViewsWithIds.put(R.id.intimidazione, 32);
        sViewsWithIds.put(R.id.intimidazioneCheckBox, 33);
        sViewsWithIds.put(R.id.intrattenere, 34);
        sViewsWithIds.put(R.id.intrattenereCheckBox, 35);
        sViewsWithIds.put(R.id.persuasione, 36);
        sViewsWithIds.put(R.id.persuasioneCheckBox, 37);
        sViewsWithIds.put(R.id.btn_avanti, 38);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCompetenzeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }
    private FragmentCompetenzeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.CheckBox) bindings[5]
            , (android.widget.CheckBox) bindings[21]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.CheckBox) bindings[11]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.CheckBox) bindings[3]
            , (android.widget.Button) bindings[38]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.CheckBox) bindings[15]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.CheckBox) bindings[31]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.CheckBox) bindings[33]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.CheckBox) bindings[35]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.CheckBox) bindings[23]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.CheckBox) bindings[25]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.CheckBox) bindings[17]
            , (android.widget.TextView) bindings[1]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.CheckBox) bindings[27]
            , (android.widget.LinearLayout) bindings[36]
            , (android.widget.CheckBox) bindings[37]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.CheckBox) bindings[9]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.CheckBox) bindings[19]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.CheckBox) bindings[29]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.CheckBox) bindings[13]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.numCompetenzeText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.numCompetenze == variableId) {
            setNumCompetenze((java.lang.Integer) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNumCompetenze(@Nullable java.lang.Integer NumCompetenze) {
        this.mNumCompetenze = NumCompetenze;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.numCompetenze);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String numCompetenzeTextAndroidStringNumeroCompetenzeNumCompetenze = null;
        java.lang.Integer numCompetenze = mNumCompetenze;

        if ((dirtyFlags & 0x3L) != 0) {



                // read @android:string/numeroCompetenze
                numCompetenzeTextAndroidStringNumeroCompetenzeNumCompetenze = numCompetenzeText.getResources().getString(R.string.numeroCompetenze, numCompetenze);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.numCompetenzeText, numCompetenzeTextAndroidStringNumeroCompetenzeNumCompetenze);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): numCompetenze
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}