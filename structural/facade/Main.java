package structural.facade;

import structural.facade.facade.MultisigWalletFacade;

/**
 * The client class that demonstrates the use of the MultisigWalletFacade.
 * It interacts only with the facade, completely ignorant of the underlying complexity.
 */
public class Main {
    public static void main(String[] args) {
        MultisigWalletFacade wallet = new MultisigWalletFacade();

        // User 1 creates a transaction proposal.
        wallet.createTransaction("tx-001", "0xRecipientAddress", 50.0, 3);
        wallet.checkTransactionStatus("tx-001");

        // User 2 approves the transaction.
        wallet.approveTransaction("tx-001", "User-A");
        wallet.checkTransactionStatus("tx-001");

        // User 3 approves the transaction.
        wallet.approveTransaction("tx-001", "User-B");
        wallet.checkTransactionStatus("tx-001");

        // User 4 approves the transaction, which reaches the required signature count.
        // The facade handles the broadcast to the "blockchain".
        wallet.approveTransaction("tx-001", "User-C");
    }
}