package com.bootcamp.states;

import com.bootcamp.contracts.TokenContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(TokenContract.class)
public class TokenState implements ContractState{

    private Party issuer;
    private Party owner;
    private int amount;

    public TokenState(Party issuer, Party owner, int amount) {
        this.issuer = issuer;
        this.owner = owner;
        this.amount = amount;
    }

    public Party getIssuer() {
        return issuer;
    }

    public Party getOwner() {
        return owner;
    }

    public int getAmount() {
        return amount;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(issuer,owner);
    }
}