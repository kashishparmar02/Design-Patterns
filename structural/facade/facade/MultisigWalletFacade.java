package structural.facade.facade;

import structural.facade.subsystems.BlockchainService;
import structural.facade.subsystems.SignatureService;
import structural.facade.subsystems.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * The Facade for the multi-signature wallet.
 * It provides a simplified interface to a complex subsystem of transaction, signature, and blockchain services.
 */
public class MultisigWalletFacade {
    private SignatureService signatureService;
    private BlockchainService blockchainService;
    private Map<String, Transaction> transactions;

    /**
     * Constructs the facade, initializing its subsystem components.
     */
    public MultisigWalletFacade() {
        this.signatureService = new SignatureService();
        this.blockchainService = new BlockchainService();
        this.transactions = new HashMap<>();
    }

    /**
     * Creates a new transaction proposal. This is the first step in the workflow.
     *
     * @param transactionId The unique ID for the new transaction.
     * @param recipient The recipient's address.
     * @param amount The amount to be transferred.
     * @param requiredSignatures The number of signatures required.
     */
    public void createTransaction(String transactionId, String recipient, double amount, int requiredSignatures) {
        System.out.println("\n--- Creating New Transaction ---");
        Transaction newTransaction = new Transaction(transactionId, recipient, amount, requiredSignatures);
        transactions.put(transactionId, newTransaction);
        System.out.println("Transaction " + transactionId + " created successfully. It requires " + requiredSignatures + " signature(s).");
    }

    /**
     * Approves a specific transaction with a new signature.
     * The method also checks if the transaction is ready to be broadcast after the signature is added.
     *
     * @param transactionId The ID of the transaction to approve.
     * @param signer The user providing the signature.
     */
    public void approveTransaction(String transactionId, String signer) {
        System.out.println("\n--- Approving Transaction " + transactionId + " ---");
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            System.out.println("Error: Transaction " + transactionId + " not found.");
            return;
        }

        signatureService.signTransaction(transaction, signer);
        System.out.println("User " + signer + " approved the transaction. Current signatures: " + transaction.getSignedBy().size());

        if (transaction.isApproved()) {
            blockchainService.broadcastTransaction(transaction);
        }
    }

    /**
     * Checks and prints the current status of a transaction, including the number of collected signatures.
     *
     * @param transactionId The ID of the transaction to check.
     */
    public void checkTransactionStatus(String transactionId) {
        System.out.println("\n--- Checking Status for Transaction " + transactionId + " ---");
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            System.out.println("Error: Transaction " + transactionId + " not found.");
            return;
        }

        System.out.println("Transaction " + transactionId + " Status:");
        System.out.println("Recipient: " + transaction.getRecipient());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Required Signatures: " + transaction.getRequiredSignatures());
        System.out.println("Current Signatures: " + transaction.getSignedBy().size());
        System.out.println("Signed By: " + transaction.getSignedBy());
        if (transaction.isApproved()) {
            System.out.println("Status: APPROVED. Ready for broadcast.");
        } else {
            System.out.println("Status: PENDING. Missing " + (transaction.getRequiredSignatures() - transaction.getSignedBy().size()) + " signature(s).");
        }
    }
}