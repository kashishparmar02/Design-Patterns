package structural.facade.subsystems;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a multi-signature transaction proposal.
 * It holds the transaction details and tracks the signatures collected.
 */
public class Transaction {
    private String id;
    private String recipient;
    private double amount;
    private int requiredSignatures;
    private List<String> signedBy;

    /**
     * Constructs a new transaction.
     *
     * @param id The unique identifier of the transaction.
     * @param recipient The recipient's address.
     * @param amount The amount to be transferred.
     * @param requiredSignatures The number of signatures needed for approval.
     */
    public Transaction(String id, String recipient, double amount, int requiredSignatures) {
        this.id = id;
        this.recipient = recipient;
        this.amount = amount;
        this.requiredSignatures = requiredSignatures;
        this.signedBy = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }

    public int getRequiredSignatures() {
        return requiredSignatures;
    }

    public List<String> getSignedBy() {
        return signedBy;
    }

    /**
     * Adds a signature to the transaction from a specific signer.
     *
     * @param signer The unique identifier of the user signing the transaction.
     */
    public void addSignature(String signer) {
        if (!signedBy.contains(signer)) {
            signedBy.add(signer);
        }
    }

    /**
     * Checks if the transaction has met the required number of signatures.
     *
     * @return true if the transaction is approved, false otherwise.
     */
    public boolean isApproved() {
        return signedBy.size() >= requiredSignatures;
    }
}